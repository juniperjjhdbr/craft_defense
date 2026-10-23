package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnEditPermProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if ((CraftDefenseModVariables.MapVariables.get(world).ownerOfRaid).equals(entity.getDisplayName().getString())) {
			return true;
		}
		return false;
	}
}