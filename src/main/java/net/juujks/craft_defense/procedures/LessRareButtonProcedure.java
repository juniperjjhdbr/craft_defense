package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModItems;

public class LessRareButtonProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
				if (itemstackiterator.getItem() == CraftDefenseModItems.RARE_XP_CANDY.get()) {
					if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).rareCandies >= 1) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.rareCandies = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).rareCandies - 1;
							_vars.markSyncDirty();
						}
					} else {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.rareCandies = 0;
							_vars.markSyncDirty();
						}
					}
				}
			}
		}
	}
}