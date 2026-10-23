package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.world.inventory.MissionGUIMenu;
import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.CraftDefenseMod;

import io.netty.buffer.Unpooled;

public class DialogueNPC1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).missionCooldown == 0) {
			if (!sourceentity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).npcTalking) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = sourceentity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.npcTalking = true;
					_vars.markSyncDirty();
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.ambient")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.ambient")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("NPC Mission #1: Hello stranger!"), false);
				CraftDefenseMod.queueServerWork(30, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.ambient")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.ambient")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("NPC Mission #1: I need your help with something..."), false);
					CraftDefenseMod.queueServerWork(40, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.ambient")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.ambient")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("NPC Mission #1: Some strong enemies are attacking \u00A7eThe Plains\u00A7f\u00A7r and I'm not that strong to defeat them!"), false);
						CraftDefenseMod.queueServerWork(50, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.ambient")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.ambient")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("NPC Mission #1: Could you help me, please?"), false);
							CraftDefenseMod.queueServerWork(50, () -> {
								{
									CraftDefenseModVariables.PlayerVariables _vars = sourceentity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
									_vars.npcTalking = false;
									_vars.markSyncDirty();
								}
								if (sourceentity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									_ent.openMenu(new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("MissionGUI");
										}

										@Override
										public boolean shouldTriggerClientSideContainerClosingOnOpen() {
											return false;
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new MissionGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							});
						});
					});
				});
			}
		} else {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7cERROR: You are in cooldown! (" + new java.text.DecimalFormat("#,###").format(sourceentity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).missionCooldownSeconds) + "s)")),
						false);
			{
				Entity _ent = sourceentity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
				}
			}
		}
	}
}