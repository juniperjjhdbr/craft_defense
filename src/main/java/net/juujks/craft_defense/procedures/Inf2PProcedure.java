package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class Inf2PProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastBeatenAct >= 4 && CraftDefenseModVariables.MapVariables.get(world).cooldownInf >= 20 && CraftDefenseModVariables.MapVariables.get(world).cooldownInf < 40) {
			return true;
		}
		return false;
	}
}