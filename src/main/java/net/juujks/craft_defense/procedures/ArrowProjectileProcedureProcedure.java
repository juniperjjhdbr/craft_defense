package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.juujks.craft_defense.entity.BoggedUnitEntity;

public class ArrowProjectileProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (entity.getPersistentData().getBoolean("attackable")) {
			if (entity.getPersistentData().getDouble("powerful") <= sourceentity.getPersistentData().getDouble("level")) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) sourceentity.getPersistentData().getDouble("damage"));
				if (sourceentity instanceof BoggedUnitEntity) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 120, 32, false, false));
				}
				if (!immediatesourceentity.level().isClientSide())
					immediatesourceentity.discard();
			}
		}
	}
}