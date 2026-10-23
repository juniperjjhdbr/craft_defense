package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnTraitRarityProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String texto = "";
		if ((entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastRolledTraitRarity).equals("Common")) {
			texto = "\u00A77" + entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastRolledTraitRarity;
		} else if ((entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastRolledTraitRarity).equals("Rare")) {
			texto = "\u00A7b" + entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastRolledTraitRarity;
		} else if ((entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastRolledTraitRarity).equals("Epic")) {
			texto = "\u00A75" + entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastRolledTraitRarity;
		}
		return texto;
	}
}