package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.CraftDefenseMod;

public class UnbugProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).unBugConfirm == 0) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							"tellraw @s [\"\",{\"text\":\"WARNING: \",\"bold\":true,\"color\":\"red\"},{\"text\":\"Using this command will bring you to your spawnpoint and will unbug you from starting raids. Only use this if you are stuck in the mod dimension or can not start a raid at all. Use \\\"/craft_defense unbug\\\" again if you are bugged in one of these conditions (stats, units and quests are not affected).\",\"color\":\"red\"},{\"text\":\"IF YOUR SPAWNPOINT IS SET TO A MODDED DIMENSION IT MIGHT NOT WORK AS INTENDED\",\"bold\":true,\"color\":\"red\"}]");
				}
			}
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.unBugConfirm = 1;
				_vars.markSyncDirty();
			}
		}
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).unBugConfirm == 1) {
			if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
				ResourceKey<Level> destinationType = Level.OVERWORLD;
				if (_player.level().dimension() == destinationType)
					return;
				ServerLevel nextLevel = _player.server.getLevel(destinationType);
				if (nextLevel != null) {
					_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
					_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
					_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
					for (MobEffectInstance _effectinstance : _player.getActiveEffects())
						_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
					_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
				}
			}
			CraftDefenseMod.queueServerWork(20, () -> {
				{
					Entity _ent = entity;
					double _tx = ((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
							? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getX() : _player.level().getLevelData().getSpawnPos().getX())
							: 0);
					double _ty = ((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
							? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getY() : _player.level().getLevelData().getSpawnPos().getY())
							: 0);
					double _tz = ((entity instanceof ServerPlayer _player && !_player.level().isClientSide())
							? ((_player.getRespawnDimension().equals(_player.level().dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getZ() : _player.level().getLevelData().getSpawnPos().getZ())
							: 0);
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
				CraftDefenseModVariables.MapVariables.get(world).gameEnded = true;
				CraftDefenseModVariables.MapVariables.get(world).inGame = false;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.playerVoted = false;
					_vars.playerVotedStart = false;
					_vars.playerInGame = false;
					_vars.unBugConfirm = 0;
					_vars.markSyncDirty();
				}
			});
		}
	}
}