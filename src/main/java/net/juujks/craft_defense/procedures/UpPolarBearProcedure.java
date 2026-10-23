package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.PolarBearUnitEntity;

public class UpPolarBearProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof PolarBearUnitEntity) {
			if (entity.getPersistentData().getDouble("level") <= 1) {
				entity.getPersistentData().putDouble("damage",
						(500 + 500 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (500 + 500 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2 - 2 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("level", 1);
				entity.getPersistentData().putDouble("upCost", 1500);
			} else if (entity.getPersistentData().getDouble("level") == 2) {
				entity.getPersistentData().putDouble("damage",
						(850 + 850 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (850 + 850 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2 - 2 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 3000);
			} else if (entity.getPersistentData().getDouble("level") == 3) {
				entity.getPersistentData().putDouble("damage",
						(1500 + 1500 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (1500 + 1500 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2 - 2 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 5000);
			} else if (entity.getPersistentData().getDouble("level") == 4) {
				entity.getPersistentData().putDouble("damage",
						(2000 + 2000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (2000 + 2000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2 - 2 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 8500);
			} else if (entity.getPersistentData().getDouble("level") == 5) {
				entity.getPersistentData().putDouble("damage",
						(3500 + 3500 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (3500 + 3500 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2 - 2 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 10000);
			} else if (entity.getPersistentData().getDouble("level") == 6) {
				entity.getPersistentData().putDouble("damage",
						(5000 + 5000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (5000 + 5000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2 - 2 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 12500);
			} else if (entity.getPersistentData().getDouble("level") == 7) {
				entity.getPersistentData().putDouble("damage",
						(7000 + 7000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (7000 + 7000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2 - 2 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 15000);
			} else if (entity.getPersistentData().getDouble("level") == 8) {
				entity.getPersistentData().putDouble("damage",
						(12000 + 12000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (12000 + 12000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2 - 2 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 20000);
			} else if (entity.getPersistentData().getDouble("level") == 9) {
				entity.getPersistentData().putDouble("damage",
						(16000 + 16000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (16000 + 16000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2 - 2 * entity.getPersistentData().getDouble("spaBuff")));
			}
		}
	}
}