package net.juujks.craft_defense.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.juujks.craft_defense.init.CraftDefenseModMenus;

public class ReturnXPPProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("xp")) + "/"
				+ ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("xpCap"))
				+ " XP";
	}
}