package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class L18Procedure {
	public static boolean execute(LevelAccessor world) {
		if (CraftDefenseModVariables.MapVariables.get(world).act > 20 && CraftDefenseModVariables.MapVariables.get(world).act <= 25) {
			if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.75) {
				return true;
			}
		}
		return false;
	}
}