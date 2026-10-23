package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class Act3PProcedure {
	public static void execute(LevelAccessor world) {
		CraftDefenseModVariables.MapVariables.get(world).act = 3;
		CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
	}
}