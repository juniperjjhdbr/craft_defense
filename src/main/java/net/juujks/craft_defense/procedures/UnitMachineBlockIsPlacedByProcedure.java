package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class UnitMachineBlockIsPlacedByProcedure {
	public static void execute(LevelAccessor world) {
		CraftDefenseModVariables.MapVariables.get(world).numberOfUnitMachines = CraftDefenseModVariables.MapVariables.get(world).numberOfUnitMachines + 1;
		CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
	}
}