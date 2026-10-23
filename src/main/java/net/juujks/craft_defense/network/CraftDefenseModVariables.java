package net.juujks.craft_defense.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.juujks.craft_defense.CraftDefenseMod;

import java.util.function.Supplier;

@EventBusSubscriber
public class CraftDefenseModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, CraftDefenseMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(PlayerVariables::new).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		CraftDefenseMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		CraftDefenseMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@SubscribeEvent
	public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerTickUpdateSyncPlayerVariables(PlayerTickEvent.Post event) {
		if (event.getEntity() instanceof ServerPlayer player && player.getData(PLAYER_VARIABLES)._syncDirty) {
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
			player.getData(PLAYER_VARIABLES)._syncDirty = false;
		}
	}

	@SubscribeEvent
	public static void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
		PlayerVariables clone = new PlayerVariables();
		clone.alex_spawned = original.alex_spawned;
		clone.autoSkip = original.autoSkip;
		clone.autoSkip2 = original.autoSkip2;
		clone.cavespider_spawned = original.cavespider_spawned;
		clone.commonCandies = original.commonCandies;
		clone.creeper_spawned = original.creeper_spawned;
		clone.damage = original.damage;
		clone.damageBuff = original.damageBuff;
		clone.epicCandies = original.epicCandies;
		clone.gameNotWon = original.gameNotWon;
		clone.gameWon = original.gameWon;
		clone.husk_spawned = original.husk_spawned;
		clone.iron_golem_spawned = original.iron_golem_spawned;
		clone.isInQueue = original.isInQueue;
		clone.isStarter = original.isStarter;
		clone.lastBeatenAct = original.lastBeatenAct;
		clone.lastRolledRarity = original.lastRolledRarity;
		clone.lastRolledTrait = original.lastRolledTrait;
		clone.lastRolledTraitRarity = original.lastRolledTraitRarity;
		clone.lastRolledUnit = original.lastRolledUnit;
		clone.lastUnitType = original.lastUnitType;
		clone.legendaryCandies = original.legendaryCandies;
		clone.level = original.level;
		clone.magmacube_spawned = original.magmacube_spawned;
		clone.maxLevel = original.maxLevel;
		clone.moneyIG = original.moneyIG;
		clone.oldDim = original.oldDim;
		clone.oldX = original.oldX;
		clone.oldY = original.oldY;
		clone.oldZ = original.oldZ;
		clone.piglin_spawned = original.piglin_spawned;
		clone.playerInGame = original.playerInGame;
		clone.playerLevel = original.playerLevel;
		clone.playerVoted = original.playerVoted;
		clone.playerVotedStart = original.playerVotedStart;
		clone.polarbear_spawned = original.polarbear_spawned;
		clone.puffer_fish_spawned = original.puffer_fish_spawned;
		clone.quest1h = original.quest1h;
		clone.quest24h = original.quest24h;
		clone.quest2Number1 = original.quest2Number1;
		clone.quest2Number24 = original.quest2Number24;
		clone.quest2Number3 = original.quest2Number3;
		clone.quest2Number6 = original.quest2Number6;
		clone.quest3h = original.quest3h;
		clone.quest6h = original.quest6h;
		clone.questCompleted1h = original.questCompleted1h;
		clone.questCompleted24h = original.questCompleted24h;
		clone.questCompleted3h = original.questCompleted3h;
		clone.questCompleted6h = original.questCompleted6h;
		clone.questNumber1 = original.questNumber1;
		clone.questNumber24 = original.questNumber24;
		clone.questNumber3 = original.questNumber3;
		clone.questNumber6 = original.questNumber6;
		clone.questType1 = original.questType1;
		clone.questType24 = original.questType24;
		clone.questType3 = original.questType3;
		clone.questType6 = original.questType6;
		clone.range = original.range;
		clone.rangeBuff = original.rangeBuff;
		clone.rareCandies = original.rareCandies;
		clone.skeleton_spawned = original.skeleton_spawned;
		clone.skipWaveProcessing = original.skipWaveProcessing;
		clone.slime_spawned = original.slime_spawned;
		clone.snowgolem_spawned = original.snowgolem_spawned;
		clone.spa = original.spa;
		clone.spaBuff = original.spaBuff;
		clone.spider_spawned = original.spider_spawned;
		clone.steve_spawned = original.steve_spawned;
		clone.stray_spawned = original.stray_spawned;
		clone.totalCandies = original.totalCandies;
		clone.trait = original.trait;
		clone.unitLevel = original.unitLevel;
		clone.unitName = original.unitName;
		clone.upCost = original.upCost;
		clone.villager_spawned = original.villager_spawned;
		clone.wins = original.wins;
		clone.winsLUP = original.winsLUP;
		clone.winsLUPCap = original.winsLUPCap;
		clone.witch_spawned = original.witch_spawned;
		clone.xpToAdd = original.xpToAdd;
		clone.zombie_spawned = original.zombie_spawned;
		clone.zombiepig_spawned = original.zombiepig_spawned;
		clone.timer = original.timer;
		clone.secondsPlayed = original.secondsPlayed;
		clone.minutesPlayed = original.minutesPlayed;
		clone.hoursPlayed = original.hoursPlayed;
		clone.timeRemaining1 = original.timeRemaining1;
		clone.timeRemaining3 = original.timeRemaining3;
		clone.timeRemaining6 = original.timeRemaining6;
		clone.timeRemaining24 = original.timeRemaining24;
		clone.time2Remaining3 = original.time2Remaining3;
		clone.time2Remaining6 = original.time2Remaining6;
		clone.time2Remaining24 = original.time2Remaining24;
		clone.unBugConfirm = original.unBugConfirm;
		clone.charged_creeper_spawned = original.charged_creeper_spawned;
		clone.crystalsReceived = original.crystalsReceived;
		clone.additionalChance = original.additionalChance;
		clone.crystalsL15 = original.crystalsL15;
		clone.crystalsL20 = original.crystalsL20;
		clone.ravager_spawned = original.ravager_spawned;
		clone.enderman_spawned = original.enderman_spawned;
		clone.breeze_spawned = original.breeze_spawned;
		clone.legendary_pity = original.legendary_pity;
		clone.times_joined = original.times_joined;
		clone.wolf_spawned = original.wolf_spawned;
		clone.pillager_spawned = original.pillager_spawned;
		clone.editingRoom = original.editingRoom;
		clone.blaze_spawned = original.blaze_spawned;
		clone.bogged_spawned = original.bogged_spawned;
		clone.dmgLock = original.dmgLock;
		clone.spaLock = original.spaLock;
		clone.rngLock = original.rngLock;
		clone.npcTalking = original.npcTalking;
		clone.missionCooldown = original.missionCooldown;
		clone.missionCooldownSeconds = original.missionCooldownSeconds;
		clone.resetCandies = original.resetCandies;
		clone.freeUnitCollected = original.freeUnitCollected;
		clone.fu1 = original.fu1;
		clone.fu2 = original.fu2;
		clone.fu3 = original.fu3;
		clone.rareChosen = original.rareChosen;
		clone.epicChosen = original.epicChosen;
		clone.legendaryChosen = original.legendaryChosen;
		clone.fuGuiOpened = original.fuGuiOpened;
		clone.fuLastCollectedLevel = original.fuLastCollectedLevel;
		clone.drowned_spawned = original.drowned_spawned;
		clone.frostbite_spawned = original.frostbite_spawned;
		clone.moneyUnits = original.moneyUnits;
		if (!event.isWasDeath()) {
			clone.daysPlayed = original.daysPlayed;
			clone.crystalsL10 = original.crystalsL10;
		}
		event.getEntity().setData(PLAYER_VARIABLES, clone);
	}

	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData mapdata = MapVariables.get(player.level());
			SavedData worlddata = WorldVariables.get(player.level());
			if (mapdata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData worlddata = WorldVariables.get(player.level());
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		if (event.getLevel() instanceof ServerLevel level) {
			WorldVariables worldVariables = WorldVariables.get(level);
			if (worldVariables._syncDirty) {
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, worldVariables));
				worldVariables._syncDirty = false;
			}
			MapVariables mapVariables = MapVariables.get(level);
			if (mapVariables._syncDirty) {
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, mapVariables));
				mapVariables._syncDirty = false;
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "craft_defense_worldvars";
		boolean _syncDirty = false;

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "craft_defense_mapvars";
		boolean _syncDirty = false;
		public double act = 1.0;
		public boolean bossKilled = false;
		public double candyAmount = 0;
		public double candyChance = 0;
		public double commonAmount = 0;
		public double commonDrops = 0;
		public double cooldownInf = 0;
		public double crystalChance = 0;
		public boolean debugMode = false;
		public boolean disableEnemiesSpawning = false;
		public boolean disableGUI = false;
		public double enemiesKilled = 0;
		public double enemiesToAdd = 1.0;
		public double enemyCount = 2.0;
		public boolean farmerVar = false;
		public boolean gameEnded = false;
		public boolean gameLost = false;
		public double gameSpeed = 1.0;
		public boolean gameStart = false;
		public boolean gameStarted = false;
		public boolean gameStarting = false;
		public boolean inGame = false;
		public double lastAnnouncedWave = -1.0;
		public String map = "\"\"";
		public double numberOfUnitMachines = 0;
		public boolean placeble = false;
		public double playersInGame = 0;
		public double playersInQueue = 0;
		public boolean playMusic = false;
		public double rareAmount = 0;
		public double rareDrops = 0;
		public double shield = 0;
		public double skipWave = 0;
		public double spawnedEnemies = 0;
		public boolean spawnEnemies = false;
		public double startCooldown = 0;
		public boolean unitReward = false;
		public double voteStart = 0;
		public double wave = 0;
		public double waveBonus = 120.0;
		public double minDebug = 0;
		public double difficulty = 1.0;
		public boolean enable3x = false;
		public double challenge = 0;
		public double aliveEnemies = 0;
		public double globalTime = 0;
		public double customMapId = 0;
		public String ownerOfRaid = "";
		public double shareCooldown = 0;
		public double mission = 0;
		public double dropMultiplier = 1.0;
		public double teleportTimer = 0;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			act = nbt.getDouble("act");
			bossKilled = nbt.getBoolean("bossKilled");
			candyAmount = nbt.getDouble("candyAmount");
			candyChance = nbt.getDouble("candyChance");
			commonAmount = nbt.getDouble("commonAmount");
			commonDrops = nbt.getDouble("commonDrops");
			cooldownInf = nbt.getDouble("cooldownInf");
			crystalChance = nbt.getDouble("crystalChance");
			debugMode = nbt.getBoolean("debugMode");
			disableEnemiesSpawning = nbt.getBoolean("disableEnemiesSpawning");
			disableGUI = nbt.getBoolean("disableGUI");
			enemiesKilled = nbt.getDouble("enemiesKilled");
			enemiesToAdd = nbt.getDouble("enemiesToAdd");
			enemyCount = nbt.getDouble("enemyCount");
			farmerVar = nbt.getBoolean("farmerVar");
			gameEnded = nbt.getBoolean("gameEnded");
			gameLost = nbt.getBoolean("gameLost");
			gameSpeed = nbt.getDouble("gameSpeed");
			gameStart = nbt.getBoolean("gameStart");
			gameStarted = nbt.getBoolean("gameStarted");
			gameStarting = nbt.getBoolean("gameStarting");
			inGame = nbt.getBoolean("inGame");
			lastAnnouncedWave = nbt.getDouble("lastAnnouncedWave");
			map = nbt.getString("map");
			numberOfUnitMachines = nbt.getDouble("numberOfUnitMachines");
			placeble = nbt.getBoolean("placeble");
			playersInGame = nbt.getDouble("playersInGame");
			playersInQueue = nbt.getDouble("playersInQueue");
			playMusic = nbt.getBoolean("playMusic");
			rareAmount = nbt.getDouble("rareAmount");
			rareDrops = nbt.getDouble("rareDrops");
			shield = nbt.getDouble("shield");
			skipWave = nbt.getDouble("skipWave");
			spawnedEnemies = nbt.getDouble("spawnedEnemies");
			spawnEnemies = nbt.getBoolean("spawnEnemies");
			startCooldown = nbt.getDouble("startCooldown");
			unitReward = nbt.getBoolean("unitReward");
			voteStart = nbt.getDouble("voteStart");
			wave = nbt.getDouble("wave");
			waveBonus = nbt.getDouble("waveBonus");
			minDebug = nbt.getDouble("minDebug");
			difficulty = nbt.getDouble("difficulty");
			enable3x = nbt.getBoolean("enable3x");
			challenge = nbt.getDouble("challenge");
			aliveEnemies = nbt.getDouble("aliveEnemies");
			globalTime = nbt.getDouble("globalTime");
			customMapId = nbt.getDouble("customMapId");
			ownerOfRaid = nbt.getString("ownerOfRaid");
			shareCooldown = nbt.getDouble("shareCooldown");
			mission = nbt.getDouble("mission");
			dropMultiplier = nbt.getDouble("dropMultiplier");
			teleportTimer = nbt.getDouble("teleportTimer");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("act", act);
			nbt.putBoolean("bossKilled", bossKilled);
			nbt.putDouble("candyAmount", candyAmount);
			nbt.putDouble("candyChance", candyChance);
			nbt.putDouble("commonAmount", commonAmount);
			nbt.putDouble("commonDrops", commonDrops);
			nbt.putDouble("cooldownInf", cooldownInf);
			nbt.putDouble("crystalChance", crystalChance);
			nbt.putBoolean("debugMode", debugMode);
			nbt.putBoolean("disableEnemiesSpawning", disableEnemiesSpawning);
			nbt.putBoolean("disableGUI", disableGUI);
			nbt.putDouble("enemiesKilled", enemiesKilled);
			nbt.putDouble("enemiesToAdd", enemiesToAdd);
			nbt.putDouble("enemyCount", enemyCount);
			nbt.putBoolean("farmerVar", farmerVar);
			nbt.putBoolean("gameEnded", gameEnded);
			nbt.putBoolean("gameLost", gameLost);
			nbt.putDouble("gameSpeed", gameSpeed);
			nbt.putBoolean("gameStart", gameStart);
			nbt.putBoolean("gameStarted", gameStarted);
			nbt.putBoolean("gameStarting", gameStarting);
			nbt.putBoolean("inGame", inGame);
			nbt.putDouble("lastAnnouncedWave", lastAnnouncedWave);
			nbt.putString("map", map);
			nbt.putDouble("numberOfUnitMachines", numberOfUnitMachines);
			nbt.putBoolean("placeble", placeble);
			nbt.putDouble("playersInGame", playersInGame);
			nbt.putDouble("playersInQueue", playersInQueue);
			nbt.putBoolean("playMusic", playMusic);
			nbt.putDouble("rareAmount", rareAmount);
			nbt.putDouble("rareDrops", rareDrops);
			nbt.putDouble("shield", shield);
			nbt.putDouble("skipWave", skipWave);
			nbt.putDouble("spawnedEnemies", spawnedEnemies);
			nbt.putBoolean("spawnEnemies", spawnEnemies);
			nbt.putDouble("startCooldown", startCooldown);
			nbt.putBoolean("unitReward", unitReward);
			nbt.putDouble("voteStart", voteStart);
			nbt.putDouble("wave", wave);
			nbt.putDouble("waveBonus", waveBonus);
			nbt.putDouble("minDebug", minDebug);
			nbt.putDouble("difficulty", difficulty);
			nbt.putBoolean("enable3x", enable3x);
			nbt.putDouble("challenge", challenge);
			nbt.putDouble("aliveEnemies", aliveEnemies);
			nbt.putDouble("globalTime", globalTime);
			nbt.putDouble("customMapId", customMapId);
			nbt.putString("ownerOfRaid", ownerOfRaid);
			nbt.putDouble("shareCooldown", shareCooldown);
			nbt.putDouble("mission", mission);
			nbt.putDouble("dropMultiplier", dropMultiplier);
			nbt.putDouble("teleportTimer", teleportTimer);
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			_syncDirty = true;
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CraftDefenseMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		boolean _syncDirty = false;
		public double alex_spawned = 0;
		public boolean autoSkip = false;
		public boolean autoSkip2 = false;
		public double cavespider_spawned = 0;
		public double commonCandies = 0;
		public double creeper_spawned = 0;
		public double damage = 0;
		public double damageBuff = 0;
		public double epicCandies = 0;
		public boolean gameNotWon = false;
		public boolean gameWon = false;
		public double husk_spawned = 0;
		public double iron_golem_spawned = 0;
		public boolean isInQueue = false;
		public boolean isStarter = true;
		public double lastBeatenAct = 0;
		public String lastRolledRarity = "\"\"";
		public String lastRolledTrait = "\"\"";
		public String lastRolledTraitRarity = "\"\"";
		public String lastRolledUnit = "\"\"";
		public String lastUnitType = "\"\"";
		public double legendaryCandies = 0;
		public double level = 0;
		public double magmacube_spawned = 0;
		public double maxLevel = 0;
		public double moneyIG = 0;
		public String oldDim = "\"\"";
		public double oldX = 0;
		public double oldY = 0;
		public double oldZ = 0;
		public double piglin_spawned = 0;
		public boolean playerInGame = false;
		public double playerLevel = 1.0;
		public boolean playerVoted = false;
		public boolean playerVotedStart = false;
		public double polarbear_spawned = 0;
		public double puffer_fish_spawned = 0;
		public String quest1h = "\"\"";
		public String quest24h = "\"\"";
		public double quest2Number1 = 0;
		public double quest2Number24 = 0;
		public double quest2Number3 = 0;
		public double quest2Number6 = 0;
		public String quest3h = "\"\"";
		public String quest6h = "\"\"";
		public boolean questCompleted1h = false;
		public boolean questCompleted24h = false;
		public boolean questCompleted3h = false;
		public boolean questCompleted6h = false;
		public double questNumber1 = 20.0;
		public double questNumber24 = 70.0;
		public double questNumber3 = 1500.0;
		public double questNumber6 = 300.0;
		public double questType1 = 1.0;
		public double questType24 = 4.0;
		public double questType3 = 2.0;
		public double questType6 = 3.0;
		public double range = 0;
		public double rangeBuff = 0;
		public double rareCandies = 0;
		public double skeleton_spawned = 0;
		public boolean skipWaveProcessing = false;
		public double slime_spawned = 0;
		public double snowgolem_spawned = 0;
		public double spa = 0;
		public double spaBuff = 0;
		public double spider_spawned = 0;
		public double steve_spawned = 0;
		public double stray_spawned = 0;
		public double totalCandies = 0;
		public String trait = "\"\"";
		public double unitLevel = 0;
		public String unitName = "\"\"";
		public double upCost = 0;
		public double villager_spawned = 0;
		public double wins = 0;
		public double winsLUP = 0.0;
		public double winsLUPCap = 1.0;
		public double witch_spawned = 0;
		public double xpToAdd = 0;
		public double zombie_spawned = 0;
		public double zombiepig_spawned = 0;
		public double timer = 0;
		public double secondsPlayed = 0;
		public double minutesPlayed = 0;
		public double hoursPlayed = 0;
		public double daysPlayed = 0;
		public double timeRemaining1 = 0;
		public double timeRemaining3 = 0;
		public double timeRemaining6 = 0;
		public double timeRemaining24 = 0;
		public double time2Remaining3 = 0;
		public double time2Remaining6 = 0;
		public double time2Remaining24 = 0;
		public double unBugConfirm = 0;
		public double charged_creeper_spawned = 0;
		public boolean crystalsReceived = false;
		public double additionalChance = 1.0;
		public boolean crystalsL10 = false;
		public boolean crystalsL15 = false;
		public boolean crystalsL20 = false;
		public double ravager_spawned = 0;
		public double enderman_spawned = 0;
		public double breeze_spawned = 0;
		public double legendary_pity = 0;
		public double times_joined = 0;
		public double wolf_spawned = 0;
		public double pillager_spawned = 0;
		public boolean editingRoom = false;
		public double blaze_spawned = 0;
		public double bogged_spawned = 0;
		public boolean dmgLock = false;
		public boolean spaLock = false;
		public boolean rngLock = false;
		public boolean npcTalking = false;
		public double missionCooldown = 0;
		public double missionCooldownSeconds = 0;
		public boolean resetCandies = false;
		public boolean freeUnitCollected = false;
		public boolean fu1 = false;
		public boolean fu2 = false;
		public boolean fu3 = false;
		public double rareChosen = 0;
		public double epicChosen = 0;
		public double legendaryChosen = 0;
		public boolean fuGuiOpened = false;
		public double fuLastCollectedLevel = 0;
		public double drowned_spawned = 0;
		public double frostbite_spawned = 0;
		public double moneyUnits = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("alex_spawned", alex_spawned);
			nbt.putBoolean("autoSkip", autoSkip);
			nbt.putBoolean("autoSkip2", autoSkip2);
			nbt.putDouble("cavespider_spawned", cavespider_spawned);
			nbt.putDouble("commonCandies", commonCandies);
			nbt.putDouble("creeper_spawned", creeper_spawned);
			nbt.putDouble("damage", damage);
			nbt.putDouble("damageBuff", damageBuff);
			nbt.putDouble("epicCandies", epicCandies);
			nbt.putBoolean("gameNotWon", gameNotWon);
			nbt.putBoolean("gameWon", gameWon);
			nbt.putDouble("husk_spawned", husk_spawned);
			nbt.putDouble("iron_golem_spawned", iron_golem_spawned);
			nbt.putBoolean("isInQueue", isInQueue);
			nbt.putBoolean("isStarter", isStarter);
			nbt.putDouble("lastBeatenAct", lastBeatenAct);
			nbt.putString("lastRolledRarity", lastRolledRarity);
			nbt.putString("lastRolledTrait", lastRolledTrait);
			nbt.putString("lastRolledTraitRarity", lastRolledTraitRarity);
			nbt.putString("lastRolledUnit", lastRolledUnit);
			nbt.putString("lastUnitType", lastUnitType);
			nbt.putDouble("legendaryCandies", legendaryCandies);
			nbt.putDouble("level", level);
			nbt.putDouble("magmacube_spawned", magmacube_spawned);
			nbt.putDouble("maxLevel", maxLevel);
			nbt.putDouble("moneyIG", moneyIG);
			nbt.putString("oldDim", oldDim);
			nbt.putDouble("oldX", oldX);
			nbt.putDouble("oldY", oldY);
			nbt.putDouble("oldZ", oldZ);
			nbt.putDouble("piglin_spawned", piglin_spawned);
			nbt.putBoolean("playerInGame", playerInGame);
			nbt.putDouble("playerLevel", playerLevel);
			nbt.putBoolean("playerVoted", playerVoted);
			nbt.putBoolean("playerVotedStart", playerVotedStart);
			nbt.putDouble("polarbear_spawned", polarbear_spawned);
			nbt.putDouble("puffer_fish_spawned", puffer_fish_spawned);
			nbt.putString("quest1h", quest1h);
			nbt.putString("quest24h", quest24h);
			nbt.putDouble("quest2Number1", quest2Number1);
			nbt.putDouble("quest2Number24", quest2Number24);
			nbt.putDouble("quest2Number3", quest2Number3);
			nbt.putDouble("quest2Number6", quest2Number6);
			nbt.putString("quest3h", quest3h);
			nbt.putString("quest6h", quest6h);
			nbt.putBoolean("questCompleted1h", questCompleted1h);
			nbt.putBoolean("questCompleted24h", questCompleted24h);
			nbt.putBoolean("questCompleted3h", questCompleted3h);
			nbt.putBoolean("questCompleted6h", questCompleted6h);
			nbt.putDouble("questNumber1", questNumber1);
			nbt.putDouble("questNumber24", questNumber24);
			nbt.putDouble("questNumber3", questNumber3);
			nbt.putDouble("questNumber6", questNumber6);
			nbt.putDouble("questType1", questType1);
			nbt.putDouble("questType24", questType24);
			nbt.putDouble("questType3", questType3);
			nbt.putDouble("questType6", questType6);
			nbt.putDouble("range", range);
			nbt.putDouble("rangeBuff", rangeBuff);
			nbt.putDouble("rareCandies", rareCandies);
			nbt.putDouble("skeleton_spawned", skeleton_spawned);
			nbt.putBoolean("skipWaveProcessing", skipWaveProcessing);
			nbt.putDouble("slime_spawned", slime_spawned);
			nbt.putDouble("snowgolem_spawned", snowgolem_spawned);
			nbt.putDouble("spa", spa);
			nbt.putDouble("spaBuff", spaBuff);
			nbt.putDouble("spider_spawned", spider_spawned);
			nbt.putDouble("steve_spawned", steve_spawned);
			nbt.putDouble("stray_spawned", stray_spawned);
			nbt.putDouble("totalCandies", totalCandies);
			nbt.putString("trait", trait);
			nbt.putDouble("unitLevel", unitLevel);
			nbt.putString("unitName", unitName);
			nbt.putDouble("upCost", upCost);
			nbt.putDouble("villager_spawned", villager_spawned);
			nbt.putDouble("wins", wins);
			nbt.putDouble("winsLUP", winsLUP);
			nbt.putDouble("winsLUPCap", winsLUPCap);
			nbt.putDouble("witch_spawned", witch_spawned);
			nbt.putDouble("xpToAdd", xpToAdd);
			nbt.putDouble("zombie_spawned", zombie_spawned);
			nbt.putDouble("zombiepig_spawned", zombiepig_spawned);
			nbt.putDouble("timer", timer);
			nbt.putDouble("secondsPlayed", secondsPlayed);
			nbt.putDouble("minutesPlayed", minutesPlayed);
			nbt.putDouble("hoursPlayed", hoursPlayed);
			nbt.putDouble("daysPlayed", daysPlayed);
			nbt.putDouble("timeRemaining1", timeRemaining1);
			nbt.putDouble("timeRemaining3", timeRemaining3);
			nbt.putDouble("timeRemaining6", timeRemaining6);
			nbt.putDouble("timeRemaining24", timeRemaining24);
			nbt.putDouble("time2Remaining3", time2Remaining3);
			nbt.putDouble("time2Remaining6", time2Remaining6);
			nbt.putDouble("time2Remaining24", time2Remaining24);
			nbt.putDouble("unBugConfirm", unBugConfirm);
			nbt.putDouble("charged_creeper_spawned", charged_creeper_spawned);
			nbt.putBoolean("crystalsReceived", crystalsReceived);
			nbt.putDouble("additionalChance", additionalChance);
			nbt.putBoolean("crystalsL10", crystalsL10);
			nbt.putBoolean("crystalsL15", crystalsL15);
			nbt.putBoolean("crystalsL20", crystalsL20);
			nbt.putDouble("ravager_spawned", ravager_spawned);
			nbt.putDouble("enderman_spawned", enderman_spawned);
			nbt.putDouble("breeze_spawned", breeze_spawned);
			nbt.putDouble("legendary_pity", legendary_pity);
			nbt.putDouble("times_joined", times_joined);
			nbt.putDouble("wolf_spawned", wolf_spawned);
			nbt.putDouble("pillager_spawned", pillager_spawned);
			nbt.putBoolean("editingRoom", editingRoom);
			nbt.putDouble("blaze_spawned", blaze_spawned);
			nbt.putDouble("bogged_spawned", bogged_spawned);
			nbt.putBoolean("dmgLock", dmgLock);
			nbt.putBoolean("spaLock", spaLock);
			nbt.putBoolean("rngLock", rngLock);
			nbt.putBoolean("npcTalking", npcTalking);
			nbt.putDouble("missionCooldown", missionCooldown);
			nbt.putDouble("missionCooldownSeconds", missionCooldownSeconds);
			nbt.putBoolean("resetCandies", resetCandies);
			nbt.putBoolean("freeUnitCollected", freeUnitCollected);
			nbt.putBoolean("fu1", fu1);
			nbt.putBoolean("fu2", fu2);
			nbt.putBoolean("fu3", fu3);
			nbt.putDouble("rareChosen", rareChosen);
			nbt.putDouble("epicChosen", epicChosen);
			nbt.putDouble("legendaryChosen", legendaryChosen);
			nbt.putBoolean("fuGuiOpened", fuGuiOpened);
			nbt.putDouble("fuLastCollectedLevel", fuLastCollectedLevel);
			nbt.putDouble("drowned_spawned", drowned_spawned);
			nbt.putDouble("frostbite_spawned", frostbite_spawned);
			nbt.putDouble("moneyUnits", moneyUnits);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			alex_spawned = nbt.getDouble("alex_spawned");
			autoSkip = nbt.getBoolean("autoSkip");
			autoSkip2 = nbt.getBoolean("autoSkip2");
			cavespider_spawned = nbt.getDouble("cavespider_spawned");
			commonCandies = nbt.getDouble("commonCandies");
			creeper_spawned = nbt.getDouble("creeper_spawned");
			damage = nbt.getDouble("damage");
			damageBuff = nbt.getDouble("damageBuff");
			epicCandies = nbt.getDouble("epicCandies");
			gameNotWon = nbt.getBoolean("gameNotWon");
			gameWon = nbt.getBoolean("gameWon");
			husk_spawned = nbt.getDouble("husk_spawned");
			iron_golem_spawned = nbt.getDouble("iron_golem_spawned");
			isInQueue = nbt.getBoolean("isInQueue");
			isStarter = nbt.getBoolean("isStarter");
			lastBeatenAct = nbt.getDouble("lastBeatenAct");
			lastRolledRarity = nbt.getString("lastRolledRarity");
			lastRolledTrait = nbt.getString("lastRolledTrait");
			lastRolledTraitRarity = nbt.getString("lastRolledTraitRarity");
			lastRolledUnit = nbt.getString("lastRolledUnit");
			lastUnitType = nbt.getString("lastUnitType");
			legendaryCandies = nbt.getDouble("legendaryCandies");
			level = nbt.getDouble("level");
			magmacube_spawned = nbt.getDouble("magmacube_spawned");
			maxLevel = nbt.getDouble("maxLevel");
			moneyIG = nbt.getDouble("moneyIG");
			oldDim = nbt.getString("oldDim");
			oldX = nbt.getDouble("oldX");
			oldY = nbt.getDouble("oldY");
			oldZ = nbt.getDouble("oldZ");
			piglin_spawned = nbt.getDouble("piglin_spawned");
			playerInGame = nbt.getBoolean("playerInGame");
			playerLevel = nbt.getDouble("playerLevel");
			playerVoted = nbt.getBoolean("playerVoted");
			playerVotedStart = nbt.getBoolean("playerVotedStart");
			polarbear_spawned = nbt.getDouble("polarbear_spawned");
			puffer_fish_spawned = nbt.getDouble("puffer_fish_spawned");
			quest1h = nbt.getString("quest1h");
			quest24h = nbt.getString("quest24h");
			quest2Number1 = nbt.getDouble("quest2Number1");
			quest2Number24 = nbt.getDouble("quest2Number24");
			quest2Number3 = nbt.getDouble("quest2Number3");
			quest2Number6 = nbt.getDouble("quest2Number6");
			quest3h = nbt.getString("quest3h");
			quest6h = nbt.getString("quest6h");
			questCompleted1h = nbt.getBoolean("questCompleted1h");
			questCompleted24h = nbt.getBoolean("questCompleted24h");
			questCompleted3h = nbt.getBoolean("questCompleted3h");
			questCompleted6h = nbt.getBoolean("questCompleted6h");
			questNumber1 = nbt.getDouble("questNumber1");
			questNumber24 = nbt.getDouble("questNumber24");
			questNumber3 = nbt.getDouble("questNumber3");
			questNumber6 = nbt.getDouble("questNumber6");
			questType1 = nbt.getDouble("questType1");
			questType24 = nbt.getDouble("questType24");
			questType3 = nbt.getDouble("questType3");
			questType6 = nbt.getDouble("questType6");
			range = nbt.getDouble("range");
			rangeBuff = nbt.getDouble("rangeBuff");
			rareCandies = nbt.getDouble("rareCandies");
			skeleton_spawned = nbt.getDouble("skeleton_spawned");
			skipWaveProcessing = nbt.getBoolean("skipWaveProcessing");
			slime_spawned = nbt.getDouble("slime_spawned");
			snowgolem_spawned = nbt.getDouble("snowgolem_spawned");
			spa = nbt.getDouble("spa");
			spaBuff = nbt.getDouble("spaBuff");
			spider_spawned = nbt.getDouble("spider_spawned");
			steve_spawned = nbt.getDouble("steve_spawned");
			stray_spawned = nbt.getDouble("stray_spawned");
			totalCandies = nbt.getDouble("totalCandies");
			trait = nbt.getString("trait");
			unitLevel = nbt.getDouble("unitLevel");
			unitName = nbt.getString("unitName");
			upCost = nbt.getDouble("upCost");
			villager_spawned = nbt.getDouble("villager_spawned");
			wins = nbt.getDouble("wins");
			winsLUP = nbt.getDouble("winsLUP");
			winsLUPCap = nbt.getDouble("winsLUPCap");
			witch_spawned = nbt.getDouble("witch_spawned");
			xpToAdd = nbt.getDouble("xpToAdd");
			zombie_spawned = nbt.getDouble("zombie_spawned");
			zombiepig_spawned = nbt.getDouble("zombiepig_spawned");
			timer = nbt.getDouble("timer");
			secondsPlayed = nbt.getDouble("secondsPlayed");
			minutesPlayed = nbt.getDouble("minutesPlayed");
			hoursPlayed = nbt.getDouble("hoursPlayed");
			daysPlayed = nbt.getDouble("daysPlayed");
			timeRemaining1 = nbt.getDouble("timeRemaining1");
			timeRemaining3 = nbt.getDouble("timeRemaining3");
			timeRemaining6 = nbt.getDouble("timeRemaining6");
			timeRemaining24 = nbt.getDouble("timeRemaining24");
			time2Remaining3 = nbt.getDouble("time2Remaining3");
			time2Remaining6 = nbt.getDouble("time2Remaining6");
			time2Remaining24 = nbt.getDouble("time2Remaining24");
			unBugConfirm = nbt.getDouble("unBugConfirm");
			charged_creeper_spawned = nbt.getDouble("charged_creeper_spawned");
			crystalsReceived = nbt.getBoolean("crystalsReceived");
			additionalChance = nbt.getDouble("additionalChance");
			crystalsL10 = nbt.getBoolean("crystalsL10");
			crystalsL15 = nbt.getBoolean("crystalsL15");
			crystalsL20 = nbt.getBoolean("crystalsL20");
			ravager_spawned = nbt.getDouble("ravager_spawned");
			enderman_spawned = nbt.getDouble("enderman_spawned");
			breeze_spawned = nbt.getDouble("breeze_spawned");
			legendary_pity = nbt.getDouble("legendary_pity");
			times_joined = nbt.getDouble("times_joined");
			wolf_spawned = nbt.getDouble("wolf_spawned");
			pillager_spawned = nbt.getDouble("pillager_spawned");
			editingRoom = nbt.getBoolean("editingRoom");
			blaze_spawned = nbt.getDouble("blaze_spawned");
			bogged_spawned = nbt.getDouble("bogged_spawned");
			dmgLock = nbt.getBoolean("dmgLock");
			spaLock = nbt.getBoolean("spaLock");
			rngLock = nbt.getBoolean("rngLock");
			npcTalking = nbt.getBoolean("npcTalking");
			missionCooldown = nbt.getDouble("missionCooldown");
			missionCooldownSeconds = nbt.getDouble("missionCooldownSeconds");
			resetCandies = nbt.getBoolean("resetCandies");
			freeUnitCollected = nbt.getBoolean("freeUnitCollected");
			fu1 = nbt.getBoolean("fu1");
			fu2 = nbt.getBoolean("fu2");
			fu3 = nbt.getBoolean("fu3");
			rareChosen = nbt.getDouble("rareChosen");
			epicChosen = nbt.getDouble("epicChosen");
			legendaryChosen = nbt.getDouble("legendaryChosen");
			fuGuiOpened = nbt.getBoolean("fuGuiOpened");
			fuLastCollectedLevel = nbt.getDouble("fuLastCollectedLevel");
			drowned_spawned = nbt.getDouble("drowned_spawned");
			frostbite_spawned = nbt.getDouble("frostbite_spawned");
			moneyUnits = nbt.getDouble("moneyUnits");
		}

		public void markSyncDirty() {
			_syncDirty = true;
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CraftDefenseMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}