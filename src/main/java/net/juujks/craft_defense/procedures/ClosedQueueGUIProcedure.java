package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ClosedQueueGUIProcedure {
	public static void execute(LevelAccessor world) {
		double counter = 0;
		CraftDefenseModVariables.MapVariables.get(world).teleportTimer = -1;
		CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
	}
}