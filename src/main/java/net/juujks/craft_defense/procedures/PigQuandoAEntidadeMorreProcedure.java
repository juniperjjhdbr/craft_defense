package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModEntities;
import net.juujks.craft_defense.entity.SlimeEnemyEntity;
import net.juujks.craft_defense.entity.EvokerEntity;
import net.juujks.craft_defense.CraftDefenseMod;

import java.util.ArrayList;

public class PigQuandoAEntidadeMorreProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		CraftDefenseMod.queueServerWork(1, () -> {
			CraftDefenseModVariables.MapVariables.get(world).enemiesKilled = CraftDefenseModVariables.MapVariables.get(world).enemiesKilled + 1;
			CraftDefenseModVariables.MapVariables.get(world).aliveEnemies = CraftDefenseModVariables.MapVariables.get(world).aliveEnemies - 1;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		});
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (CraftDefenseModVariables.MapVariables.get(world).challenge == 1) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.moneyIG = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG + Mth.nextInt(RandomSource.create(), 30, 40);
					_vars.markSyncDirty();
				}
			} else if (CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.moneyIG = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG + Mth.nextInt(RandomSource.create(), 600, 800);
					_vars.markSyncDirty();
				}
			} else {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.moneyIG = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG + Mth.nextInt(RandomSource.create(), 60, 80);
					_vars.markSyncDirty();
				}
			}
			if (entity.getPersistentData().getDouble("boss") == 1) {
				CraftDefenseModVariables.MapVariables.get(world).bossKilled = true;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 2) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.quest2Number1 = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number1 + 1;
					_vars.markSyncDirty();
				}
			}
			if (entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 2) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.quest2Number3 = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number3 + 1;
					_vars.markSyncDirty();
				}
			}
			if (entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 2) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.quest2Number6 = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number6 + 1;
					_vars.markSyncDirty();
				}
			}
			if (entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 2) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.quest2Number24 = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number24 + 1;
					_vars.markSyncDirty();
				}
			}
		}
		if (entity instanceof SlimeEnemyEntity) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = CraftDefenseModEntities.SLIME_CLONED.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = CraftDefenseModEntities.SLIME_CLONED.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = CraftDefenseModEntities.SLIME_CLONED.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			CraftDefenseModVariables.MapVariables.get(world).aliveEnemies = CraftDefenseModVariables.MapVariables.get(world).aliveEnemies + 3;
			CraftDefenseModVariables.MapVariables.get(world).enemyCount = CraftDefenseModVariables.MapVariables.get(world).enemyCount + 3;
			CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 3;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		}
		if (entity instanceof EvokerEntity) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = CraftDefenseModEntities.VEX.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = CraftDefenseModEntities.VEX.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			CraftDefenseModVariables.MapVariables.get(world).aliveEnemies = CraftDefenseModVariables.MapVariables.get(world).aliveEnemies + 2;
			CraftDefenseModVariables.MapVariables.get(world).enemyCount = CraftDefenseModVariables.MapVariables.get(world).enemyCount + 2;
			CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies = CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies + 2;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}