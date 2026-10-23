package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModItems;

public class CandyTickUpProcedure {
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
					common = itemstackiterator.getCount();
				}
				if (itemstackiterator.getItem() == CraftDefenseModItems.RARE_XP_CANDY.get()) {
					rare = itemstackiterator.getCount();
				}
				if (itemstackiterator.getItem() == CraftDefenseModItems.EPIC_XP_CANDY.get()) {
					epic = itemstackiterator.getCount();
				}
				if (itemstackiterator.getItem() == CraftDefenseModItems.LEGENDARY_XP_CANDY.get()) {
					legendary = itemstackiterator.getCount();
				}
				if (common + rare + epic + legendary != entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).totalCandies) {
					if (entity instanceof Player _player)
						_player.closeContainer();
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.legendaryCandies = 0;
						_vars.totalCandies = 0;
						_vars.commonCandies = 0;
						_vars.rareCandies = 0;
						_vars.epicCandies = 0;
						_vars.markSyncDirty();
					}
				}
			}
		}
	}
}