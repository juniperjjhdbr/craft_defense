package net.juujks.craft_defense.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.juujks.craft_defense.network.CraftDefenseModVariables;

import java.util.ArrayList;

public class ShareButtonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity ownerOfRaid = null;
		if (CraftDefenseModVariables.MapVariables.get(world).shareCooldown == 0) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((entityiterator.getDisplayName().getString()).equals(CraftDefenseModVariables.MapVariables.get(world).ownerOfRaid)) {
					ownerOfRaid = entityiterator;
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
					CraftDefenseModVariables.MapVariables.get(world).shareCooldown = 200;
					CraftDefenseModVariables.MapVariables.get(world).markSyncDirty();
				}
			}
		}
	}
}