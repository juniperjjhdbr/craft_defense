package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class UpUnitProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.hasPermissions(1)) {
			CraftDefenseModVariables.MapVariables.get(world).unitReward = true;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}