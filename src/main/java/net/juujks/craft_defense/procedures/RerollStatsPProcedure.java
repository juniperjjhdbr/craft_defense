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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModMenus;
import net.juujks.craft_defense.init.CraftDefenseModItems;

public class RerollStatsPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double statsChance = 0;
		double dmgChance = 0;
		double rngChance = 0;
		double spaChance = 0;
		double dices = 0;
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).dmgLock && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).rngLock && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).spaLock) {
			dices = 0;
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).dmgLock && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).rngLock
				|| entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).dmgLock && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).spaLock
				|| entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).rngLock && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).spaLock) {
			dices = 3;
		} else if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).dmgLock || entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).rngLock || entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).spaLock) {
			dices = 2;
		} else {
			dices = 1;
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == CraftDefenseModItems.STAT_DICE.get()) {
			if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() >= dices) {
				dmgChance = Math.random();
				rngChance = Math.random();
				spaChance = Math.random();
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bit master @s ~ ~ ~ 1 1");
					}
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = 2;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink((int) dices);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				if (!entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).dmgLock) {
					if (dmgChance <= 0.05 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						{
							final String _tagName = "statsDBuff";
							final double _tagValue = 0.15;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameDBuff";
							final String _tagValue = "\u00A7bS";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					} else if (dmgChance > 0.05 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance && dmgChance <= 0.15 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						{
							final String _tagName = "statsDBuff";
							final double _tagValue = 0.1;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameDBuff";
							final String _tagValue = "\u00A7aA";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					} else if (dmgChance > 0.15 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance && dmgChance <= 0.35 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						{
							final String _tagName = "statsDBuff";
							final double _tagValue = 0.075;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameDBuff";
							final String _tagValue = "\u00A7eB";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					} else if (dmgChance > 0.35 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance && dmgChance <= 0.65 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						{
							final String _tagName = "statsDBuff";
							final double _tagValue = 0.05;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameDBuff";
							final String _tagValue = "\u00A76C";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					} else {
						{
							final String _tagName = "statsDBuff";
							final double _tagValue = 0.025;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameDBuff";
							final String _tagValue = "\u00A7cD";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					}
				}
				if (!entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).rngLock) {
					if (rngChance <= 0.05 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						{
							final String _tagName = "statsRBuff";
							final double _tagValue = 0.15;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu25 ? _menu25.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameRBuff";
							final String _tagValue = "\u00A7bS";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					} else if (rngChance > 0.05 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance && rngChance <= 0.15 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						{
							final String _tagName = "statsRBuff";
							final double _tagValue = 0.1;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameRBuff";
							final String _tagValue = "\u00A7aA";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu31 ? _menu31.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					} else if (rngChance > 0.15 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance && rngChance <= 0.35 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						{
							final String _tagName = "statsRBuff";
							final double _tagValue = 0.075;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu33 ? _menu33.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameRBuff";
							final String _tagValue = "\u00A7eB";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu35 ? _menu35.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					} else if (rngChance > 0.35 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance && rngChance <= 0.65 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						{
							final String _tagName = "statsRBuff";
							final double _tagValue = 0.05;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu37 ? _menu37.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameRBuff";
							final String _tagValue = "\u00A76C";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu39 ? _menu39.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					} else {
						{
							final String _tagName = "statsRBuff";
							final double _tagValue = 0.025;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu41 ? _menu41.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameRBuff";
							final String _tagValue = "\u00A7cD";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu43 ? _menu43.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					}
				}
				if (!entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).spaLock) {
					if (spaChance <= 0.05 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						{
							final String _tagName = "statsSBuff";
							final double _tagValue = 0.15;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameSBuff";
							final String _tagValue = "\u00A7bS";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu47 ? _menu47.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					} else if (spaChance > 0.05 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance && spaChance <= 0.15 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						{
							final String _tagName = "statsSBuff";
							final double _tagValue = 0.1;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu49 ? _menu49.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameSBuff";
							final String _tagValue = "\u00A7aA";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu51 ? _menu51.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					} else if (spaChance > 0.15 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance && spaChance <= 0.35 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						{
							final String _tagName = "statsSBuff";
							final double _tagValue = 0.075;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu53 ? _menu53.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameSBuff";
							final String _tagValue = "\u00A7eB";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu55 ? _menu55.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					} else if (spaChance > 0.35 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance && spaChance <= 0.65 * entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).additionalChance) {
						{
							final String _tagName = "statsSBuff";
							final double _tagValue = 0.05;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameSBuff";
							final String _tagValue = "\u00A76C";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu59 ? _menu59.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
						}
					} else {
						{
							final String _tagName = "statsSBuff";
							final double _tagValue = 0.025;
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu61 ? _menu61.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "statsNameSBuff";
							final String _tagValue = "\u00A7cD";
							CustomData.update(DataComponents.CUSTOM_DATA,
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof CraftDefenseModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get(0).getItem() : ItemStack.EMPTY),
									tag -> tag.putString(_tagName, _tagValue));
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