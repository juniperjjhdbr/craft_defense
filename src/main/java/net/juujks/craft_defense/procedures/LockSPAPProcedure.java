package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class LockSPAPProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).spaLock) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.spaLock = false;
				_vars.markSyncDirty();
			}
		} else {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.spaLock = true;
				_vars.markSyncDirty();
			}
		}
	}
}