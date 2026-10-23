package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

public class DamageClientProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("unitLevel", (entity.getPersistentData().getDouble("unitLevel")));
	}
}