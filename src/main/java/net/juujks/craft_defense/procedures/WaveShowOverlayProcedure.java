package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class WaveShowOverlayProcedure {
	public static String execute(LevelAccessor world) {
		if (CraftDefenseModVariables.MapVariables.get(world).inGame) {
			return "Wave " + new java.text.DecimalFormat("##").format(CraftDefenseModVariables.MapVariables.get(world).wave);
		}
		return "";
	}
}