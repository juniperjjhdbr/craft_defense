package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModEntities;

public class Act11to15Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double powerfulChance = 0;
		if (CraftDefenseModVariables.MapVariables.get(world).act == 11) {
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.WITCH.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.BAT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act == 12) {
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_VILLAGER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.BAT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				} else if (CraftDefenseModVariables.MapVariables.get(world).wave > 10) {
					powerfulChance = Math.random();
					if (powerfulChance <= 0.3) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.BAT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.6 && powerfulChance <= 0.8) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SPIDER_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act == 13) {
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.CAVE_SPIDER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SPIDER_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.BAT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SPIDER_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.2 && powerfulChance <= 0.5) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.BAT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.5 && powerfulChance <= 0.8) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.CREEPER_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SPIDER_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act == 14) {
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_HORSE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SPIDER_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.BAT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SPIDER_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.2 && powerfulChance <= 0.5) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.BAT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.5 && powerfulChance <= 0.8) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.CREEPER_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SLIME_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act == 15) {
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.SKELETON_HORSE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.BAT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SPIDER_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.BAT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.6 && powerfulChance <= 0.8) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.CREEPER_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SPIDER_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SKELETON_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.2 && powerfulChance <= 0.4) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.BAT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.4 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.CREEPER_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.6 && powerfulChance <= 0.8) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SPIDER_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SLIME_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			}
		}
	}
}