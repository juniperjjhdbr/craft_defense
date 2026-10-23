package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

import java.util.ArrayList;

public class ReturnPlayerInQueuePProcedure {
	public static String execute(LevelAccessor world) {
		String texto = "";
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).isInQueue) {
				texto = entityiterator.getDisplayName().getString();
			}
		}
		return texto;
	}
}