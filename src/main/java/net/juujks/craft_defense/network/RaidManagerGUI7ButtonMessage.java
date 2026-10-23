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

import net.juujks.craft_defense.procedures.*;
import net.juujks.craft_defense.CraftDefenseMod;

@EventBusSubscriber
public record RaidManagerGUI7ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<RaidManagerGUI7ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CraftDefenseMod.MODID, "raid_manager_gui_7_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, RaidManagerGUI7ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, RaidManagerGUI7ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new RaidManagerGUI7ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<RaidManagerGUI7ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final RaidManagerGUI7ButtonMessage message, final IPayloadContext context) {
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

			StartRaidButtonPProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			A21PProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			A22PProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			A23PProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			A24PProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			A25PProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			H9PProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CraftDefenseMod.addNetworkMessage(RaidManagerGUI7ButtonMessage.TYPE, RaidManagerGUI7ButtonMessage.STREAM_CODEC, RaidManagerGUI7ButtonMessage::handleData);
	}
}