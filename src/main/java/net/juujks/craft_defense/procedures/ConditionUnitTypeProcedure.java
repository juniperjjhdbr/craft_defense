package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.entity.*;

import java.util.Comparator;

public class ConditionUnitTypeProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		boolean valido = false;
		valido = false;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if ((entity.getPersistentData().getString("guiOpenedOf")).equals(entityiterator.getStringUUID())) {
					if (entityiterator instanceof AlexEntity || entityiterator instanceof CreeperUnitEntity || entityiterator instanceof SkeletonUnitEntity || entityiterator instanceof SlimeUnitEntity || entityiterator instanceof SpiderUnitEntity
							|| entityiterator instanceof SteveEntity || entityiterator instanceof WitchUnitEntity || entityiterator instanceof ZombieUnitEntity) {
						valido = true;
					}
				}
			}
		}
		return valido;
	}
}