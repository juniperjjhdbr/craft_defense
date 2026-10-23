package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModItems;

public class MaxAllPProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
				if (itemstackiterator.getItem() == CraftDefenseModItems.COMMON_XP_CANDY.get()) {
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.commonCandies = itemstackiterator.getCount();
						_vars.markSyncDirty();
					}
				}
				if (itemstackiterator.getItem() == CraftDefenseModItems.RARE_XP_CANDY.get()) {
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.rareCandies = itemstackiterator.getCount();
						_vars.markSyncDirty();
					}
				}
				if (itemstackiterator.getItem() == CraftDefenseModItems.EPIC_XP_CANDY.get()) {
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.epicCandies = itemstackiterator.getCount();
						_vars.markSyncDirty();
					}
				}
				if (itemstackiterator.getItem() == CraftDefenseModItems.LEGENDARY_XP_CANDY.get()) {
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.legendaryCandies = itemstackiterator.getCount();
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}