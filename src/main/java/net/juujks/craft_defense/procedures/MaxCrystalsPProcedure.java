package net.juujks.craft_defense.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

public class MaxCrystalsPProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("craft_defense:units/common")))) {
			{
				final String _tagName = "maxCrystals";
				final double _tagValue = 1;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("craft_defense:units/rare")))) {
			{
				final String _tagName = "maxCrystals";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("craft_defense:units/epic")))) {
			{
				final String _tagName = "maxCrystals";
				final double _tagValue = 3;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("craft_defense:units/legendary")))) {
			{
				final String _tagName = "maxCrystals";
				final double _tagValue = 4;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
	}
}