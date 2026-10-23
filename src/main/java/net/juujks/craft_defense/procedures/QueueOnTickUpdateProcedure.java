package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class QueueOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (CraftDefenseModVariables.MapVariables.get(world).voteStart < 0) {
			CraftDefenseModVariables.MapVariables.get(world).playersInQueue = 0;
			CraftDefenseModVariables.MapVariables.get(world).voteStart = 0;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.isInQueue = false;
				_vars.playerVotedStart = false;
				_vars.markSyncDirty();
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).inGame) {
			if (entity instanceof Player _player)
				_player.closeContainer();
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cERROR: You can not start a raid while there is already one raid happening!"), false);
		}
		if (CraftDefenseModVariables.MapVariables.get(world).customMapId == 0) {
			if (CraftDefenseModVariables.MapVariables.get(world).mission == 0 && (CraftDefenseModVariables.MapVariables.get(world).act != 901 && CraftDefenseModVariables.MapVariables.get(world).act != 911
					&& CraftDefenseModVariables.MapVariables.get(world).act != 1000 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastBeatenAct < CraftDefenseModVariables.MapVariables.get(world).act - 1
					|| CraftDefenseModVariables.MapVariables.get(world).act == 901 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastBeatenAct < 9
					|| CraftDefenseModVariables.MapVariables.get(world).act == 1000 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastBeatenAct < 4)) {
				if (entity instanceof Player _player)
					_player.closeContainer();
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cERROR: You haven't unlocked this act yet!"), false);
			}
		}
		if ((CraftDefenseModVariables.MapVariables.get(world).ownerOfRaid).equals("")) {
			CraftDefenseModVariables.MapVariables.get(world).ownerOfRaid = entity.getDisplayName().getString();
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}