package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.VillagerUnitEntity;

public class UpVillagerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof VillagerUnitEntity) {
			if (entity.getPersistentData().getBoolean("evo")) {
				entity.getPersistentData().putDouble("maxLevel", 8);
			} else {
				entity.getPersistentData().putDouble("maxLevel", 6);
			}
		}
		if (entity instanceof VillagerUnitEntity) {
			if (entity.getPersistentData().getDouble("level") <= 1) {
				entity.getPersistentData().putDouble("money",
						(100 + 100 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (100 + 100 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", 3);
				entity.getPersistentData().putDouble("spa", 1);
				entity.getPersistentData().putDouble("level", 1);
				entity.getPersistentData().putDouble("upCost", 900);
			} else if (entity.getPersistentData().getDouble("level") == 2) {
				entity.getPersistentData().putDouble("money",
						(250 + 250 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (250 + 250 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", 3);
				entity.getPersistentData().putDouble("spa", 1);
				entity.getPersistentData().putDouble("upCost", 1400);
			} else if (entity.getPersistentData().getDouble("level") == 3) {
				entity.getPersistentData().putDouble("money",
						(400 + 400 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (400 + 400 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", 3);
				entity.getPersistentData().putDouble("spa", 1);
				entity.getPersistentData().putDouble("upCost", 2000);
				if (entity instanceof VillagerUnitEntity) {
					((VillagerUnitEntity) entity).setControllerAnimation("procedure", "stage1");
				}
			} else if (entity.getPersistentData().getDouble("level") == 4) {
				entity.getPersistentData().putDouble("money",
						(750 + 750 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (750 + 750 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", 3);
				entity.getPersistentData().putDouble("spa", 1);
				entity.getPersistentData().putDouble("upCost", 3000);
			} else if (entity.getPersistentData().getDouble("level") == 5) {
				entity.getPersistentData().putDouble("money",
						(1000 + 1000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (1000 + 1000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", 3);
				entity.getPersistentData().putDouble("spa", 1);
				entity.getPersistentData().putDouble("upCost", 6000);
			} else if (entity.getPersistentData().getDouble("level") == 6) {
				entity.getPersistentData().putDouble("money",
						(1500 + 1500 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (1500 + 1500 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", 3);
				entity.getPersistentData().putDouble("spa", 1);
				if (entity instanceof VillagerUnitEntity) {
					((VillagerUnitEntity) entity).setControllerAnimation("procedure", "stage2");
				}
				entity.getPersistentData().putDouble("upCost", 10000);
			} else if (entity.getPersistentData().getDouble("level") == 7) {
				entity.getPersistentData().putDouble("money",
						(2250 + 2250 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (2250 + 2250 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", 3);
				entity.getPersistentData().putDouble("spa", 1);
				entity.getPersistentData().putDouble("upCost", 12500);
			} else if (entity.getPersistentData().getDouble("level") == 8) {
				entity.getPersistentData().putDouble("money",
						(3000 + 3000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (3000 + 3000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", 3);
				entity.getPersistentData().putDouble("spa", 1);
			}
		}
	}
}