package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class QuestCompletionPProcedure {
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
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number1 >= entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber1 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 != 0
				&& 0 != entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber1) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.questType1 = 0;
				_vars.markSyncDirty();
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You have completed a quest!"), false);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CraftDefenseModItems.COMMON_XP_CANDY.get()).copy();
				_setstack.setCount(16);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number3 >= entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber3 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 != 0
				&& 0 != entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber3) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.questType3 = 0;
				_vars.markSyncDirty();
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You have completed a quest!"), false);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CraftDefenseModItems.RARE_XP_CANDY.get()).copy();
				_setstack.setCount(16);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number6 >= entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber6 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 != 0
				&& 0 != entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber6) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.questType6 = 0;
				_vars.markSyncDirty();
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You have completed a quest!"), false);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CraftDefenseModItems.EPIC_XP_CANDY.get()).copy();
				_setstack.setCount(16);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number24 >= entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber24 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 != 0
				&& 0 != entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questNumber24) {
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.questType24 = 0;
				_vars.markSyncDirty();
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You have completed a quest!"), false);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CraftDefenseModItems.LEGENDARY_XP_CANDY.get()).copy();
				_setstack.setCount(16);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}