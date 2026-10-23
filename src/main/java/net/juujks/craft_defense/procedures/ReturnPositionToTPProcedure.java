package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class ReturnPositionToTPProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		return "Create orange portal at Y: " + new java.text.DecimalFormat("##").format(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "positionToTP"));
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}