package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class LockCond2Procedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if (world.isClientSide()) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).dmgLock == true) {
				return true;
			}
		}
		return false;
	}
}