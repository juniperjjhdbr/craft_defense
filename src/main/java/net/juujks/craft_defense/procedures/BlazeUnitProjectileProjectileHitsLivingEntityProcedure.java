package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class BlazeUnitProjectileProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (entity.getPersistentData().getBoolean("attackable")) {
			if (entity.getPersistentData().getDouble("powerful") <= sourceentity.getPersistentData().getDouble("level")) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) sourceentity.getPersistentData().getDouble("damage"));
				entity.getPersistentData().putDouble("burningTick", 100);
				entity.igniteForSeconds(5);
				if (!immediatesourceentity.level().isClientSide())
					immediatesourceentity.discard();
			}
		}
	}
}