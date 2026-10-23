/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.juujks.craft_defense.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.juujks.craft_defense.client.renderer.*;

@EventBusSubscriber(Dist.CLIENT)
public class CraftDefenseModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(CraftDefenseModEntities.PIG.get(), PigRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ZOMBIE.get(), ZombieRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.COW.get(), CowRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SHEEP.get(), SheepRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.HORSE.get(), HorseRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SKELETON.get(), SkeletonRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SPIDER.get(), SpiderRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.CREEPER.get(), CreeperRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SLIME.get(), SlimeRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SPIDER_UNIT.get(), SpiderUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.WITCH_UNIT.get(), WitchUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SLIME_UNIT.get(), SlimeUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.COLD_PIG.get(), ColdPigRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.COLD_COW.get(), ColdCowRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.RABBIT.get(), RabbitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.GOAT.get(), GoatRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.LLAMA_BOSS.get(), LlamaRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SNOW_FOX.get(), SnowFoxRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.STRAY.get(), StrayRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.POLAR_BEAR.get(), PolarBearRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SNOW_GOLEM.get(), SnowGolemRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.LLAMA_B.get(), LlamaBRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ENEMY.get(), EnemyRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ENEMY_POWERFUL.get(), EnemyPowerfulRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ENEMY_AERIAL.get(), EnemyAerialRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ENEMY_POWERFUL_2.get(), EnemyPowerful2Renderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ENEMY_POWERFUL_3.get(), EnemyPowerful3Renderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ENEMY_FAST.get(), EnemyFastRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ENEMY_TANK.get(), EnemyTankRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ENEMY_REGENERATOR.get(), EnemyRegeneratorRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ZOMBIE_ENEMY.get(), ZombieEnemyRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SKELETON_ENEMY.get(), SkeletonEnemyRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SPIDER_ENEMY.get(), SpiderEnemyRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.CREEPER_ENEMY.get(), CreeperEnemyRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.WITCH.get(), WitchRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SLIME_ENEMY.get(), SlimeEnemyRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SLIME_CLONED.get(), SlimeClonedRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ZOMBIE_VILLAGER.get(), ZombieVillagerRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.CAVE_SPIDER.get(), CaveSpiderRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ZOMBIE_HORSE.get(), ZombieHorseRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SKELETON_HORSE.get(), SkeletonHorseRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.CAVE_SPIDER_UNIT.get(), CaveSpiderUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.STRAY_UNIT.get(), StrayUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.WITCH_2.get(), Witch2Renderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ZOMBIE_VILLAGER_2.get(), ZombieVillager2Renderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.PILLAGER_BOSS.get(), PillagerBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.PILLAGER.get(), PillagerRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.VINDICATOR_BOSS.get(), VindicatorBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.VINDICATOR.get(), VindicatorRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.EVOKER_BOSS.get(), EvokerBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.EVOKER.get(), EvokerRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.RAVAGER_BOSS.get(), RavagerBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.RAVAGER.get(), RavagerRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.WARM_PIG.get(), WarmPigRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.WARM_COW.get(), WarmCowRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.CAMEL.get(), CamelRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.DONKEY.get(), DonkeyRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.HUSK.get(), HuskRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ARMADILLO.get(), ArmadilloRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.DONKEY_BOSS.get(), DonkeyBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.CAMEL_BOSS.get(), CamelBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ARMADILLO_BOSS.get(), ArmadilloBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.HUSK_BOSS.get(), HuskBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.PARCHED_BOSS.get(), ParchedBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.MAGMA_CUBE_UNIT.get(), MagmaCubeUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.POLAR_BEAR_UNIT.get(), PolarBearUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.TADPOLE.get(), TadpoleRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SALMON.get(), SalmonRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.AXOLOTL.get(), AxolotlRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.COD.get(), CodRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.TURTLE.get(), TurtleRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.PUFFERFISH.get(), PufferfishRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.PUFFERFISH_BOSS.get(), PufferfishBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.DOLPHIN_BOSS.get(), DolphinBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.DROWNED_BOSS.get(), DrownedBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.GUARDIAN_BOSS.get(), GuardianBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ELDER_GUARDIAN_BOSS.get(), ElderGuardianBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.RAVAGER_UNIT.get(), RavagerUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.AOE_SQUARE.get(), AoeSquareRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.RANGE_SQUARE.get(), RangeSquareRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.PILLAGER_UNIT.get(), PillagerUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.BLAZE_UNIT_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.BOGGED_UNIT.get(), BoggedUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ARROW_PROJECTILE.get(), ArrowProjectileRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.NPC_MISSION_1.get(), NPCMission1Renderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.WIND_CHARGE_PROJECTILE.get(), WindChargeProjectileRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SNOWBALL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.TRIDENT_PROJECTILE.get(), TridentProjectileRenderer::new);
	}
}