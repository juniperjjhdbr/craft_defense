package net.juujks.craft_defense.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.juujks.craft_defense.world.inventory.QueueGUIMenu;
import net.juujks.craft_defense.procedures.*;
import net.juujks.craft_defense.network.QueueGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class QueueGUIScreen extends AbstractContainerScreen<QueueGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_play;
	private ImageButton imagebutton_cancel;
	private ImageButton imagebutton_share;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/queue1.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("craft_defense:textures/screens/eba3.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("craft_defense:textures/screens/1star.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("craft_defense:textures/screens/act22u.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("craft_defense:textures/screens/2star.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("craft_defense:textures/screens/act3u.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("craft_defense:textures/screens/3star.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("craft_defense:textures/screens/4star.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("craft_defense:textures/screens/5star.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("craft_defense:textures/screens/10star.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("craft_defense:textures/screens/inf2u.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("craft_defense:textures/screens/act12u.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("craft_defense:textures/screens/act4u.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("craft_defense:textures/screens/act5u.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("craft_defense:textures/screens/act6u.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("craft_defense:textures/screens/6star.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("craft_defense:textures/screens/10star.png");
	private static final ResourceLocation IMAGE_17 = ResourceLocation.parse("craft_defense:textures/screens/bru.png");
	private static final ResourceLocation IMAGE_18 = ResourceLocation.parse("craft_defense:textures/screens/eu.png");

	public QueueGUIScreen(QueueGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 464;
		this.imageHeight = 261;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (ReturnNotEditingPProcedure.execute(entity))
			if (mouseX > leftPos + 191 && mouseX < leftPos + 215 && mouseY > topPos + 171 && mouseY < topPos + 195) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.queue_gui.tooltip_start"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (ReturnNotEditingPProcedure.execute(entity))
			if (mouseX > leftPos + 222 && mouseX < leftPos + 246 && mouseY > topPos + 171 && mouseY < topPos + 195) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.queue_gui.tooltip_cancel"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (ReturnNotEditingPProcedure.execute(entity))
			if (mouseX > leftPos + 254 && mouseX < leftPos + 278 && mouseY > topPos + 171 && mouseY < topPos + 195) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.queue_gui.tooltip_share_in_chat"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + 2, this.topPos + 9, 0, 0, 464, 261, 464, 261);
		guiGraphics.blit(IMAGE_1, this.leftPos + 321, this.topPos + 95, 0, 0, 90, 90, 90, 90);
		if (W1RProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 326, this.topPos + 117, 0, 0, 80, 16, 80, 16);
		}
		if (W2RProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + 335, this.topPos + 140, 0, 0, 64, 36, 64, 36);
		}
		if (W2RProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_4, this.leftPos + 326, this.topPos + 117, 0, 0, 80, 16, 80, 16);
		}
		if (W3RProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_5, this.leftPos + 335, this.topPos + 140, 0, 0, 64, 36, 64, 36);
		}
		if (W3RProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_6, this.leftPos + 326, this.topPos + 117, 0, 0, 80, 16, 80, 16);
		}
		if (W4RProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_7, this.leftPos + 326, this.topPos + 117, 0, 0, 80, 16, 80, 16);
		}
		if (W5RProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_8, this.leftPos + 326, this.topPos + 117, 0, 0, 80, 16, 80, 16);
		}
		if (WInfRProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_9, this.leftPos + 326, this.topPos + 117, 0, 0, 80, 16, 80, 16);
		}
		if (WInfRProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_10, this.leftPos + 335, this.topPos + 140, 0, 0, 64, 36, 64, 36);
		}
		if (W1RProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_11, this.leftPos + 335, this.topPos + 140, 0, 0, 64, 36, 64, 36);
		}
		if (W4RProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_12, this.leftPos + 335, this.topPos + 140, 0, 0, 64, 36, 64, 36);
		}
		if (W5RProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_13, this.leftPos + 335, this.topPos + 140, 0, 0, 64, 36, 64, 36);
		}
		if (W6RProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_14, this.leftPos + 335, this.topPos + 140, 0, 0, 64, 36, 64, 36);
		}
		if (W6RProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_15, this.leftPos + 326, this.topPos + 117, 0, 0, 80, 16, 80, 16);
		}
		if (WBR1Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_16, this.leftPos + 326, this.topPos + 117, 0, 0, 80, 16, 80, 16);
		}
		if (WBR1Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_17, this.leftPos + 335, this.topPos + 140, 0, 0, 64, 36, 64, 36);
		}
		if (WE1Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_18, this.leftPos + 335, this.topPos + 140, 0, 0, 64, 36, 64, 36);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (ReturnNotEditingPProcedure.execute(entity))
			guiGraphics.drawString(this.font, ReturnQueuePlayersProcedure.execute(world), 159, 131, -1, false);
		if (ReturnNotEditingPProcedure.execute(entity))
			guiGraphics.drawString(this.font, ReturnVotesToStartProcedure.execute(world), 159, 158, -10027162, false);
		if (ReturnNotEditingPProcedure.execute(entity))
			guiGraphics.drawString(this.font, ReturnMapPProcedure.execute(world), 159, 144, -256, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.queue_gui.label_difficulty"), 339, 104, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_play = new ImageButton(this.leftPos + 191, this.topPos + 171, 24, 24, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/play.png"), ResourceLocation.parse("craft_defense:textures/screens/playh.png")), e -> {
			int x = QueueGUIScreen.this.x;
			int y = QueueGUIScreen.this.y;
			if (ReturnNotEditingPProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new QueueGUIButtonMessage(0, x, y, z));
				QueueGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_play);
		imagebutton_cancel = new ImageButton(this.leftPos + 222, this.topPos + 171, 24, 24, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/cancel.png"), ResourceLocation.parse("craft_defense:textures/screens/cancelh.png")),
				e -> {
					int x = QueueGUIScreen.this.x;
					int y = QueueGUIScreen.this.y;
					if (ReturnNotEditingPProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new QueueGUIButtonMessage(1, x, y, z));
						QueueGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cancel);
		imagebutton_share = new ImageButton(this.leftPos + 254, this.topPos + 171, 24, 24, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/share.png"), ResourceLocation.parse("craft_defense:textures/screens/shareh.png")),
				e -> {
					int x = QueueGUIScreen.this.x;
					int y = QueueGUIScreen.this.y;
					if (ReturnNotEditingPProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new QueueGUIButtonMessage(2, x, y, z));
						QueueGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_share);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.imagebutton_play.visible = ReturnNotEditingPProcedure.execute(entity);
		this.imagebutton_cancel.visible = ReturnNotEditingPProcedure.execute(entity);
		this.imagebutton_share.visible = ReturnNotEditingPProcedure.execute(entity);
	}
}