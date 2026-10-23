package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.configuration.CraftDefenseConfigConfiguration;
import net.juujks.craft_defense.CraftDefenseMod;

public class SteveUnitItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		boolean gameEnd = false;
		double slotIndex = 0;
		MaxCrystalsPProcedure.execute(itemstack);
		UnitFirstLevelProcedureProcedure.execute(itemstack);
		if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("statsNameDBuff")).equals("")) {
			{
				final String _tagName = "statsNameDBuff";
				final String _tagValue = "\u00A74F";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		}
		if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("statsNameRBuff")).equals("")) {
			{
				final String _tagName = "statsNameRBuff";
				final String _tagValue = "\u00A74F";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		}
		if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("statsNameSBuff")).equals("")) {
			{
				final String _tagName = "statsNameSBuff";
				final String _tagValue = "\u00A74F";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		}
		if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("itemUUID")).equals("")) {
			{
				final String _tagName = "itemUUID";
				final String _tagValue = (new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 10000000)));
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		}
		if (!itemstack.is(ItemTags.create(ResourceLocation.parse("craft_defense:units/mythic")))) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("crystals") >= itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("maxCrystals")) {
				{
					final String _tagName = "evo";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).wave >= 1) {
			gameEnd = true;
		} else {
			gameEnd = false;
		}
		if (CraftDefenseModVariables.MapVariables.get(world).unitReward) {
			if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("xpGranted")) {
				{
					final String _tagName = "xp";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xp")
							+ (CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910 ? 1 : 100) * CraftDefenseModVariables.MapVariables.get(world).act
									* (double) CraftDefenseConfigConfiguration.XP_MULTIPLIER.get());
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				CraftDefenseMod.queueServerWork(1, () -> {
					{
						final String _tagName = "xpGranted";
						final boolean _tagValue = true;
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
					}
				});
			}
			CraftDefenseMod.queueServerWork(1, () -> {
				CraftDefenseModVariables.MapVariables.get(world).unitReward = false;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			});
		} else {
			{
				final String _tagName = "xpGranted";
				final boolean _tagValue = false;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
		if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("initialized")) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xpCap") == 0) {
				{
					final String _tagName = "xpCap";
					final double _tagValue = 100;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level") == 0) {
				{
					final String _tagName = "level";
					final double _tagValue = 1;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
			{
				final String _tagName = "initialized";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
		for (int _i1 = 0; _i1 < (int) Math
				.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xp") / itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xpCap")); _i1++) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xp") >= itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xpCap")
					&& itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level") <= (double) CraftDefenseConfigConfiguration.LEVEL_CAP.get() - 1) {
				{
					final String _tagName = "xp";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xp") - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xpCap"));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "xpCap";
					final double _tagValue = Math.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xpCap") * 1.1);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					final String _tagName = "level";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level") + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
		}
		ItemNamePProcedure.execute(itemstack);
	}
}