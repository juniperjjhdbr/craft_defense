package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;
import net.minecraft.ChatFormatting;

import net.juujks.craft_defense.init.CraftDefenseModItems;

public class UnitEvolverPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.AIR.asItem()) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 8).copy()).getItem() == CraftDefenseModItems.EVOLUTION_CRYSTAL.get()
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getItem() == CraftDefenseModItems.MYTHIC_UPGRADE.get()) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == CraftDefenseModItems.BREEZE_UNIT_ITEM.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() >= 1
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Items.BLAZE_ROD && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() >= 4
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == Items.FIRE_CHARGE && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() >= 2
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == CraftDefenseModItems.LEGENDARY_DUST.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() >= 2) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(CraftDefenseModItems.BLAZE_UNIT_ITEM.get()).copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(0, _setstack);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 8;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 1;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 2;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(4);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 3;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(2);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 4;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(2);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.challenge_complete")), SoundSource.NEUTRAL, 9999, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.challenge_complete")), SoundSource.NEUTRAL, 9999, 1, false);
						}
					}
					if (entity instanceof Player _player)
						_player.closeContainer();
					if (world.isClientSide())
						Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(CraftDefenseModItems.BLAZE_UNIT_ITEM.get()));
					if (world instanceof ServerLevel _level) {
						_level.getServer().getPlayerList()
								.broadcastSystemMessage(Component.literal((entity.getDisplayName().getString() + " just crafted an " + new ItemStack(CraftDefenseModItems.BLAZE_UNIT_ITEM.get()).getDisplayName().getString() + "!")), false);
					}
				}
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == CraftDefenseModItems.ZOMBIE_UNIT_ITEM.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() >= 1
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Blocks.BLUE_ICE.asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() >= 4
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == Items.POWDER_SNOW_BUCKET && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() >= 1
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == CraftDefenseModItems.LEGENDARY_DUST.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() >= 2) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(CraftDefenseModItems.FROSTBITE_UNIT_ITEM.get()).copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(0, _setstack);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 8;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 1;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 2;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(4);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 3;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(2);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 4;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(2);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.challenge_complete")), SoundSource.NEUTRAL, 9999, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.toast.challenge_complete")), SoundSource.NEUTRAL, 9999, 1, false);
						}
					}
					if (entity instanceof Player _player)
						_player.closeContainer();
					if (world.isClientSide())
						Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(CraftDefenseModItems.FROSTBITE_UNIT_ITEM.get()));
					if (world instanceof ServerLevel _level) {
						_level.getServer().getPlayerList().broadcastSystemMessage(
								Component.literal((entity.getDisplayName().getString() + " just crafted an " + new ItemStack(CraftDefenseModItems.FROSTBITE_UNIT_ITEM.get()).getDisplayName().getString() + "!")).withStyle(ChatFormatting.BOLD), false);
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