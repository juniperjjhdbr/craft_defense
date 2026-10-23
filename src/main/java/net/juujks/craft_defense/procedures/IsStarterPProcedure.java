package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.world.inventory.WelcomeGUIMenu;
import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModItems;
import net.juujks.craft_defense.init.CraftDefenseModBlocks;
import net.juujks.craft_defense.configuration.CraftDefenseConfigConfiguration;
import net.juujks.craft_defense.CraftDefenseMod;

import io.netty.buffer.Unpooled;

public class IsStarterPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		CraftDefenseMod.queueServerWork(1, () -> {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).isStarter) {
				if (entity instanceof Player _player)
					_player.closeContainer();
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(CraftDefenseModItems.STEVE_UNIT.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(CraftDefenseModItems.ALEX_UNIT.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("WelcomeGUI");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new WelcomeGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.isStarter = false;
					_vars.markSyncDirty();
				}
			}
		});
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == CraftDefenseModBlocks.UNIT_MACHINE.get()) {
			if (!CraftDefenseConfigConfiguration.UNIT_MACHINE.get()) {
				if (entity instanceof Player _player)
					_player.closeContainer();
			}
		}
	}
}