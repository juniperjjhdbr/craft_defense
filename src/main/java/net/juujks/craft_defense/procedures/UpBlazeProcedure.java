package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.BlazeUnitEntity;

public class UpBlazeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BlazeUnitEntity) {
			if (entity.getPersistentData().getDouble("level") <= 1) {
				entity.getPersistentData().putDouble("damage",
						(3000 + 3000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (3000 + 3000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (10 + 10 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (3 - 3 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("level", 1);
				entity.getPersistentData().putDouble("upCost", 1750);
			} else if (entity.getPersistentData().getDouble("level") == 2) {
				entity.getPersistentData().putDouble("damage",
						(5500 + 5500 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (5500 + 5500 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (10 + 10 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (3 - 3 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 3000);
			} else if (entity.getPersistentData().getDouble("level") == 3) {
				entity.getPersistentData().putDouble("damage",
						(8000 + 8000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (8000 + 8000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (10 + 10 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (3 - 3 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 5000);
			} else if (entity.getPersistentData().getDouble("level") == 4) {
				entity.getPersistentData().putDouble("damage",
						(12500 + 12500 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (12500 + 12500 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (10 + 10 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (3 - 3 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 8500);
			} else if (entity.getPersistentData().getDouble("level") == 5) {
				entity.getPersistentData().putDouble("damage",
						(16000 + 16000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (16000 + 16000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (10 + 10 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (3 - 3 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 10000);
			} else if (entity.getPersistentData().getDouble("level") == 6) {
				entity.getPersistentData().putDouble("damage",
						(20000 + 20000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (20000 + 20000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (10 + 10 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (3 - 3 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 12500);
			} else if (entity.getPersistentData().getDouble("level") == 7) {
				entity.getPersistentData().putDouble("damage",
						(25000 + 25000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (25000 + 25000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (10 + 10 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (3 - 3 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 15000);
			} else if (entity.getPersistentData().getDouble("level") == 8) {
				entity.getPersistentData().putDouble("damage",
						(30000 + 30000 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (30000 + 30000 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (10 + 10 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (3 - 3 * entity.getPersistentData().getDouble("spaBuff")));
			}
		}
	}
}