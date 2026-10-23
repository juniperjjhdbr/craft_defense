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

import net.juujks.craft_defense.procedures.RerollTraitProcedureProcedure;
import net.juujks.craft_defense.procedures.LockSPAPProcedure;
import net.juujks.craft_defense.procedures.LockRNGPProcedure;
import net.juujks.craft_defense.procedures.LockDMGPProcedure;
import net.juujks.craft_defense.CraftDefenseMod;

@EventBusSubscriber
public record TraitRerollerGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<TraitRerollerGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CraftDefenseMod.MODID, "trait_reroller_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TraitRerollerGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TraitRerollerGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new TraitRerollerGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TraitRerollerGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final TraitRerollerGUIButtonMessage message, final IPayloadContext context) {
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

			RerollTraitProcedureProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			LockDMGPProcedure.execute(entity);
		}
		if (buttonID == 2) {

			LockRNGPProcedure.execute(entity);
		}
		if (buttonID == 3) {

			LockSPAPProcedure.execute(entity);
		}
		if (buttonID == 4) {

			LockDMGPProcedure.execute(entity);
		}
		if (buttonID == 5) {

			LockRNGPProcedure.execute(entity);
		}
		if (buttonID == 6) {

			LockSPAPProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CraftDefenseMod.addNetworkMessage(TraitRerollerGUIButtonMessage.TYPE, TraitRerollerGUIButtonMessage.STREAM_CODEC, TraitRerollerGUIButtonMessage::handleData);
	}
}