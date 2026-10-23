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

import net.juujks.craft_defense.procedures.StartButtonPProcedure;
import net.juujks.craft_defense.procedures.ShareButtonProcedure;
import net.juujks.craft_defense.procedures.ClaimButtonProcedure;
import net.juujks.craft_defense.CraftDefenseMod;

@EventBusSubscriber
public record QueueGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<QueueGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CraftDefenseMod.MODID, "queue_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, QueueGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, QueueGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new QueueGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<QueueGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final QueueGUIButtonMessage message, final IPayloadContext context) {
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

			StartButtonPProcedure.execute(world, entity);
		}
		if (buttonID == 1) {

			ClaimButtonProcedure.execute(entity);
		}
		if (buttonID == 2) {

			ShareButtonProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CraftDefenseMod.addNetworkMessage(QueueGUIButtonMessage.TYPE, QueueGUIButtonMessage.STREAM_CODEC, QueueGUIButtonMessage::handleData);
	}
}