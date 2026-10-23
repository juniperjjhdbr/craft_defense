package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ShareCooldownPProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (CraftDefenseModVariables.MapVariables.get(world).shareCooldown > 0) {
			CraftDefenseModVariables.MapVariables.get(world).shareCooldown = CraftDefenseModVariables.MapVariables.get(world).shareCooldown - 1;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}