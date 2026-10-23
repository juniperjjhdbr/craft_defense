package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class ChangePriorityPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String texto = "";
		Entity entidade = null;
		double priorityIndex = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if ((entity.getPersistentData().getString("guiOpenedOf")).equals(entityiterator.getStringUUID())) {
					if ((entityiterator.getPersistentData().getString("priority")).equals("nearest")) {
						entityiterator.getPersistentData().putString("priority", "furthest");
					} else if ((entityiterator.getPersistentData().getString("priority")).equals("furthest")) {
						entityiterator.getPersistentData().putString("priority", "first");
					} else if ((entityiterator.getPersistentData().getString("priority")).equals("first")) {
						entityiterator.getPersistentData().putString("priority", "last");
					} else if ((entityiterator.getPersistentData().getString("priority")).equals("last")) {
						entityiterator.getPersistentData().putString("priority", "strongest");
					} else if ((entityiterator.getPersistentData().getString("priority")).equals("strongest")) {
						entityiterator.getPersistentData().putString("priority", "weakest");
					} else if ((entityiterator.getPersistentData().getString("priority")).equals("weakest")) {
						if (entityiterator.getPersistentData().getBoolean("canHitAerial")) {
							entityiterator.getPersistentData().putString("priority", "aerial");
						} else {
							entityiterator.getPersistentData().putString("priority", "nearest");
						}
					} else if ((entityiterator.getPersistentData().getString("priority")).equals("aerial")) {
						entityiterator.getPersistentData().putString("priority", "nearest");
					} else {
						entityiterator.getPersistentData().putString("priority", "first");
					}
				}
			}
		}
	}
}