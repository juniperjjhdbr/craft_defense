package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.init.CraftDefenseModItems;

public class ReturnAmountOfGemsProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		double gems = 0;
		double unitChance = 0;
		double rareChance = 0;
		gems = 0;
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
				if (CraftDefenseModItems.TOWER_GEM.get() == itemstackiterator.getItem()) {
					gems = gems + itemstackiterator.getCount();
				}
			}
		}
		return new java.text.DecimalFormat("##").format(gems) + "x";
	}
}