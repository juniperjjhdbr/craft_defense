package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ResetRaidManagerPProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		CraftDefenseModVariables.MapVariables.get(world).act = 0;
		CraftDefenseModVariables.MapVariables.get(world).playersInGame = 0;
		CraftDefenseModVariables.MapVariables.get(world).playersInQueue = 0;
		CraftDefenseModVariables.MapVariables.get(world).voteStart = 0;
		CraftDefenseModVariables.MapVariables.get(world).skipWave = 0;
		CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		{
			CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
			_vars.autoSkip = false;
			_vars.isInQueue = false;
			_vars.playerVotedStart = false;
			_vars.playerVoted = false;
			_vars.markSyncDirty();
		}
	}
}