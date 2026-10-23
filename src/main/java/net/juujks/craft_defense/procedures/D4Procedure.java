package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class D4Procedure {
	public static String execute(LevelAccessor world) {
		return "PLAYERS_IN_GAME: " + new java.text.DecimalFormat("##.##").format(CraftDefenseModVariables.MapVariables.get(world).playersInGame);
	}
}