package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.entity.*;

public class EnemyTraitProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof CowEntity || entity instanceof EnemyPowerfulEntity || entity instanceof SkeletonEnemyEntity || entity instanceof ZombieVillager2Entity || entity instanceof WarmCowEntity || entity instanceof CodEntity
				|| entity instanceof ColdCowEntity) {
			entity.getPersistentData().putDouble("powerful", 2);
		}
		if (entity instanceof SheepEntity || entity instanceof EnemyPowerful2Entity || entity instanceof CreeperEnemyEntity || entity instanceof PillagerEntity || entity instanceof CamelEntity || entity instanceof SalmonEntity
				|| entity instanceof GoatEntity) {
			entity.getPersistentData().putDouble("powerful", 3);
		}
		if (entity instanceof SnowFoxEntity || entity instanceof VindicatorEntity || entity instanceof HuskEntity || entity instanceof PufferfishEntity || entity instanceof EnemyPowerful3Entity) {
			entity.getPersistentData().putDouble("powerful", 4);
		}
		if (!(CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 910)) {
			if (entity instanceof ZombieEntity || entity instanceof SkeletonEntity || entity instanceof SpiderEntity || entity instanceof RabbitEntity || entity instanceof StrayEntity || entity instanceof LlamaBEntity
					|| entity instanceof PolarBearEntity || entity instanceof SnowGolemEntity || entity instanceof CaveSpiderEntity || entity instanceof WitchEntity || entity instanceof ZombieHorseEntity || entity instanceof SkeletonHorseEntity
					|| entity instanceof ZombieVillagerEntity || entity instanceof SlimeEntity || entity instanceof AllayBossEntity || entity instanceof EvokerBossEntity || entity instanceof IronGolemBossEntity || entity instanceof PillagerBossEntity
					|| entity instanceof RavagerBossEntity || entity instanceof VindicatorBossEntity || entity instanceof ArmadilloBossEntity || entity instanceof CamelBossEntity || entity instanceof DonkeyBossEntity
					|| entity instanceof HuskBossEntity || entity instanceof ParchedBossEntity || entity instanceof DolphinBossEntity || entity instanceof DrownedBossEntity || entity instanceof ElderGuardianBossEntity
					|| entity instanceof GuardianBossEntity || entity instanceof PufferfishBossEntity || entity instanceof CreeperEntity) {
				entity.getPersistentData().putDouble("boss", 1);
			}
		} else {
			if (entity instanceof SkeletonHorseEntity) {
				entity.getPersistentData().putDouble("boss", 1);
			}
		}
		if (entity instanceof ColdChickenEntity || entity instanceof EnemyAerialEntity || entity instanceof BatEntity || entity instanceof VexEntity || entity instanceof WarmChickenEntity || entity instanceof AxolotlEntity
				|| entity instanceof ChickenEntity) {
			entity.getPersistentData().putBoolean("aerial", true);
		}
		if (CraftDefenseModVariables.MapVariables.get(world).challenge == 3) {
			if (entity instanceof PigEntity || entity instanceof ColdPigEntity || entity instanceof ZombieEnemyEntity || entity instanceof Witch2Entity || entity instanceof WarmPigEntity || entity instanceof TadpoleEntity) {
				entity.getPersistentData().putBoolean("aerial", true);
			}
		}
		if (entity instanceof HorseEntity || entity instanceof EnemyFastEntity || entity instanceof SpiderEnemyEntity || entity instanceof DonkeyEntity || entity instanceof LlamaEntity) {
			entity.getPersistentData().putBoolean("fast", true);
		}
		if (entity instanceof EnemyRegeneratorEntity) {
			entity.getPersistentData().putBoolean("regen", true);
		}
		if (entity instanceof EnemyTankEntity || entity instanceof ArmadilloEntity || entity instanceof TurtleEntity || entity instanceof RavagerEntity) {
			entity.getPersistentData().putBoolean("tank", true);
		}
		if (entity instanceof SlimeEnemyEntity || entity instanceof EvokerEntity || entity instanceof SlimeClonedEntity) {
			entity.getPersistentData().putBoolean("cloner", true);
		}
	}
}