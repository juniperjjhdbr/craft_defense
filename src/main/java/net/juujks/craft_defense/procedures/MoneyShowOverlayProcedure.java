package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

public class MoneyShowOverlayProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		if (!CraftDefenseModVariables.MapVariables.get(world).disableGUI) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerInGame) {
				return "$" + new java.text.DecimalFormat("#,###").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG);
			}
		}
		return "";
	}
}