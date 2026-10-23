package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.*;

public class CallEpicProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		UpCaveSpiderProcedure.execute(entity);
		UpStrayProcedure.execute(entity);
		UpZombifiedPiglinProcedure.execute(entity);
		UpPiglinProcedure.execute(entity);
		UpPufferfishProcedure.execute(entity);
		UpHuskProcedure.execute(entity);
		UpMagmaCubeProcedure.execute(entity);
		UpEndermanProcedure.execute(entity);
		UpPillagerProcedure.execute(entity);
		if (entity instanceof CaveSpiderUnitEntity || entity instanceof StrayUnitEntity || entity instanceof ZombifiedPiglinUnitEntity || entity instanceof PiglinUnitEntity || entity instanceof HuskUnitEntity || entity instanceof MagmaCubeUnitEntity
				|| entity instanceof EndermanUnitEntity || entity instanceof PillagerUnitEntity || entity instanceof PufferfishUnitEntity) {
			if (entity.getPersistentData().getBoolean("evo")) {
				entity.getPersistentData().putDouble("maxLevel", 8);
			} else {
				entity.getPersistentData().putDouble("maxLevel", 6);
			}
		}
	}
}