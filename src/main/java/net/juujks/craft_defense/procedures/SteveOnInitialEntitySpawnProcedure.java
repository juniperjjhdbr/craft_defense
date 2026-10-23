package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.*;

public class SteveOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("clientLevel", (entity.getPersistentData().getDouble("unitLevel")));
		if (entity instanceof SteveEntity) {
			((SteveEntity) entity).setControllerAnimation("procedure", "spawn");
		}
		if (entity instanceof AlexEntity) {
			((AlexEntity) entity).setControllerAnimation("procedure", "spawn");
		}
		if (entity instanceof ZombieUnitEntity) {
			((ZombieUnitEntity) entity).setControllerAnimation("procedure", "spawn");
		}
		if (entity instanceof SkeletonUnitEntity) {
			((SkeletonUnitEntity) entity).setControllerAnimation("procedure", "spawn");
		}
		if (entity instanceof IronGolemUnitEntity) {
			((IronGolemUnitEntity) entity).setControllerAnimation("procedure", "spawn");
		}
		if (entity instanceof CreeperUnitEntity) {
			((CreeperUnitEntity) entity).setControllerAnimation("procedure", "spawn");
		}
		if (entity instanceof SnowGolemUnitEntity) {
			((SnowGolemUnitEntity) entity).setControllerAnimation("procedure", "spawn");
		}
		if (entity instanceof DrownedUnitEntity) {
			((DrownedUnitEntity) entity).setControllerAnimation("procedure", "spawn");
		}
		if (entity instanceof FrostbiteUnitEntity) {
			((FrostbiteUnitEntity) entity).setControllerAnimation("procedure", "spawn");
		}
	}
}