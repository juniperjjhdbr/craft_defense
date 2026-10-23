package net.juujks.craft_defense.block.listener;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.entity.BlockEntityType;

import net.juujks.craft_defense.init.CraftDefenseModBlockEntities;
import net.juujks.craft_defense.block.renderer.OrangePortalTileRenderer;
import net.juujks.craft_defense.block.renderer.BluePortalTileRenderer;
import net.juujks.craft_defense.block.entity.OrangePortalTileEntity;
import net.juujks.craft_defense.block.entity.BluePortalTileEntity;
import net.juujks.craft_defense.CraftDefenseMod;

@EventBusSubscriber(modid = CraftDefenseMod.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer((BlockEntityType<BluePortalTileEntity>) CraftDefenseModBlockEntities.BLUE_PORTAL.get(), context -> new BluePortalTileRenderer());
		event.registerBlockEntityRenderer((BlockEntityType<OrangePortalTileEntity>) CraftDefenseModBlockEntities.ORANGE_PORTAL.get(), context -> new OrangePortalTileRenderer());
	}
}