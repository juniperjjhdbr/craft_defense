package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

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

import net.juujks.craft_defense.world.inventory.FreeUnitsGUIMenu;
import net.juujks.craft_defense.network.CraftDefenseModVariables;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class FreeUnitProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean guiOpened = false;
		if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel > 1 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel <= 4
				|| entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel > 4 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel <= 7 || entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel == 8
				|| entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel == 10 || entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel == 12) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel > entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).fuLastCollectedLevel) {
				if (!(entity instanceof Player _plr0 && _plr0.containerMenu instanceof FreeUnitsGUIMenu)) {
					if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel >= 2 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).fuLastCollectedLevel < 2
							|| entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel >= 5 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).fuLastCollectedLevel < 5
							|| entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel >= 8 && entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).fuLastCollectedLevel < 8) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.fu1 = false;
							_vars.fu2 = false;
							_vars.fu3 = false;
							_vars.markSyncDirty();
						}
					}
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						_ent.openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("FreeUnitsGUI");
							}

							@Override
							public boolean shouldTriggerClientSideContainerClosingOnOpen() {
								return false;
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new FreeUnitsGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
		}
	}
}