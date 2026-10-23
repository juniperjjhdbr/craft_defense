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
public record ChallengesGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<ChallengesGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CraftDefenseMod.MODID, "challenges_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ChallengesGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ChallengesGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ChallengesGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<ChallengesGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ChallengesGUIButtonMessage message, final IPayloadContext context) {
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

			D1PProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			D2PProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			D6PProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			D7PProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			D3PProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			D5PProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			D4PProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CraftDefenseMod.addNetworkMessage(ChallengesGUIButtonMessage.TYPE, ChallengesGUIButtonMessage.STREAM_CODEC, ChallengesGUIButtonMessage::handleData);
	}
}