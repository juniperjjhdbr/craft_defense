package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class D8Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String texttoreturn = "";
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerInGame) {
			texttoreturn = "PLAYER_IN_GAME: " + "true";
		} else {
			texttoreturn = "PLAYER_IN_GAME: " + "false";
		}
		return texttoreturn;
	}
}