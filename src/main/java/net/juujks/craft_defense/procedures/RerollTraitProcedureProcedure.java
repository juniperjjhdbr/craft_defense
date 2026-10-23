package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModMenus;
import net.juujks.craft_defense.init.CraftDefenseModItems;

public class RerollTraitProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rarityChance = 0;
		double rareChance = 0;
		double commonChance = 0;
		double epicChance = 0;
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level") > 0) {
			RerollStatsPProcedure.execute(world, x, y, z, entity);
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == CraftDefenseModItems.TRAIT_CUBE.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() >= 1) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 1;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				rarityChance = Math.random();
				if (rarityChance <= 0.05 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
					epicChance = Mth.nextInt(RandomSource.create(), 1, 3);
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.lastRolledTraitRarity = "Epic";
						_vars.markSyncDirty();
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bell master @s ~ ~ ~ 1 0");
						}
					}
					if (epicChance == 1) {
						{
							final String _tagName = "trait";
							final String _tagValue = "warrior";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A74Warrior";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7l\u00A79Warrior";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0.25;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					} else if (epicChance == 2) {
						{
							final String _tagName = "trait";
							final String _tagValue = "wizard";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A71Wizard";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7l\u00A71Wizard";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu22 ? _menu22.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0.4;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					} else if (epicChance == 3) {
						{
							final String _tagName = "trait";
							final String _tagValue = "thunderman";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A72Thunderman";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7l\u00A72Thunderman";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu32 ? _menu32.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu34 ? _menu34.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0.3;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu36 ? _menu36.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
				} else if (rarityChance > 0.05 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance && rarityChance <= 0.35 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
					rareChance = Mth.nextInt(RandomSource.create(), 1, 3);
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.lastRolledTraitRarity = "Rare";
						_vars.markSyncDirty();
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bell master @s ~ ~ ~ 1 1");
						}
					}
					if (rareChance == 1) {
						{
							final String _tagName = "trait";
							final String _tagValue = "swordsman";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu40 ? _menu40.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A76Swordsman";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu42 ? _menu42.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7l\u00A7Swordsman";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0.15;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = (-0.3);
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu46 ? _menu46.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0.075;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					} else if (rareChance == 2) {
						{
							final String _tagName = "trait";
							final String _tagValue = "archer";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A79Archer";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu52 ? _menu52.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7l\u00A79Archer";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0.075;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu54 ? _menu54.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0.4;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu56 ? _menu56.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = (-0.2);
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu58 ? _menu58.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					} else if (rareChance == 3) {
						{
							final String _tagName = "trait";
							final String _tagValue = "sprinter";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu60 ? _menu60.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A7aSprinter";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu62 ? _menu62.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7l\u00A7aSprinter";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = (-0.1);
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0.1;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu66 ? _menu66.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0.15;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
				} else {
					commonChance = Mth.nextInt(RandomSource.create(), 1, 9);
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.lastRolledTraitRarity = "Common";
						_vars.markSyncDirty();
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bell master @s ~ ~ ~ 1 2");
						}
					}
					if (commonChance == 1) {
						{
							final String _tagName = "trait";
							final String _tagValue = "combat1";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu72 ? _menu72.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A7cCombat I";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu74 ? _menu74.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7c\u00A7lCombat I";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0.025;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu76 ? _menu76.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu78 ? _menu78.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu80 ? _menu80.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					} else if (commonChance == 2) {
						{
							final String _tagName = "trait";
							final String _tagValue = "combat2";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu82 ? _menu82.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A7cCombat II";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu84 ? _menu84.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7c\u00A7lCombat II";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0.05;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu86 ? _menu86.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu88 ? _menu88.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu90 ? _menu90.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					} else if (commonChance == 3) {
						{
							final String _tagName = "trait";
							final String _tagValue = "combat3";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu92 ? _menu92.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A7cCombat III";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu94 ? _menu94.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7c\u00A7lCombat III";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0.1;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu96 ? _menu96.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu98 ? _menu98.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu100 ? _menu100.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					} else if (commonChance == 4) {
						{
							final String _tagName = "trait";
							final String _tagValue = "agility1";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu102 ? _menu102.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A7bAgility I";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu104 ? _menu104.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7b\u00A7lAgility I";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu106 ? _menu106.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu108 ? _menu108.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0.025;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu110 ? _menu110.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					} else if (commonChance == 5) {
						{
							final String _tagName = "trait";
							final String _tagValue = "agility2";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu112 ? _menu112.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A7bAgility II";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu114 ? _menu114.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7b\u00A7lAgility II";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu116 ? _menu116.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu118 ? _menu118.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0.05;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu120 ? _menu120.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					} else if (commonChance == 6) {
						{
							final String _tagName = "trait";
							final String _tagValue = "agility3";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu122 ? _menu122.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A7bAgility III";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu124 ? _menu124.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7b\u00A7lAgility III";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu126 ? _menu126.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu128 ? _menu128.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0.1;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu130 ? _menu130.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					} else if (commonChance == 7) {
						{
							final String _tagName = "trait";
							final String _tagValue = "perception1";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu132 ? _menu132.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A7ePerception I";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu134 ? _menu134.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7e\u00A7lPerception I";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu136 ? _menu136.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0.05;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu138 ? _menu138.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu140 ? _menu140.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					} else if (commonChance == 8) {
						{
							final String _tagName = "trait";
							final String _tagValue = "perception2";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu142 ? _menu142.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A7ePerception II";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu144 ? _menu144.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7e\u00A7lPerception II";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu146 ? _menu146.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0.1;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu148 ? _menu148.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu150 ? _menu150.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
					} else if (commonChance == 9) {
						{
							final String _tagName = "traitText";
							final String _tagValue = "\u00A7l\u00A7ePerception III";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu152 ? _menu152.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							final String _tagName = "trait";
							final String _tagValue = "perception3";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu154 ? _menu154.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.lastRolledTrait = "\u00A7e\u00A7lPerception III";
							_vars.markSyncDirty();
						}
						{
							final String _tagName = "damageBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu156 ? _menu156.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "rangeBuff";
							final double _tagValue = 0.15;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu158 ? _menu158.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "spaBuff";
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu160 ? _menu160.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
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