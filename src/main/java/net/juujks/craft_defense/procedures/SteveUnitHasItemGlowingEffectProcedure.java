package net.juujks.craft_defense.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

public class SteveUnitHasItemGlowingEffectProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (!itemstack.is(ItemTags.create(ResourceLocation.parse("craft_defense:units/mythic")))) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("evo")) {
				return true;
			}
		} else {
			return true;
		}
		return false;
	}
}