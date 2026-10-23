package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class X1Procedure {
	public static boolean execute(LevelAccessor world) {
		boolean s = false;
		if (CraftDefenseModVariables.MapVariables.get(world).debugMode) {
			s = true;
		} else {
			s = false;
		}
		return s;
	}
}