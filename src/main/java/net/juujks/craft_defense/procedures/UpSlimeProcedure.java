package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.SlimeUnitEntity;

public class UpSlimeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof SlimeUnitEntity) {
			if (entity.getPersistentData().getDouble("level") <= 1) {
				entity.getPersistentData().putDouble("damage",
						(20 + 20 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (20 + 20 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2.5 - 2.5 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("level", 1);
				entity.getPersistentData().putDouble("upCost", 500);
				if (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.SCALE))
					_livingEntity12.getAttribute(Attributes.SCALE).setBaseValue(0.5);
			} else if (entity.getPersistentData().getDouble("level") == 2) {
				entity.getPersistentData().putDouble("damage",
						(28 + 28 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (28 + 28 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2.5 - 2.5 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 800);
				if (entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(Attributes.SCALE))
					_livingEntity23.getAttribute(Attributes.SCALE).setBaseValue(0.6);
			} else if (entity.getPersistentData().getDouble("level") == 3) {
				entity.getPersistentData().putDouble("damage",
						(35 + 35 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (35 + 35 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2.5 - 2.5 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 1000);
				if (entity instanceof LivingEntity _livingEntity34 && _livingEntity34.getAttributes().hasAttribute(Attributes.SCALE))
					_livingEntity34.getAttribute(Attributes.SCALE).setBaseValue(0.7);
			} else if (entity.getPersistentData().getDouble("level") == 4) {
				entity.getPersistentData().putDouble("damage",
						(48 + 48 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (48 + 48 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2 - 2 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 1350);
				if (entity instanceof LivingEntity _livingEntity45 && _livingEntity45.getAttributes().hasAttribute(Attributes.SCALE))
					_livingEntity45.getAttribute(Attributes.SCALE).setBaseValue(0.8);
			} else if (entity.getPersistentData().getDouble("level") == 5) {
				entity.getPersistentData().putDouble("damage",
						(56 + 56 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (56 + 56 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2 - 2 * entity.getPersistentData().getDouble("spaBuff")));
				entity.getPersistentData().putDouble("upCost", 1600);
				if (entity instanceof LivingEntity _livingEntity56 && _livingEntity56.getAttributes().hasAttribute(Attributes.SCALE))
					_livingEntity56.getAttribute(Attributes.SCALE).setBaseValue(1);
			} else if (entity.getPersistentData().getDouble("level") == 6) {
				entity.getPersistentData().putDouble("damage",
						(70 + 70 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (70 + 70 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2 - 2 * entity.getPersistentData().getDouble("spaBuff")));
				if (entity instanceof LivingEntity _livingEntity66 && _livingEntity66.getAttributes().hasAttribute(Attributes.SCALE))
					_livingEntity66.getAttribute(Attributes.SCALE).setBaseValue(1.2);
				entity.getPersistentData().putDouble("upCost", 2000);
			} else if (entity.getPersistentData().getDouble("level") == 7) {
				if (entity instanceof LivingEntity _livingEntity69 && _livingEntity69.getAttributes().hasAttribute(Attributes.SCALE))
					_livingEntity69.getAttribute(Attributes.SCALE).setBaseValue(1.5);
				entity.getPersistentData().putDouble("damage",
						(90 + 90 * entity.getPersistentData().getDouble("unitLevel") * 0.1 + (90 + 90 * entity.getPersistentData().getDouble("unitLevel") * 0.1) * entity.getPersistentData().getDouble("damageBuff")));
				entity.getPersistentData().putDouble("range", (7 + 7 * entity.getPersistentData().getDouble("rangeBuff")));
				entity.getPersistentData().putDouble("spa", (2 - 2 * entity.getPersistentData().getDouble("spaBuff")));
			}
		}
	}
}