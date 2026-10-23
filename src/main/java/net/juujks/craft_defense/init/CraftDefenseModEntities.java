package net.juujks.craft_defense.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.juujks.craft_defense.entity.*;
import net.juujks.craft_defense.CraftDefenseMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CraftDefenseModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, CraftDefenseMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<SteveEntity>> STEVE = register("steve",
			EntityType.Builder.<SteveEntity>of(SteveEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<PigEntity>> PIG = register("pig",
			EntityType.Builder.<PigEntity>of(PigEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<AlexEntity>> ALEX = register("alex",
			EntityType.Builder.<AlexEntity>of(AlexEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ZombieEntity>> ZOMBIE = register("zombie",
			EntityType.Builder.<ZombieEntity>of(ZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<CowEntity>> COW = register("cow",
			EntityType.Builder.<CowEntity>of(CowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ChickenEntity>> CHICKEN = register("chicken",
			EntityType.Builder.<ChickenEntity>of(ChickenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ZombieUnitEntity>> ZOMBIE_UNIT = register("zombie_unit",
			EntityType.Builder.<ZombieUnitEntity>of(ZombieUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SheepEntity>> SHEEP = register("sheep",
			EntityType.Builder.<SheepEntity>of(SheepEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<HorseEntity>> HORSE = register("horse",
			EntityType.Builder.<HorseEntity>of(HorseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SkeletonEntity>> SKELETON = register("skeleton",
			EntityType.Builder.<SkeletonEntity>of(SkeletonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SpiderEntity>> SPIDER = register("spider",
			EntityType.Builder.<SpiderEntity>of(SpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<CreeperEntity>> CREEPER = register("creeper",
			EntityType.Builder.<CreeperEntity>of(CreeperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SlimeEntity>> SLIME = register("slime",
			EntityType.Builder.<SlimeEntity>of(SlimeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<CreeperUnitEntity>> CREEPER_UNIT = register("creeper_unit",
			EntityType.Builder.<CreeperUnitEntity>of(CreeperUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SpiderUnitEntity>> SPIDER_UNIT = register("spider_unit",
			EntityType.Builder.<SpiderUnitEntity>of(SpiderUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<WitchUnitEntity>> WITCH_UNIT = register("witch_unit",
			EntityType.Builder.<WitchUnitEntity>of(WitchUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SlimeUnitEntity>> SLIME_UNIT = register("slime_unit",
			EntityType.Builder.<SlimeUnitEntity>of(SlimeUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ColdPigEntity>> COLD_PIG = register("cold_pig",
			EntityType.Builder.<ColdPigEntity>of(ColdPigEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ColdCowEntity>> COLD_COW = register("cold_cow",
			EntityType.Builder.<ColdCowEntity>of(ColdCowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ColdChickenEntity>> COLD_CHICKEN = register("cold_chicken",
			EntityType.Builder.<ColdChickenEntity>of(ColdChickenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<RabbitEntity>> RABBIT = register("rabbit",
			EntityType.Builder.<RabbitEntity>of(RabbitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<GoatEntity>> GOAT = register("goat",
			EntityType.Builder.<GoatEntity>of(GoatEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<LlamaEntity>> LLAMA_BOSS = register("llama_boss",
			EntityType.Builder.<LlamaEntity>of(LlamaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SnowFoxEntity>> SNOW_FOX = register("snow_fox",
			EntityType.Builder.<SnowFoxEntity>of(SnowFoxEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<StrayEntity>> STRAY = register("stray",
			EntityType.Builder.<StrayEntity>of(StrayEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<PolarBearEntity>> POLAR_BEAR = register("polar_bear",
			EntityType.Builder.<PolarBearEntity>of(PolarBearEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SnowGolemEntity>> SNOW_GOLEM = register("snow_golem",
			EntityType.Builder.<SnowGolemEntity>of(SnowGolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<LlamaBEntity>> LLAMA_B = register("llama_b",
			EntityType.Builder.<LlamaBEntity>of(LlamaBEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<VillagerUnitEntity>> VILLAGER_UNIT = register("villager_unit",
			EntityType.Builder.<VillagerUnitEntity>of(VillagerUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<EnemyEntity>> ENEMY = register("enemy",
			EntityType.Builder.<EnemyEntity>of(EnemyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<EnemyPowerfulEntity>> ENEMY_POWERFUL = register("enemy_powerful",
			EntityType.Builder.<EnemyPowerfulEntity>of(EnemyPowerfulEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<EnemyAerialEntity>> ENEMY_AERIAL = register("enemy_aerial",
			EntityType.Builder.<EnemyAerialEntity>of(EnemyAerialEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<EnemyPowerful2Entity>> ENEMY_POWERFUL_2 = register("enemy_powerful_2",
			EntityType.Builder.<EnemyPowerful2Entity>of(EnemyPowerful2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<EnemyPowerful3Entity>> ENEMY_POWERFUL_3 = register("enemy_powerful_3",
			EntityType.Builder.<EnemyPowerful3Entity>of(EnemyPowerful3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<EnemyFastEntity>> ENEMY_FAST = register("enemy_fast",
			EntityType.Builder.<EnemyFastEntity>of(EnemyFastEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<EnemyTankEntity>> ENEMY_TANK = register("enemy_tank",
			EntityType.Builder.<EnemyTankEntity>of(EnemyTankEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<EnemyRegeneratorEntity>> ENEMY_REGENERATOR = register("enemy_regenerator",
			EntityType.Builder.<EnemyRegeneratorEntity>of(EnemyRegeneratorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ZombieEnemyEntity>> ZOMBIE_ENEMY = register("zombie_enemy",
			EntityType.Builder.<ZombieEnemyEntity>of(ZombieEnemyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SkeletonEnemyEntity>> SKELETON_ENEMY = register("skeleton_enemy",
			EntityType.Builder.<SkeletonEnemyEntity>of(SkeletonEnemyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SpiderEnemyEntity>> SPIDER_ENEMY = register("spider_enemy",
			EntityType.Builder.<SpiderEnemyEntity>of(SpiderEnemyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<CreeperEnemyEntity>> CREEPER_ENEMY = register("creeper_enemy",
			EntityType.Builder.<CreeperEnemyEntity>of(CreeperEnemyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<BatEntity>> BAT = register("bat",
			EntityType.Builder.<BatEntity>of(BatEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<WitchEntity>> WITCH = register("witch",
			EntityType.Builder.<WitchEntity>of(WitchEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SlimeEnemyEntity>> SLIME_ENEMY = register("slime_enemy",
			EntityType.Builder.<SlimeEnemyEntity>of(SlimeEnemyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SlimeClonedEntity>> SLIME_CLONED = register("slime_cloned",
			EntityType.Builder.<SlimeClonedEntity>of(SlimeClonedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ZombieVillagerEntity>> ZOMBIE_VILLAGER = register("zombie_villager",
			EntityType.Builder.<ZombieVillagerEntity>of(ZombieVillagerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<CaveSpiderEntity>> CAVE_SPIDER = register("cave_spider",
			EntityType.Builder.<CaveSpiderEntity>of(CaveSpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ZombieHorseEntity>> ZOMBIE_HORSE = register("zombie_horse",
			EntityType.Builder.<ZombieHorseEntity>of(ZombieHorseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SkeletonHorseEntity>> SKELETON_HORSE = register("skeleton_horse",
			EntityType.Builder.<SkeletonHorseEntity>of(SkeletonHorseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<CaveSpiderUnitEntity>> CAVE_SPIDER_UNIT = register("cave_spider_unit",
			EntityType.Builder.<CaveSpiderUnitEntity>of(CaveSpiderUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<StrayUnitEntity>> STRAY_UNIT = register("stray_unit",
			EntityType.Builder.<StrayUnitEntity>of(StrayUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ZombifiedPiglinUnitEntity>> ZOMBIFIED_PIGLIN_UNIT = register("zombified_piglin_unit",
			EntityType.Builder.<ZombifiedPiglinUnitEntity>of(ZombifiedPiglinUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<PiglinUnitEntity>> PIGLIN_UNIT = register("piglin_unit",
			EntityType.Builder.<PiglinUnitEntity>of(PiglinUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<PufferfishUnitEntity>> PUFFERFISH_UNIT = register("pufferfish_unit",
			EntityType.Builder.<PufferfishUnitEntity>of(PufferfishUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<IronGolemUnitEntity>> IRON_GOLEM_UNIT = register("iron_golem_unit",
			EntityType.Builder.<IronGolemUnitEntity>of(IronGolemUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<Witch2Entity>> WITCH_2 = register("witch_2",
			EntityType.Builder.<Witch2Entity>of(Witch2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ZombieVillager2Entity>> ZOMBIE_VILLAGER_2 = register("zombie_villager_2",
			EntityType.Builder.<ZombieVillager2Entity>of(ZombieVillager2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<PillagerBossEntity>> PILLAGER_BOSS = register("pillager_boss",
			EntityType.Builder.<PillagerBossEntity>of(PillagerBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<VexEntity>> VEX = register("vex",
			EntityType.Builder.<VexEntity>of(VexEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<PillagerEntity>> PILLAGER = register("pillager",
			EntityType.Builder.<PillagerEntity>of(PillagerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<VindicatorBossEntity>> VINDICATOR_BOSS = register("vindicator_boss",
			EntityType.Builder.<VindicatorBossEntity>of(VindicatorBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<VindicatorEntity>> VINDICATOR = register("vindicator",
			EntityType.Builder.<VindicatorEntity>of(VindicatorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<EvokerBossEntity>> EVOKER_BOSS = register("evoker_boss",
			EntityType.Builder.<EvokerBossEntity>of(EvokerBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<EvokerEntity>> EVOKER = register("evoker",
			EntityType.Builder.<EvokerEntity>of(EvokerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<RavagerBossEntity>> RAVAGER_BOSS = register("ravager_boss",
			EntityType.Builder.<RavagerBossEntity>of(RavagerBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<RavagerEntity>> RAVAGER = register("ravager",
			EntityType.Builder.<RavagerEntity>of(RavagerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<IronGolemBossEntity>> IRON_GOLEM_BOSS = register("iron_golem_boss",
			EntityType.Builder.<IronGolemBossEntity>of(IronGolemBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<AllayBossEntity>> ALLAY_BOSS = register("allay_boss",
			EntityType.Builder.<AllayBossEntity>of(AllayBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<WarmPigEntity>> WARM_PIG = register("warm_pig",
			EntityType.Builder.<WarmPigEntity>of(WarmPigEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<WarmCowEntity>> WARM_COW = register("warm_cow",
			EntityType.Builder.<WarmCowEntity>of(WarmCowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<WarmChickenEntity>> WARM_CHICKEN = register("warm_chicken",
			EntityType.Builder.<WarmChickenEntity>of(WarmChickenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<CamelEntity>> CAMEL = register("camel",
			EntityType.Builder.<CamelEntity>of(CamelEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<DonkeyEntity>> DONKEY = register("donkey",
			EntityType.Builder.<DonkeyEntity>of(DonkeyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<HuskEntity>> HUSK = register("husk",
			EntityType.Builder.<HuskEntity>of(HuskEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ArmadilloEntity>> ARMADILLO = register("armadillo",
			EntityType.Builder.<ArmadilloEntity>of(ArmadilloEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<DonkeyBossEntity>> DONKEY_BOSS = register("donkey_boss",
			EntityType.Builder.<DonkeyBossEntity>of(DonkeyBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<CamelBossEntity>> CAMEL_BOSS = register("camel_boss",
			EntityType.Builder.<CamelBossEntity>of(CamelBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ArmadilloBossEntity>> ARMADILLO_BOSS = register("armadillo_boss",
			EntityType.Builder.<ArmadilloBossEntity>of(ArmadilloBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<HuskBossEntity>> HUSK_BOSS = register("husk_boss",
			EntityType.Builder.<HuskBossEntity>of(HuskBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ParchedBossEntity>> PARCHED_BOSS = register("parched_boss",
			EntityType.Builder.<ParchedBossEntity>of(ParchedBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<HuskUnitEntity>> HUSK_UNIT = register("husk_unit",
			EntityType.Builder.<HuskUnitEntity>of(HuskUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<MagmaCubeUnitEntity>> MAGMA_CUBE_UNIT = register("magma_cube_unit",
			EntityType.Builder.<MagmaCubeUnitEntity>of(MagmaCubeUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<PolarBearUnitEntity>> POLAR_BEAR_UNIT = register("polar_bear_unit",
			EntityType.Builder.<PolarBearUnitEntity>of(PolarBearUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SkeletonUnitEntity>> SKELETON_UNIT = register("skeleton_unit",
			EntityType.Builder.<SkeletonUnitEntity>of(SkeletonUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SnowGolemUnitEntity>> SNOW_GOLEM_UNIT = register("snow_golem_unit",
			EntityType.Builder.<SnowGolemUnitEntity>of(SnowGolemUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<TadpoleEntity>> TADPOLE = register("tadpole",
			EntityType.Builder.<TadpoleEntity>of(TadpoleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<SalmonEntity>> SALMON = register("salmon",
			EntityType.Builder.<SalmonEntity>of(SalmonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<AxolotlEntity>> AXOLOTL = register("axolotl",
			EntityType.Builder.<AxolotlEntity>of(AxolotlEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<CodEntity>> COD = register("cod",
			EntityType.Builder.<CodEntity>of(CodEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<TurtleEntity>> TURTLE = register("turtle",
			EntityType.Builder.<TurtleEntity>of(TurtleEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<PufferfishEntity>> PUFFERFISH = register("pufferfish",
			EntityType.Builder.<PufferfishEntity>of(PufferfishEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<PufferfishBossEntity>> PUFFERFISH_BOSS = register("pufferfish_boss",
			EntityType.Builder.<PufferfishBossEntity>of(PufferfishBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<DolphinBossEntity>> DOLPHIN_BOSS = register("dolphin_boss",
			EntityType.Builder.<DolphinBossEntity>of(DolphinBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<DrownedBossEntity>> DROWNED_BOSS = register("drowned_boss",
			EntityType.Builder.<DrownedBossEntity>of(DrownedBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<GuardianBossEntity>> GUARDIAN_BOSS = register("guardian_boss",
			EntityType.Builder.<GuardianBossEntity>of(GuardianBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ElderGuardianBossEntity>> ELDER_GUARDIAN_BOSS = register("elder_guardian_boss",
			EntityType.Builder.<ElderGuardianBossEntity>of(ElderGuardianBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ChargedCreeperUnitEntity>> CHARGED_CREEPER_UNIT = register("charged_creeper_unit",
			EntityType.Builder.<ChargedCreeperUnitEntity>of(ChargedCreeperUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<RavagerUnitEntity>> RAVAGER_UNIT = register("ravager_unit",
			EntityType.Builder.<RavagerUnitEntity>of(RavagerUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<AoeSquareEntity>> AOE_SQUARE = register("aoe_square",
			EntityType.Builder.<AoeSquareEntity>of(AoeSquareEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<RangeSquareEntity>> RANGE_SQUARE = register("range_square",
			EntityType.Builder.<RangeSquareEntity>of(RangeSquareEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<EndermanUnitEntity>> ENDERMAN_UNIT = register("enderman_unit",
			EntityType.Builder.<EndermanUnitEntity>of(EndermanUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<BreezeUnitEntity>> BREEZE_UNIT = register("breeze_unit",
			EntityType.Builder.<BreezeUnitEntity>of(BreezeUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<WolfUnitEntity>> WOLF_UNIT = register("wolf_unit",
			EntityType.Builder.<WolfUnitEntity>of(WolfUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<PillagerUnitEntity>> PILLAGER_UNIT = register("pillager_unit",
			EntityType.Builder.<PillagerUnitEntity>of(PillagerUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<BlazeUnitEntity>> BLAZE_UNIT = register("blaze_unit",
			EntityType.Builder.<BlazeUnitEntity>of(BlazeUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<BlazeUnitProjectileEntity>> BLAZE_UNIT_PROJECTILE = register("blaze_unit_projectile",
			EntityType.Builder.<BlazeUnitProjectileEntity>of(BlazeUnitProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<BoggedUnitEntity>> BOGGED_UNIT = register("bogged_unit",
			EntityType.Builder.<BoggedUnitEntity>of(BoggedUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<ArrowProjectileEntity>> ARROW_PROJECTILE = register("arrow_projectile",
			EntityType.Builder.<ArrowProjectileEntity>of(ArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<NPCMission1Entity>> NPC_MISSION_1 = register("npc_mission_1",
			EntityType.Builder.<NPCMission1Entity>of(NPCMission1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<WindChargeProjectileEntity>> WIND_CHARGE_PROJECTILE = register("wind_charge_projectile",
			EntityType.Builder.<WindChargeProjectileEntity>of(WindChargeProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<SnowballProjectileEntity>> SNOWBALL_PROJECTILE = register("snowball_projectile",
			EntityType.Builder.<SnowballProjectileEntity>of(SnowballProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<DrownedUnitEntity>> DROWNED_UNIT = register("drowned_unit",
			EntityType.Builder.<DrownedUnitEntity>of(DrownedUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);
	public static final DeferredHolder<EntityType<?>, EntityType<TridentProjectileEntity>> TRIDENT_PROJECTILE = register("trident_projectile",
			EntityType.Builder.<TridentProjectileEntity>of(TridentProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.1f, 0.1f));
	public static final DeferredHolder<EntityType<?>, EntityType<FrostbiteUnitEntity>> FROSTBITE_UNIT = register("frostbite_unit",
			EntityType.Builder.<FrostbiteUnitEntity>of(FrostbiteUnitEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune()

					.sized(0.6f, 1.8f)

	);

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerEntity(Capabilities.ItemHandler.ENTITY, SPIDER_UNIT.get(), (living, context) -> living.getCombinedInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, WITCH_UNIT.get(), (living, context) -> living.getCombinedInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, SLIME_UNIT.get(), (living, context) -> living.getCombinedInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, CAVE_SPIDER_UNIT.get(), (living, context) -> living.getCombinedInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, STRAY_UNIT.get(), (living, context) -> living.getCombinedInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, MAGMA_CUBE_UNIT.get(), (living, context) -> living.getCombinedInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, POLAR_BEAR_UNIT.get(), (living, context) -> living.getCombinedInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, RAVAGER_UNIT.get(), (living, context) -> living.getCombinedInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, PILLAGER_UNIT.get(), (living, context) -> living.getCombinedInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, BOGGED_UNIT.get(), (living, context) -> living.getCombinedInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, STEVE.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, ALEX.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, ZOMBIE_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, CREEPER_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, VILLAGER_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, ZOMBIFIED_PIGLIN_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, PIGLIN_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, PUFFERFISH_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, IRON_GOLEM_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, HUSK_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, SKELETON_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, SNOW_GOLEM_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, CHARGED_CREEPER_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, ENDERMAN_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, BREEZE_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, WOLF_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, BLAZE_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, DROWNED_UNIT.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, FROSTBITE_UNIT.get(), (living, context) -> living.getInventory());
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		SteveEntity.init(event);
		PigEntity.init(event);
		AlexEntity.init(event);
		ZombieEntity.init(event);
		CowEntity.init(event);
		ChickenEntity.init(event);
		ZombieUnitEntity.init(event);
		SheepEntity.init(event);
		HorseEntity.init(event);
		SkeletonEntity.init(event);
		SpiderEntity.init(event);
		CreeperEntity.init(event);
		SlimeEntity.init(event);
		CreeperUnitEntity.init(event);
		SpiderUnitEntity.init(event);
		WitchUnitEntity.init(event);
		SlimeUnitEntity.init(event);
		ColdPigEntity.init(event);
		ColdCowEntity.init(event);
		ColdChickenEntity.init(event);
		RabbitEntity.init(event);
		GoatEntity.init(event);
		LlamaEntity.init(event);
		SnowFoxEntity.init(event);
		StrayEntity.init(event);
		PolarBearEntity.init(event);
		SnowGolemEntity.init(event);
		LlamaBEntity.init(event);
		VillagerUnitEntity.init(event);
		EnemyEntity.init(event);
		EnemyPowerfulEntity.init(event);
		EnemyAerialEntity.init(event);
		EnemyPowerful2Entity.init(event);
		EnemyPowerful3Entity.init(event);
		EnemyFastEntity.init(event);
		EnemyTankEntity.init(event);
		EnemyRegeneratorEntity.init(event);
		ZombieEnemyEntity.init(event);
		SkeletonEnemyEntity.init(event);
		SpiderEnemyEntity.init(event);
		CreeperEnemyEntity.init(event);
		BatEntity.init(event);
		WitchEntity.init(event);
		SlimeEnemyEntity.init(event);
		SlimeClonedEntity.init(event);
		ZombieVillagerEntity.init(event);
		CaveSpiderEntity.init(event);
		ZombieHorseEntity.init(event);
		SkeletonHorseEntity.init(event);
		CaveSpiderUnitEntity.init(event);
		StrayUnitEntity.init(event);
		ZombifiedPiglinUnitEntity.init(event);
		PiglinUnitEntity.init(event);
		PufferfishUnitEntity.init(event);
		IronGolemUnitEntity.init(event);
		Witch2Entity.init(event);
		ZombieVillager2Entity.init(event);
		PillagerBossEntity.init(event);
		VexEntity.init(event);
		PillagerEntity.init(event);
		VindicatorBossEntity.init(event);
		VindicatorEntity.init(event);
		EvokerBossEntity.init(event);
		EvokerEntity.init(event);
		RavagerBossEntity.init(event);
		RavagerEntity.init(event);
		IronGolemBossEntity.init(event);
		AllayBossEntity.init(event);
		WarmPigEntity.init(event);
		WarmCowEntity.init(event);
		WarmChickenEntity.init(event);
		CamelEntity.init(event);
		DonkeyEntity.init(event);
		HuskEntity.init(event);
		ArmadilloEntity.init(event);
		DonkeyBossEntity.init(event);
		CamelBossEntity.init(event);
		ArmadilloBossEntity.init(event);
		HuskBossEntity.init(event);
		ParchedBossEntity.init(event);
		HuskUnitEntity.init(event);
		MagmaCubeUnitEntity.init(event);
		PolarBearUnitEntity.init(event);
		SkeletonUnitEntity.init(event);
		SnowGolemUnitEntity.init(event);
		TadpoleEntity.init(event);
		SalmonEntity.init(event);
		AxolotlEntity.init(event);
		CodEntity.init(event);
		TurtleEntity.init(event);
		PufferfishEntity.init(event);
		PufferfishBossEntity.init(event);
		DolphinBossEntity.init(event);
		DrownedBossEntity.init(event);
		GuardianBossEntity.init(event);
		ElderGuardianBossEntity.init(event);
		ChargedCreeperUnitEntity.init(event);
		RavagerUnitEntity.init(event);
		AoeSquareEntity.init(event);
		RangeSquareEntity.init(event);
		EndermanUnitEntity.init(event);
		BreezeUnitEntity.init(event);
		WolfUnitEntity.init(event);
		PillagerUnitEntity.init(event);
		BlazeUnitEntity.init(event);
		BoggedUnitEntity.init(event);
		NPCMission1Entity.init(event);
		DrownedUnitEntity.init(event);
		FrostbiteUnitEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(STEVE.get(), SteveEntity.createAttributes().build());
		event.put(PIG.get(), PigEntity.createAttributes().build());
		event.put(ALEX.get(), AlexEntity.createAttributes().build());
		event.put(ZOMBIE.get(), ZombieEntity.createAttributes().build());
		event.put(COW.get(), CowEntity.createAttributes().build());
		event.put(CHICKEN.get(), ChickenEntity.createAttributes().build());
		event.put(ZOMBIE_UNIT.get(), ZombieUnitEntity.createAttributes().build());
		event.put(SHEEP.get(), SheepEntity.createAttributes().build());
		event.put(HORSE.get(), HorseEntity.createAttributes().build());
		event.put(SKELETON.get(), SkeletonEntity.createAttributes().build());
		event.put(SPIDER.get(), SpiderEntity.createAttributes().build());
		event.put(CREEPER.get(), CreeperEntity.createAttributes().build());
		event.put(SLIME.get(), SlimeEntity.createAttributes().build());
		event.put(CREEPER_UNIT.get(), CreeperUnitEntity.createAttributes().build());
		event.put(SPIDER_UNIT.get(), SpiderUnitEntity.createAttributes().build());
		event.put(WITCH_UNIT.get(), WitchUnitEntity.createAttributes().build());
		event.put(SLIME_UNIT.get(), SlimeUnitEntity.createAttributes().build());
		event.put(COLD_PIG.get(), ColdPigEntity.createAttributes().build());
		event.put(COLD_COW.get(), ColdCowEntity.createAttributes().build());
		event.put(COLD_CHICKEN.get(), ColdChickenEntity.createAttributes().build());
		event.put(RABBIT.get(), RabbitEntity.createAttributes().build());
		event.put(GOAT.get(), GoatEntity.createAttributes().build());
		event.put(LLAMA_BOSS.get(), LlamaEntity.createAttributes().build());
		event.put(SNOW_FOX.get(), SnowFoxEntity.createAttributes().build());
		event.put(STRAY.get(), StrayEntity.createAttributes().build());
		event.put(POLAR_BEAR.get(), PolarBearEntity.createAttributes().build());
		event.put(SNOW_GOLEM.get(), SnowGolemEntity.createAttributes().build());
		event.put(LLAMA_B.get(), LlamaBEntity.createAttributes().build());
		event.put(VILLAGER_UNIT.get(), VillagerUnitEntity.createAttributes().build());
		event.put(ENEMY.get(), EnemyEntity.createAttributes().build());
		event.put(ENEMY_POWERFUL.get(), EnemyPowerfulEntity.createAttributes().build());
		event.put(ENEMY_AERIAL.get(), EnemyAerialEntity.createAttributes().build());
		event.put(ENEMY_POWERFUL_2.get(), EnemyPowerful2Entity.createAttributes().build());
		event.put(ENEMY_POWERFUL_3.get(), EnemyPowerful3Entity.createAttributes().build());
		event.put(ENEMY_FAST.get(), EnemyFastEntity.createAttributes().build());
		event.put(ENEMY_TANK.get(), EnemyTankEntity.createAttributes().build());
		event.put(ENEMY_REGENERATOR.get(), EnemyRegeneratorEntity.createAttributes().build());
		event.put(ZOMBIE_ENEMY.get(), ZombieEnemyEntity.createAttributes().build());
		event.put(SKELETON_ENEMY.get(), SkeletonEnemyEntity.createAttributes().build());
		event.put(SPIDER_ENEMY.get(), SpiderEnemyEntity.createAttributes().build());
		event.put(CREEPER_ENEMY.get(), CreeperEnemyEntity.createAttributes().build());
		event.put(BAT.get(), BatEntity.createAttributes().build());
		event.put(WITCH.get(), WitchEntity.createAttributes().build());
		event.put(SLIME_ENEMY.get(), SlimeEnemyEntity.createAttributes().build());
		event.put(SLIME_CLONED.get(), SlimeClonedEntity.createAttributes().build());
		event.put(ZOMBIE_VILLAGER.get(), ZombieVillagerEntity.createAttributes().build());
		event.put(CAVE_SPIDER.get(), CaveSpiderEntity.createAttributes().build());
		event.put(ZOMBIE_HORSE.get(), ZombieHorseEntity.createAttributes().build());
		event.put(SKELETON_HORSE.get(), SkeletonHorseEntity.createAttributes().build());
		event.put(CAVE_SPIDER_UNIT.get(), CaveSpiderUnitEntity.createAttributes().build());
		event.put(STRAY_UNIT.get(), StrayUnitEntity.createAttributes().build());
		event.put(ZOMBIFIED_PIGLIN_UNIT.get(), ZombifiedPiglinUnitEntity.createAttributes().build());
		event.put(PIGLIN_UNIT.get(), PiglinUnitEntity.createAttributes().build());
		event.put(PUFFERFISH_UNIT.get(), PufferfishUnitEntity.createAttributes().build());
		event.put(IRON_GOLEM_UNIT.get(), IronGolemUnitEntity.createAttributes().build());
		event.put(WITCH_2.get(), Witch2Entity.createAttributes().build());
		event.put(ZOMBIE_VILLAGER_2.get(), ZombieVillager2Entity.createAttributes().build());
		event.put(PILLAGER_BOSS.get(), PillagerBossEntity.createAttributes().build());
		event.put(VEX.get(), VexEntity.createAttributes().build());
		event.put(PILLAGER.get(), PillagerEntity.createAttributes().build());
		event.put(VINDICATOR_BOSS.get(), VindicatorBossEntity.createAttributes().build());
		event.put(VINDICATOR.get(), VindicatorEntity.createAttributes().build());
		event.put(EVOKER_BOSS.get(), EvokerBossEntity.createAttributes().build());
		event.put(EVOKER.get(), EvokerEntity.createAttributes().build());
		event.put(RAVAGER_BOSS.get(), RavagerBossEntity.createAttributes().build());
		event.put(RAVAGER.get(), RavagerEntity.createAttributes().build());
		event.put(IRON_GOLEM_BOSS.get(), IronGolemBossEntity.createAttributes().build());
		event.put(ALLAY_BOSS.get(), AllayBossEntity.createAttributes().build());
		event.put(WARM_PIG.get(), WarmPigEntity.createAttributes().build());
		event.put(WARM_COW.get(), WarmCowEntity.createAttributes().build());
		event.put(WARM_CHICKEN.get(), WarmChickenEntity.createAttributes().build());
		event.put(CAMEL.get(), CamelEntity.createAttributes().build());
		event.put(DONKEY.get(), DonkeyEntity.createAttributes().build());
		event.put(HUSK.get(), HuskEntity.createAttributes().build());
		event.put(ARMADILLO.get(), ArmadilloEntity.createAttributes().build());
		event.put(DONKEY_BOSS.get(), DonkeyBossEntity.createAttributes().build());
		event.put(CAMEL_BOSS.get(), CamelBossEntity.createAttributes().build());
		event.put(ARMADILLO_BOSS.get(), ArmadilloBossEntity.createAttributes().build());
		event.put(HUSK_BOSS.get(), HuskBossEntity.createAttributes().build());
		event.put(PARCHED_BOSS.get(), ParchedBossEntity.createAttributes().build());
		event.put(HUSK_UNIT.get(), HuskUnitEntity.createAttributes().build());
		event.put(MAGMA_CUBE_UNIT.get(), MagmaCubeUnitEntity.createAttributes().build());
		event.put(POLAR_BEAR_UNIT.get(), PolarBearUnitEntity.createAttributes().build());
		event.put(SKELETON_UNIT.get(), SkeletonUnitEntity.createAttributes().build());
		event.put(SNOW_GOLEM_UNIT.get(), SnowGolemUnitEntity.createAttributes().build());
		event.put(TADPOLE.get(), TadpoleEntity.createAttributes().build());
		event.put(SALMON.get(), SalmonEntity.createAttributes().build());
		event.put(AXOLOTL.get(), AxolotlEntity.createAttributes().build());
		event.put(COD.get(), CodEntity.createAttributes().build());
		event.put(TURTLE.get(), TurtleEntity.createAttributes().build());
		event.put(PUFFERFISH.get(), PufferfishEntity.createAttributes().build());
		event.put(PUFFERFISH_BOSS.get(), PufferfishBossEntity.createAttributes().build());
		event.put(DOLPHIN_BOSS.get(), DolphinBossEntity.createAttributes().build());
		event.put(DROWNED_BOSS.get(), DrownedBossEntity.createAttributes().build());
		event.put(GUARDIAN_BOSS.get(), GuardianBossEntity.createAttributes().build());
		event.put(ELDER_GUARDIAN_BOSS.get(), ElderGuardianBossEntity.createAttributes().build());
		event.put(CHARGED_CREEPER_UNIT.get(), ChargedCreeperUnitEntity.createAttributes().build());
		event.put(RAVAGER_UNIT.get(), RavagerUnitEntity.createAttributes().build());
		event.put(AOE_SQUARE.get(), AoeSquareEntity.createAttributes().build());
		event.put(RANGE_SQUARE.get(), RangeSquareEntity.createAttributes().build());
		event.put(ENDERMAN_UNIT.get(), EndermanUnitEntity.createAttributes().build());
		event.put(BREEZE_UNIT.get(), BreezeUnitEntity.createAttributes().build());
		event.put(WOLF_UNIT.get(), WolfUnitEntity.createAttributes().build());
		event.put(PILLAGER_UNIT.get(), PillagerUnitEntity.createAttributes().build());
		event.put(BLAZE_UNIT.get(), BlazeUnitEntity.createAttributes().build());
		event.put(BOGGED_UNIT.get(), BoggedUnitEntity.createAttributes().build());
		event.put(NPC_MISSION_1.get(), NPCMission1Entity.createAttributes().build());
		event.put(DROWNED_UNIT.get(), DrownedUnitEntity.createAttributes().build());
		event.put(FROSTBITE_UNIT.get(), FrostbiteUnitEntity.createAttributes().build());
	}
}