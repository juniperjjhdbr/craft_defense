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

import net.juujks.craft_defense.world.inventory.RaidManagerGUI4Menu;
import net.juujks.craft_defense.procedures.*;
import net.juujks.craft_defense.network.RaidManagerGUI4ButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class RaidManagerGUI4Screen extends AbstractContainerScreen<RaidManagerGUI4Menu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_cancel;
	private Button button_11;
	private Button button_12;
	private Button button_13;
	private Button button_14;
	private Button button_15;
	private Button button_hard_mode;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/act2.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("craft_defense:textures/screens/act22u.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("craft_defense:textures/screens/eba4.png");

	public RaidManagerGUI4Screen(RaidManagerGUI4Menu container, Inventory inventory, Component text) {
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
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + 2, this.topPos + 0, 0, 0, 464, 261, 464, 261);
		guiGraphics.blit(IMAGE_1, this.leftPos + 200, this.topPos + 135, 0, 0, 64, 36, 64, 36);
		if (B10PProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 317, this.topPos + 171, 0, 0, 90, 39, 90, 39);
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
	}

	@Override
	public void init() {
		super.init();
		button_cancel = Button.builder(Component.translatable("gui.craft_defense.raid_manager_gui_4.button_cancel"), e -> {
			int x = RaidManagerGUI4Screen.this.x;
			int y = RaidManagerGUI4Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RaidManagerGUI4ButtonMessage(0, x, y, z));
				RaidManagerGUI4ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 204, this.topPos + 180, 56, 20).build();
		this.addRenderableWidget(button_cancel);
		button_11 = Button.builder(Component.translatable("gui.craft_defense.raid_manager_gui_4.button_11"), e -> {
			int x = RaidManagerGUI4Screen.this.x;
			int y = RaidManagerGUI4Screen.this.y;
			if (B5PProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new RaidManagerGUI4ButtonMessage(1, x, y, z));
				RaidManagerGUI4ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 168, this.topPos + 81, 40, 20).build();
		this.addRenderableWidget(button_11);
		button_12 = Button.builder(Component.translatable("gui.craft_defense.raid_manager_gui_4.button_12"), e -> {
			int x = RaidManagerGUI4Screen.this.x;
			int y = RaidManagerGUI4Screen.this.y;
			if (B6PProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new RaidManagerGUI4ButtonMessage(2, x, y, z));
				RaidManagerGUI4ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 213, this.topPos + 81, 40, 20).build();
		this.addRenderableWidget(button_12);
		button_13 = Button.builder(Component.translatable("gui.craft_defense.raid_manager_gui_4.button_13"), e -> {
			int x = RaidManagerGUI4Screen.this.x;
			int y = RaidManagerGUI4Screen.this.y;
			if (B7PProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new RaidManagerGUI4ButtonMessage(3, x, y, z));
				RaidManagerGUI4ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 258, this.topPos + 81, 40, 20).build();
		this.addRenderableWidget(button_13);
		button_14 = Button.builder(Component.translatable("gui.craft_defense.raid_manager_gui_4.button_14"), e -> {
			int x = RaidManagerGUI4Screen.this.x;
			int y = RaidManagerGUI4Screen.this.y;
			if (B8PProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new RaidManagerGUI4ButtonMessage(4, x, y, z));
				RaidManagerGUI4ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 186, this.topPos + 108, 40, 20).build();
		this.addRenderableWidget(button_14);
		button_15 = Button.builder(Component.translatable("gui.craft_defense.raid_manager_gui_4.button_15"), e -> {
			int x = RaidManagerGUI4Screen.this.x;
			int y = RaidManagerGUI4Screen.this.y;
			if (B9PProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new RaidManagerGUI4ButtonMessage(5, x, y, z));
				RaidManagerGUI4ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 231, this.topPos + 108, 40, 20).build();
		this.addRenderableWidget(button_15);
		button_hard_mode = Button.builder(Component.translatable("gui.craft_defense.raid_manager_gui_4.button_hard_mode"), e -> {
			int x = RaidManagerGUI4Screen.this.x;
			int y = RaidManagerGUI4Screen.this.y;
			if (B10PProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new RaidManagerGUI4ButtonMessage(6, x, y, z));
				RaidManagerGUI4ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 326, this.topPos + 180, 72, 20).build();
		this.addRenderableWidget(button_hard_mode);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.button_11.visible = B5PProcedure.execute(entity);
		this.button_12.visible = B6PProcedure.execute(entity);
		this.button_13.visible = B7PProcedure.execute(entity);
		this.button_14.visible = B8PProcedure.execute(entity);
		this.button_15.visible = B9PProcedure.execute(entity);
		this.button_hard_mode.visible = B10PProcedure.execute(entity);
	}
}