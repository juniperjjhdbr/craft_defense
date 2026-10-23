package net.juujks.craft_defense.cdmap;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtIo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomMapLoader {

    /**
     * Loads a custom map NBT from disk and places it in the world.
     * Called from SpawnStructureProcedure when customMapId > 0.
     */
    public static boolean placeStructure(LevelAccessor world, int mapId, int x, int y, int z) {
        if (!(world instanceof ServerLevel serverLevel)) return false;

        // Find the map folder in the index
        CdmapEntry entry = findEntry(mapId);
        if (entry == null) {
            System.err.println("[CraftDefense] Custom map not found for ID: " + mapId);
            return false;
        }

        Path nbtPath = CdmapIndex.getCdmapsFolder()
                .resolve(entry.getFolderName())
                .resolve("map.nbt");

        if (!Files.exists(nbtPath)) {
            System.err.println("[CraftDefense] map.nbt not found at: " + nbtPath);
            return false;
        }

        try (InputStream is = Files.newInputStream(nbtPath)) {
            // Read the NBT data
            CompoundTag tag = NbtIo.readCompressed(is, 
                    net.minecraft.nbt.NbtAccounter.unlimitedHeap());

            // Create and load the structure template
            StructureTemplate template = new StructureTemplate();
            template.load(serverLevel.holderLookup(net.minecraft.core.registries.Registries.BLOCK), tag);

            // Place the structure
            BlockPos origin = new BlockPos(x, y, z);
            template.placeInWorld(
                    serverLevel,
                    origin,
                    origin,
                    new StructurePlaceSettings()
                            .setRotation(Rotation.NONE)
                            .setMirror(Mirror.NONE)
                            .setIgnoreEntities(false),
                    serverLevel.random,
                    3
            );

            System.out.println("[CraftDefense] Custom map " + mapId + " placed at " + x + ", " + y + ", " + z);
            return true;

        } catch (IOException e) {
            System.err.println("[CraftDefense] Failed to load custom map NBT: " + e.getMessage());
            return false;
        }
    }

    /**
     * Calculates the spawn X coordinate for a custom map based on its ID.
     */
    public static int getSpawnX(int mapId) {
        return 10000 + (mapId * 1000);
    }

    /**
     * Finds a CdmapEntry by ID from the index.
     */
    private static CdmapEntry findEntry(int mapId) {
        return CdmapIndex.loadIndex().stream()
                .filter(e -> e.getId() == mapId)
                .findFirst()
                .orElse(null);
    }
}