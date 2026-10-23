package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnTimePlayedProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Total Time Played: " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).daysPlayed) + "d "
				+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).hoursPlayed) + "h "
				+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).minutesPlayed) + "min "
				+ new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).secondsPlayed) + "s";
	}
}