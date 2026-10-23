package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class Act9PProcedure {
	public static void execute(LevelAccessor world) {
		CraftDefenseModVariables.MapVariables.get(world).act = 9;
		CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
	}
}