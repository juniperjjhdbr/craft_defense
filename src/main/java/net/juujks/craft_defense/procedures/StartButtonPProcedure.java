package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class StartButtonPProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerVotedStart) {
			CraftDefenseModVariables.MapVariables.get(world).voteStart = CraftDefenseModVariables.MapVariables.get(world).voteStart + 1;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.playerVotedStart = true;
				_vars.oldX = entity.getX();
				_vars.oldY = entity.getY();
				_vars.oldZ = entity.getZ();
				_vars.markSyncDirty();
			}
			if ((entity.level().dimension()) == Level.END) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.oldDim = "end";
					_vars.markSyncDirty();
				}
			} else if ((entity.level().dimension()) == Level.NETHER) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.oldDim = "nether";
					_vars.markSyncDirty();
				}
			} else {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.oldDim = "overworld";
					_vars.markSyncDirty();
				}
			}
		}
	}
}