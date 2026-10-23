package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.*;

public class CallLegendaryProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		UpIronGolemProcedure.execute(entity);
		UpSnowGolemProcedure.execute(entity);
		UpPolarBearProcedure.execute(entity);
		UpChargedCreeperProcedure.execute(entity);
		UpRavagerProcedure.execute(entity);
		UpBreezeProcedure.execute(entity);
		UpBoggedProcedure.execute(entity);
		UpDrownedProcedure.execute(entity);
		if (entity instanceof SnowGolemUnitEntity || entity instanceof PolarBearUnitEntity || entity instanceof ChargedCreeperUnitEntity || entity instanceof RavagerUnitEntity || entity instanceof BreezeUnitEntity
				|| entity instanceof BoggedUnitEntity || entity instanceof DrownedUnitEntity || entity instanceof IronGolemUnitEntity) {
			if (entity.getPersistentData().getBoolean("evo")) {
				entity.getPersistentData().putDouble("maxLevel", 9);
			} else {
				entity.getPersistentData().putDouble("maxLevel", 7);
			}
		}
	}
}