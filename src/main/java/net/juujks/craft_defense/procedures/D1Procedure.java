package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class D1Procedure {
	public static String execute(LevelAccessor world) {
		return "SKIP_WAVE: " + new java.text.DecimalFormat("##.##").format(CraftDefenseModVariables.MapVariables.get(world).skipWave);
	}
}