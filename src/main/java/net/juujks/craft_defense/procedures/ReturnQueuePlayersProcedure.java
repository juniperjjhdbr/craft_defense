package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.Minecraft;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnQueuePlayersProcedure {
	public static String execute(LevelAccessor world) {
		return "Player in queue: " + new java.text.DecimalFormat("##").format(CraftDefenseModVariables.MapVariables.get(world).playersInQueue) + "/"
				+ new java.text.DecimalFormat("##").format(world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount());
	}
}