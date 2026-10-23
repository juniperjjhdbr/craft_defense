package net.juujks.craft_defense.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.ChatFormatting;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
public class VersionCheckProcedure {

    private static final String CURRENT_VERSION = "6.2";
    private static final String VERSION_URL = "https://raw.githubusercontent.com/juniperjjhdbr/craft_defense_version_check/refs/heads/main/.github/workflows/version_check.txt";

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player))
            return;

        CompletableFuture.runAsync(() -> {
            String latest = fetchLatestVersion();
            if (latest == null) return;

            if (!CURRENT_VERSION.equalsIgnoreCase(latest.trim())) {
                MutableComponent warning = Component.literal("§c[Warning] You are using an outdated version of Craft Defense (" + CURRENT_VERSION +
                        "). Latest version: " + latest + ".\n§7Download the latest version: ");

                // Clickable links
                MutableComponent curseforgeLink = Component.literal("[CurseForge]")
                        .setStyle(Style.EMPTY
                                .withColor(ChatFormatting.BLUE)
                                .withUnderlined(true)
                                .withClickEvent(new net.minecraft.network.chat.ClickEvent(
                                        net.minecraft.network.chat.ClickEvent.Action.OPEN_URL,
                                        "https://www.curseforge.com/minecraft/mc-mods/craft-defense"))
                                .withHoverEvent(new net.minecraft.network.chat.HoverEvent(
                                        net.minecraft.network.chat.HoverEvent.Action.SHOW_TEXT,
                                        Component.literal("Open CurseForge page"))));

                MutableComponent modrinthLink = Component.literal("[Modrinth]")
                        .setStyle(Style.EMPTY
                                .withColor(ChatFormatting.GREEN)
                                .withUnderlined(true)
                                .withClickEvent(new net.minecraft.network.chat.ClickEvent(
                                        net.minecraft.network.chat.ClickEvent.Action.OPEN_URL,
                                        "https://modrinth.com/mod/craft-defense"))
                                .withHoverEvent(new net.minecraft.network.chat.HoverEvent(
                                        net.minecraft.network.chat.HoverEvent.Action.SHOW_TEXT,
                                        Component.literal("Open Modrinth page"))));

                warning.append(curseforgeLink).append(" ").append(modrinthLink);

                player.sendSystemMessage(warning);
            }
        });
    }

    private static String fetchLatestVersion() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(VERSION_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200)
                return response.body().trim();
        } catch (Exception ignored) {}
        return null;
    }
}
