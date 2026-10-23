package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class Level5to7P3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel >= 5 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel <= 7 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).epicChosen <= 2
				&& entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).rareChosen >= 3 && !entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).fu3) {
			return true;
		}
		return false;
	}
}