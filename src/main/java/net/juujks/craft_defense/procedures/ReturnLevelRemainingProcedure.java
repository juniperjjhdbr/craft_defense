package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnLevelRemainingProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "XP: " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).wins) + "/" + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).winsLUPCap);
	}
}