package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ShieldBarP2Procedure {
	public static boolean execute(LevelAccessor world) {
		if (CraftDefenseModVariables.MapVariables.get(world).inGame) {
			if (CraftDefenseModVariables.MapVariables.get(world).shield == 1) {
				return true;
			}
		}
		return false;
	}
}