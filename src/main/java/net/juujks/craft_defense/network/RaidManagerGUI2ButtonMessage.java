package net.juujks.craft_defense.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.juujks.craft_defense.procedures.DiscordButtonProcedure;
import net.juujks.craft_defense.CraftDefenseMod;

@EventBusSubscriber
public record RaidManagerGUI2ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<RaidManagerGUI2ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CraftDefenseMod.MODID, "raid_manager_gui_2_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, RaidManagerGUI2ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, RaidManagerGUI2ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new RaidManagerGUI2ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<RaidManagerGUI2ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final RaidManagerGUI2ButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			DiscordButtonProcedure.execute();
		}

		guiTools$enhancedImageButton : {
			if (buttonID == 1) {
				net.juujks.craft_defense.procedures.StartRaidButtonPProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 2) {
				net.juujks.craft_defense.procedures.A100PProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 3) {
				net.juujks.craft_defense.procedures.A100PProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 4) {
				net.juujks.craft_defense.procedures.A100PProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 5) {
				net.juujks.craft_defense.procedures.BR1PProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 6) {
				net.juujks.craft_defense.procedures.E1PProcedure.execute(world, x, y, z, entity);
			}
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CraftDefenseMod.addNetworkMessage(RaidManagerGUI2ButtonMessage.TYPE, RaidManagerGUI2ButtonMessage.STREAM_CODEC, RaidManagerGUI2ButtonMessage::handleData);
	}
}