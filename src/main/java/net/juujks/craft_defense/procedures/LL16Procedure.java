package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class LL16Procedure {
	public static boolean execute(LevelAccessor world) {
		if (CraftDefenseModVariables.MapVariables.get(world).act > 15 && CraftDefenseModVariables.MapVariables.get(world).act <= 20) {
			if (CraftDefenseModVariables.MapVariables.get(world).rareDrops > 0.8) {
				return true;
			}
		}
		return false;
	}
}