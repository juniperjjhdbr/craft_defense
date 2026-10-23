package net.juujks.craft_defense.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.juujks.craft_defense.world.inventory.UpgradeUnitGUIMenu;
import net.juujks.craft_defense.procedures.*;
import net.juujks.craft_defense.network.UpgradeUnitGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class UpgradeUnitGUIScreen extends AbstractContainerScreen<UpgradeUnitGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_upgrade;
	private Button button_sell;
	private Button button_empty;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/testamento5.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("craft_defense:textures/screens/eba3.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("craft_defense:textures/screens/wooden_sword.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("craft_defense:textures/screens/wooden_sword_1.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("craft_defense:textures/screens/speed.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("craft_defense:textures/screens/eba3.png");

	public UpgradeUnitGUIScreen(UpgradeUnitGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 180;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (ShowEntityTestProcedure.execute(world, x, y, z, entity) instanceof LivingEntity livingEntity) {
			CraftDefenseModScreens.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 42, this.topPos + 61, 15, 0f + (float) Math.atan((this.leftPos + 42 - mouseX) / 40.0), (float) Math.atan((this.topPos + 12 - mouseY) / 40.0),
					livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + -1, 0, 0, 176, 180, 176, 180);
		guiGraphics.blit(IMAGE_1, this.leftPos + 20, this.topPos + 19, 0, 0, 45, 45, 45, 45);
		guiGraphics.blit(IMAGE_2, this.leftPos + 87, this.topPos + 23, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_3, this.leftPos + 87, this.topPos + 50, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_4, this.leftPos + 87, this.topPos + 77, 0, 0, 18, 18, 18, 18);
		guiGraphics.blit(IMAGE_5, this.leftPos + -43, this.topPos + 118, 0, 0, 45, 45, 45, 45);
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
		guiGraphics.drawString(this.font, DmgP2Procedure.execute(world, x, y, z, entity), 110, 28, -65536, false);
		guiGraphics.drawString(this.font, RngPProcedure.execute(world, x, y, z, entity), 110, 55, -256, false);
		guiGraphics.drawString(this.font, SpaPProcedure.execute(world, x, y, z, entity), 110, 86, -16776961, false);
		guiGraphics.drawString(this.font, LvlPProcedure.execute(world, x, y, z, entity), 6, 82, -256, false);
		guiGraphics.drawString(this.font, MoneyShowOverlayProcedure.execute(world, entity), -39, 140, -16711917, false);
		guiGraphics.drawString(this.font, WaveShowOverlayProcedure.execute(world), -39, 127, -1, false);
		guiGraphics.drawString(this.font, NextUpPProcedure.execute(world, x, y, z, entity), 47, 140, -15794432, false);
		guiGraphics.drawString(this.font, UnitLevelPProcedure.execute(world, x, y, z, entity), 6, 68, -16717592, false);
		guiGraphics.drawString(this.font, ReturnPriorityPProcedure.execute(world, x, y, z, entity), 92, 140, -65310, false);
		guiGraphics.drawString(this.font, ReturnTraitPProcedure.execute(world, x, y, z, entity), 6, 95, -12829636, false);
		if (ReturnDMGBPProcedure.execute(world, x, y, z, entity))
			guiGraphics.drawString(this.font, ReturnDamageBuffProcedure.execute(world, x, y, z, entity), 110, 41, -65536, false);
		if (ReturnRNGBPProcedure.execute(world, x, y, z, entity))
			guiGraphics.drawString(this.font, ReturnRangeBuffProcedure.execute(world, x, y, z, entity), 110, 68, -256, false);
		if (ReturnSPABPProcedure.execute(world, x, y, z, entity))
			guiGraphics.drawString(this.font, ReturnSpaBuffProcedure.execute(world, x, y, z, entity), 110, 100, -16776961, false);
	}

	@Override
	public void init() {
		super.init();
		button_upgrade = Button.builder(Component.translatable("gui.craft_defense.upgrade_unit_gui.button_upgrade"), e -> {
			int x = UpgradeUnitGUIScreen.this.x;
			int y = UpgradeUnitGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new UpgradeUnitGUIButtonMessage(0, x, y, z));
				UpgradeUnitGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 33, this.topPos + 154, 61, 20).build();
		this.addRenderableWidget(button_upgrade);
		button_sell = Button.builder(Component.translatable("gui.craft_defense.upgrade_unit_gui.button_sell"), e -> {
			int x = UpgradeUnitGUIScreen.this.x;
			int y = UpgradeUnitGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new UpgradeUnitGUIButtonMessage(1, x, y, z));
				UpgradeUnitGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 96, this.topPos + 154, 46, 20).build();
		this.addRenderableWidget(button_sell);
		button_empty = Button.builder(Component.translatable("gui.craft_defense.upgrade_unit_gui.button_empty"), e -> {
			int x = UpgradeUnitGUIScreen.this.x;
			int y = UpgradeUnitGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new UpgradeUnitGUIButtonMessage(2, x, y, z));
				UpgradeUnitGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 118, 30, 20).build();
		this.addRenderableWidget(button_empty);
	}
}