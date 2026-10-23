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

import net.juujks.craft_defense.procedures.Remove1ButtonProcedure;
import net.juujks.craft_defense.procedures.PlaceOrangePortalPProcedure;
import net.juujks.craft_defense.procedures.Add1ButtonProcedure;
import net.juujks.craft_defense.CraftDefenseMod;

@EventBusSubscriber
public record BluePortalGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<BluePortalGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CraftDefenseMod.MODID, "blue_portal_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, BluePortalGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, BluePortalGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new BluePortalGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<BluePortalGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final BluePortalGUIButtonMessage message, final IPayloadContext context) {
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

			Add1ButtonProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			Remove1ButtonProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			PlaceOrangePortalPProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CraftDefenseMod.addNetworkMessage(BluePortalGUIButtonMessage.TYPE, BluePortalGUIButtonMessage.STREAM_CODEC, BluePortalGUIButtonMessage::handleData);
	}
}