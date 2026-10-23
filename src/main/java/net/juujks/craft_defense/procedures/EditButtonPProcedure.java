package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class EditButtonPProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).editingRoom) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.editingRoom = false;
				_vars.markSyncDirty();
			}
		} else {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.editingRoom = true;
				_vars.markSyncDirty();
			}
		}
	}
}