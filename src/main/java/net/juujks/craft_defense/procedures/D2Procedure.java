package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class D2Procedure {
	public static String execute(LevelAccessor world) {
		return "WAVE_BONUS: " + new java.text.DecimalFormat("##.##").format(CraftDefenseModVariables.MapVariables.get(world).waveBonus);
	}
}