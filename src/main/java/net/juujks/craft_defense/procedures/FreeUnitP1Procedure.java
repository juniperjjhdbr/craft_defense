package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModItems;

public class FreeUnitP1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel <= 4) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CraftDefenseModItems.SKELETON_UNIT_ITEM.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.fu1 = true;
				_vars.rareChosen = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).rareChosen + 1;
				_vars.markSyncDirty();
			}
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel >= 8) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CraftDefenseModItems.IRON_GOLEM_UNIT_ITEM.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.fu1 = true;
				_vars.legendaryChosen = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).legendaryChosen + 1;
				_vars.markSyncDirty();
			}
		} else {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CraftDefenseModItems.VILLAGER_UNIT_ITEM.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.fu1 = true;
				_vars.epicChosen = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).epicChosen + 1;
				_vars.markSyncDirty();
			}
		}
		{
			CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
			_vars.freeUnitCollected = true;
			_vars.markSyncDirty();
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
		{
			CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
			_vars.fuLastCollectedLevel = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel;
			_vars.markSyncDirty();
		}
	}
}