package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.world.inventory.QueueGUIMenu;
import net.juujks.craft_defense.network.CraftDefenseModVariables;

import io.netty.buffer.Unpooled;

public class A15PProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity ownerOfRaid = null;
		CraftDefenseModVariables.MapVariables.get(world).map = "The Mines - Act 3-5";
		CraftDefenseModVariables.MapVariables.get(world).act = 15;
		CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		{
			CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
			_vars.isInQueue = true;
			_vars.markSyncDirty();
		}
		CraftDefenseModVariables.MapVariables.get(world).playersInQueue = CraftDefenseModVariables.MapVariables.get(world).playersInQueue + 1;
		CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			_ent.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("QueueGUI");
				}

				@Override
				public boolean shouldTriggerClientSideContainerClosingOnOpen() {
					return false;
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new QueueGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
	}
}