package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModItems;

import java.util.ArrayList;

public class DropsForRaidProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (CraftDefenseModVariables.MapVariables.get(world).customMapId == 0) {
			CraftDefenseModVariables.MapVariables.get(world).commonDrops = Math.random();
			CraftDefenseModVariables.MapVariables.get(world).rareDrops = Math.random();
			CraftDefenseModVariables.MapVariables.get(world).candyAmount = Math.random();
			CraftDefenseModVariables.MapVariables.get(world).candyChance = Mth.nextInt(RandomSource.create(), 1, 2);
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (CraftDefenseModVariables.MapVariables.get(world).mission == 1 || CraftDefenseModVariables.MapVariables.get(world).act == 911) {
					CraftDefenseModVariables.MapVariables.get(world).commonAmount = CraftDefenseModVariables.MapVariables.get(world).act == 911
							? 20
							: CraftDefenseModVariables.MapVariables.get(world).act * 2 * CraftDefenseModVariables.MapVariables.get(world).dropMultiplier;
					CraftDefenseModVariables.MapVariables.get(world).rareAmount = 1;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
					if (entityiterator instanceof Player _player) {
						ItemStack _setstack = new ItemStack(CraftDefenseModItems.STAT_DICE.get()).copy();
						_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).commonAmount);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entityiterator instanceof Player _player) {
						ItemStack _setstack = new ItemStack(CraftDefenseModItems.DUPLICATION_TOKEN.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else {
					if (CraftDefenseModVariables.MapVariables.get(world).act <= 5) {
						CraftDefenseModVariables.MapVariables.get(world).commonAmount = CraftDefenseModVariables.MapVariables.get(world).act * 2;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						if (CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.25) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.PORKCHOP).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).commonAmount);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.25 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.5) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.MUTTON).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).commonAmount);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.5 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.75) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.CHICKEN).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).commonAmount);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.BEEF).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).commonAmount);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
						if (CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.2) {
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = CraftDefenseModVariables.MapVariables.get(world).act * 2;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.FEATHER).copy();
								_setstack.setCount((int) (CraftDefenseModVariables.MapVariables.get(world).act * 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).rareDrops > 0.2 && CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.4) {
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = CraftDefenseModVariables.MapVariables.get(world).act * 2;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Blocks.WHITE_WOOL).copy();
								_setstack.setCount((int) (CraftDefenseModVariables.MapVariables.get(world).act * 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.4 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.6) {
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = CraftDefenseModVariables.MapVariables.get(world).act * 2;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.LEATHER).copy();
								_setstack.setCount((int) (CraftDefenseModVariables.MapVariables.get(world).act * 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.6 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.8) {
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = Math.ceil(CraftDefenseModVariables.MapVariables.get(world).act / 2);
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.HONEY_BOTTLE).copy();
								_setstack.setCount((int) (Math.ceil(CraftDefenseModVariables.MapVariables.get(world).act / 2) + 1));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
						if (entityiterator instanceof Player _player) {
							ItemStack _setstack = new ItemStack(CraftDefenseModItems.COMMON_XP_CANDY.get()).copy();
							_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act > 5 && CraftDefenseModVariables.MapVariables.get(world).act <= 10) {
						if (CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.5) {
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = CraftDefenseModVariables.MapVariables.get(world).act * 2;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Blocks.SPRUCE_SAPLING).copy();
								_setstack.setCount((int) (CraftDefenseModVariables.MapVariables.get(world).act * 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else {
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = CraftDefenseModVariables.MapVariables.get(world).act;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.COAL).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).act);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
						if (CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.2) {
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = Math.ceil(CraftDefenseModVariables.MapVariables.get(world).act / 2);
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.RABBIT_FOOT).copy();
								_setstack.setCount((int) Math.ceil(CraftDefenseModVariables.MapVariables.get(world).act / 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).rareDrops > 0.2 && CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.4) {
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = 2;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.IRON_INGOT).copy();
								_setstack.setCount(2);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(CraftDefenseModItems.COMMON_XP_CANDY.get()).copy();
							_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act > 10 && CraftDefenseModVariables.MapVariables.get(world).act <= 15) {
						CraftDefenseModVariables.MapVariables.get(world).commonAmount = CraftDefenseModVariables.MapVariables.get(world).act * 2;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						if (CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.25) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.ROTTEN_FLESH).copy();
								_setstack.setCount((int) (CraftDefenseModVariables.MapVariables.get(world).act * 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.25 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.5) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.BONE).copy();
								_setstack.setCount((int) (CraftDefenseModVariables.MapVariables.get(world).act * 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.5 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.75) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.STRING).copy();
								_setstack.setCount((int) (CraftDefenseModVariables.MapVariables.get(world).act * 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.GUNPOWDER).copy();
								_setstack.setCount((int) (CraftDefenseModVariables.MapVariables.get(world).act * 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
						if (CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.2) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.IRON_INGOT).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).act);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = CraftDefenseModVariables.MapVariables.get(world).act;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).rareDrops > 0.2 && CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.3) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.GOLD_INGOT).copy();
								_setstack.setCount((int) Math.ceil(CraftDefenseModVariables.MapVariables.get(world).act / 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = Math.ceil(CraftDefenseModVariables.MapVariables.get(world).act / 2);
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.3 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.4) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.4 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.5) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.REDSTONE).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).act);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = CraftDefenseModVariables.MapVariables.get(world).act;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.5 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.7) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.LAPIS_LAZULI).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).act);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = CraftDefenseModVariables.MapVariables.get(world).act;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.COAL).copy();
								_setstack.setCount((int) (CraftDefenseModVariables.MapVariables.get(world).act * 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = CraftDefenseModVariables.MapVariables.get(world).act * 2;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
						if (CraftDefenseModVariables.MapVariables.get(world).candyAmount <= 0.7) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.COMMON_XP_CANDY.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.RARE_XP_CANDY.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act > 15 && CraftDefenseModVariables.MapVariables.get(world).act <= 20) {
						if (CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.25) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.EMERALD).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).act);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = CraftDefenseModVariables.MapVariables.get(world).act;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.25 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.5) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.WHEAT).copy();
								_setstack.setCount((int) (CraftDefenseModVariables.MapVariables.get(world).act * 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = CraftDefenseModVariables.MapVariables.get(world).act * 2;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.5 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.75) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.CARROT).copy();
								_setstack.setCount((int) (CraftDefenseModVariables.MapVariables.get(world).act * 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = CraftDefenseModVariables.MapVariables.get(world).act * 2;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.POTATO).copy();
								_setstack.setCount((int) (CraftDefenseModVariables.MapVariables.get(world).act * 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = CraftDefenseModVariables.MapVariables.get(world).act * 2;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
						if (CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.15) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
								_setstack.setCount(4);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = 4;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).rareDrops > 0.15 && CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.4) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Blocks.OBSIDIAN).copy();
								_setstack.setCount((int) Math.ceil(CraftDefenseModVariables.MapVariables.get(world).act / 3));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = Math.ceil(CraftDefenseModVariables.MapVariables.get(world).act / 3);
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.4 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.8) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.IRON_INGOT).copy();
								_setstack.setCount((int) Math.ceil(CraftDefenseModVariables.MapVariables.get(world).act / 2));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = Math.ceil(CraftDefenseModVariables.MapVariables.get(world).act / 2);
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.VILLAGER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
						if (CraftDefenseModVariables.MapVariables.get(world).candyAmount <= 0.7) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.COMMON_XP_CANDY.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.RARE_XP_CANDY.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act > 20 && CraftDefenseModVariables.MapVariables.get(world).act <= 25) {
						if (CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.25) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Blocks.CACTUS).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).act);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = CraftDefenseModVariables.MapVariables.get(world).act;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.25 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.5) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Blocks.DEAD_BUSH).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).act);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = CraftDefenseModVariables.MapVariables.get(world).act;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.5 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.75) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.SKELETON_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.COMMON_XP_CANDY.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
						if (CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.15) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
								_setstack.setCount(8);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = 8;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).rareDrops > 0.15 && CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.4) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.COMMON_XP_CANDY.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.4 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.8) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.IRON_INGOT).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).act);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = CraftDefenseModVariables.MapVariables.get(world).act;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.STRAY_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
						if (CraftDefenseModVariables.MapVariables.get(world).candyAmount <= 0.65) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.COMMON_XP_CANDY.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).candyAmount > 0.65 && CraftDefenseModVariables.MapVariables.get(world).candyAmount <= 0.95) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.RARE_XP_CANDY.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.EPIC_XP_CANDY.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act > 25 && CraftDefenseModVariables.MapVariables.get(world).act <= 30) {
						if (CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.25) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.PRISMARINE_SHARD).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).act);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = CraftDefenseModVariables.MapVariables.get(world).act;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.25 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.5) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.PRISMARINE_CRYSTALS).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).act);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = CraftDefenseModVariables.MapVariables.get(world).act;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.5 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.75) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Blocks.SPONGE).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.COMMON_XP_CANDY.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).commonAmount = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
						if (CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.15) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
								_setstack.setCount(8);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = 8;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).rareDrops > 0.15 && CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.4) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.COMMON_XP_CANDY.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else if (CraftDefenseModVariables.MapVariables.get(world).commonDrops > 0.4 && CraftDefenseModVariables.MapVariables.get(world).commonDrops <= 0.8) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.PUFFERFISH_UNIT_ITEM.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).act);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = CraftDefenseModVariables.MapVariables.get(world).act;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.VILLAGER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
						if (CraftDefenseModVariables.MapVariables.get(world).candyAmount <= 0.65) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.COMMON_XP_CANDY.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).candyAmount > 0.65 && CraftDefenseModVariables.MapVariables.get(world).candyAmount <= 0.95) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.RARE_XP_CANDY.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.EPIC_XP_CANDY.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
					}
					if (CraftDefenseModVariables.MapVariables.get(world).act == 901) {
						if (CraftDefenseModVariables.MapVariables.get(world).rareDrops <= 0.1 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.BREEZE_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.RARE_XP_CANDY.get()).copy();
								_setstack.setCount(3);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).rareAmount = 3;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
						if (CraftDefenseModVariables.MapVariables.get(world).candyAmount <= 0.65) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.COMMON_XP_CANDY.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (CraftDefenseModVariables.MapVariables.get(world).candyAmount > 0.65 && CraftDefenseModVariables.MapVariables.get(world).candyAmount <= 0.95) {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.RARE_XP_CANDY.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else {
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.EPIC_XP_CANDY.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).candyChance);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
					}
				}
			}
		}
	}
}