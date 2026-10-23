package net.juujks.craft_defense.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.entity.*;

import java.util.Comparator;

public class SellUnitPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String texto = "";
		Entity entidade = null;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if ((entity.getPersistentData().getString("guiOpenedOf")).equals(entityiterator.getStringUUID())) {
					if (CraftDefenseModVariables.MapVariables.get(world).challenge != 2) {
						if (entity instanceof Player _player)
							_player.closeContainer();
						entidade = entityiterator;
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7cERROR: You can not sell a unit in this challenge!"), false);
					}
				}
			}
		}
		if (entidade.isAlive()) {
			if (entidade instanceof SteveEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.steve_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).steve_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof AlexEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.alex_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).alex_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof CreeperUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.creeper_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).creeper_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof SkeletonUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.skeleton_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).skeleton_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof SlimeUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.slime_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).slime_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof SpiderUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.spider_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).spider_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof VillagerUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.villager_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).villager_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof WitchUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.witch_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).witch_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof ZombieUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.zombie_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).zombie_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof CaveSpiderUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.cavespider_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).cavespider_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof StrayUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.stray_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).stray_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof ZombifiedPiglinUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.zombiepig_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).zombiepig_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof PiglinUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.piglin_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).piglin_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof PufferfishUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.puffer_fish_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).puffer_fish_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof IronGolemUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.iron_golem_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).iron_golem_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof SnowGolemUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.snowgolem_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).snowgolem_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof HuskUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.husk_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).husk_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof MagmaCubeUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.magmacube_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).magmacube_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof PolarBearUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.polarbear_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).polarbear_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof ChargedCreeperUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.charged_creeper_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).charged_creeper_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof RavagerUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.ravager_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).ravager_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof EndermanUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.enderman_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).enderman_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof BreezeUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.breeze_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).breeze_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof WolfUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.wolf_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).wolf_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof PillagerUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.pillager_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).pillager_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof BlazeUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.blaze_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).blaze_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof BoggedUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.bogged_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).bogged_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof DrownedUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.drowned_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).drowned_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			if (entidade instanceof FrostbiteUnitEntity) {
				{
					CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
					_vars.frostbite_spawned = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).frostbite_spawned - 1;
					_vars.markSyncDirty();
				}
			}
			entidade.getPersistentData().putBoolean("hasAoeMarker", false);
			entidade.getPersistentData().putBoolean("hasRangeMarker", false);
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if ((entityiterator.getPersistentData().getString("ownerUUID")).equals(entidade.getStringUUID())) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
				}
			}
			if (!entidade.level().isClientSide())
				entidade.discard();
			{
				CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
				_vars.moneyIG = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG + Math.round(entidade.getPersistentData().getDouble("upCost") / 4);
				_vars.markSyncDirty();
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7aUnit selled sucessfully"), false);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound minecraft:block.note_block.pling master @s ~ ~ ~ 1 0");
				}
			}
		}
	}
}