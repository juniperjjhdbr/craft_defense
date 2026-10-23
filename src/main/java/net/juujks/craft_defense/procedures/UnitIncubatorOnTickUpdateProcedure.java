package net.juujks.craft_defense.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class UnitIncubatorOnTickUpdateProcedure {

	public static void execute(LevelAccessor world, double x, double y, double z) {

		BlockPos pos = BlockPos.containing(x, y, z);

		// pega block entity
		if (world.getBlockEntity(pos) == null)
			return;

		// pega item do slot 0
		ItemStack stack = getItemStack(world, pos, 0);

		if (stack.isEmpty())
			return;

		// pega level do item
		double level = stack
				.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY)
				.copyTag()
				.getDouble("level");

		// verifica se level > 0
		if (level > 0) {

			// incrementa direto no bloco
			double cooldown = world.getBlockEntity(pos)
					.getPersistentData()
					.getDouble("xpCooldown");

			cooldown++;

			world.getBlockEntity(pos)
					.getPersistentData()
					.putDouble("xpCooldown", cooldown);

			// verifica cooldown
			if (cooldown >= 20) {

				double xp = stack
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY)
						.copyTag()
						.getDouble("xp");

				double totalXpGained = stack
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY)
						.copyTag()
						.getDouble("totalXpGained");

				CustomData.update(
						DataComponents.CUSTOM_DATA,
						stack,
						tag -> {
							tag.putDouble("xp", xp + 2);
							tag.putDouble("totalXpGained", totalXpGained + 2);
						}
				);

				world.getBlockEntity(pos).setChanged();

				// reseta
				world.getBlockEntity(pos)
						.getPersistentData()
						.putDouble("xpCooldown", 0);
			}
		}
	}

	private static ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {

		if (world instanceof ILevelExtension ext) {

			IItemHandler itemHandler =
					ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);

			if (itemHandler != null)
				return itemHandler.getStackInSlot(slotid);
		}

		return ItemStack.EMPTY;
	}
}