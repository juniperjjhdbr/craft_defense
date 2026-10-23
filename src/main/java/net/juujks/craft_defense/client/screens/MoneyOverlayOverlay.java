package net.juujks.craft_defense.client.screens;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.juujks.craft_defense.procedures.*;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber(Dist.CLIENT)
public class MoneyOverlayOverlay {
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/shield3.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("craft_defense:textures/screens/shield_bar1.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("craft_defense:textures/screens/shield_bar2.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("craft_defense:textures/screens/shield_bar3.png");

	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			if (ShieldBarP1Procedure.execute(world)) {
				event.getGuiGraphics().blit(IMAGE_0, w - 80, h - 49, 0, 0, 48, 16, 48, 16);
			}
			if (ShieldBarP2Procedure.execute(world)) {
				event.getGuiGraphics().blit(IMAGE_1, w - 80, h - 49, 0, 0, 48, 16, 48, 16);
			}
			if (ShieldBarP3Procedure.execute(world)) {
				event.getGuiGraphics().blit(IMAGE_2, w - 80, h - 49, 0, 0, 48, 16, 48, 16);
			}
			if (ShieldBarP4Procedure.execute(world)) {
				event.getGuiGraphics().blit(IMAGE_3, w - 80, h - 49, 0, 0, 48, 16, 48, 16);
			}
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					MoneyShowOverlayProcedure.execute(world, entity), w - 80, h - 33, -16711936, true);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					WaveShowOverlayProcedure.execute(world), w - 80, h - 22, -1, true);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D2Procedure.execute(world), 2, -1, -1, false);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D1Procedure.execute(world), 2, 8, -1, false);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D3Procedure.execute(world), 2, 17, -1, false);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D4Procedure.execute(world), 2, 26, -1, false);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D5Procedure.execute(world), 2, 35, -1, false);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D6Procedure.execute(entity), 2, 44, -1, false);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D7Procedure.execute(world), 2, 53, -1, false);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D8Procedure.execute(entity), 2, 62, -1, false);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D9Procedure.execute(entity), 2, 71, -1, false);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D10Procedure.execute(entity), 2, 80, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnSpeedProcedure.execute(world, entity), w - 80, h - 11, -1, true);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D11Procedure.execute(world), 2, 89, -1, false);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnDiffProcedure.execute(world), 2, 98, -1, false);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnMapPProcedure.execute(world), w - 92, 5, -1, true);
			if (X1Procedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnAliveEnemiesProcedure.execute(world), w - 92, 14, -1, true);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}