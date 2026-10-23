package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class D10Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "LAST_BEATEN_ACT: " + new java.text.DecimalFormat("##.##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastBeatenAct);
	}
}