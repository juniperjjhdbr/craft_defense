package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

public class UnitNamePProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String texto = "";
		Entity entidade = null;
		return entity.getPersistentData().getString("unitName");
	}
}