package net.juujks.craft_defense.procedures;

import net.juujks.craft_defense.cdmap.CustomMapLoader;
import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class TeleportCustomStrucutreProcedure {

    public static void execute(LevelAccessor world, Entity entity) {
        int id = (int) CraftDefenseModVariables.MapVariables.get(world).customMapId;
        if (id <= 0) return;

        int spawnX = CustomMapLoader.getSpawnX(id) + 4;

        if (!entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(
                new CommandSourceStack(
                    CommandSource.NULL,
                    entity.position(),
                    entity.getRotationVector(),
                    entity.level() instanceof ServerLevel sl ? sl : null,
                    4,
                    entity.getName().getString(),
                    entity.getDisplayName(),
                    entity.level().getServer(),
                    entity
                ),
                "tp @s " + spawnX + " 205 4"
            );
        }
    }
}