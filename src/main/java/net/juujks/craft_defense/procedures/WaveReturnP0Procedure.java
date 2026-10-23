package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class WaveReturnP0Procedure {
	public static boolean execute(LevelAccessor world) {
		if (CraftDefenseModVariables.MapVariables.get(world).act == 5 || CraftDefenseModVariables.MapVariables.get(world).act == 15 || CraftDefenseModVariables.MapVariables.get(world).act == 20
				|| CraftDefenseModVariables.MapVariables.get(world).act == 25 || CraftDefenseModVariables.MapVariables.get(world).act == 30 || CraftDefenseModVariables.MapVariables.get(world).act == 10) {
			return true;
		}
		return false;
	}
}