package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class L2Procedure {
	public static boolean execute(LevelAccessor world) {
		if (CraftDefenseModVariables.MapVariables.get(world).act <= 5) {
			if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.25 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.5) {
				return true;
			}
		}
		return false;
	}
}