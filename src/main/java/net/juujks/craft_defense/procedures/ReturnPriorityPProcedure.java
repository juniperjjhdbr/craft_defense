package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class ReturnPriorityPProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		String texto = "";
		Entity entidade = null;
		double priorityIndex = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if ((entity.getPersistentData().getString("guiOpenedOf")).equals(entityiterator.getStringUUID())) {
					if ((entityiterator.getPersistentData().getString("priority")).equals("nearest")) {
						texto = "Nearest";
					} else if ((entityiterator.getPersistentData().getString("priority")).equals("furthest")) {
						texto = "Furthest";
					} else if ((entityiterator.getPersistentData().getString("priority")).equals("strongest")) {
						texto = "Strongest";
					} else if ((entityiterator.getPersistentData().getString("priority")).equals("weakest")) {
						texto = "Weakest";
					} else if ((entityiterator.getPersistentData().getString("priority")).equals("first")) {
						texto = "First";
					} else if ((entityiterator.getPersistentData().getString("priority")).equals("last")) {
						texto = "Last";
					} else if ((entityiterator.getPersistentData().getString("priority")).equals("aerial")) {
						texto = "Aerial";
					} else {
						texto = "Nearest";
					}
				}
			}
		}
		return texto;
	}
}