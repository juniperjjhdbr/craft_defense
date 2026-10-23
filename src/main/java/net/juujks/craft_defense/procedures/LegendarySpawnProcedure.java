package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModItems;
import net.juujks.craft_defense.init.CraftDefenseModEntities;
import net.juujks.craft_defense.init.CraftDefenseModBlocks;

import java.util.Comparator;

public class LegendarySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CraftDefenseModItems.IRON_GOLEM_UNIT_ITEM.get()) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).iron_golem_spawned < (CraftDefenseModVariables.MapVariables.get(world).challenge == 5 ? 1 : 4)) {
				if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == CraftDefenseModBlocks.AERIAL_BLOCK.get())) {
					if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG >= 1000) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.IRON_GOLEM_UNIT.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.moneyIG = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG - 1000;
							_vars.iron_golem_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).iron_golem_spawned + 1;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CLOUD, x, (y + 1), z, 100, 0, 0, 0, 0.1);
						{
							final Vec3 _center = new Vec3(x, (y + 1), z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								entityiterator.getPersistentData().putDouble("unitLevel",
										(CraftDefenseModVariables.MapVariables.get(world).challenge == 4
												? 1
												: (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")));
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								entityiterator.getPersistentData().putString("owner", (entity.getStringUUID()));
								entity.getPersistentData().putString("ownerOf", (entityiterator.getStringUUID()));
								entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString() + "'s " + entityiterator.getDisplayName().getString())));
								entityiterator.getPersistentData().putDouble("damageBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("damageBuff")));
								entityiterator.getPersistentData().putDouble("rangeBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rangeBuff")));
								entityiterator.getPersistentData().putDouble("spaBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("spaBuff")));
								entityiterator.getPersistentData().putString("trait",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("traitText")));
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("evo")) {
									entityiterator.getPersistentData().putBoolean("evo", true);
									entityiterator.getPersistentData().putDouble("maxLevel", 9);
								}
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You don't have enough money!\",\"color\":\"red\"}");
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
							}
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You can only place this unit on ground!\",\"color\":\"red\"}");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
						}
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You have reached max placements for this unit!\",\"color\":\"red\"}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CraftDefenseModItems.DROWNED_UNIT_ITEM.get()) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).drowned_spawned < (CraftDefenseModVariables.MapVariables.get(world).challenge == 5 ? 1 : 4)) {
				if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == CraftDefenseModBlocks.AERIAL_BLOCK.get())) {
					if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG >= 1000) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.DROWNED_UNIT.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.moneyIG = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG - 1000;
							_vars.drowned_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).drowned_spawned + 1;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CLOUD, x, (y + 1), z, 100, 0, 0, 0, 0.1);
						{
							final Vec3 _center = new Vec3(x, (y + 1), z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								entityiterator.getPersistentData().putDouble("unitLevel",
										(CraftDefenseModVariables.MapVariables.get(world).challenge == 4
												? 1
												: (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")));
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								entityiterator.getPersistentData().putString("owner", (entity.getStringUUID()));
								entity.getPersistentData().putString("ownerOf", (entityiterator.getStringUUID()));
								entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString() + "'s " + entityiterator.getDisplayName().getString())));
								entityiterator.getPersistentData().putDouble("damageBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("damageBuff")));
								entityiterator.getPersistentData().putDouble("rangeBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rangeBuff")));
								entityiterator.getPersistentData().putDouble("spaBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("spaBuff")));
								entityiterator.getPersistentData().putString("trait",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("traitText")));
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("evo")) {
									entityiterator.getPersistentData().putBoolean("evo", true);
									entityiterator.getPersistentData().putDouble("maxLevel", 9);
								}
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You don't have enough money!\",\"color\":\"red\"}");
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
							}
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You can only place this unit on ground!\",\"color\":\"red\"}");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
						}
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You have reached max placements for this unit!\",\"color\":\"red\"}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CraftDefenseModItems.CHARGED_CREEPER_UNIT_ITEM.get()) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).charged_creeper_spawned < (CraftDefenseModVariables.MapVariables.get(world).challenge == 5 ? 1 : 2)) {
				if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == CraftDefenseModBlocks.AERIAL_BLOCK.get())) {
					if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG >= 1500) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.CHARGED_CREEPER_UNIT.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.moneyIG = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG - 1500;
							_vars.charged_creeper_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).charged_creeper_spawned + 1;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CLOUD, x, (y + 1), z, 100, 0, 0, 0, 0.1);
						if (world instanceof ServerLevel _level) {
							LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y + 1, z)));
							entityToSpawn.setVisualOnly(true);
							_level.addFreshEntity(entityToSpawn);
						}
						{
							final Vec3 _center = new Vec3(x, (y + 1), z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								entityiterator.getPersistentData().putDouble("unitLevel",
										(CraftDefenseModVariables.MapVariables.get(world).challenge == 4
												? 1
												: (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")));
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								entityiterator.getPersistentData().putString("owner", (entity.getStringUUID()));
								entity.getPersistentData().putString("ownerOf", (entityiterator.getStringUUID()));
								entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString() + "'s " + entityiterator.getDisplayName().getString())));
								entityiterator.getPersistentData().putDouble("damageBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("damageBuff")));
								entityiterator.getPersistentData().putDouble("rangeBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rangeBuff")));
								entityiterator.getPersistentData().putDouble("spaBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("spaBuff")));
								entityiterator.getPersistentData().putString("trait",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("traitText")));
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("evo")) {
									entityiterator.getPersistentData().putBoolean("evo", true);
									entityiterator.getPersistentData().putDouble("maxLevel", 9);
								}
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You don't have enough money!\",\"color\":\"red\"}");
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
							}
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You can only place this unit on ground!\",\"color\":\"red\"}");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
						}
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You have reached max placements for this unit!\",\"color\":\"red\"}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CraftDefenseModItems.BREEZE_UNIT_ITEM.get()) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).breeze_spawned < (CraftDefenseModVariables.MapVariables.get(world).challenge == 5 ? 1 : 4)) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == CraftDefenseModBlocks.AERIAL_BLOCK.get()) {
					if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG >= 1000) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.BREEZE_UNIT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.moneyIG = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG - 1000;
							_vars.breeze_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).breeze_spawned + 1;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CLOUD, x, (y + 1), z, 100, 0, 0, 0, 0.1);
						{
							final Vec3 _center = new Vec3(x, (y + 1), z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								entityiterator.getPersistentData().putDouble("unitLevel",
										(CraftDefenseModVariables.MapVariables.get(world).challenge == 4
												? 1
												: (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")));
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								entityiterator.getPersistentData().putString("owner", (entity.getStringUUID()));
								entityiterator.getPersistentData().putString("attackType", "circleAOE");
								entityiterator.getPersistentData().putDouble("aoeRange", 1.5);
								entity.getPersistentData().putString("ownerOf", (entityiterator.getStringUUID()));
								entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString() + "'s " + entityiterator.getDisplayName().getString())));
								entityiterator.getPersistentData().putDouble("damageBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("damageBuff")));
								entityiterator.getPersistentData().putDouble("rangeBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rangeBuff")));
								entityiterator.getPersistentData().putDouble("spaBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("spaBuff")));
								entityiterator.getPersistentData().putString("trait",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("traitText")));
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("evo")) {
									entityiterator.getPersistentData().putBoolean("evo", true);
									entityiterator.getPersistentData().putDouble("maxLevel", 9);
								}
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You don't have enough money!\",\"color\":\"red\"}");
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
							}
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You can't place this unit on ground!\",\"color\":\"red\"}");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
						}
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You have reached max placements for this unit!\",\"color\":\"red\"}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CraftDefenseModItems.BOGGED_UNIT_ITEM.get()) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).bogged_spawned < (CraftDefenseModVariables.MapVariables.get(world).challenge == 5 ? 1 : 4)) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == CraftDefenseModBlocks.AERIAL_BLOCK.get()) {
					if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG >= 1000) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.BOGGED_UNIT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.moneyIG = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG - 1000;
							_vars.bogged_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).bogged_spawned + 1;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CLOUD, x, (y + 1), z, 100, 0, 0, 0, 0.1);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ITEM_SLIME, x, (y + 1), z, 100, 0, 0, 0, 0.1);
						{
							final Vec3 _center = new Vec3(x, (y + 1), z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								entityiterator.getPersistentData().putDouble("unitLevel",
										(CraftDefenseModVariables.MapVariables.get(world).challenge == 4
												? 1
												: (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")));
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								entityiterator.getPersistentData().putString("owner", (entity.getStringUUID()));
								entity.getPersistentData().putString("ownerOf", (entityiterator.getStringUUID()));
								entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString() + "'s " + entityiterator.getDisplayName().getString())));
								entityiterator.getPersistentData().putDouble("damageBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("damageBuff")));
								entityiterator.getPersistentData().putDouble("rangeBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rangeBuff")));
								entityiterator.getPersistentData().putDouble("spaBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("spaBuff")));
								entityiterator.getPersistentData().putString("trait",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("traitText")));
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("evo")) {
									entityiterator.getPersistentData().putBoolean("evo", true);
									entityiterator.getPersistentData().putDouble("maxLevel", 9);
								}
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You don't have enough money!\",\"color\":\"red\"}");
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
							}
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You can't place this unit on ground!\",\"color\":\"red\"}");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
						}
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You have reached max placements for this unit!\",\"color\":\"red\"}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CraftDefenseModItems.SNOW_GOLEM_UNIT_ITEM.get()) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).snowgolem_spawned < (CraftDefenseModVariables.MapVariables.get(world).challenge == 5 ? 1 : 4)) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == CraftDefenseModBlocks.AERIAL_BLOCK.get()) {
					if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG >= 1000) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.SNOW_GOLEM_UNIT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.moneyIG = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG - 1000;
							_vars.snowgolem_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).snowgolem_spawned + 1;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CLOUD, x, (y + 1), z, 100, 0, 0, 0, 0.1);
						{
							final Vec3 _center = new Vec3(x, (y + 1), z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								entityiterator.getPersistentData().putDouble("unitLevel",
										(CraftDefenseModVariables.MapVariables.get(world).challenge == 4
												? 1
												: (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")));
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								entityiterator.getPersistentData().putString("owner", (entity.getStringUUID()));
								entity.getPersistentData().putString("ownerOf", (entityiterator.getStringUUID()));
								entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString() + "'s " + entityiterator.getDisplayName().getString())));
								entityiterator.getPersistentData().putDouble("damageBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("damageBuff")));
								entityiterator.getPersistentData().putDouble("rangeBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rangeBuff")));
								entityiterator.getPersistentData().putDouble("spaBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("spaBuff")));
								entityiterator.getPersistentData().putString("trait",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("traitText")));
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("evo")) {
									entityiterator.getPersistentData().putBoolean("evo", true);
									entityiterator.getPersistentData().putDouble("maxLevel", 9);
								}
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You don't have enough money!\",\"color\":\"red\"}");
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
							}
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You can't place this unit on ground!\",\"color\":\"red\"}");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
						}
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You have reached max placements for this unit!\",\"color\":\"red\"}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CraftDefenseModItems.RAVAGER_UNIT_ITEM.get()) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).ravager_spawned < (CraftDefenseModVariables.MapVariables.get(world).challenge == 5 ? 1 : 4)) {
				if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == CraftDefenseModBlocks.AERIAL_BLOCK.get())) {
					if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG >= 1000) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.RAVAGER_UNIT.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.moneyIG = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG - 1000;
							_vars.ravager_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).ravager_spawned + 1;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CLOUD, x, (y + 1), z, 100, 0, 0, 0, 0.1);
						{
							final Vec3 _center = new Vec3(x, (y + 1), z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								entityiterator.getPersistentData().putDouble("unitLevel",
										(CraftDefenseModVariables.MapVariables.get(world).challenge == 4
												? 1
												: (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")));
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								entityiterator.getPersistentData().putString("owner", (entity.getStringUUID()));
								entity.getPersistentData().putString("ownerOf", (entityiterator.getStringUUID()));
								entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString() + "'s " + entityiterator.getDisplayName().getString())));
								entityiterator.getPersistentData().putDouble("damageBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("damageBuff")));
								entityiterator.getPersistentData().putDouble("rangeBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rangeBuff")));
								entityiterator.getPersistentData().putDouble("spaBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("spaBuff")));
								entityiterator.getPersistentData().putString("trait",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("traitText")));
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("evo")) {
									entityiterator.getPersistentData().putBoolean("evo", true);
									entityiterator.getPersistentData().putDouble("maxLevel", 9);
								}
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You don't have enough money!\",\"color\":\"red\"}");
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
							}
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You can only place this unit on ground!\",\"color\":\"red\"}");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
						}
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You have reached max placements for this unit!\",\"color\":\"red\"}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CraftDefenseModItems.POLAR_BEAR_UNIT_ITEM.get()) {
			if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).polarbear_spawned < (CraftDefenseModVariables.MapVariables.get(world).challenge == 5 ? 1 : 4)) {
				if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == CraftDefenseModBlocks.AERIAL_BLOCK.get())) {
					if (entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG >= 1000) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CraftDefenseModEntities.POLAR_BEAR_UNIT.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						{
							CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
							_vars.moneyIG = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG - 1000;
							_vars.polarbear_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).polarbear_spawned + 1;
							_vars.markSyncDirty();
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CLOUD, x, (y + 1), z, 100, 0, 0, 0, 0.1);
						{
							final Vec3 _center = new Vec3(x, (y + 1), z);
							for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
								entityiterator.getPersistentData().putDouble("unitLevel",
										(CraftDefenseModVariables.MapVariables.get(world).challenge == 4
												? 1
												: (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("level")));
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
								entityiterator.getPersistentData().putString("owner", (entity.getStringUUID()));
								entity.getPersistentData().putString("ownerOf", (entityiterator.getStringUUID()));
								entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString() + "'s " + entityiterator.getDisplayName().getString())));
								entityiterator.getPersistentData().putDouble("damageBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("damageBuff")));
								entityiterator.getPersistentData().putDouble("rangeBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("rangeBuff")));
								entityiterator.getPersistentData().putDouble("spaBuff",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("spaBuff")));
								entityiterator.getPersistentData().putString("trait",
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("traitText")));
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("evo")) {
									entityiterator.getPersistentData().putBoolean("evo", true);
									entityiterator.getPersistentData().putDouble("maxLevel", 9);
								}
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You don't have enough money!\",\"color\":\"red\"}");
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
							}
						}
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You can only place this unit on ground!\",\"color\":\"red\"}");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
						}
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"ERROR: You have reached max placements for this unit!\",\"color\":\"red\"}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.bass master @s");
					}
				}
			}
		}
	}
}