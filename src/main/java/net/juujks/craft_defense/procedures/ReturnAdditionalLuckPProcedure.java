package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnAdditionalLuckPProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance > 1) {
			return new java.text.DecimalFormat("##.##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) + "x Luck";
		}
		return "";
	}
}