package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class XpToAddPProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
			_vars.xpToAdd = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).legendaryCandies * 2700 + entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).epicCandies * 675
					+ entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).rareCandies * 225 + entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).commonCandies * 100;
			_vars.markSyncDirty();
		}
	}
}