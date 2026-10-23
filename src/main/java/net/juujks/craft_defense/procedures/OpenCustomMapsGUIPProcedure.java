package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;

public class OpenCustomMapsGUIPProcedure {

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            ClientHandler.open();
        }
    }

    // Classe interna estática — só carregada na JVM do cliente
    private static class ClientHandler {
        static void open() {
            net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
            if (mc.player == null) return;

            if (mc.player.isCreative() || mc.player.hasPermissions(2)) {
                mc.execute(() ->
                    mc.setScreen(new net.juujks.craft_defense.client.gui.CustomMapsScreen(mc.screen))
                );
            } else {
                mc.player.sendSystemMessage(
                    Component.literal("§cYou need Creative mode or OP permissions to access Custom Maps.")
                );
            }
        }
    }
}