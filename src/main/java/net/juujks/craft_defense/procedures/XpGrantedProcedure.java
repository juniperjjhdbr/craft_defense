package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class XpGrantedProcedure {
	public static String execute(LevelAccessor world) {
		return "+"
				+ new java.text.DecimalFormat("##").format((CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910 ? 1 : 100) * CraftDefenseModVariables.MapVariables.get(world).act)
				+ " Unit XP";
	}
}