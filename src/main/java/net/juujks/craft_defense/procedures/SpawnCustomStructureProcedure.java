package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.juujks.craft_defense.cdmap.CustomMapLoader;


import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.CraftDefenseMod;


public class SpawnCustomStructureProcedure {
	public static void execute(LevelAccessor world) {
		// Mapas customizados usam X = 20000 + (id * 1000)
		if (CraftDefenseModVariables.MapVariables.get(world).customMapId > 0) {
		    int id = (int) CraftDefenseModVariables.MapVariables.get(world).customMapId;
		    int spawnX = 20000 + (id * 1000);
		    // Carrega o NBT do disco e coloca no mundo
		    CustomMapLoader.placeStructure(world, id, spawnX, 200, 0);
		}
	}
}
