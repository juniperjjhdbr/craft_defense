package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class L7Procedure {
	public static boolean execute(LevelAccessor world) {
		if (CraftDefenseModVariables.MapVariables.get(world).act > 10 && CraftDefenseModVariables.MapVariables.get(world).act <= 15) {
			if (CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.25) {
				return true;
			}
		}
		return false;
	}
}