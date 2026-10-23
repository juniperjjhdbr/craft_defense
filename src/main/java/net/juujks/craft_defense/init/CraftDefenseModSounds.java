/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.juujks.craft_defense.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.juujks.craft_defense.CraftDefenseMod;

public class CraftDefenseModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, CraftDefenseMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> ENTITY_FROSTBITE_AMBIENT = REGISTRY.register("entity.frostbite.ambient",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("craft_defense", "entity.frostbite.ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_BOUNCE = REGISTRY.register("music_disc.bounce", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("craft_defense", "music_disc.bounce")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_TEARS = REGISTRY.register("music_disc.tears", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("craft_defense", "music_disc.tears")));
}