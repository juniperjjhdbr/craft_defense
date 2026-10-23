package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.entity.*;

public class LlamaOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		CraftDefenseModVariables.MapVariables.get(world).aliveEnemies = CraftDefenseModVariables.MapVariables.get(world).aliveEnemies + 1;
		CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		if (CraftDefenseModVariables.MapVariables.get(world).act < 1000) {
			if ((world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount()) >= 1) {
				if (entity instanceof LlamaBEntity || entity instanceof ZombieVillager2Entity) {
					if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity3.getAttribute(Attributes.MAX_HEALTH).setBaseValue((1500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (1500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof StrayEntity) {
					if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity6.getAttribute(Attributes.MAX_HEALTH).setBaseValue((2000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (2000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof PolarBearEntity) {
					if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity9.getAttribute(Attributes.MAX_HEALTH).setBaseValue((2500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (2500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof SnowGolemEntity || entity instanceof PillagerEntity) {
					if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity13.getAttribute(Attributes.MAX_HEALTH).setBaseValue((3500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (3500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof CreeperEnemyEntity) {
					if (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity16.getAttribute(Attributes.MAX_HEALTH).setBaseValue((1300 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (1300 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof BatEntity || entity instanceof SlimeEnemyEntity) {
					if (entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity20.getAttribute(Attributes.MAX_HEALTH).setBaseValue((1000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (1000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof WitchEntity || entity instanceof VexEntity) {
					if (entity instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity24.getAttribute(Attributes.MAX_HEALTH).setBaseValue((4000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (4000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof ZombieVillagerEntity || entity instanceof VindicatorEntity) {
					if (entity instanceof LivingEntity _livingEntity28 && _livingEntity28.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity28.getAttribute(Attributes.MAX_HEALTH).setBaseValue((5500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (5500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof CaveSpiderEntity || entity instanceof EvokerEntity) {
					if (entity instanceof LivingEntity _livingEntity32 && _livingEntity32.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity32.getAttribute(Attributes.MAX_HEALTH).setBaseValue((6250 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (6250 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof ZombieHorseEntity || entity instanceof RavagerEntity || entity instanceof WarmPigEntity || entity instanceof DonkeyEntity || entity instanceof PillagerBossEntity) {
					if (entity instanceof LivingEntity _livingEntity39 && _livingEntity39.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity39.getAttribute(Attributes.MAX_HEALTH).setBaseValue((7000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (7000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof SkeletonHorseEntity || entity instanceof VindicatorBossEntity) {
					if (entity instanceof LivingEntity _livingEntity43 && _livingEntity43.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity43.getAttribute(Attributes.MAX_HEALTH).setBaseValue((8000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (8000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof EvokerBossEntity || entity instanceof WarmChickenEntity || entity instanceof WarmCowEntity) {
					if (entity instanceof LivingEntity _livingEntity48 && _livingEntity48.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity48.getAttribute(Attributes.MAX_HEALTH).setBaseValue((10000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (10000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof RavagerBossEntity || entity instanceof CamelEntity || entity instanceof AllayBossEntity) {
					if (entity instanceof LivingEntity _livingEntity53 && _livingEntity53.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity53.getAttribute(Attributes.MAX_HEALTH).setBaseValue((12500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (12500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof IronGolemBossEntity || entity instanceof HuskEntity) {
					if (entity instanceof LivingEntity _livingEntity57 && _livingEntity57.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity57.getAttribute(Attributes.MAX_HEALTH).setBaseValue((16500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (16500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof ArmadilloEntity || entity instanceof DonkeyBossEntity) {
					if (entity instanceof LivingEntity _livingEntity61 && _livingEntity61.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity61.getAttribute(Attributes.MAX_HEALTH).setBaseValue((18000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (18000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof CamelBossEntity || entity instanceof TadpoleEntity) {
					if (entity instanceof LivingEntity _livingEntity65 && _livingEntity65.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity65.getAttribute(Attributes.MAX_HEALTH).setBaseValue((22500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (22500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof HuskBossEntity || entity instanceof AxolotlEntity || entity instanceof CodEntity) {
					if (entity instanceof LivingEntity _livingEntity70 && _livingEntity70.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity70.getAttribute(Attributes.MAX_HEALTH).setBaseValue((25000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (25000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof ArmadilloBossEntity || entity instanceof SalmonEntity) {
					if (entity instanceof LivingEntity _livingEntity74 && _livingEntity74.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity74.getAttribute(Attributes.MAX_HEALTH).setBaseValue((29000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (29000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof ParchedBossEntity || entity instanceof PufferfishEntity || entity instanceof PufferfishBossEntity) {
					if (entity instanceof LivingEntity _livingEntity79 && _livingEntity79.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity79.getAttribute(Attributes.MAX_HEALTH).setBaseValue((35000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (35000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof TurtleEntity || entity instanceof DolphinBossEntity) {
					if (entity instanceof LivingEntity _livingEntity83 && _livingEntity83.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity83.getAttribute(Attributes.MAX_HEALTH).setBaseValue((40000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (40000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof DrownedBossEntity) {
					if (entity instanceof LivingEntity _livingEntity86 && _livingEntity86.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity86.getAttribute(Attributes.MAX_HEALTH).setBaseValue((42500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (42500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof GuardianBossEntity) {
					if (entity instanceof LivingEntity _livingEntity89 && _livingEntity89.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity89.getAttribute(Attributes.MAX_HEALTH).setBaseValue((47500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (47500 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else if (entity instanceof ElderGuardianBossEntity) {
					if (entity instanceof LivingEntity _livingEntity92 && _livingEntity92.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity92.getAttribute(Attributes.MAX_HEALTH).setBaseValue((55000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) (55000 * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				} else {
					if (entity instanceof LivingEntity _livingEntity95 && _livingEntity95.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
						_livingEntity95.getAttribute(Attributes.MAX_HEALTH)
								.setBaseValue(((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) * CraftDefenseModVariables.MapVariables.get(world).playersInGame * CraftDefenseModVariables.MapVariables.get(world).difficulty));
				}
			}
		} else {
			if (entity instanceof LivingEntity _livingEntity99 && _livingEntity99.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
				_livingEntity99.getAttribute(Attributes.MAX_HEALTH).setBaseValue(((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * CraftDefenseModVariables.MapVariables.get(world).playersInGame
						* Math.pow(10, -0.09587106 + 0.09587106 * CraftDefenseModVariables.MapVariables.get(world).wave + 0.13716048 * Math.log10(CraftDefenseModVariables.MapVariables.get(world).wave))));
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * CraftDefenseModVariables.MapVariables.get(world).playersInGame
						* Math.pow(10, -0.09587106 + 0.09587106 * CraftDefenseModVariables.MapVariables.get(world).wave + 0.13716048 * Math.log10(CraftDefenseModVariables.MapVariables.get(world).wave))));
		}
	}
}