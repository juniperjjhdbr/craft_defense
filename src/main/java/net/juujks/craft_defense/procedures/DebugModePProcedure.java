package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class DebugModePProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.hasPermissions(1)) {
			if (CraftDefenseModVariables.MapVariables.get(world).debugMode) {
				CraftDefenseModVariables.MapVariables.get(world).debugMode = false;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				if (world instanceof ServerLevel _level) {
					_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Debug mode has been deactivaded."), false);
				}
			} else {
				CraftDefenseModVariables.MapVariables.get(world).debugMode = true;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				if (world instanceof ServerLevel _level) {
					_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Debug mode has been activated."), false);
				}
			}
		}
	}
}