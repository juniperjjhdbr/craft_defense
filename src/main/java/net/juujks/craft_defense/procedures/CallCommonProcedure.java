package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.SteveEntity;
import net.juujks.craft_defense.entity.AlexEntity;

public class CallCommonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		UpSteveProcedure.execute(entity);
		UpAlexProcedure.execute(entity);
		if (entity instanceof SteveEntity || entity instanceof AlexEntity) {
			if (entity.getPersistentData().getBoolean("evo")) {
				entity.getPersistentData().putDouble("maxLevel", 6);
			} else {
				entity.getPersistentData().putDouble("maxLevel", 4);
			}
		}
	}
}