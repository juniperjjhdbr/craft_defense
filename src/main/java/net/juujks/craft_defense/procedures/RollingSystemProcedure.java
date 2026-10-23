package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModMenus;
import net.juujks.craft_defense.init.CraftDefenseModItems;

public class RollingSystemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double gems = 0;
		double unitChance = 0;
		double rareChance = 0;
		double currentTick = 0;
		double epicChance = 0;
		double legendaryChance = 0;
		boolean isRunning = false;
		boolean canRoll = false;
		if (!world.isClientSide()) {
			unitChance = Math.random();
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
					if (CraftDefenseModItems.TOWER_GEM.get() == itemstackiterator.getItem()) {
						gems = gems + itemstackiterator.getCount();
					}
				}
			}
		}
		if (gems >= 2) {
			canRoll = true;
		} else {
			canRoll = false;
		}
		if (canRoll) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 3) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.quest2Number1 = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number1 + 1;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 3) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.quest2Number3 = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number3 + 1;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 3) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.quest2Number6 = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number6 + 1;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 3) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.quest2Number24 = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number24 + 1;
					_vars.markSyncDirty();
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == CraftDefenseModItems.DUPLICATION_TOKEN.get()) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("craft_defense:units")))
						&& !(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("craft_defense:units/mythic")))) {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("craft_defense:units/rare")))) {
						if (gems >= 3) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(CraftDefenseModItems.TOWER_GEM.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 3, _player.inventoryMenu.getCraftSlots());
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								int _slotid = 1;
								ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
								_stk.shrink(1);
								_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
							}
							{
								final String _tagName = "itemUUID";
								final String _tagValue = (new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 99999999)));
								CustomData.update(DataComponents.CUSTOM_DATA,
										(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(0).getItem() : ItemStack.EMPTY),
										tag -> tag.putString(_tagName, _tagValue));
							}
						}
					}
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("craft_defense:units/epic")))) {
						if (gems >= 4) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(CraftDefenseModItems.TOWER_GEM.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 4, _player.inventoryMenu.getCraftSlots());
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								int _slotid = 1;
								ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
								_stk.shrink(1);
								_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
							}
							{
								final String _tagName = "itemUUID";
								final String _tagValue = (new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 99999999)));
								CustomData.update(DataComponents.CUSTOM_DATA,
										(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(0).getItem() : ItemStack.EMPTY),
										tag -> tag.putString(_tagName, _tagValue));
							}
						}
					}
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("craft_defense:units/legendary")))) {
						if (gems >= 5) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(CraftDefenseModItems.TOWER_GEM.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 5, _player.inventoryMenu.getCraftSlots());
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								int _slotid = 1;
								ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
								_stk.shrink(1);
								_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
							}
							{
								final String _tagName = "itemUUID";
								final String _tagValue = (new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 99999999)));
								CustomData.update(DataComponents.CUSTOM_DATA,
										(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(0).getItem() : ItemStack.EMPTY),
										tag -> tag.putString(_tagName, _tagValue));
							}
						}
					}
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("craft_defense:units/common")))) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(CraftDefenseModItems.TOWER_GEM.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 2, _player.inventoryMenu.getCraftSlots());
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.totem.use")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 1;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
						{
							final String _tagName = "itemUUID";
							final String _tagValue = (new java.text.DecimalFormat("##").format(Mth.nextInt(RandomSource.create(), 1, 99999999)));
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					}
				}
			} else {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(CraftDefenseModItems.TOWER_GEM.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 2, _player.inventoryMenu.getCraftSlots());
				}
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == CraftDefenseModItems.EPIC_UPGRADE.get()) {
					if (unitChance < 0.2 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						epicChance = Mth.nextInt(RandomSource.create(), 1, 10);
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledRarity = "Epic";
							_vars.markSyncDirty();
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 0);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 0, false);
							}
						}
						if (epicChance == 1) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Villager";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.VILLAGER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 2) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Cave Spider";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.CAVE_SPIDER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 3) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Stray";
								_vars.lastUnitType = "Aerial";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.STRAY_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 4) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Zombified Piglin";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.ZOMBIFIED_PIGLIN_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 5) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Piglin";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.PIGLIN_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 6) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Pufferfish";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.PUFFERFISH_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 7) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Husk";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.HUSK_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 8) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.MAGMA_CUBE_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Magma Cube";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
						} else if (epicChance == 9) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.ENDERMAN_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Enderman";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
						} else if (epicChance == 10) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.PILLAGER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Pillager";
								_vars.lastUnitType = "Aerial";
								_vars.markSyncDirty();
							}
						}
					} else {
						rareChance = Mth.nextInt(RandomSource.create(), 1, 7);
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledRarity = "Rare";
							_vars.markSyncDirty();
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (rareChance == 1) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Zombie";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.ZOMBIE_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (rareChance == 2) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Skeleton";
								_vars.lastUnitType = "Aerial";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.SKELETON_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (rareChance == 3) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Creeper";
								_vars.lastUnitType = "Hybrid";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.CREEPER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (rareChance == 4) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Spider";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.SPIDER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (rareChance == 5) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Witch";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.WITCH_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (rareChance == 6) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Slime";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.SLIME_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (rareChance == 7) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Wolf";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.WOLF_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
					}
				} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == CraftDefenseModItems.LEGENDARY_UPGRADE.get()
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == CraftDefenseModItems.MYTHIC_UPGRADE.get()) {
					if (unitChance <= 0.05 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance || entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).legendary_pity == 25) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.legendary_pity = 0;
							_vars.markSyncDirty();
						}
						legendaryChance = Mth.nextInt(RandomSource.create(), 1, 7);
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledRarity = "Legendary";
							_vars.markSyncDirty();
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.challenge_complete")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.challenge_complete")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (legendaryChance == 1) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Iron Golem";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.IRON_GOLEM_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (legendaryChance == 2) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Snow Golem";
								_vars.lastUnitType = "Aerial";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.SNOW_GOLEM_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (legendaryChance == 3) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Polar Bear";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.POLAR_BEAR_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (legendaryChance == 4) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Charged Creeper";
								_vars.lastUnitType = "Hybrid";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.CHARGED_CREEPER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (legendaryChance == 5) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Ravager";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.RAVAGER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (legendaryChance == 6) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Bogged";
								_vars.lastUnitType = "Aerial";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.BOGGED_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (legendaryChance == 7) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Drowned";
								_vars.lastUnitType = "Hybrid";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.DROWNED_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
					} else if (unitChance > 0.05 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance && unitChance <= 0.25 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.legendary_pity = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).legendary_pity + 1;
							_vars.markSyncDirty();
						}
						epicChance = Mth.nextInt(RandomSource.create(), 1, 10);
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledRarity = "Epic";
							_vars.markSyncDirty();
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 0);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 0, false);
							}
						}
						if (epicChance == 1) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Villager";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.VILLAGER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 2) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Cave Spider";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.CAVE_SPIDER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 3) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Stray";
								_vars.lastUnitType = "Aerial";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.STRAY_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 4) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Zombified Piglin";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.ZOMBIFIED_PIGLIN_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 5) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Piglin";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.PIGLIN_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 6) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Pufferfish";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.PUFFERFISH_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 7) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Husk";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.HUSK_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (epicChance == 8) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.MAGMA_CUBE_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Magma Cube";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
						} else if (epicChance == 9) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.ENDERMAN_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Enderman";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
						} else if (epicChance == 10) {
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.PILLAGER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Pillager";
								_vars.lastUnitType = "Aerial";
								_vars.markSyncDirty();
							}
						}
					} else {
						rareChance = Mth.nextInt(RandomSource.create(), 1, 7);
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.legendary_pity = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).legendary_pity + 1;
							_vars.lastRolledRarity = "Rare";
							_vars.markSyncDirty();
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (rareChance == 1) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Zombie";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.ZOMBIE_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (rareChance == 2) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Skeleton";
								_vars.lastUnitType = "Aerial";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.SKELETON_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (rareChance == 3) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Creeper";
								_vars.lastUnitType = "Hybrid";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.CREEPER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (rareChance == 4) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Spider";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.SPIDER_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (rareChance == 5) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Witch";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.WITCH_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (rareChance == 6) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Slime";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.SLIME_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						} else if (rareChance == 7) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.lastRolledUnit = "Wolf";
								_vars.lastUnitType = "Ground";
								_vars.markSyncDirty();
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.WOLF_UNIT_ITEM.get()).copy();
								_setstack.setCount(1);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
						}
					}
				} else {
					rareChance = Mth.nextInt(RandomSource.create(), 1, 7);
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.lastRolledRarity = "Rare";
						_vars.markSyncDirty();
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (rareChance == 1) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledUnit = "Zombie";
							_vars.lastUnitType = "Ground";
							_vars.markSyncDirty();
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(CraftDefenseModItems.ZOMBIE_UNIT_ITEM.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else if (rareChance == 2) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledUnit = "Skeleton";
							_vars.lastUnitType = "Aerial";
							_vars.markSyncDirty();
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(CraftDefenseModItems.SKELETON_UNIT_ITEM.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else if (rareChance == 3) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledUnit = "Creeper";
							_vars.lastUnitType = "Hybrid";
							_vars.markSyncDirty();
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(CraftDefenseModItems.CREEPER_UNIT_ITEM.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else if (rareChance == 4) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledUnit = "Spider";
							_vars.lastUnitType = "Ground";
							_vars.markSyncDirty();
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(CraftDefenseModItems.SPIDER_UNIT_ITEM.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else if (rareChance == 5) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledUnit = "Witch";
							_vars.lastUnitType = "Ground";
							_vars.markSyncDirty();
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(CraftDefenseModItems.WITCH_UNIT_ITEM.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else if (rareChance == 6) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledUnit = "Slime";
							_vars.lastUnitType = "Ground";
							_vars.markSyncDirty();
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(CraftDefenseModItems.SLIME_UNIT_ITEM.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					} else if (rareChance == 7) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledUnit = "Wolf";
							_vars.lastUnitType = "Ground";
							_vars.markSyncDirty();
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(CraftDefenseModItems.WOLF_UNIT_ITEM.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				}
			}
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}