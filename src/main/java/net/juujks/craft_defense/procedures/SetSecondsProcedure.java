package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetSecondsProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (entity.hasPermissions(1)) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.secondsPlayed = DoubleArgumentType.getDouble(arguments, "seconds");
				_vars.markSyncDirty();
			}
		}
	}
}