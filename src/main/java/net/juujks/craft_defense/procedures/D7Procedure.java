package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class D7Procedure {
	public static String execute(LevelAccessor world) {
		String texttoreturn = "";
		if (CraftDefenseModVariables.MapVariables.get(world).inGame) {
			texttoreturn = "GAME: " + "true";
		} else {
			texttoreturn = "GAME: " + "false";
		}
		return texttoreturn;
	}
}