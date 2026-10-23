package net.juujks.craft_defense.cdmap;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

/**
 * Handles importing and extracting .cdmap files.
 */
public class CdmapImporter {

    private static final Gson GSON = new Gson();
    private static final long MAX_SIZE_BYTES = 64L * 1024 * 1024; // 64MB

    public enum ImportResult {
        SUCCESS,
        FILE_TOO_LARGE,
        NOT_A_ZIP,
        MISSING_MANIFEST,
        MISSING_NBT,
        MISSING_THUMBNAIL,
        INVALID_MANIFEST,
        ALREADY_IMPORTED,
        IO_ERROR
    }

    /**
     * Imports a .cdmap file into the cdmaps folder.
     * Returns an ImportResult indicating success or the type of failure.
     */
    public static ImportResult importCdmap(File cdmapFile) {
        // Check file size
        if (cdmapFile.length() > MAX_SIZE_BYTES) {
            return ImportResult.FILE_TOO_LARGE;
        }

        // Check if it's a valid ZIP
        if (!isValidZip(cdmapFile)) {
            return ImportResult.NOT_A_ZIP;
        }

        try (ZipFile zip = new ZipFile(cdmapFile)) {

            // Check required files exist inside the zip
            ZipEntry manifestEntry = zip.getEntry("manifest.json");
            ZipEntry nbtEntry = zip.getEntry("map.nbt");
            ZipEntry thumbEntry = zip.getEntry("thumbnail.png");

            if (manifestEntry == null) return ImportResult.MISSING_MANIFEST;
            if (nbtEntry == null) return ImportResult.MISSING_NBT;
            if (thumbEntry == null) return ImportResult.MISSING_THUMBNAIL;

            // Parse manifest
            JsonObject manifest;
            try (Reader reader = new InputStreamReader(zip.getInputStream(manifestEntry))) {
                manifest = GSON.fromJson(reader, JsonObject.class);
            }

            if (manifest == null) return ImportResult.INVALID_MANIFEST;
            if (!manifest.has("id") || !manifest.has("name") || !manifest.has("act")) {
                return ImportResult.INVALID_MANIFEST;
            }

            int id = manifest.get("id").getAsInt();
            String name = manifest.get("name").getAsString();
            int act = manifest.get("act").getAsInt();

            // Check if already imported
            String folderName = id + "_" + name.toLowerCase().replace(" ", "_");
            Path targetFolder = CdmapIndex.getCdmapsFolder().resolve(folderName);

            if (Files.exists(targetFolder)) {
                return ImportResult.ALREADY_IMPORTED;
            }

            // Create folder and extract files
            Files.createDirectories(targetFolder);

            extractEntry(zip, nbtEntry, targetFolder.resolve("map.nbt"));
            extractEntry(zip, thumbEntry, targetFolder.resolve("thumbnail.png"));

            // Write manifest.json
            try (Writer writer = Files.newBufferedWriter(targetFolder.resolve("manifest.json"))) {
                new com.google.gson.GsonBuilder()
                        .setPrettyPrinting()
                        .create()
                        .toJson(manifest, writer);
            }

            // Add to index
            CdmapEntry entry = new CdmapEntry(id, name, act, folderName);
            CdmapIndex.addEntry(entry);

            return ImportResult.SUCCESS;

        } catch (IOException e) {
            System.err.println("[CraftDefense] IO error during cdmap import: " + e.getMessage());
            return ImportResult.IO_ERROR;
        }
    }

    /**
     * Opens a system file picker dialog and returns the selected .cdmap file.
     * Returns null if the user cancelled.
     */
    public static File openFilePicker() {
        org.lwjgl.PointerBuffer filters = org.lwjgl.BufferUtils.createPointerBuffer(1);
        org.lwjgl.system.MemoryStack stack = org.lwjgl.system.MemoryStack.stackPush();
        
        try {
            filters.put(stack.UTF8("*.zip"));
            filters.flip();
            
            String result = org.lwjgl.util.tinyfd.TinyFileDialogs.tinyfd_openFileDialog(
                    "Select a .zip file",
                    "",
                    filters,
                    "Custom Map Files (*.zip)",
                    false
            );

            if (result == null) return null;
            return new File(result);
        } finally {
            stack.pop();
        }
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private static boolean isValidZip(File file) {
        try (ZipFile zip = new ZipFile(file)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static void extractEntry(ZipFile zip, ZipEntry entry, Path target) throws IOException {
        try (InputStream in = zip.getInputStream(entry)) {
            Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}