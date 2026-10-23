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

import net.juujks.craft_defense.procedures.FreeUnitP3Procedure;
import net.juujks.craft_defense.procedures.FreeUnitP2Procedure;
import net.juujks.craft_defense.procedures.FreeUnitP1Procedure;
import net.juujks.craft_defense.CraftDefenseMod;

@EventBusSubscriber
public record FreeUnitsGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<FreeUnitsGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CraftDefenseMod.MODID, "free_units_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FreeUnitsGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, FreeUnitsGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new FreeUnitsGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<FreeUnitsGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final FreeUnitsGUIButtonMessage message, final IPayloadContext context) {
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

			FreeUnitP1Procedure.execute(entity);
		}
		if (buttonID == 1) {

			FreeUnitP2Procedure.execute(entity);
		}
		if (buttonID == 2) {

			FreeUnitP3Procedure.execute(entity);
		}
		if (buttonID == 3) {

			FreeUnitP1Procedure.execute(entity);
		}
		if (buttonID == 4) {

			FreeUnitP2Procedure.execute(entity);
		}
		if (buttonID == 5) {

			FreeUnitP3Procedure.execute(entity);
		}
		if (buttonID == 6) {

			FreeUnitP1Procedure.execute(entity);
		}
		if (buttonID == 7) {

			FreeUnitP2Procedure.execute(entity);
		}
		if (buttonID == 8) {

			FreeUnitP3Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CraftDefenseMod.addNetworkMessage(FreeUnitsGUIButtonMessage.TYPE, FreeUnitsGUIButtonMessage.STREAM_CODEC, FreeUnitsGUIButtonMessage::handleData);
	}
}