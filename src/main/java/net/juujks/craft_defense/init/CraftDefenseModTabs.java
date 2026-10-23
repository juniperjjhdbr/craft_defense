/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.juujks.craft_defense.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.juujks.craft_defense.CraftDefenseMod;

public class CraftDefenseModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CraftDefenseMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CRAFT_DEFENSE = REGISTRY.register("craft_defense",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.craft_defense.craft_defense")).icon(() -> new ItemStack(CraftDefenseModItems.TOWER_GEM.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CraftDefenseModItems.TOWER_GEM.get());
				tabData.accept(CraftDefenseModItems.TRAIT_CUBE.get());
				tabData.accept(CraftDefenseModItems.EVOLUTION_CRYSTAL.get());
				tabData.accept(CraftDefenseModItems.DUPLICATION_TOKEN.get());
				tabData.accept(CraftDefenseModItems.STAT_DICE.get());
				tabData.accept(CraftDefenseModItems.COMMON_XP_CANDY.get());
				tabData.accept(CraftDefenseModItems.RARE_XP_CANDY.get());
				tabData.accept(CraftDefenseModItems.EPIC_XP_CANDY.get());
				tabData.accept(CraftDefenseModItems.LEGENDARY_XP_CANDY.get());
				tabData.accept(CraftDefenseModBlocks.RAID_MANAGER.get().asItem());
				tabData.accept(CraftDefenseModBlocks.UNIT_MACHINE.get().asItem());
				tabData.accept(CraftDefenseModBlocks.TRAIT_REROLLER.get().asItem());
				tabData.accept(CraftDefenseModBlocks.UNIT_EVOLVER.get().asItem());
				tabData.accept(CraftDefenseModBlocks.UNIT_INCUBATOR.get().asItem());
				tabData.accept(CraftDefenseModBlocks.UNIT_RECYCLER.get().asItem());
				tabData.accept(CraftDefenseModItems.STEVE_UNIT.get());
				tabData.accept(CraftDefenseModItems.ALEX_UNIT.get());
				tabData.accept(CraftDefenseModItems.ZOMBIE_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.SKELETON_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.CREEPER_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.SPIDER_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.WITCH_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.SLIME_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.WOLF_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.CAVE_SPIDER_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.STRAY_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.ZOMBIFIED_PIGLIN_ITEM.get());
				tabData.accept(CraftDefenseModItems.VILLAGER_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.PIGLIN_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.PUFFERFISH_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.HUSK_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.MAGMA_CUBE_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.ENDERMAN_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.PILLAGER_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.IRON_GOLEM_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.SNOW_GOLEM_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.POLAR_BEAR_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.CHARGED_CREEPER_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.RAVAGER_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.BREEZE_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.BOGGED_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.DROWNED_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.BLAZE_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModItems.FROSTBITE_UNIT_ITEM.get());
				tabData.accept(CraftDefenseModBlocks.FIRST_WORLD_TROPHY.get().asItem());
				tabData.accept(CraftDefenseModBlocks.SECOND_WORLD_TROPHY.get().asItem());
				tabData.accept(CraftDefenseModBlocks.THIRD_WORLD_TROPHY.get().asItem());
				tabData.accept(CraftDefenseModBlocks.FOURTH_WORLD_TROPHY.get().asItem());
				tabData.accept(CraftDefenseModBlocks.FIFTH_WORLD_TROPHY.get().asItem());
				tabData.accept(CraftDefenseModBlocks.SIXTH_WORLD_TROPHY.get().asItem());
				tabData.accept(CraftDefenseModItems.RARE_UPGRADE.get());
				tabData.accept(CraftDefenseModItems.EPIC_UPGRADE.get());
				tabData.accept(CraftDefenseModItems.LEGENDARY_UPGRADE.get());
				tabData.accept(CraftDefenseModItems.MYTHIC_UPGRADE.get());
				tabData.accept(CraftDefenseModItems.COMMON_DUST.get());
				tabData.accept(CraftDefenseModItems.RARE_DUST.get());
				tabData.accept(CraftDefenseModItems.EPIC_DUST.get());
				tabData.accept(CraftDefenseModItems.LEGENDARY_DUST.get());
				tabData.accept(CraftDefenseModItems.MYTHIC_DUST.get());
				tabData.accept(CraftDefenseModBlocks.PATH_BLOCK_WAY.get().asItem());
				tabData.accept(CraftDefenseModBlocks.PATH_BLOCK_LEFT_CURVE.get().asItem());
				tabData.accept(CraftDefenseModBlocks.PATH_BLOCK_RIGHT_CURVE.get().asItem());
				tabData.accept(CraftDefenseModBlocks.START_TOWER.get().asItem());
				tabData.accept(CraftDefenseModBlocks.END_TOWER.get().asItem());
				tabData.accept(CraftDefenseModBlocks.BLUE_PORTAL.get().asItem());
				tabData.accept(CraftDefenseModBlocks.ORANGE_PORTAL.get().asItem());
			}).build());
}