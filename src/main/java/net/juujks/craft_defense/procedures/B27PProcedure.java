package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class B27PProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastBeatenAct >= 27) {
			return true;
		}
		return false;
	}
}