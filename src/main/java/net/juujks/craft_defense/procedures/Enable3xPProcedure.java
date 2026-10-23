package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class Enable3xPProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.hasPermissions(1)) {
			if (!CraftDefenseModVariables.MapVariables.get(world).enable3x) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("3x Speed enabled (use this with responsability since this can cause lag)"), false);
				CraftDefenseModVariables.MapVariables.get(world).enable3x = true;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("3x Speed disabled"), false);
				CraftDefenseModVariables.MapVariables.get(world).enable3x = false;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
		}
	}
}