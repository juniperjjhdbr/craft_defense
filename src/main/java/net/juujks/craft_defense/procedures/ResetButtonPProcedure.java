package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ResetButtonPProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
			_vars.commonCandies = 0;
			_vars.rareCandies = 0;
			_vars.epicCandies = 0;
			_vars.legendaryCandies = 0;
			_vars.xpToAdd = 0;
			_vars.markSyncDirty();
		}
	}
}