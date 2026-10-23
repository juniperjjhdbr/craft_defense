package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.FrostbiteUnitEntity;
import net.juujks.craft_defense.entity.BlazeUnitEntity;

public class CallMythicProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		UpBlazeProcedure.execute(entity);
		UpFrostbiteProcedure.execute(entity);
		if (entity instanceof BlazeUnitEntity) {
			entity.getPersistentData().putDouble("maxLevel", 8);
		}
		if (entity instanceof FrostbiteUnitEntity) {
			entity.getPersistentData().putDouble("maxLevel", 8);
		}
		if (entity instanceof BlazeUnitEntity) {
			entity.igniteForSeconds(15);
		}
	}
}