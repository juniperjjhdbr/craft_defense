package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModItems;

public class CandyGUIThisGUIIsOpenedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double common = 0;
		double rare = 0;
		double epic = 0;
		double legendary = 0;
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
				if (itemstackiterator.getItem() == CraftDefenseModItems.COMMON_XP_CANDY.get()) {
					common = common + itemstackiterator.getCount();
				}
				if (itemstackiterator.getItem() == CraftDefenseModItems.RARE_XP_CANDY.get()) {
					rare = rare + itemstackiterator.getCount();
				}
				if (itemstackiterator.getItem() == CraftDefenseModItems.EPIC_XP_CANDY.get()) {
					epic = epic + itemstackiterator.getCount();
				}
				if (itemstackiterator.getItem() == CraftDefenseModItems.LEGENDARY_XP_CANDY.get()) {
					legendary = legendary + itemstackiterator.getCount();
				}
			}
		}
		{
			CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
			_vars.totalCandies = common + rare + epic + legendary;
			_vars.markSyncDirty();
		}
	}
}