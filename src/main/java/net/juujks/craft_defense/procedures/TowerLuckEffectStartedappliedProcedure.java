package net.juujks.craft_defense.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModMobEffects;

public class TowerLuckEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
			_vars.additionalChance = 1.25 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(CraftDefenseModMobEffects.TOWER_LUCK) ? _livEnt.getEffect(CraftDefenseModMobEffects.TOWER_LUCK).getAmplifier() : 0) / 4;
			_vars.markSyncDirty();
		}
	}
}