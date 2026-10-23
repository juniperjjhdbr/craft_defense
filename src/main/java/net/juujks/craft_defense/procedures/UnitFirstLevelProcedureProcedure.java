package net.juujks.craft_defense.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

import net.juujks.craft_defense.init.CraftDefenseModItems;

public class UnitFirstLevelProcedureProcedure {
	public static void execute(ItemStack itemstack) {
		{
			final String _tagName = "initDamage";
			final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("baseDamage")
					+ itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("baseDamage") * itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level") * 0.1
					+ (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("baseDamage")
							+ itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("baseDamage") * itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level") * 0.1)
							* (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("damageBuff") + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("statsDBuff")));
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
		}
		{
			final String _tagName = "initRange";
			final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("baseRange") + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("baseRange")
					* (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rangeBuff") + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("statsRBuff")));
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
		}
		{
			final String _tagName = "initSpa";
			final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("baseSpa") - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("baseSpa")
					* (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("spaBuff") + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("statsSBuff")));
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
		}
		if (itemstack.getItem() == CraftDefenseModItems.STEVE_UNIT.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 6;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.ALEX_UNIT.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 8;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.ZOMBIE_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 16;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.SKELETON_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 22;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2.5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.CREEPER_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 80;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.SPIDER_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 10;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 1;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.WITCH_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 10;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.SLIME_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 20;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2.5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.VILLAGER_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 100;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 0;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 0;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.CAVE_SPIDER_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 72;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 1;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.STRAY_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 90;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.ZOMBIFIED_PIGLIN_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 100;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.PIGLIN_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 150;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 3;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.PUFFERFISH_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 70;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 3;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.PUFFERFISH_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 70;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 3;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.IRON_GOLEM_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 600;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 3;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.IRON_GOLEM_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 600;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 3;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.HUSK_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 100;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.HUSK_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 100;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.MAGMA_CUBE_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 90;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.POLAR_BEAR_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 500;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.CHARGED_CREEPER_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 1500;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 6;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 6;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.CHARGED_CREEPER_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 1500;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 6;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 6;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.ENDERMAN_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 100;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.BREEZE_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 300;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 8;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.SNOW_GOLEM_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 500;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 10;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 1.5;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.WOLF_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 20;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.PILLAGER_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 100;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.PILLAGER_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 100;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.BLAZE_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 3000;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 10;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 3;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.BOGGED_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 600;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 8;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 3;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.DROWNED_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 600;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 8;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 3;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.getItem() == CraftDefenseModItems.FROSTBITE_UNIT_ITEM.get()) {
			{
				final String _tagName = "baseDamage";
				final double _tagValue = 2000;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseRange";
				final double _tagValue = 7;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "baseSpa";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
	}
}