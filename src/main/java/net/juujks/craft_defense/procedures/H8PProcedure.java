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

import net.juujks.craft_defense.world.inventory.QueueGUIMenu;
import net.juujks.craft_defense.network.CraftDefenseModVariables;

import io.netty.buffer.Unpooled;

public class H8PProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity ownerOfRaid = null;
		CraftDefenseModVariables.MapVariables.get(world).map = "Plains Village - \u00A7l\u00A7d(Insane Mode)";
		CraftDefenseModVariables.MapVariables.get(world).act = 20;
		CraftDefenseModVariables.MapVariables.get(world).difficulty = 7;
		CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		{
			CraftDefenseModVariables.PlayerVariables _vars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
			_vars.isInQueue = true;
			_vars.markSyncDirty();
		}
		CraftDefenseModVariables.MapVariables.get(world).playersInQueue = CraftDefenseModVariables.MapVariables.get(world).playersInQueue + 1;
		CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			_ent.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("QueueGUI");
				}

				@Override
				public boolean shouldTriggerClientSideContainerClosingOnOpen() {
					return false;
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new QueueGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
		if (CraftDefenseModVariables.MapVariables.get(world).playersInQueue == 1) {
			ownerOfRaid = entity;
			{
				Entity _ent = ownerOfRaid;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							"/tellraw @a [\"\",{\"text\":\"[Craft Defense]: \",\"bold\":true,\"color\":\"green\"},{\"selector\":\"@s\"},{\"text\":\" is starting a new raid. \"},{\"text\":\"[Click Here]\",\"bold\":true,\"underlined\":true,\"color\":\"aqua\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/craft_defense join_queue\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":[{\"text\":\"Click to join!\"}]}},{\"text\":\" to join!\"}]");
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.iron_xylophone")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.note_block.iron_xylophone")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}