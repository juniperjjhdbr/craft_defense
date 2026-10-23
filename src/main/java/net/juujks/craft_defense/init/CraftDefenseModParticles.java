/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.juujks.craft_defense.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.juujks.craft_defense.client.particle.SnowFlakeParticle;
import net.juujks.craft_defense.client.particle.SnowFlake2Particle;
import net.juujks.craft_defense.client.particle.LevelUpParticleParticle;

@EventBusSubscriber(Dist.CLIENT)
public class CraftDefenseModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(CraftDefenseModParticleTypes.LEVEL_UP_PARTICLE.get(), LevelUpParticleParticle::provider);
		event.registerSpriteSet(CraftDefenseModParticleTypes.SNOW_FLAKE.get(), SnowFlakeParticle::provider);
		event.registerSpriteSet(CraftDefenseModParticleTypes.SNOW_FLAKE_2.get(), SnowFlake2Particle::provider);
	}
}