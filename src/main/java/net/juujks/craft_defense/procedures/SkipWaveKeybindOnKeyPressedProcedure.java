package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class SkipWaveKeybindOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerInGame) {
			if (CraftDefenseModVariables.MapVariables.get(world).act == 1000) {
				if (CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies >= CraftDefenseModVariables.MapVariables.get(world).enemyCount) {
					if (!entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerVoted) {
						CraftDefenseModVariables.MapVariables.get(world).skipWave = CraftDefenseModVariables.MapVariables.get(world).skipWave + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.playerVoted = true;
							_vars.markSyncDirty();
						}
					}
				}
			} else {
				if (CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies >= CraftDefenseModVariables.MapVariables.get(world).enemyCount && CraftDefenseModVariables.MapVariables.get(world).wave < 15) {
					if (!entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerVoted) {
						CraftDefenseModVariables.MapVariables.get(world).skipWave = CraftDefenseModVariables.MapVariables.get(world).skipWave + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.playerVoted = true;
							_vars.markSyncDirty();
						}
					}
				}
			}
		}
	}
}