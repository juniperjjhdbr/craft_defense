package net.juujks.craft_defense.client;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.juujks.craft_defense.init.CraftDefenseModEntities;
import net.juujks.craft_defense.client.renderer.*;
import net.juujks.craft_defense.CraftDefenseMod;

@EventBusSubscriber(modid = CraftDefenseMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class AnimatedEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(CraftDefenseModEntities.STEVE.get(), SteveRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ALEX.get(), AlexRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.CHICKEN.get(), ChickenRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ZOMBIE_UNIT.get(), ZombieUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.CREEPER_UNIT.get(), CreeperUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.COLD_CHICKEN.get(), ColdChickenRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.VILLAGER_UNIT.get(), VillagerUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.BAT.get(), BatRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ZOMBIFIED_PIGLIN_UNIT.get(), ZombifiedPiglinUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.PIGLIN_UNIT.get(), PiglinUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.PUFFERFISH_UNIT.get(), PufferfishUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.IRON_GOLEM_UNIT.get(), IronGolemUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.VEX.get(), VexRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.IRON_GOLEM_BOSS.get(), IronGolemBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ALLAY_BOSS.get(), AllayBossRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.WARM_CHICKEN.get(), WarmChickenRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.HUSK_UNIT.get(), HuskUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SKELETON_UNIT.get(), SkeletonUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.SNOW_GOLEM_UNIT.get(), SnowGolemUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.CHARGED_CREEPER_UNIT.get(), ChargedCreeperUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.ENDERMAN_UNIT.get(), EndermanUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.BREEZE_UNIT.get(), BreezeUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.WOLF_UNIT.get(), WolfUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.BLAZE_UNIT.get(), BlazeUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.DROWNED_UNIT.get(), DrownedUnitRenderer::new);
		event.registerEntityRenderer(CraftDefenseModEntities.FROSTBITE_UNIT.get(), FrostbiteUnitRenderer::new);
	}
}