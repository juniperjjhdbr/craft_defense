package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModEntities;

public class BossRush1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double powerfulChance = 0;
		if (CraftDefenseModVariables.MapVariables.get(world).act == 901) {
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 1 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 2 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.SKELETON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 3 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.SPIDER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 4 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.CREEPER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 5 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.SLIME.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 6 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.RABBIT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 7 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.LLAMA_B.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 8 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.STRAY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 9 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.POLAR_BEAR.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 10 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.SNOW_GOLEM.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 11 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.WITCH.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 12 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_VILLAGER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 13 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.CAVE_SPIDER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 14 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.ZOMBIE_HORSE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.SKELETON_HORSE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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