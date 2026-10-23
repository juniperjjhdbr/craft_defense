package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModEntities;

public class InfinityPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double powerfulChance = 0;
		if (CraftDefenseModVariables.MapVariables.get(world).act == 1000) {
			if (CraftDefenseModVariables.MapVariables.get(world).wave > 4 && CraftDefenseModVariables.MapVariables.get(world).wave <= 8) {
				powerfulChance = Math.random();
				if (powerfulChance <= 0.3) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_POWERFUL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			} else if (CraftDefenseModVariables.MapVariables.get(world).wave > 8 && CraftDefenseModVariables.MapVariables.get(world).wave <= 12) {
				powerfulChance = Math.random();
				if (powerfulChance <= 0.3) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_POWERFUL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_AERIAL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			} else if (CraftDefenseModVariables.MapVariables.get(world).wave > 12 && CraftDefenseModVariables.MapVariables.get(world).wave <= 16) {
				powerfulChance = Math.random();
				if (powerfulChance <= 0.2) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_POWERFUL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else if (powerfulChance > 0.2 && powerfulChance <= 0.5) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_AERIAL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else if (powerfulChance > 0.5 && powerfulChance <= 0.8) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_POWERFUL_2.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			} else if (CraftDefenseModVariables.MapVariables.get(world).wave > 16 && CraftDefenseModVariables.MapVariables.get(world).wave <= 20) {
				powerfulChance = Math.random();
				if (powerfulChance <= 0.2) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_POWERFUL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else if (powerfulChance > 0.2 && powerfulChance <= 0.4) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_AERIAL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else if (powerfulChance > 0.4 && powerfulChance <= 0.6) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_POWERFUL_2.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else if (powerfulChance > 0.6 && powerfulChance <= 0.8) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_POWERFUL_3.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_FAST.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			} else if (CraftDefenseModVariables.MapVariables.get(world).wave > 20 && CraftDefenseModVariables.MapVariables.get(world).wave <= 24) {
				powerfulChance = Math.random();
				if (powerfulChance <= 0.2) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_REGENERATOR.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else if (powerfulChance > 0.2 && powerfulChance <= 0.4) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_AERIAL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else if (powerfulChance > 0.4 && powerfulChance <= 0.6) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_POWERFUL_2.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else if (powerfulChance > 0.6 && powerfulChance <= 0.8) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_POWERFUL_3.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_FAST.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			} else if (CraftDefenseModVariables.MapVariables.get(world).wave > 24) {
				powerfulChance = Math.random();
				if (powerfulChance <= 0.2) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_REGENERATOR.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else if (powerfulChance > 0.2 && powerfulChance <= 0.4) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_AERIAL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else if (powerfulChance > 0.4 && powerfulChance <= 0.6) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_POWERFUL_2.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				} else if (powerfulChance > 0.6 && powerfulChance <= 0.8) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_POWERFUL_3.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.ENEMY_TANK.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			} else {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.ENEMY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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