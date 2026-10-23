package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.WolfUnitEntity;

import java.util.Comparator;

public class WolfBuffProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean buffed = false;
		boolean foundWolf = false;
		Entity wolf = null;
		double ddx = 0;
		double ddz = 0;
		double ddistSq = 0;
		double drange = 0;
		entity.getPersistentData().putDouble("damageBuff", (entity.getPersistentData().getDouble("damageBuffBase")));
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof WolfUnitEntity) {
					ddx = entity.getX() - entityiterator.getX();
					ddz = entity.getZ() - entityiterator.getZ();
					ddistSq = ddx * ddx + ddz * ddz;
					drange = entityiterator.getPersistentData().getDouble("range") / 2;
					if (ddistSq <= drange * drange && !buffed) {
						entity.getPersistentData().putDouble("damageBuff", (entity.getPersistentData().getDouble("damageBuffBase") + entityiterator.getPersistentData().getDouble("wolfBuff") / 100));
						buffed = true;
					}
				}
			}
		}
	}
}