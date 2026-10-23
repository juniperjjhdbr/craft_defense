package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.CreeperUnitEntity;

public class UpCreeperProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof CreeperUnitEntity) {
			if (entity.getPersistentData().getDouble("level") <= 1) {
				entity.getPersistentData().putDouble("damage",
						(80 + 80 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (80 + 80 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (7 - 7 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("level", 1);
				entity.getPersistentData().putDouble("upCost", 900);
			} else if (entity.getPersistentData().getDouble("level") == 2) {
				entity.getPersistentData().putDouble("damage",
						(120 + 120 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (120 + 120 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (6 - 6 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 1500);
			} else if (entity.getPersistentData().getDouble("level") == 3) {
				entity.getPersistentData().putDouble("damage",
						(160 + 160 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (160 + 160 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (6 - 6 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 2000);
			} else if (entity.getPersistentData().getDouble("level") == 4) {
				entity.getPersistentData().putDouble("damage",
						(200 + 200 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (200 + 200 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (6 - 6 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 3000);
			} else if (entity.getPersistentData().getDouble("level") == 5) {
				entity.getPersistentData().putDouble("damage",
						(240 + 240 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (240 + 240 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (6 - 6 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 3500);
			} else if (entity.getPersistentData().getDouble("level") == 6) {
				entity.getPersistentData().putDouble("damage",
						(320 + 320 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (320 + 320 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (8 + 8 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (6 - 6 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 5000);
			} else if (entity.getPersistentData().getDouble("level") == 7) {
				entity.getPersistentData().putDouble("damage",
						(400 + 400 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (400 + 400 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (9 + 9 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (6 - 6 * entity.getPersistentData().getDouble("spaBuff")));
			}
		}
	}
}