package net.juujks.craft_defense.procedures;

public class DiscordButtonProcedure {
    public static void execute() {
		net.minecraft.client.Minecraft.getInstance().submit(() -> {
    		net.minecraft.Util.getPlatform().openUri("https://discord.gg/JTgSNTUt8F");
		});
    }
}