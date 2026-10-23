package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class EndGamePProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.hasPermissions(1)) {
			CraftDefenseModVariables.MapVariables.get(world).gameStart = false;
			CraftDefenseModVariables.MapVariables.get(world).gameStarted = false;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.playerVoted = false;
				_vars.markSyncDirty();
			}
			CraftDefenseModVariables.MapVariables.get(world).inGame = false;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.playerInGame = false;
				_vars.markSyncDirty();
			}
			CraftDefenseModVariables.MapVariables.get(world).inGame = false;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.moneyIG = 0;
				_vars.markSyncDirty();
			}
			CraftDefenseModVariables.MapVariables.get(world).wave = 0;
			CraftDefenseModVariables.MapVariables.get(world).enemyCount = 2;
			CraftDefenseModVariables.MapVariables.get(world).enemiesKilled = 0;
			CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = 0;
			CraftDefenseModVariables.MapVariables.get(world).shield = 0;
			CraftDefenseModVariables.MapVariables.get(world).lastAnnouncedWave = -1;
			CraftDefenseModVariables.MapVariables.get(world).waveBonus = 120;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Game ended"), false);
		}
	}
}