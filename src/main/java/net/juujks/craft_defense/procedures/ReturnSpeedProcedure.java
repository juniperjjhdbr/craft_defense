package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class ReturnSpeedProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		String texto = "";
		if (!CraftDefenseModVariables.MapVariables.get(world).disableGUI) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerInGame) {
				if (CraftDefenseModVariables.MapVariables.get(world).gameSpeed == 1) {
					texto = "\u00A7a1x Speed";
				} else if (CraftDefenseModVariables.MapVariables.get(world).gameSpeed == 3) {
					texto = "\u00A7c\u00A7l3x Speed";
				} else {
					texto = "\u00A7e2x Speed";
				}
			}
		}
		return texto;
	}
}