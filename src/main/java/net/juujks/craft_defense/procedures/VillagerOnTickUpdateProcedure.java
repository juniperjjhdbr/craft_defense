package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.entity.VillagerUnitEntity;
import net.juujks.craft_defense.CraftDefenseMod;

import java.util.ArrayList;

public class VillagerOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String ownerOfText = "";
		Entity playerToGive = null;
		entity.getPersistentData().putBoolean("unit", true);
		if (entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.SCALE))
			_livingEntity1.getAttribute(Attributes.SCALE).setBaseValue(0.5);
		ownerOfText = entity.getPersistentData().getString("owner");
		if (!(ownerOfText).equals("")) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((ownerOfText).equals(entityiterator.getStringUUID())) {
					playerToGive = entityiterator;
				}
			}
		}
		ShowEntityTestProcedure.execute(world, x, y, z, entity);
		UpVillagerProcedure.execute(entity);
		if (CraftDefenseModVariables.MapVariables.get(world).farmerVar) {
			if (playerToGive instanceof Player) {
				if (!entity.getPersistentData().getBoolean("moneyReward")) {
					{
						CraftDefenseModVariables.PlayerVariables _vars = playerToGive.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
						_vars.moneyIG = playerToGive.getData(CraftDefenseModVariables.PLAYER_VARIABLES).moneyIG + entity.getPersistentData().getDouble("money");
						_vars.markSyncDirty();
					}
					if (entity instanceof VillagerUnitEntity) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.celebrate")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.celebrate")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.piglin.celebrate")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.piglin.celebrate")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
					entity.getPersistentData().putBoolean("moneyReward", true);
					CraftDefenseMod.queueServerWork(1, () -> {
						entity.getPersistentData().putBoolean("moneyReward", false);
					});
				}
				CraftDefenseMod.queueServerWork(1, () -> {
					CraftDefenseModVariables.MapVariables.get(world).farmerVar = false;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				});
			}
		}
	}
}