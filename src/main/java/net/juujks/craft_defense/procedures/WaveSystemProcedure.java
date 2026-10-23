package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.CraftDefenseMod;

import javax.annotation.Nullable;

import java.util.ArrayList;

@EventBusSubscriber
public class WaveSystemProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		double randomDisc = 0;
		boolean playMusic = false;
		if (CraftDefenseModVariables.MapVariables.get(world).playersInQueue == CraftDefenseModVariables.MapVariables.get(world).voteStart && CraftDefenseModVariables.MapVariables.get(world).playersInQueue > 0
				&& CraftDefenseModVariables.MapVariables.get(world).voteStart > 0) {
			CraftDefenseModVariables.MapVariables.get(world).shield = 0;
			CraftDefenseModVariables.MapVariables.get(world).playersInGame = CraftDefenseModVariables.MapVariables.get(world).playersInQueue;
			CraftDefenseModVariables.MapVariables.get(world).inGame = true;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.gameNotWon = false;
					_vars.gameWon = false;
					_vars.markSyncDirty();
				}
				if (entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).isInQueue) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Teleporting!"), false);
					if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
						ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("craft_defense:td_dim"));
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
					if (CraftDefenseModVariables.MapVariables.get(world).act <= 5) {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s 20 205 35");
							}
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act > 5 && CraftDefenseModVariables.MapVariables.get(world).act <= 10) {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s 1035 205 1006");
							}
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act > 10 && CraftDefenseModVariables.MapVariables.get(world).act <= 15) {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s 1020 210 -980");
							}
						}
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"tellraw @s [\"\",{\"text\":\"TIP: \",\"bold\":true,\"color\":\"aqua\"},{\"text\":\"This map has two paths to defend! It is recommended to bring more units to this map!\"}]");
							}
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act > 15 && CraftDefenseModVariables.MapVariables.get(world).act <= 20) {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s -970 210 -1000");
							}
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act > 20 && CraftDefenseModVariables.MapVariables.get(world).act <= 25) {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s -970 220 1020");
							}
						}
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"tellraw @s [\"\",{\"text\":\"TIP: \",\"bold\":true,\"color\":\"aqua\"},{\"text\":\"This map has two paths to defend! It is recommended to bring more units to this map!\"}]");
							}
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act > 25 && CraftDefenseModVariables.MapVariables.get(world).act <= 30) {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s 1045 205 30");
							}
						}
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"tellraw @s [\"\",{\"text\":\"TIP: \",\"bold\":true,\"color\":\"aqua\"},{\"text\":\"This map has two paths to defend! It is recommended to bring more units to this map!\"}]");
							}
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910) {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s 10040 220 23");
							}
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act == 911) {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s 10012 215 -9988");
							}
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act == 1000) {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s 10020 215 10015");
							}
						}
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"tellraw @s [\"\",{\"text\":\"TIP: \",\"bold\":true,\"color\":\"aqua\"},{\"text\":\"This map has two paths to defend! It is recommended to bring more units to this map!\"}]");
							}
						}
					}
					TeleportCustomStrucutreProcedure.execute(world, entityiterator);
					{
						Entity _ent = entityiterator;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "stopsound @s");
						}
					}
					{
						CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.playerVotedStart = false;
						_vars.playerInGame = true;
						_vars.markSyncDirty();
					}
					if (entityiterator instanceof Player _player)
						_player.closeContainer();
					{
						CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.steve_spawned = 0;
						_vars.alex_spawned = 0;
						_vars.zombie_spawned = 0;
						_vars.skeleton_spawned = 0;
						_vars.creeper_spawned = 0;
						_vars.spider_spawned = 0;
						_vars.slime_spawned = 0;
						_vars.witch_spawned = 0;
						_vars.villager_spawned = 0;
						_vars.cavespider_spawned = 0;
						_vars.markSyncDirty();
					}
					CraftDefenseModVariables.MapVariables.get(world).enemyCount = CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910
							? 1
							: CraftDefenseModVariables.MapVariables.get(world).enemyCount;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					{
						CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.isInQueue = false;
						_vars.markSyncDirty();
					}
					CraftDefenseModVariables.MapVariables.get(world).startCooldown = 1200;
					CraftDefenseModVariables.MapVariables.get(world).playMusic = true;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
				CraftDefenseMod.queueServerWork(1, () -> {
					CraftDefenseModVariables.MapVariables.get(world).playersInQueue = 0;
					CraftDefenseModVariables.MapVariables.get(world).voteStart = 0;
					CraftDefenseModVariables.MapVariables.get(world).spawnEnemies = true;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				});
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).startCooldown > 1) {
			CraftDefenseModVariables.MapVariables.get(world).startCooldown = CraftDefenseModVariables.MapVariables.get(world).startCooldown - 1;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerInGame) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("Map is starting in " + new java.text.DecimalFormat("##").format(Math.round(CraftDefenseModVariables.MapVariables.get(world).startCooldown / 80)))), true);
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).startCooldown == 2) {
			CraftDefenseModVariables.MapVariables.get(world).gameStart = true;
			CraftDefenseModVariables.MapVariables.get(world).startCooldown = 0;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		}
		if (CraftDefenseModVariables.MapVariables.get(world).inGame) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((CraftDefenseModVariables.MapVariables.get(world).skipWave == CraftDefenseModVariables.MapVariables.get(world).playersInGame || CraftDefenseModVariables.MapVariables.get(world).aliveEnemies == 0)
						&& CraftDefenseModVariables.MapVariables.get(world).wave >= 1 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount
						&& CraftDefenseModVariables.MapVariables.get(world).enemyCount > 0) {
					if (CraftDefenseModVariables.MapVariables.get(world).act == 1000) {
						CraftDefenseModVariables.MapVariables.get(world).wave = CraftDefenseModVariables.MapVariables.get(world).wave + 1;
						CraftDefenseModVariables.MapVariables.get(world).enemiesKilled = 0;
						CraftDefenseModVariables.MapVariables.get(world).enemyCount = CraftDefenseModVariables.MapVariables.get(world).enemyCount + 1;
						CraftDefenseModVariables.MapVariables.get(world).skipWave = 0;
						CraftDefenseModVariables.MapVariables.get(world).waveBonus = Math.round(CraftDefenseModVariables.MapVariables.get(world).waveBonus * 1.25);
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						{
							CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.playerVoted = false;
							_vars.markSyncDirty();
						}
						CraftDefenseModVariables.MapVariables.get(world).farmerVar = true;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						CraftDefenseMod.queueServerWork(5, () -> {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.skipWaveProcessing = true;
								_vars.markSyncDirty();
							}
						});
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = 0;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (CraftDefenseModVariables.MapVariables.get(world).wave < 15) {
							CraftDefenseModVariables.MapVariables.get(world).wave = CraftDefenseModVariables.MapVariables.get(world).wave + 1;
							CraftDefenseModVariables.MapVariables.get(world).enemiesKilled = 0;
							CraftDefenseModVariables.MapVariables.get(world).enemyCount = CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910
									? 1
									: CraftDefenseModVariables.MapVariables.get(world).enemyCount + 1;
							CraftDefenseModVariables.MapVariables.get(world).skipWave = 0;
							CraftDefenseModVariables.MapVariables.get(world).waveBonus = Math.round(CraftDefenseModVariables.MapVariables.get(world).waveBonus * 1.25);
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							{
								CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.playerVoted = false;
								_vars.markSyncDirty();
							}
							CraftDefenseModVariables.MapVariables.get(world).farmerVar = true;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							CraftDefenseMod.queueServerWork(5, () -> {
								{
									CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
									_vars.skipWaveProcessing = true;
									_vars.markSyncDirty();
								}
							});
							CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = 0;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
					}
				}
				if (CraftDefenseModVariables.MapVariables.get(world).bossKilled) {
					CraftDefenseModVariables.MapVariables.get(world).wave = 0;
					CraftDefenseModVariables.MapVariables.get(world).enemiesKilled = 0;
					CraftDefenseModVariables.MapVariables.get(world).enemyCount = 2;
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = 0;
					CraftDefenseModVariables.MapVariables.get(world).skipWave = 0;
					CraftDefenseModVariables.MapVariables.get(world).waveBonus = 120;
					CraftDefenseModVariables.MapVariables.get(world).lastAnnouncedWave = -1;
					CraftDefenseModVariables.MapVariables.get(world).gameSpeed = 1;
					CraftDefenseModVariables.MapVariables.get(world).difficulty = 1;
					CraftDefenseModVariables.MapVariables.get(world).challenge = 0;
					CraftDefenseModVariables.MapVariables.get(world).gameStart = false;
					CraftDefenseModVariables.MapVariables.get(world).gameStarted = false;
					CraftDefenseModVariables.MapVariables.get(world).unitReward = true;
					CraftDefenseModVariables.MapVariables.get(world).gameEnded = true;
					CraftDefenseModVariables.MapVariables.get(world).bossKilled = false;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					CraftDefenseMod.queueServerWork(5, () -> {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.gameWon = true;
							_vars.markSyncDirty();
						}
						CraftDefenseModVariables.MapVariables.get(world).customMapId = 0;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					});
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).gameLost) {
			CraftDefenseModVariables.MapVariables.get(world).enemiesKilled = 0;
			CraftDefenseModVariables.MapVariables.get(world).enemyCount = 2;
			CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = 0;
			CraftDefenseModVariables.MapVariables.get(world).skipWave = 0;
			CraftDefenseModVariables.MapVariables.get(world).waveBonus = 120;
			CraftDefenseModVariables.MapVariables.get(world).lastAnnouncedWave = -1;
			CraftDefenseModVariables.MapVariables.get(world).gameSpeed = 1;
			CraftDefenseModVariables.MapVariables.get(world).difficulty = 1;
			CraftDefenseModVariables.MapVariables.get(world).challenge = 0;
			CraftDefenseModVariables.MapVariables.get(world).gameStart = false;
			CraftDefenseModVariables.MapVariables.get(world).gameStarted = false;
			CraftDefenseModVariables.MapVariables.get(world).gameEnded = true;
			CraftDefenseModVariables.MapVariables.get(world).bossKilled = false;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				CraftDefenseMod.queueServerWork(5, () -> {
					{
						CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.gameNotWon = true;
						_vars.markSyncDirty();
					}
					CraftDefenseModVariables.MapVariables.get(world).customMapId = 0;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				});
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A74\u00A7lYou've lost the game... Teleporting back in a few seconds"), true);
			}
			CraftDefenseMod.queueServerWork(1, () -> {
				CraftDefenseModVariables.MapVariables.get(world).gameLost = false;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			});
		}
	}
}