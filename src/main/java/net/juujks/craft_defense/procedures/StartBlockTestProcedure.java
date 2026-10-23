package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModEntities;
import net.juujks.craft_defense.entity.SheepEntity;
import net.juujks.craft_defense.entity.HorseEntity;
import net.juujks.craft_defense.entity.CowEntity;
import net.juujks.craft_defense.entity.ChickenEntity;

import java.util.Comparator;
import java.util.ArrayList;

public class StartBlockTestProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double powerfulChance = 0;
		double announceCooldown = 0;
		boolean announced = false;
		if (CraftDefenseModVariables.MapVariables.get(world).spawnEnemies) {
			if (CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies < CraftDefenseModVariables.MapVariables.get(world).enemyCount && CraftDefenseModVariables.MapVariables.get(world).wave > 0) {
				if (CraftDefenseModVariables.MapVariables.get(world).gameSpeed == 1) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("spawnCooldown", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "spawnCooldown") + 1));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if (CraftDefenseModVariables.MapVariables.get(world).gameSpeed == 2) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("spawnCooldown", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "spawnCooldown") + 2));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("spawnCooldown", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "spawnCooldown") + 3));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("spawnCooldown", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave != CraftDefenseModVariables.MapVariables.get(world).lastAnnouncedWave) {
				announceCooldown = 0;
				if (CraftDefenseModVariables.MapVariables.get(world).act == 2) {
					if (CraftDefenseModVariables.MapVariables.get(world).wave == 3) {
						announceCooldown = 1;
						CraftDefenseModVariables.MapVariables.get(world).lastAnnouncedWave = CraftDefenseModVariables.MapVariables.get(world).wave;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				}
				if (CraftDefenseModVariables.MapVariables.get(world).act == 3) {
					if (CraftDefenseModVariables.MapVariables.get(world).wave == 6) {
						announceCooldown = 2;
						CraftDefenseModVariables.MapVariables.get(world).lastAnnouncedWave = CraftDefenseModVariables.MapVariables.get(world).wave;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				}
				if (CraftDefenseModVariables.MapVariables.get(world).act == 4) {
					if (CraftDefenseModVariables.MapVariables.get(world).wave == 10) {
						announceCooldown = 3;
						CraftDefenseModVariables.MapVariables.get(world).lastAnnouncedWave = CraftDefenseModVariables.MapVariables.get(world).wave;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				}
				if (CraftDefenseModVariables.MapVariables.get(world).act == 5) {
					if (CraftDefenseModVariables.MapVariables.get(world).wave == 3) {
						announceCooldown = 4;
						CraftDefenseModVariables.MapVariables.get(world).lastAnnouncedWave = CraftDefenseModVariables.MapVariables.get(world).wave;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				}
				if (announceCooldown != 0) {
					for (Entity entityiterator : new ArrayList<>(world.players())) {
						if (entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerInGame) {
							if (announceCooldown == 1) {
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"tellraw @s [\"\",{\"text\":\"--- \u26A0 WARNING \u26A0 ---\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"Powerful Enemies:\",\"bold\":true,\"color\":\"red\"},{\"text\":\" Can only be attacked by units with atleast 1 upgrade\"}]");
									}
								}
							} else if (announceCooldown == 2) {
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"tellraw @s [\"\",{\"text\":\"--- \u26A0 WARNING \u26A0 ---\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"Aerial Enemies:\",\"bold\":true,\"color\":\"aqua\"},{\"text\":\" Can only be attacked by aerial type units\"}]");
									}
								}
							} else if (announceCooldown == 3) {
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"tellraw @s [\"\",{\"text\":\"--- \u26A0 WARNING \u26A0 ---\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"Poweful II Enemies:\",\"bold\":true,\"color\":\"dark_red\"},{\"text\":\" Can only be attacked by units with atleast 2 upgrades\"}]");
									}
								}
							} else if (announceCooldown == 4) {
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"tellraw @s [\"\",{\"text\":\"--- \u26A0 WARNING \u26A0 ---\",\"bold\":true,\"color\":\"yellow\"},{\"text\":\"\\n\"},{\"text\":\"Fast Enemies:\",\"bold\":true,\"color\":\"gold\"},{\"text\":\" Are faster than other types of enemies\"}]");
									}
								}
							}
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.pling")), SoundSource.NEUTRAL, 1, 0);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.pling")), SoundSource.NEUTRAL, 1, 0, false);
						}
					}
					announceCooldown = 0;
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "spawnCooldown") >= 20 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies < CraftDefenseModVariables.MapVariables.get(world).enemyCount) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("spawnCooldown", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (CraftDefenseModVariables.MapVariables.get(world).act == 1) {
					if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.PIG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				}
				if (CraftDefenseModVariables.MapVariables.get(world).act == 2) {
					if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (CraftDefenseModVariables.MapVariables.get(world).wave > 3) {
							powerfulChance = Math.random();
							if (powerfulChance <= 0.3) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.COW.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, CowEntity.class, x, y, z, 5)).getPersistentData().putDouble("powerful", 2);
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.PIG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							}
						} else {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = CraftDefenseModEntities.PIG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
							CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
					}
				}
				if (CraftDefenseModVariables.MapVariables.get(world).act == 3) {
					if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SPIDER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (CraftDefenseModVariables.MapVariables.get(world).wave > 3 && CraftDefenseModVariables.MapVariables.get(world).wave <= 7) {
							powerfulChance = Math.random();
							if (powerfulChance <= 0.3) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.COW.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, CowEntity.class, x, y, z, 5)).getPersistentData().putDouble("powerful", 2);
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.PIG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).wave > 7) {
							powerfulChance = Math.random();
							if (powerfulChance <= 0.3) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.COW.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, CowEntity.class, x, y, z, 5)).getPersistentData().putDouble("powerful", 2);
							} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.CHICKEN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, ChickenEntity.class, x, y, z, 5)).getPersistentData().putBoolean("aerial", true);
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.PIG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							}
						} else {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = CraftDefenseModEntities.PIG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
							CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
					}
				}
				if (CraftDefenseModVariables.MapVariables.get(world).act == 4) {
					if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.CREEPER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (CraftDefenseModVariables.MapVariables.get(world).wave > 3 && CraftDefenseModVariables.MapVariables.get(world).wave <= 7) {
							powerfulChance = Math.random();
							if (powerfulChance <= 0.3) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.COW.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, CowEntity.class, x, y, z, 5)).getPersistentData().putDouble("powerful", 2);
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.PIG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).wave > 7 && CraftDefenseModVariables.MapVariables.get(world).wave <= 10) {
							powerfulChance = Math.random();
							if (powerfulChance <= 0.3) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.COW.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, CowEntity.class, x, y, z, 5)).getPersistentData().putDouble("powerful", 2);
							} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.CHICKEN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, ChickenEntity.class, x, y, z, 5)).getPersistentData().putBoolean("aerial", true);
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.PIG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).wave > 10) {
							powerfulChance = Math.random();
							if (powerfulChance <= 0.2) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.COW.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, CowEntity.class, x, y, z, 5)).getPersistentData().putDouble("powerful", 2);
							} else if (powerfulChance > 0.2 && powerfulChance <= 0.5) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.CHICKEN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, ChickenEntity.class, x, y, z, 5)).getPersistentData().putBoolean("aerial", true);
							} else if (powerfulChance > 0.5 && powerfulChance <= 0.8) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.SHEEP.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, SheepEntity.class, x, y, z, 5)).getPersistentData().putDouble("powerful", 3);
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.PIG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							}
						} else {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = CraftDefenseModEntities.PIG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
							CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
					}
				}
				if (CraftDefenseModVariables.MapVariables.get(world).act == 5) {
					if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SLIME.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (CraftDefenseModVariables.MapVariables.get(world).wave > 3 && CraftDefenseModVariables.MapVariables.get(world).wave <= 7) {
							powerfulChance = Math.random();
							if (powerfulChance <= 0.3) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.COW.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, CowEntity.class, x, y, z, 5)).getPersistentData().putDouble("powerful", 2);
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.HORSE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, HorseEntity.class, x, y, z, 5)).getPersistentData().putBoolean("fast", true);
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).wave > 7 && CraftDefenseModVariables.MapVariables.get(world).wave <= 10) {
							powerfulChance = Math.random();
							if (powerfulChance <= 0.3) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.COW.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, CowEntity.class, x, y, z, 5)).getPersistentData().putDouble("powerful", 2);
							} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.CHICKEN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, ChickenEntity.class, x, y, z, 5)).getPersistentData().putBoolean("aerial", true);
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.HORSE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, HorseEntity.class, x, y, z, 5)).getPersistentData().putBoolean("fast", true);
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).wave > 10) {
							powerfulChance = Math.random();
							if (powerfulChance <= 0.2) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.COW.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, CowEntity.class, x, y, z, 5)).getPersistentData().putDouble("powerful", 2);
							} else if (powerfulChance > 0.2 && powerfulChance <= 0.5) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.CHICKEN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, ChickenEntity.class, x, y, z, 5)).getPersistentData().putBoolean("aerial", true);
							} else if (powerfulChance > 0.5 && powerfulChance <= 0.8) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.SHEEP.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, SheepEntity.class, x, y, z, 5)).getPersistentData().putDouble("powerful", 3);
							} else {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = CraftDefenseModEntities.HORSE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
								CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
								(findEntityInWorldRange(world, HorseEntity.class, x, y, z, 5)).getPersistentData().putBoolean("fast", true);
							}
						} else {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = CraftDefenseModEntities.PIG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
							CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
					}
				}
				Act6To10Procedure.execute(world, x, y, z);
				Act11to15Procedure.execute(world, x, y, z);
				Act16to20Procedure.execute(world, x, y, z);
				Act21to25Procedure.execute(world, x, y, z);
				Act26to30Procedure.execute(world, x, y, z);
				InfinityPProcedure.execute(world, x, y, z);
				BossRush1Procedure.execute(world, x, y, z);
				Event1PProcedure.execute(world, x, y, z);
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}