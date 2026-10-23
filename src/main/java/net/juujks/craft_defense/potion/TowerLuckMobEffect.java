package net.juujks.craft_defense.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.juujks.craft_defense.procedures.TowerLuckEffectStartedappliedProcedure;

public class TowerLuckMobEffect extends MobEffect {
	public TowerLuckMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10027162);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		TowerLuckEffectStartedappliedProcedure.execute(entity);
	}
}