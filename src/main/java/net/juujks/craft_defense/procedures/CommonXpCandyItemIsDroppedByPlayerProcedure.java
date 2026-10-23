package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.world.inventory.CandyGUIMenu;
import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CommonXpCandyItemIsDroppedByPlayerProcedure {
	@SubscribeEvent
	public static void onGemDropped(ItemTossEvent event) {
		execute(event, event.getPlayer(), event.getEntity().getItem());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof CandyGUIMenu) {
			if (itemstack.getItem() == CraftDefenseModItems.COMMON_XP_CANDY.get() || itemstack.getItem() == CraftDefenseModItems.RARE_XP_CANDY.get() || itemstack.getItem() == CraftDefenseModItems.EPIC_XP_CANDY.get()
					|| itemstack.getItem() == CraftDefenseModItems.LEGENDARY_XP_CANDY.get()) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.xpToAdd = 0;
					_vars.commonCandies = 0;
					_vars.rareCandies = 0;
					_vars.epicCandies = 0;
					_vars.legendaryCandies = 0;
					_vars.resetCandies = true;
					_vars.markSyncDirty();
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = itemstack.copy();
					_setstack.setCount(itemstack.getCount());
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player)
					_player.closeContainer();
			}
		}
	}
}