package net.juujks.craft_defense.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record EditCustomMapMessage(int challenge, int difficulty) implements CustomPacketPayload {

    public static final Type<EditCustomMapMessage> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("craft_defense", "edit_custom_map"));

    public static final StreamCodec<RegistryFriendlyByteBuf, EditCustomMapMessage> STREAM_CODEC =
            StreamCodec.of(
                    (buf, msg) -> { buf.writeInt(msg.challenge()); buf.writeInt(msg.difficulty()); },
                    buf -> new EditCustomMapMessage(buf.readInt(), buf.readInt())
            );

    @Override
    public Type<EditCustomMapMessage> type() { return TYPE; }

    public static void handle(final EditCustomMapMessage msg, final IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            ServerPlayer player = (ServerPlayer) ctx.player();
            var world = player.serverLevel();
            var mapVars = CraftDefenseModVariables.MapVariables.get(world);

            mapVars.challenge = msg.challenge();
            mapVars.markSyncDirty();
            mapVars.difficulty = msg.difficulty();
            mapVars.markSyncDirty();
        });
    }
}