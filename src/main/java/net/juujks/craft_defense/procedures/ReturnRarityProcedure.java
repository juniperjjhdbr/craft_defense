package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnRarityProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String texto = "";
		texto = "";
		if ((entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastRolledRarity).equals("Rare")) {
			texto = "\u00A7b" + entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastRolledRarity;
		}
		if ((entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastRolledRarity).equals("Epic")) {
			texto = "\u00A75" + entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastRolledRarity;
		}
		if ((entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastRolledRarity).equals("Legendary")) {
			texto = "\u00A7e" + entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastRolledRarity;
		}
		return texto;
	}
}