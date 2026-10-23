package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.MenuProvider;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.juujks.craft_defense.world.inventory.RewardGUIMenu;
import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModItems;
import net.juujks.craft_defense.init.CraftDefenseModBlocks;

import javax.annotation.Nullable;

import java.util.ArrayList;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class WaveSystem2FixProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double randomDisc = 0;
		double teleportTimer = 0;
		boolean playMusic = false;
		if (!world.isClientSide()) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel < 10) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.crystalsL10 = false;
					_vars.crystalsL15 = false;
					_vars.crystalsL20 = false;
					_vars.markSyncDirty();
				}
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel == 10) {
				if (!entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).crystalsL10) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(CraftDefenseModItems.EVOLUTION_CRYSTAL.get()).copy();
						_setstack.setCount(4);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.crystalsL10 = true;
						_vars.markSyncDirty();
					}
				}
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel == 15) {
				if (!entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).crystalsL15) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(CraftDefenseModItems.EVOLUTION_CRYSTAL.get()).copy();
						_setstack.setCount(4);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.crystalsL15 = true;
						_vars.markSyncDirty();
					}
				}
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel == 20) {
				if (!entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).crystalsL20) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(CraftDefenseModItems.EVOLUTION_CRYSTAL.get()).copy();
						_setstack.setCount(4);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.crystalsL20 = true;
						_vars.markSyncDirty();
					}
				}
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).wins >= entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).winsLUPCap) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.playerLevel = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel + 1;
					_vars.winsLUPCap = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).winsLUPCap + entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel;
					_vars.markSyncDirty();
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("You leveled up to " + "\u00A7e\u00A7lLevel " + new java.text.DecimalFormat("##").format(entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerLevel) + "!")), false);
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerInGame) {
				if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).autoSkip) {
					if (!entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).autoSkip2) {
						CraftDefenseModVariables.MapVariables.get(world).skipWave = CraftDefenseModVariables.MapVariables.get(world).skipWave + 1;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.playerVoted = true;
							_vars.autoSkip2 = true;
							_vars.markSyncDirty();
						}
					}
				}
			}
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).skipWaveProcessing) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7aWave Cleared!"), true);
					if (CraftDefenseModVariables.MapVariables.get(world).challenge == 1) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.moneyIG = (entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG + CraftDefenseModVariables.MapVariables.get(world).waveBonus) / 2;
							_vars.markSyncDirty();
						}
					} else {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.moneyIG = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG + CraftDefenseModVariables.MapVariables.get(world).waveBonus;
							_vars.markSyncDirty();
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")),
									SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:entity.experience_orb.pickup master @s");
						}
					}
					{
						CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.playerVoted = false;
						_vars.markSyncDirty();
					}
					if (entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).autoSkip) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.autoSkip2 = false;
							_vars.markSyncDirty();
						}
					}
					{
						CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.playerVotedStart = false;
						_vars.markSyncDirty();
					}
				}
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.skipWaveProcessing = false;
					_vars.markSyncDirty();
				}
			}
			if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("craft_defense:td_dim"))) {
				if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).gameWon) {
					DropsForRaidProcedure.execute(world, entity);
					for (Entity entityiterator : new ArrayList<>(world.players())) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.moneyIG = 0;
							_vars.steve_spawned = 0;
							_vars.alex_spawned = 0;
							_vars.zombie_spawned = 0;
							_vars.skeleton_spawned = 0;
							_vars.creeper_spawned = 0;
							_vars.spider_spawned = 0;
							_vars.slime_spawned = 0;
							_vars.witch_spawned = 0;
							_vars.villager_spawned = 0;
							_vars.cavespider_spawned = 0;
							_vars.stray_spawned = 0;
							_vars.zombiepig_spawned = 0;
							_vars.piglin_spawned = 0;
							_vars.puffer_fish_spawned = 0;
							_vars.iron_golem_spawned = 0;
							_vars.snowgolem_spawned = 0;
							_vars.husk_spawned = 0;
							_vars.magmacube_spawned = 0;
							_vars.polarbear_spawned = 0;
							_vars.charged_creeper_spawned = 0;
							_vars.ravager_spawned = 0;
							_vars.enderman_spawned = 0;
							_vars.breeze_spawned = 0;
							_vars.wolf_spawned = 0;
							_vars.pillager_spawned = 0;
							_vars.blaze_spawned = 0;
							_vars.bogged_spawned = 0;
							_vars.drowned_spawned = 0;
							_vars.frostbite_spawned = 0;
							_vars.drowned_spawned = 0;
							_vars.frostbite_spawned = 0;
							_vars.markSyncDirty();
						}
						CraftDefenseModVariables.MapVariables.get(world).mission = 0;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						if (CraftDefenseModVariables.MapVariables.get(world).customMapId == 0) {
							{
								CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.wins = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).wins + 1;
								_vars.winsLUP = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).winsLUP + 1;
								_vars.markSyncDirty();
							}
							if (entityiterator instanceof Player _player)
								_player.closeContainer();
							if (entity instanceof ServerPlayer _ent) {
								BlockPos _bpos = BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ());
								_ent.openMenu(new MenuProvider() {
									@Override
									public Component getDisplayName() {
										return Component.literal("RewardGUI");
									}

									@Override
									public boolean shouldTriggerClientSideContainerClosingOnOpen() {
										return false;
									}

									@Override
									public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
										return new RewardGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.TOWER_GEM.get()).copy();
								_setstack.setCount((int) (CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 911
										? (CraftDefenseModVariables.MapVariables.get(world).act - 900) * 20
										: (CraftDefenseModVariables.MapVariables.get(world).challenge + CraftDefenseModVariables.MapVariables.get(world).act + CraftDefenseModVariables.MapVariables.get(world).difficulty) - 1));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							CraftDefenseModVariables.MapVariables.get(world).crystalChance = Math.random();
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
							if (CraftDefenseModVariables.MapVariables.get(world).crystalChance <= (CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 911
									? 0.3
									: 0.05 + CraftDefenseModVariables.MapVariables.get(world).act / 100)) {
								if (entityiterator instanceof Player _player) {
									ItemStack _setstack = new ItemStack(CraftDefenseModItems.EVOLUTION_CRYSTAL.get()).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							}
							{
								CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
								_vars.playerVoted = false;
								_vars.markSyncDirty();
							}
							if (!(CraftDefenseModVariables.MapVariables.get(world).mission > 0 && CraftDefenseModVariables.MapVariables.get(world).difficulty > 1 && CraftDefenseModVariables.MapVariables.get(world).challenge > 0)) {
								if (CraftDefenseModVariables.MapVariables.get(world).act == 5) {
									if (entityiterator instanceof Player _player) {
										ItemStack _setstack = new ItemStack(CraftDefenseModBlocks.FIRST_WORLD_TROPHY.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									if (entityiterator instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("craft_defense:adv_2"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
								}
								if (CraftDefenseModVariables.MapVariables.get(world).act == 10) {
									if (entityiterator instanceof Player _player) {
										ItemStack _setstack = new ItemStack(CraftDefenseModBlocks.SECOND_WORLD_TROPHY.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									if (entityiterator instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("craft_defense:adv_3"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
								}
								if (CraftDefenseModVariables.MapVariables.get(world).act == 15) {
									if (entityiterator instanceof Player _player) {
										ItemStack _setstack = new ItemStack(CraftDefenseModBlocks.THIRD_WORLD_TROPHY.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									if (entityiterator instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("craft_defense:adv_4"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
								}
								if (CraftDefenseModVariables.MapVariables.get(world).act == 20) {
									if (entityiterator instanceof Player _player) {
										ItemStack _setstack = new ItemStack(CraftDefenseModBlocks.FOURTH_WORLD_TROPHY.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									if (entityiterator instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("craft_defense:adv_5"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
								}
								if (CraftDefenseModVariables.MapVariables.get(world).act == 25) {
									if (entityiterator instanceof Player _player) {
										ItemStack _setstack = new ItemStack(CraftDefenseModBlocks.FIFTH_WORLD_TROPHY.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									if (entityiterator instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("craft_defense:adv_6"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
								}
								if (CraftDefenseModVariables.MapVariables.get(world).act == 30) {
									if (entityiterator instanceof Player _player) {
										ItemStack _setstack = new ItemStack(CraftDefenseModBlocks.SIXTH_WORLD_TROPHY.get()).copy();
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									if (entityiterator instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("craft_defense:adv_7"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
								}
							}
							if (!(CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 911)) {
								if (entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).lastBeatenAct <= CraftDefenseModVariables.MapVariables.get(world).act) {
									{
										CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
										_vars.lastBeatenAct = CraftDefenseModVariables.MapVariables.get(world).act;
										_vars.markSyncDirty();
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"playsound minecraft:ui.toast.challenge_complete master @s ~ ~ ~");
									}
								}
							}
							if (CraftDefenseModVariables.MapVariables.get(world).difficulty != 1 && !(CraftDefenseModVariables.MapVariables.get(world).act > 900 && CraftDefenseModVariables.MapVariables.get(world).act <= 911)
									|| CraftDefenseModVariables.MapVariables.get(world).challenge != 0) {
								if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 5) {
									{
										CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
										_vars.quest2Number1 = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number1 + 1;
										_vars.markSyncDirty();
									}
								}
								if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 5) {
									{
										CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
										_vars.quest2Number3 = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number3 + 1;
										_vars.markSyncDirty();
									}
								}
								if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 5) {
									{
										CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
										_vars.quest2Number6 = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number6 + 1;
										_vars.markSyncDirty();
									}
								}
								if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 5) {
									{
										CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
										_vars.quest2Number24 = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number24 + 1;
										_vars.markSyncDirty();
									}
								}
							}
							if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 4) {
								{
									CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
									_vars.quest2Number1 = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number1 + 1;
									_vars.markSyncDirty();
								}
							}
							if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 4) {
								{
									CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
									_vars.quest2Number3 = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number3 + 1;
									_vars.markSyncDirty();
								}
							}
							if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 4) {
								{
									CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
									_vars.quest2Number6 = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number6 + 1;
									_vars.markSyncDirty();
								}
							}
							if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 4) {
								{
									CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
									_vars.quest2Number24 = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number24 + 1;
									_vars.markSyncDirty();
								}
							}
							CraftDefenseModVariables.MapVariables.get(world).teleportTimer = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						} else {
							if (entityiterator instanceof Player _player)
								_player.closeContainer();
							if (entity instanceof ServerPlayer _ent) {
								BlockPos _bpos = BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ());
								_ent.openMenu(new MenuProvider() {
									@Override
									public Component getDisplayName() {
										return Component.literal("RewardGUI");
									}

									@Override
									public boolean shouldTriggerClientSideContainerClosingOnOpen() {
										return false;
									}

									@Override
									public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
										return new RewardGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
							CraftDefenseModVariables.MapVariables.get(world).teleportTimer = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
					}
					{
						CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.gameWon = false;
						_vars.markSyncDirty();
					}
				}
				if (CraftDefenseModVariables.MapVariables.get(world).act < 1000) {
					if (CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies >= CraftDefenseModVariables.MapVariables.get(world).enemyCount && CraftDefenseModVariables.MapVariables.get(world).wave < 15) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Skip wave? Press " + "V" + " to vote (" + new java.text.DecimalFormat("##").format(CraftDefenseModVariables.MapVariables.get(world).skipWave) + "/"
									+ new java.text.DecimalFormat("##").format(CraftDefenseModVariables.MapVariables.get(world).playersInGame) + ")")), true);
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.autoSkip2 = false;
							_vars.markSyncDirty();
						}
					}
				} else {
					if (CraftDefenseModVariables.MapVariables.get(world).spawnedEnemies >= CraftDefenseModVariables.MapVariables.get(world).enemyCount) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Skip wave? Press V" + " to vote (" + new java.text.DecimalFormat("##").format(CraftDefenseModVariables.MapVariables.get(world).skipWave) + "/"
									+ new java.text.DecimalFormat("##").format(CraftDefenseModVariables.MapVariables.get(world).playersInGame) + ")")), true);
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.autoSkip2 = false;
							_vars.markSyncDirty();
						}
					}
				}
				if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).gameNotWon) {
					for (Entity entityiterator : new ArrayList<>(world.players())) {
						{
							CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.gameNotWon = false;
							_vars.moneyIG = 0;
							_vars.steve_spawned = 0;
							_vars.alex_spawned = 0;
							_vars.zombie_spawned = 0;
							_vars.skeleton_spawned = 0;
							_vars.creeper_spawned = 0;
							_vars.spider_spawned = 0;
							_vars.slime_spawned = 0;
							_vars.witch_spawned = 0;
							_vars.villager_spawned = 0;
							_vars.cavespider_spawned = 0;
							_vars.stray_spawned = 0;
							_vars.zombiepig_spawned = 0;
							_vars.piglin_spawned = 0;
							_vars.puffer_fish_spawned = 0;
							_vars.iron_golem_spawned = 0;
							_vars.snowgolem_spawned = 0;
							_vars.husk_spawned = 0;
							_vars.magmacube_spawned = 0;
							_vars.polarbear_spawned = 0;
							_vars.charged_creeper_spawned = 0;
							_vars.ravager_spawned = 0;
							_vars.enderman_spawned = 0;
							_vars.breeze_spawned = 0;
							_vars.wolf_spawned = 0;
							_vars.pillager_spawned = 0;
							_vars.blaze_spawned = 0;
							_vars.bogged_spawned = 0;
							_vars.markSyncDirty();
						}
						CraftDefenseModVariables.MapVariables.get(world).mission = 0;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						{
							CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.playerVoted = false;
							_vars.markSyncDirty();
						}
						if (CraftDefenseModVariables.MapVariables.get(world).act == 1000) {
							if (entityiterator instanceof ServerPlayer _ent) {
								BlockPos _bpos = BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ());
								_ent.openMenu(new MenuProvider() {
									@Override
									public Component getDisplayName() {
										return Component.literal("RewardGUI");
									}

									@Override
									public boolean shouldTriggerClientSideContainerClosingOnOpen() {
										return false;
									}

									@Override
									public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
										return new RewardGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
							if (entityiterator instanceof Player _player) {
								ItemStack _setstack = new ItemStack(CraftDefenseModItems.TRAIT_CUBE.get()).copy();
								_setstack.setCount((int) CraftDefenseModVariables.MapVariables.get(world).wave);
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (entityiterator instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("craft_defense:adv_8"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType1 == 1) {
								if (CraftDefenseModVariables.MapVariables.get(world).wave > entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number1) {
									{
										CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
										_vars.quest2Number1 = CraftDefenseModVariables.MapVariables.get(world).wave;
										_vars.markSyncDirty();
									}
								}
							}
							if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType3 == 1) {
								if (CraftDefenseModVariables.MapVariables.get(world).wave > entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number3) {
									{
										CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
										_vars.quest2Number3 = CraftDefenseModVariables.MapVariables.get(world).wave;
										_vars.markSyncDirty();
									}
								}
							}
							if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType6 == 1) {
								if (CraftDefenseModVariables.MapVariables.get(world).wave > entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number6) {
									{
										CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
										_vars.quest2Number6 = CraftDefenseModVariables.MapVariables.get(world).wave;
										_vars.markSyncDirty();
									}
								}
							}
							if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).questType24 == 1) {
								if (CraftDefenseModVariables.MapVariables.get(world).wave > entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).quest2Number24) {
									{
										CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
										_vars.quest2Number24 = CraftDefenseModVariables.MapVariables.get(world).wave;
										_vars.markSyncDirty();
									}
								}
							}
						}
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74\u00A7lYou've lost the game... Teleporting back in a few seconds"), true);
						CraftDefenseModVariables.MapVariables.get(world).wave = 0;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						if (CraftDefenseModVariables.MapVariables.get(world).teleportTimer == 0) {
							CraftDefenseModVariables.MapVariables.get(world).teleportTimer = 1;
							CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						}
					}
				}
				if (CraftDefenseModVariables.MapVariables.get(world).playMusic) {
					randomDisc = Mth.nextInt(RandomSource.create(), 0, 13);
					if (randomDisc == 0) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:music_disc.blocks record @s");
							}
						}
					} else if (randomDisc == 1) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:music_disc.cat record @s");
							}
						}
					} else if (randomDisc == 2) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:music_disc.creator record @s");
							}
						}
					} else if (randomDisc == 3) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:music_disc.far record @s");
							}
						}
					} else if (randomDisc == 4) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:music_disc.mall record @s");
							}
						}
					} else if (randomDisc == 5) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:music_disc.otherside record @s");
							}
						}
					} else if (randomDisc == 6) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:music_disc.precipice record @s ");
							}
						}
					} else if (randomDisc == 7) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:music_disc.relic record @s ");
							}
						}
					} else if (randomDisc == 8) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:music_disc.stal record @s ~ ~ ~ 3 1");
							}
						}
					} else if (randomDisc == 9) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:music_disc.strad record @s ~ ~ ~ 3 1");
							}
						}
					} else if (randomDisc == 10) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:music_disc.wait record @s ~ ~ ~ 3 1");
							}
						}
					} else if (randomDisc == 11) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:music_disc.ward record @s ~ ~ ~ 3 1");
							}
						}
					} else if (randomDisc == 12) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound craft_defense:music_disc.tears record @s ~ ~ ~ 3 1");
							}
						}
					} else if (randomDisc == 13) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound craft_defense:music_disc.bounce record @s ~ ~ ~ 3 1");
							}
						}
					}
					CraftDefenseModVariables.MapVariables.get(world).playMusic = false;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			}
		}
		if (CraftDefenseModVariables.MapVariables.get(world).teleportTimer >= 1) {
			CraftDefenseModVariables.MapVariables.get(world).teleportTimer = CraftDefenseModVariables.MapVariables.get(world).teleportTimer + 1;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			if (CraftDefenseModVariables.MapVariables.get(world).teleportTimer >= 201) {
				for (Entity entityiterator : new ArrayList<>(world.players())) {
					if (entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).playerInGame) {
						if ((entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).oldDim).equals("nether")) {
							if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
								ResourceKey<Level> destinationType = Level.NETHER;
								if (_player.level().dimension() == destinationType)
									return;
								ServerLevel nextLevel = _player.server.getLevel(destinationType);
								if (nextLevel != null) {
									_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
									_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
									for (MobEffectInstance _effectinstance : _player.getActiveEffects())
										_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
									_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						} else if ((entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).oldDim).equals("end")) {
							if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
								ResourceKey<Level> destinationType = Level.END;
								if (_player.level().dimension() == destinationType)
									return;
								ServerLevel nextLevel = _player.server.getLevel(destinationType);
								if (nextLevel != null) {
									_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
									_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
									for (MobEffectInstance _effectinstance : _player.getActiveEffects())
										_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
									_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						} else {
							if (entityiterator instanceof ServerPlayer _player && !_player.level().isClientSide()) {
								ResourceKey<Level> destinationType = Level.OVERWORLD;
								if (_player.level().dimension() == destinationType)
									return;
								ServerLevel nextLevel = _player.server.getLevel(destinationType);
								if (nextLevel != null) {
									_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
									_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
									for (MobEffectInstance _effectinstance : _player.getActiveEffects())
										_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
									_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
						if (world instanceof ServerLevel _level)
							_level.setDayTime((int) CraftDefenseModVariables.MapVariables.get(world).globalTime);
						{
							Entity _ent = entityiterator;
							double _tx = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).oldX;
							double _ty = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).oldY;
							double _tz = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES).oldZ;
							_ent.teleportTo(_tx, _ty, _tz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
						}
						CraftDefenseModVariables.MapVariables.get(world).inGame = false;
						CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
						{
							CraftDefenseModVariables.PlayerVariables _vars = entityiterator.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.playerInGame = false;
							_vars.markSyncDirty();
						}
					}
				}
				CraftDefenseModVariables.MapVariables.get(world).teleportTimer = 0;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
		}
	}
}