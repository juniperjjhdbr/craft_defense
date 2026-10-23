package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.*;

public class AerialUnitsPProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof AlexEntity || entity instanceof StrayUnitEntity || entity instanceof DrownedUnitEntity || entity instanceof BoggedUnitEntity || entity instanceof BlazeUnitEntity || entity instanceof PillagerUnitEntity
				|| entity instanceof BreezeUnitEntity || entity instanceof SnowGolemUnitEntity || entity instanceof SkeletonUnitEntity) {
			entity.getPersistentData().putBoolean("canHitAerial", true);
		}
	}
}