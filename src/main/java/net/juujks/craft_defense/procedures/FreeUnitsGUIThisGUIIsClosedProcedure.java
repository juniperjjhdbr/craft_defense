package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class FreeUnitsGUIThisGUIIsClosedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).freeUnitCollected) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							"tellraw @s [\"\",{\"text\":\"[Craft Defense]: It seems you have closed the \"},{\"text\":\"Free Units Menu\",\"bold\":true},{\"text\":\" without collecting an unit. You can still collect it by opening the \\u0020player stats menu!\"}]");
				}
			}
		}
	}
}