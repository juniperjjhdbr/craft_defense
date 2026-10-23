package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class GemsToGiveProcedure {
	public static String execute(LevelAccessor world) {
		return new java.text.DecimalFormat("##").format(CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910
				? (CraftDefenseModVariables.MapVariables.get(world).act - 900) * 20
				: (CraftDefenseModVariables.MapVariables.get(world).challenge + CraftDefenseModVariables.MapVariables.get(world).act + CraftDefenseModVariables.MapVariables.get(world).difficulty) - 1) + "x";
	}
}