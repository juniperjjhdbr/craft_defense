/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.juujks.craft_defense.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.juujks.craft_defense.CraftDefenseMod;

public class CraftDefenseModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, CraftDefenseMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LEVEL_UP_PARTICLE = REGISTRY.register("level_up_particle", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SNOW_FLAKE = REGISTRY.register("snow_flake", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SNOW_FLAKE_2 = REGISTRY.register("snow_flake_2", () -> new SimpleParticleType(false));
}