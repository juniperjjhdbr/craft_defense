package net.juujks.craft_defense.cdmap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.client.Minecraft;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the index.json file that lists all imported custom maps.
 */
public class CdmapIndex {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Returns the path to the cdmaps folder inside the current world save.
     * Example: .minecraft/saves/MyWorld/craft_defense/cdmaps/
     */
    public static Path getCdmapsFolder() {
        Minecraft mc = Minecraft.getInstance();
        return mc.gameDirectory.toPath()
                .resolve("craft_defense")
                .resolve("cdmaps");
    }

    /**
     * Returns the path to index.json inside the cdmaps folder.
     */
    public static Path getIndexFile() {
        return getCdmapsFolder().resolve("index.json");
    }

    /**
     * Loads all map entries from index.json.
     * Returns an empty list if the file doesn't exist or is invalid.
     */
    public static List<CdmapEntry> loadIndex() {
        List<CdmapEntry> entries = new ArrayList<>();
        Path indexFile = getIndexFile();

        if (!Files.exists(indexFile)) {
            return entries;
        }

        try (Reader reader = Files.newBufferedReader(indexFile)) {
            JsonArray array = GSON.fromJson(reader, JsonArray.class);
            if (array == null) return entries;

            for (int i = 0; i < array.size(); i++) {
                JsonObject obj = array.get(i).getAsJsonObject();
                int id = obj.get("id").getAsInt();
                String name = obj.get("name").getAsString();
                int act = obj.get("act").getAsInt();
                String folderName = obj.get("folder").getAsString();
                entries.add(new CdmapEntry(id, name, act, folderName));
            }
        } catch (Exception e) {
            System.err.println("[CraftDefense] Failed to load cdmap index: " + e.getMessage());
        }

        return entries;
    }

    /**
     * Saves the list of entries to index.json.
     */
    public static void saveIndex(List<CdmapEntry> entries) {
        Path indexFile = getIndexFile();

        try {
            Files.createDirectories(indexFile.getParent());
            JsonArray array = new JsonArray();

            for (CdmapEntry entry : entries) {
                JsonObject obj = new JsonObject();
                obj.addProperty("id", entry.getId());
                obj.addProperty("name", entry.getName());
                obj.addProperty("act", entry.getAct());
                obj.addProperty("folder", entry.getFolderName());
                array.add(obj);
            }

            try (Writer writer = Files.newBufferedWriter(indexFile)) {
                GSON.toJson(array, writer);
            }
        } catch (Exception e) {
            System.err.println("[CraftDefense] Failed to save cdmap index: " + e.getMessage());
        }
    }

    /**
     * Adds a new entry to the index and saves it.
     */
    public static void addEntry(CdmapEntry entry) {
        List<CdmapEntry> entries = loadIndex();
        entries.add(entry);
        saveIndex(entries);
    }

    /**
     * Removes an entry by ID from the index and saves it.
     */
    public static void removeEntry(int id) {
        List<CdmapEntry> entries = loadIndex();
        entries.removeIf(e -> e.getId() == id);
        saveIndex(entries);
    }
}