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
public record CandyGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<CandyGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CraftDefenseMod.MODID, "candy_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, CandyGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, CandyGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new CandyGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<CandyGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final CandyGUIButtonMessage message, final IPayloadContext context) {
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

			MaxAllPProcedure.execute(world, entity);
		}
		if (buttonID == 1) {

			ConfirmButtonPProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			MoreCommonButtonProcedure.execute(world, entity);
		}
		if (buttonID == 3) {

			LessCommonButtonProcedure.execute(world, entity);
		}
		if (buttonID == 4) {

			MoreRareButtonProcedure.execute(world, entity);
		}
		if (buttonID == 5) {

			LessRareButtonProcedure.execute(world, entity);
		}
		if (buttonID == 6) {

			MoreEpicButtonProcedure.execute(world, entity);
		}
		if (buttonID == 7) {

			LessEpicButtonProcedure.execute(world, entity);
		}
		if (buttonID == 8) {

			MoreLegendaryButtonProcedure.execute(world, entity);
		}
		if (buttonID == 9) {

			LessLegendaryButtonProcedure.execute(world, entity);
		}
		if (buttonID == 10) {

			ResetButtonPProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CraftDefenseMod.addNetworkMessage(CandyGUIButtonMessage.TYPE, CandyGUIButtonMessage.STREAM_CODEC, CandyGUIButtonMessage::handleData);
	}
}