package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class LBR1Procedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if (CraftDefenseModVariables.MapVariables.get(world).act == 901) {
			if (CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.1 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
				return true;
			}
		}
		return false;
	}
}