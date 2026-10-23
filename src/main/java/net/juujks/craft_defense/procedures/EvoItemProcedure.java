package net.juujks.craft_defense.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.juujks.craft_defense.init.CraftDefenseModItems;

public class EvoItemProcedure {
	public static void execute(ItemStack itemstack) {
		boolean gameEnd = false;
		double slotIndex = 0;
		if (itemstack.getItem() == CraftDefenseModItems.STEVE_UNIT.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lSteve \u00A77(Common)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 200;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.ALEX_UNIT.get()) {
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 200;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "AERIAL";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lAlex \u00A77(Common)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
		} else if (itemstack.getItem() == CraftDefenseModItems.ZOMBIE_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lZombie \u00A7b(Rare)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 500;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.SKELETON_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lSkeleton \u00A7b(Rare)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 500;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "AERIAL";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.CREEPER_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lCreeper \u00A7b(Rare)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 600;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "HYBRID";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "AOE";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.SPIDER_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lSpider \u00A7b(Rare)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 500;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.WITCH_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lWitch \u00A7b(Rare)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 400;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "passive";
				final String _tagValue = "\u00A72Poisoning Unit";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.SLIME_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lSlime \u00A7b(Rare)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 500;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Circle AOE";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "passive";
				final String _tagValue = "\u00A73Decelerate Unit";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.VILLAGER_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lVillager \u00A75(Epic)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 500;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "passive";
				final String _tagValue = "\u00A7eFarmer Unit";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.CAVE_SPIDER_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lCave Spider \u00A75(Epic)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 600;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "passive";
				final String _tagValue = "\u00A72Poisoning Unit";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.STRAY_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lStray \u00A75(Epic)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 700;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "AERIAL";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "passive";
				final String _tagValue = "\u00A73Decelerate Unit";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.ZOMBIFIED_PIGLIN_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7a\u00A7lEvolved \u00A7r\u00A7lZombified Piglin \u00A75(Epic)" + " - \u00A7eLv."
					+ new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 650;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.PIGLIN_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lPiglin \u00A75(Epic)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 700;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.PUFFERFISH_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lPufferfish \u00A75(Epic)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 500;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "HYBRID";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "AOE";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "passive";
				final String _tagValue = "\u00A72Poisoning Unit";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.IRON_GOLEM_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7a\u00A7lEvolved \u00A7r\u00A7lIron Golem \u00A7e(Legendary)" + " - \u00A7eLv."
					+ new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 1000;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.SNOW_GOLEM_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7a\u00A7lEvolved \u00A7r\u00A7lSnow Golem \u00A7e(Legendary)" + " - \u00A7eLv."
					+ new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 1000;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "AERIAL";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "passive";
				final String _tagValue = "\u00A73Decelerate Unit";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.HUSK_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component
					.literal(("\u00A7a\u00A7lEvolved \u00A7r\u00A7lHusk \u00A75(Epic)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 650;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.MAGMA_CUBE_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lMagma Cube \u00A75(Epic)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 650;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.POLAR_BEAR_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7a\u00A7lEvolved \u00A7r\u00A7lPolar Bear \u00A7e(Legendary)" + " - \u00A7eLv."
					+ new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 1000;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.CHARGED_CREEPER_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7a\u00A7lEvolved \u00A7r\u00A7lCharged Creeper \u00A7e(Legendary)" + " - \u00A7eLv."
					+ new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 1500;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "HYBRID";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "AOE";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.RAVAGER_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lRavager \u00A7e(Legendary)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 1000;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.ENDERMAN_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lEnderman \u00A75(Epic)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 650;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "GROUND";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Single Target";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.BREEZE_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lBreeze \u00A7e(Legendary)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
			{
				final String _tagName = "deployPrice";
				final double _tagValue = 1000;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "unitType";
				final String _tagValue = "AERIAL";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "attackType";
				final String _tagValue = "Circle AOE";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
		} else if (itemstack.getItem() == CraftDefenseModItems.WOLF_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component
					.literal(("\u00A7a\u00A7lEvolved \u00A7r\u00A7lWolf \u00A7b(Rare)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
		} else if (itemstack.getItem() == CraftDefenseModItems.PILLAGER_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lPillager \u00A75(Epic)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
		} else if (itemstack.getItem() == CraftDefenseModItems.BOGGED_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lBogged \u00A7e(Legendary)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
		} else if (itemstack.getItem() == CraftDefenseModItems.DROWNED_UNIT_ITEM.get()) {
			itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(
					("\u00A7a\u00A7lEvolved \u00A7r\u00A7lDrowned \u00A7e(Legendary)" + " - \u00A7eLv." + new java.text.DecimalFormat("##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")))));
		}
	}
}