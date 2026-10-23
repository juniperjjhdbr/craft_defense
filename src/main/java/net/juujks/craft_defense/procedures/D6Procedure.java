package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class D6Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String texttoreturn = "";
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerVoted) {
			texttoreturn = "PLAYER_VOTED: " + "true";
		} else {
			texttoreturn = "PLAYER_VOTED: " + "false";
		}
		return texttoreturn;
	}
}