package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnXPToAddProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "+" + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).xpToAdd) + "XP";
	}
}