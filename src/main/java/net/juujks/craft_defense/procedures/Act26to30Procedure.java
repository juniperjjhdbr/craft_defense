package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModEntities;

public class Act26to30Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double powerfulChance = 0;
		if (CraftDefenseModVariables.MapVariables.get(world).act == 26) {
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.PUFFERFISH_BOSS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.COD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.COD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.AXOLOTL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act == 27) {
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.DOLPHIN_BOSS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.COD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.COD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.AXOLOTL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.COD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.AXOLOTL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.6 && powerfulChance <= 0.8) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SALMON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act == 28) {
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.DROWNED_BOSS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.COD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.COD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.AXOLOTL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.COD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.2 && powerfulChance <= 0.5) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.AXOLOTL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.5 && powerfulChance <= 0.8) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SALMON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.PUFFERFISH.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act == 29) {
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.GUARDIAN_BOSS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.COD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.COD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.AXOLOTL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.TURTLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.2 && powerfulChance <= 0.5) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.AXOLOTL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.5 && powerfulChance <= 0.8) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SALMON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.PUFFERFISH.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.WARM_PIG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).act == 30) {
			if (CraftDefenseModVariables.MapVariables.get(world).wave == 15 && CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies == CraftDefenseModVariables.MapVariables.get(world).enemyCount - 1) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = CraftDefenseModEntities.ELDER_GUARDIAN_BOSS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.COD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.AXOLOTL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SALMON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.SALMON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.3 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.AXOLOTL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.6 && powerfulChance <= 0.8) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.PUFFERFISH.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.COD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
							Entity entityToSpawn = CraftDefenseModEntities.AXOLOTL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.2 && powerfulChance <= 0.4) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.COD.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.4 && powerfulChance <= 0.6) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SALMON.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else if (powerfulChance > 0.6 && powerfulChance <= 0.8) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.PUFFERFISH.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.TURTLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = CraftDefenseModEntities.TADPOLE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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