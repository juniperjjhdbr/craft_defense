package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.entity.SlimeEntity;
import net.juujks.craft_defense.entity.SlimeEnemyEntity;

public class AttackableProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double motionZ = 0;
		double decimalX = 0;
		double rotatedCooldown = 0;
		double motionX = 0;
		double speedAxis = 0;
		double decimalZ = 0;
		double powerfulChance = 0;
		double poisonCooldown = 0;
		boolean isPowerful = false;
		boolean setAlive = false;
		entity.getPersistentData().putDouble("pathProgress", (entity.getPersistentData().getDouble("pathProgress") + 1));
		entity.getPersistentData().putBoolean("attackable", true);
		if (!(entity instanceof SlimeEntity) || !(!(CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910) || !(entity instanceof SlimeEnemyEntity))) {
			if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.SCALE))
				_livingEntity5.getAttribute(Attributes.SCALE).setBaseValue(0.5);
		} else if (CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910) {
			if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.SCALE))
				_livingEntity6.getAttribute(Attributes.SCALE).setBaseValue(0.75);
		} else {
			if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.SCALE))
				_livingEntity7.getAttribute(Attributes.SCALE).setBaseValue(1);
		}
		EnemyTraitProcedureProcedure.execute(world, entity);
		LifeBarProcedure.execute(world, entity);
		LifeBarPowerfulProcedure.execute(world, entity);
		LifeBarBossProcedure.execute(world, entity);
		LifeBarAerialProcedure.execute(world, entity);
		LifeBarFastProcedure.execute(world, entity);
		EndEnemySysProcedure.execute(world, x, y, z, entity);
		WalkSysProcedure.execute(world, x, y, z, entity);
		RegenProcedureProcedure.execute(entity);
		LifeBarRegenProcedure.execute(world, entity);
		LifeBarTankProcedure.execute(world, entity);
		LifeBarClonerProcedure.execute(world, entity);
		if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.POISON)) {
			entity.getPersistentData().putDouble("poisonCooldown", (entity.getPersistentData().getDouble("poisonCooldown") + 1 * CraftDefenseModVariables.MapVariables.get(world).gameSpeed));
		}
		if (entity.getPersistentData().getDouble("poisonCooldown") >= 40) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.025));
			entity.getPersistentData().putDouble("poisonCooldown", 0);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle entity_effect{color:[0.16,0.44,0.18,1.0]} ~ ~1 ~ 0 0 0 0.1 3 normal");
		}
		if (entity.getPersistentData().getDouble("burningTick") > 0) {
			if (CraftDefenseModVariables.MapVariables.get(world).gameSpeed != 3 ? entity.getPersistentData().getDouble("burningTick") % 20 == 0 : entity.getPersistentData().getDouble("burningTick") % 21 == 0) {
				entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.05));
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, y, z, 3, 0, 0, 0, 0.025);
			entity.getPersistentData().putDouble("burningTick", (entity.getPersistentData().getDouble("burningTick") - 1 * CraftDefenseModVariables.MapVariables.get(world).gameSpeed));
		}
		if (entity.getPersistentData().getBoolean("stunned")) {
			if (entity.getPersistentData().getDouble("stunTimer") < 60) {
				entity.getPersistentData().putDouble("stunTimer", (entity.getPersistentData().getDouble("stunTimer") + 1 * CraftDefenseModVariables.MapVariables.get(world).gameSpeed));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.PORTAL, x, y, z, 1, 0, 0, 0, 1);
			}
		}
	}
}