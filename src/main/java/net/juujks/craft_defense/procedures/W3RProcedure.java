package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class W3RProcedure {
	public static boolean execute(LevelAccessor world) {
		if (CraftDefenseModVariables.MapVariables.get(world).act > 10 && CraftDefenseModVariables.MapVariables.get(world).act <= 15) {
			return true;
		}
		return false;
	}
}