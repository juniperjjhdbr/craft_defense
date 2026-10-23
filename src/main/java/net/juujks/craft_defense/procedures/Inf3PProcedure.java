package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class Inf3PProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if (CraftDefenseModVariables.MapVariables.get(world).cooldownInf >= 40 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastBeatenAct >= 4) {
			return true;
		}
		return false;
	}
}