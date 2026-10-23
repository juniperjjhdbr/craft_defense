package net.juujks.craft_defense.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.gui.screens.Screen;

public class ReturnUnitLevelProcedure {
	public static String execute(ItemStack itemstack) {
		if (Screen.hasShiftDown()) {
			return "\u00A7aDeploy $" + new java.text.DecimalFormat("#,###").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deployPrice")) + "\n"
					+ itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("unitType") + " - " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("attackType") + "\n"
					+ "\u00A7c\u2694: " + new java.text.DecimalFormat("#,###.##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("initDamage")) + "\u00A7r ("
					+ itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("statsNameDBuff") + "\u00A7r) | \u00A7e\uD83C\uDFF9: "
					+ new java.text.DecimalFormat("#,###.##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("initRange") / 2) + "m\u00A7r ("
					+ itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("statsNameRBuff") + "\u00A7r) | \u00A71\u26A1: "
					+ new java.text.DecimalFormat("#,###.##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("initSpa")) + "s\u00A7r ("
					+ itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("statsNameSBuff") + "\u00A7r)" + "\n" + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("passive")
					+ "\n" + (!(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("traitText")).equals("") ? "" : "\n")
					+ (!(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("traitText")).equals("") ? "" : "[")
					+ (!(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("traitText")).equals("") ? "" : itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("traitText"))
					+ (!(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("traitText")).equals("") ? "" : "\u00A7r]") + "\n" + "\u00A7b"
					+ new java.text.DecimalFormat("#,###").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xp")) + "/"
					+ new java.text.DecimalFormat("#,###").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xpCap")) + "XP" + "\n" + "\u00A7cTotal Damage: " + "\u00A7r"
					+ new java.text.DecimalFormat("#,###").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("totalDamage")) + "\n" + "\u00A7dTotal Placements: " + "\u00A7r"
					+ new java.text.DecimalFormat("#,###").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("totalPlacements")) + "\n" + "\u00A78Item UUID: "
					+ itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("itemUUID");
		}
		return "\u00A7aDeploy $" + new java.text.DecimalFormat("#,###").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deployPrice")) + "\n" + "\u00A77Press SHIFT to view more info!";
	}
}
