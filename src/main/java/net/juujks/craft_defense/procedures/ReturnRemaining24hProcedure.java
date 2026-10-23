package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnRemaining24hProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String texto = "";
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).time2Remaining24 > 0) {
			texto = new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).time2Remaining24) + "h";
		} else {
			texto = new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).timeRemaining24) + "min";
		}
		return texto;
	}
}