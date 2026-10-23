package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class LL6Procedure {
	public static boolean execute(LevelAccessor world) {
		if (CraftDefenseModVariables.MapVariables.get(world).act > 5 && CraftDefenseModVariables.MapVariables.get(world).act <= 10) {
			if (CraftDefenseModVariables.MapVariables.get(world).rareDrops > 0.2 && CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.4) {
				return true;
			}
		}
		return false;
	}
}