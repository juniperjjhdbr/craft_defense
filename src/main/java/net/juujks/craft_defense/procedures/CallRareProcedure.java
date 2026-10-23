package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.*;

public class CallRareProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		UpZombieProcedure.execute(entity);
		UpSkeletonProcedure.execute(entity);
		UpCreeperProcedure.execute(entity);
		UpSpiderProcedure.execute(entity);
		UpWitchProcedure.execute(entity);
		UpSlimeProcedure.execute(entity);
		UpWolfProcedure.execute(entity);
		if (entity instanceof CreeperUnitEntity || entity instanceof SkeletonUnitEntity || entity instanceof SlimeUnitEntity || entity instanceof SpiderUnitEntity || entity instanceof WitchUnitEntity || entity instanceof WolfUnitEntity
				|| entity instanceof ZombieUnitEntity) {
			if (entity.getPersistentData().getBoolean("evo")) {
				entity.getPersistentData().putDouble("maxLevel", 7);
			} else {
				entity.getPersistentData().putDouble("maxLevel", 5);
			}
		}
	}
}