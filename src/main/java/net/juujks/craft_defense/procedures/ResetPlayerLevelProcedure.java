package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ResetPlayerLevelProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.hasPermissions(1)) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.wins = 0;
				_vars.playerLevel = 1;
				_vars.winsLUP = 0;
				_vars.winsLUPCap = 1;
				_vars.markSyncDirty();
			}
		}
	}
}