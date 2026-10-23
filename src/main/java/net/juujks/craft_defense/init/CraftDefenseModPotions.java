/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.juujks.craft_defense.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.juujks.craft_defense.CraftDefenseMod;

public class CraftDefenseModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, CraftDefenseMod.MODID);
	public static final DeferredHolder<Potion, Potion> TOWER_LUCK_POTION = REGISTRY.register("tower_luck_potion", () -> new Potion(new MobEffectInstance(CraftDefenseModMobEffects.TOWER_LUCK, 3600, 1, false, true)));
}