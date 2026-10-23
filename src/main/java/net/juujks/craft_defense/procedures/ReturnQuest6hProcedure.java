package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnQuest6hProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest6h;
	}
}