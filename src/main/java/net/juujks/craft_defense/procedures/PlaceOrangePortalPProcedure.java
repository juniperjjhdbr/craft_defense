package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.juujks.craft_defense.init.CraftDefenseModBlocks;

public class PlaceOrangePortalPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "positionToTP"), z), CraftDefenseModBlocks.ORANGE_PORTAL.get().defaultBlockState(), 3);
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}