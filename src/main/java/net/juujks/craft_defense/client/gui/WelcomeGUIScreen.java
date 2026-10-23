package net.juujks.craft_defense.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.juujks.craft_defense.world.inventory.WelcomeGUIMenu;
import net.juujks.craft_defense.network.WelcomeGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class WelcomeGUIScreen extends AbstractContainerScreen<WelcomeGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_thank_you;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("craft_defense:textures/screens/welcome_gui.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/alex_item.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("craft_defense:textures/screens/player_item.png");

	public WelcomeGUIScreen(WelcomeGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 120;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(IMAGE_0, this.leftPos + 69, this.topPos + 56, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_1, this.leftPos + 69, this.topPos + 70, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.welcome_gui.label_it_looks_like_its_your_first_ti"), 6, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.welcome_gui.label_time_using_this_block_take"), 6, 29, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.welcome_gui.label_these_two_units_as_your"), 6, 38, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.welcome_gui.label_adventure"), 60, 47, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.welcome_gui.label_1x"), 87, 61, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.welcome_gui.label_1x1"), 87, 74, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_thank_you = Button.builder(Component.translatable("gui.craft_defense.welcome_gui.button_thank_you"), e -> {
			int x = WelcomeGUIScreen.this.x;
			int y = WelcomeGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new WelcomeGUIButtonMessage(0, x, y, z));
				WelcomeGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 42, this.topPos + 88, 77, 20).build();
		this.addRenderableWidget(button_thank_you);
	}
}