package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class LL3Procedure {
	public static boolean execute(LevelAccessor world) {
		if (CraftDefenseModVariables.MapVariables.get(world).act <= 5) {
			if (CraftDefenseModVariables.MapVariables.get(world).rareDrops > 0.4 && CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.6) {
				return true;
			}
		}
		return false;
	}
}