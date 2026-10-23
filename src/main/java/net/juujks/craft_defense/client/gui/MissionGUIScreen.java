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

import net.juujks.craft_defense.world.inventory.MissionGUIMenu;
import net.juujks.craft_defense.network.MissionGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class MissionGUIScreen extends AbstractContainerScreen<MissionGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cancel;
	private ImageButton imagebutton_play;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/act2.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("craft_defense:textures/screens/act12u.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("craft_defense:textures/screens/duplication_token.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("craft_defense:textures/screens/towergem.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("craft_defense:textures/screens/23_sem_titulo_20260816204235.png");

	public MissionGUIScreen(MissionGUIMenu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 209 && mouseX < leftPos + 233 && mouseY > topPos + 180 && mouseY < topPos + 204) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.mission_gui.tooltip_play"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 236 && mouseX < leftPos + 260 && mouseY > topPos + 180 && mouseY < topPos + 204) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.mission_gui.tooltip_cancel"), mouseX, mouseY);
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 2, this.topPos + 0, 0, 0, 464, 261, 464, 261);
		guiGraphics.blit(IMAGE_1, this.leftPos + 200, this.topPos + 135, 0, 0, 64, 36, 64, 36);
		guiGraphics.blit(IMAGE_2, this.leftPos + 200, this.topPos + 113, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_3, this.leftPos + 225, this.topPos + 113, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_4, this.leftPos + 249, this.topPos + 113, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.mission_gui.label_mission_1_plains"), 186, 77, -256, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.mission_gui.label_enemies_have_2x_health"), 177, 86, -3355444, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.mission_gui.label_rewards"), 213, 99, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cancel = new ImageButton(this.leftPos + 236, this.topPos + 180, 24, 24, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/cancel.png"), ResourceLocation.parse("craft_defense:textures/screens/cancelh.png")),
				e -> {
					int x = MissionGUIScreen.this.x;
					int y = MissionGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new MissionGUIButtonMessage(0, x, y, z));
						MissionGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cancel);
		imagebutton_play = new ImageButton(this.leftPos + 209, this.topPos + 180, 24, 24, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/play.png"), ResourceLocation.parse("craft_defense:textures/screens/playh.png")), e -> {
			int x = MissionGUIScreen.this.x;
			int y = MissionGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new MissionGUIButtonMessage(1, x, y, z));
				MissionGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_play);
	}
}