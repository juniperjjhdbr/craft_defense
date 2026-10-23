package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnRareAmountProcedure {
	public static String execute(LevelAccessor world) {
		return new java.text.DecimalFormat("##").format(CraftDefenseModVariables.MapVariables.get(world).rareAmount) + "x";
	}
}