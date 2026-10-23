package net.juujks.craft_defense.network;

import net.juujks.craft_defense.cdmap.CdmapEntry;
import net.juujks.craft_defense.cdmap.CdmapIndex;
import net.juujks.craft_defense.network.CraftDefenseModVariables;
import net.juujks.craft_defense.world.inventory.QueueGUIMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import io.netty.buffer.Unpooled;

public record LoadCustomMapMessage(int mapId, int blockX, int blockY, int blockZ) implements CustomPacketPayload {

    public static final Type<LoadCustomMapMessage> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("craft_defense", "load_custom_map"));

    public static final StreamCodec<RegistryFriendlyByteBuf, LoadCustomMapMessage> STREAM_CODEC =
            StreamCodec.of(
                    (buf, msg) -> {
                        buf.writeInt(msg.mapId());
                        buf.writeInt(msg.blockX());
                        buf.writeInt(msg.blockY());
                        buf.writeInt(msg.blockZ());
                    },
                    buf -> new LoadCustomMapMessage(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt())
            );

    @Override
    public Type<LoadCustomMapMessage> type() { return TYPE; }

    public static void handle(final LoadCustomMapMessage msg, final IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            ServerPlayer entity = (ServerPlayer) ctx.player();
            var world = entity.serverLevel();

            // Busca o mapa no índice
            CdmapEntry entry = CdmapIndex.loadIndex().stream()
                    .filter(e -> e.getId() == msg.mapId())
                    .findFirst().orElse(null);

            if (entry == null) {
                entity.displayClientMessage(
                        Component.literal("§cCustom map not found!"), false);
                return;
            }

            // Seta as variáveis do mapa — igual ao A6PProcedure
            var mapVars = CraftDefenseModVariables.MapVariables.get(world);
            mapVars.map = entry.getName() + " (Custom)";
            mapVars.markSyncDirty();
            mapVars.act = entry.getAct();
            mapVars.markSyncDirty();
            mapVars.customMapId = entry.getId();
            mapVars.markSyncDirty();

            // Adiciona o jogador à queue — igual ao JoinQueuePProcedure
            var playerVars = entity.getData(CraftDefenseModVariables.PLAYER_VARIABLES);
            playerVars.isInQueue = true;
            playerVars.markSyncDirty();

            mapVars.playersInQueue = mapVars.playersInQueue + 1;
            mapVars.markSyncDirty();

            // Abre a QueueGUI — igual ao padrão
            BlockPos bpos = new BlockPos(msg.blockX(), msg.blockY(), msg.blockZ());
            entity.openMenu(new MenuProvider() {
                @Override
                public Component getDisplayName() { return Component.literal("QueueGUI"); }

                @Override
                public boolean shouldTriggerClientSideContainerClosingOnOpen() { return false; }

                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    return new QueueGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(bpos));
                }
            }, bpos);
        });
    }
}