package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.init.CraftDefenseModBlocks;

public class EndEnemySysProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == CraftDefenseModBlocks.END_TOWER.get()) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("shield", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "shield") + 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			CraftDefenseModVariables.MapVariables.get(world).shield = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "shield");
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			if (entity.getPersistentData().getDouble("boss") == 1) {
				CraftDefenseModVariables.MapVariables.get(world).gameLost = true;
				CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
			}
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.break_block")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.break_block")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			CraftDefenseModVariables.MapVariables.get(world).enemiesKilled = CraftDefenseModVariables.MapVariables.get(world).enemiesKilled + 1;
			CraftDefenseModVariables.MapVariables.get(world).aliveEnemies = CraftDefenseModVariables.MapVariables.get(world).aliveEnemies - 1;
			CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == CraftDefenseModBlocks.BLUE_PORTAL.get()) {
			{
				Entity _ent = entity;
				double _tx = x;
				double _ty = (y + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "positionToTP"));
				double _tz = z;
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}