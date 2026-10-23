package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.entity.RangeSquareEntity;
import net.juujks.craft_defense.entity.AoeSquareEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class ResetEnemiesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (CraftDefenseModVariables.MapVariables.get(world).bossKilled || CraftDefenseModVariables.MapVariables.get(world).wave == 0) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(512 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator.getPersistentData().getBoolean("unit")) {
						entityiterator.getPersistentData().putBoolean("hasAoeMarker", false);
						entityiterator.getPersistentData().putBoolean("hasRangeMarker", false);
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
					if (entityiterator instanceof AoeSquareEntity || entityiterator instanceof RangeSquareEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
				}
			}
		}
	}
}