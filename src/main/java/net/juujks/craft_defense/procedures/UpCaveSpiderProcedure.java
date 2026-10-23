package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.CaveSpiderUnitEntity;

public class UpCaveSpiderProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof CaveSpiderUnitEntity) {
			if (entity.getPersistentData().getDouble("level") <= 1) {
				entity.getPersistentData().putDouble("damage",
						(72 + 72 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (72 + 72 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (1 - 1 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("level", 1);
				entity.getPersistentData().putDouble("upCost", 800);
			} else if (entity.getPersistentData().getDouble("level") == 2) {
				entity.getPersistentData().putDouble("damage",
						(150 + 150 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (150 + 150 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (1 - 1 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 1300);
			} else if (entity.getPersistentData().getDouble("level") == 3) {
				entity.getPersistentData().putDouble("damage",
						(280 + 280 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (280 + 280 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (0.5 - 0.5 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 2000);
			} else if (entity.getPersistentData().getDouble("level") == 4) {
				entity.getPersistentData().putDouble("damage",
						(350 + 350 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (350 + 350 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (0.5 - 0.5 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 3500);
			} else if (entity.getPersistentData().getDouble("level") == 5) {
				entity.getPersistentData().putDouble("damage",
						(450 + 450 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (450 + 450 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (0.5 - 0.5 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 5000);
			} else if (entity.getPersistentData().getDouble("level") == 6) {
				entity.getPersistentData().putDouble("damage",
						(600 + 600 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (600 + 600 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (0.5 - 0.5 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 6000);
			} else if (entity.getPersistentData().getDouble("level") == 7) {
				entity.getPersistentData().putDouble("damage",
						(1000 + 1000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (1000 + 1000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (0.5 - 0.5 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 10000);
			} else if (entity.getPersistentData().getDouble("level") == 8) {
				entity.getPersistentData().putDouble("damage",
						(1500 + 1500 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (1500 + 1500 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (0.5 - 0.5 * entity.getPersistentData().getDouble("spaBuff")));
			}
		}
	}
}