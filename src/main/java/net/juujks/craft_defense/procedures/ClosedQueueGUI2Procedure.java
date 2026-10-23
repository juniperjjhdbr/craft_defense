package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ClosedQueueGUI2Procedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double counter = 0;
		if (CraftDefenseModVariables.MapVariables.get(world).teleportTimer <= -1) {
			CraftDefenseModVariables.MapVariables.get(world).teleportTimer = CraftDefenseModVariables.MapVariables.get(world).teleportTimer - 1;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			if (CraftDefenseModVariables.MapVariables.get(world).teleportTimer <= -5) {
				if (!CraftDefenseModVariables.MapVariables.get(world).inGame) {
					if (CraftDefenseModVariables.MapVariables.get(world).playersInQueue > 0) {
						CraftDefenseModVariables.MapVariables.get(world).playersInQueue = CraftDefenseModVariables.MapVariables.get(world).playersInQueue - 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerVotedStart) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.playerVotedStart = false;
								_vars.markSyncDirty();
							}
							CraftDefenseModVariables.MapVariables.get(world).voteStart = CraftDefenseModVariables.MapVariables.get(world).voteStart - 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
					} else {
						CraftDefenseModVariables.MapVariables.get(world).map = "";
						CraftDefenseModVariables.MapVariables.get(world).ownerOfRaid = "";
						CraftDefenseModVariables.MapVariables.get(world).difficulty = 1;
						CraftDefenseModVariables.MapVariables.get(world).challenge = 0;
						CraftDefenseModVariables.MapVariables.get(world).mission = 0;
						CraftDefenseModVariables.MapVariables.get(world).playersInQueue = 0;
						CraftDefenseModVariables.MapVariables.get(world).voteStart = 0;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					}
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.isInQueue = false;
						_vars.markSyncDirty();
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).teleportTimer = 0;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
		}
	}
}