package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class D9Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String texttoreturn = "";
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).skipWaveProcessing) {
			texttoreturn = "SKIP_WAVE_PROCESSING: " + "true";
		} else {
			texttoreturn = "SKIP_WAVE_PROCESSING: " + "false";
		}
		return texttoreturn;
	}
}