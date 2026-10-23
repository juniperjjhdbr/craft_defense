package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.entity.CreeperUnitEntity;
import net.juujks.craft_defense.entity.ChargedCreeperUnitEntity;

import java.util.Comparator;

public class CreeperExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("range")) / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator.getPersistentData().getBoolean("attackable")) {
					if (entity instanceof CreeperUnitEntity || entity instanceof ChargedCreeperUnitEntity) {
						if (entity.getPersistentData().getDouble("cooldown") == 20 * entity.getPersistentData().getDouble("spa") - 20) {
							if (entity instanceof CreeperUnitEntity) {
								((CreeperUnitEntity) entity).setControllerAnimation("procedure", "explode");
							}
							if (entity instanceof ChargedCreeperUnitEntity) {
								((ChargedCreeperUnitEntity) entity).setControllerAnimation("procedure", "explode");
							}
							if (entity instanceof CreeperUnitEntity animatable)
								animatable.setTexture("creeper_primed");
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.creeper.primed")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.creeper.primed")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					}
				}
			}
		}
	}
}