package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class GameStartPProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.hasPermissions(1)) {
			if (!CraftDefenseModVariables.MapVariables.get(world).gameStart) {
				CraftDefenseModVariables.MapVariables.get(world).gameStart = true;
				CraftDefenseModVariables.MapVariables.get(world).gameStarted = false;
				CraftDefenseModVariables.MapVariables.get(world).inGame = true;
				CraftDefenseModVariables.MapVariables.get(world).playersInGame = world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount();
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Game started. Good luck!"), false);
			}
		}
	}
}