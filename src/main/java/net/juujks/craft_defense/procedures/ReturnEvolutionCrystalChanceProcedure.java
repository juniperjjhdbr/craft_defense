package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnEvolutionCrystalChanceProcedure {
	public static boolean execute(LevelAccessor world) {
		if (CraftDefenseModVariables.MapVariables
				.get(world).crystalChance <= (CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910 ? 0.5 : 0.05 + CraftDefenseModVariables.MapVariables.get(world).act / 1000)) {
			return true;
		}
		return false;
	}
}