package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnMapPProcedure {
	public static String execute(LevelAccessor world) {
		return CraftDefenseModVariables.MapVariables.get(world).map;
	}
}