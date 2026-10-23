package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class FindTargetPProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity nearestEnemy = null;
		String priority = "";
		boolean found = false;
		boolean isWatched = false;
		boolean isCritial = false;
		double pdy = 0;
		double pdx = 0;
		double distSq = 0;
		double pdz = 0;
		double dot = 0;
		double dist = 0;
		double nx = 0;
		double ny = 0;
		double nz = 0;
		double score = 0;
		double dx = 0;
		double dz = 0;
		double dz3 = 0;
		double playerLookZ = 0;
		double dz2 = 0;
		double playerLookY = 0;
		double dx3 = 0;
		double playerLookX = 0;
		double dx2 = 0;
		double nearestDistSq = 0;
		double bestScore = 0;
		double nz2 = 0;
		double finalDamage = 0;
		double nx2 = 0;
		double yaw = 0;
		double dy2 = 0;
		double dist3 = 0;
		{
			final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("range")) / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator.getPersistentData().getBoolean("attackable")) {
					dx = entityiterator.getX() - entity.getX();
					dz = entityiterator.getZ() - entity.getZ();
					distSq = dx * dx + dz * dz;
					if ((priority).equals("nearest")) {
						score = 0 - distSq;
					} else if ((priority).equals("furthest")) {
						score = distSq;
					} else if ((priority).equals("strongest")) {
						score = entityiterator.getPersistentData().getDouble("powerful");
						if (score == 0) {
							score = entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1;
						}
					} else if ((priority).equals("weakest")) {
						score = entityiterator.getPersistentData().getDouble("powerful");
						if (score == 0) {
							score = entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
						}
						score = 0 - score;
					} else if ((priority).equals("aerial")) {
						if (entityiterator.getPersistentData().getBoolean("aerial")) {
							score = 0 - distSq;
						} else {
							score = -1000000000;
						}
					} else if ((priority).equals("first")) {
						score = entityiterator.getPersistentData().getDouble("pathProgress");
					} else if ((priority).equals("last")) {
						score = 0 - entityiterator.getPersistentData().getDouble("pathProgress");
					} else {
						score = entityiterator.getPersistentData().getDouble("pathProgress");
					}
					if (entityiterator.isAlive() && score > bestScore) {
						bestScore = score;
						nearestDistSq = distSq;
						nearestEnemy = entityiterator;
						found = true;
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof Player) {
					playerLookX = entityiterator.getLookAngle().x;
					playerLookY = entityiterator.getLookAngle().y;
					playerLookZ = entityiterator.getLookAngle().z;
					dx2 = entity.getX() - entityiterator.getX();
					dy2 = (entity.getY() + 0.5) - (entityiterator.getY() + 1.62);
					dz2 = entity.getZ() - entityiterator.getZ();
					dist = Math.sqrt(dy2 * dy2 + dx2 * dx2 + dz2 * dz2);
					nx = dx2 / dist;
					ny = dy2 / dist;
					nz = dz2 / dist;
					dot = playerLookY * ny + playerLookX * nx + playerLookZ * nz;
					if (dot >= 0.95) {
						isWatched = true;
					}
				}
			}
		}
	}
}