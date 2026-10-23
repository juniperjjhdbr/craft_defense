package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class D5Procedure {
	public static String execute(LevelAccessor world) {
		String texttoreturn = "";
		if (CraftDefenseModVariables.MapVariables.get(world).bossKilled) {
			texttoreturn = "BOSS_KILLED: " + "true";
		} else {
			texttoreturn = "BOSS_KILLED: " + "false";
		}
		return texttoreturn;
	}
}