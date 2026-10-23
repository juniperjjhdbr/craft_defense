package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class ChangeChallengeProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (entity.hasPermissions(1)) {
			CraftDefenseModVariables.MapVariables.get(world).challenge = DoubleArgumentType.getDouble(arguments, "challenge");
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}