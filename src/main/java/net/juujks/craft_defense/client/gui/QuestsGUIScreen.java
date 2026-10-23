package net.juujks.craft_defense.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.juujks.craft_defense.world.inventory.QuestsGUIMenu;
import net.juujks.craft_defense.procedures.*;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class QuestsGUIScreen extends AbstractContainerScreen<QuestsGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/quests2.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("craft_defense:textures/screens/common_exp_candy.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("craft_defense:textures/screens/rare_exp_candy.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("craft_defense:textures/screens/epic_exp_candy.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("craft_defense:textures/screens/legendary_exp_candy.png");

	public QuestsGUIScreen(QuestsGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 220;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -1, this.topPos + -1, 0, 0, 250, 220, 250, 220);
		guiGraphics.blit(IMAGE_1, this.leftPos + 43, this.topPos + 61, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_2, this.leftPos + 43, this.topPos + 111, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_3, this.leftPos + 43, this.topPos + 156, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_4, this.leftPos + 43, this.topPos + 196, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.drawString(this.font, ReturnRemaining1hProcedure.execute(entity), 205, 70, -12829636, false);
		guiGraphics.drawString(this.font, ReturnRemaining3hProcedure.execute(entity), 205, 115, -12829636, false);
		guiGraphics.drawString(this.font, ReturnRemaining6hProcedure.execute(entity), 205, 160, -12829636, false);
		guiGraphics.drawString(this.font, ReturnRemaining24hProcedure.execute(entity), 205, 205, -12829636, false);
		guiGraphics.drawString(this.font, ReturnQuest1hProcedure.execute(entity), 43, 52, -1, false);
		guiGraphics.drawString(this.font, ReturnQuest3hProcedure.execute(entity), 43, 98, -1, false);
		guiGraphics.drawString(this.font, ReturnQuest6hProcedure.execute(entity), 43, 142, -1, false);
		guiGraphics.drawString(this.font, ReturnQuest24hProcedure.execute(entity), 43, 187, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.quests_gui.label_x10"), 61, 66, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.quests_gui.label_x101"), 61, 115, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.quests_gui.label_x102"), 61, 160, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.quests_gui.label_x103"), 61, 201, -1, false);
	}

	@Override
	public void init() {
		super.init();
	}
}