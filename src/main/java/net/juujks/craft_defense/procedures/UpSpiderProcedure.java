package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.SpiderUnitEntity;

public class UpSpiderProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof SpiderUnitEntity) {
			if (entity.getPersistentData().getDouble("level") <= 1) {
				entity.getPersistentData().putDouble("damage",
						(10 + 10 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (10 + 10 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (1 - 1 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("level", 1);
				entity.getPersistentData().putDouble("upCost", 500);
			} else if (entity.getPersistentData().getDouble("level") == 2) {
				entity.getPersistentData().putDouble("damage",
						(18 + 18 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (18 + 18 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (1 - 1 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 800);
			} else if (entity.getPersistentData().getDouble("level") == 3) {
				entity.getPersistentData().putDouble("damage",
						(26 + 26 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (26 + 26 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (0.5 - 0.5 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 1000);
			} else if (entity.getPersistentData().getDouble("level") == 4) {
				entity.getPersistentData().putDouble("damage",
						(34 + 34 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (34 + 34 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (0.5 - 0.5 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 1350);
			} else if (entity.getPersistentData().getDouble("level") == 5) {
				entity.getPersistentData().putDouble("damage",
						(42 + 42 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (42 + 42 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (0.5 - 0.5 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 1600);
			} else if (entity.getPersistentData().getDouble("level") == 6) {
				entity.getPersistentData().putDouble("damage",
						(42 + 42 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (42 + 42 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (5 + 5 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (0.33 - 0.33 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 2000);
			} else if (entity.getPersistentData().getDouble("level") == 7) {
				entity.getPersistentData().putDouble("damage",
						(42 + 42 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (42 + 42 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (4 + 4 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (0.25 - 0.25 * entity.getPersistentData().getDouble("spaBuff")));
			}
		}
	}
}