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

import net.juujks.craft_defense.world.inventory.PlayerLevelGUIMenu;
import net.juujks.craft_defense.procedures.*;
import net.juujks.craft_defense.network.PlayerLevelGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class PlayerLevelGUIScreen extends AbstractContainerScreen<PlayerLevelGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_quests;
	private Button button_free_unit;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/leveluou2.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("craft_defense:textures/screens/lvl2.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("craft_defense:textures/screens/lvl2.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("craft_defense:textures/screens/lvl2.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("craft_defense:textures/screens/lvl2.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("craft_defense:textures/screens/lvl2.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("craft_defense:textures/screens/lvl3.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("craft_defense:textures/screens/lvl3.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("craft_defense:textures/screens/lvl3.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("craft_defense:textures/screens/lvl3.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("craft_defense:textures/screens/lvl4.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("craft_defense:textures/screens/lvl3.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("craft_defense:textures/screens/lvl4.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("craft_defense:textures/screens/lvl5.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("craft_defense:textures/screens/lvl6.png");

	public PlayerLevelGUIScreen(PlayerLevelGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 347;
		this.imageHeight = 100;
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
		if (mouseX > leftPos + 25 && mouseX < leftPos + 49 && mouseY > topPos + 60 && mouseY < topPos + 84) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.player_level_gui.tooltip_map_unlocked_plains"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 56 && mouseX < leftPos + 80 && mouseY > topPos + 60 && mouseY < topPos + 84) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.player_level_gui.tooltip_map_unlocked_snow_valley"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 88 && mouseX < leftPos + 112 && mouseY > topPos + 60 && mouseY < topPos + 84) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.player_level_gui.tooltip_map_unlocked_the_mines"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 119 && mouseX < leftPos + 143 && mouseY > topPos + 60 && mouseY < topPos + 84) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.player_level_gui.tooltip_map_unlocked_plains_village"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 154 && mouseX < leftPos + 178 && mouseY > topPos + 60 && mouseY < topPos + 84) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.player_level_gui.tooltip_challenges_unlocked"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 188 && mouseX < leftPos + 212 && mouseY > topPos + 60 && mouseY < topPos + 84) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.player_level_gui.tooltip_map_unlocked_desert_maze"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 223 && mouseX < leftPos + 247 && mouseY > topPos + 60 && mouseY < topPos + 84) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.player_level_gui.tooltip_map_unlocked_ocean_temple"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 259 && mouseX < leftPos + 283 && mouseY > topPos + 60 && mouseY < topPos + 84) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.player_level_gui.tooltip_map_unlocked_ocean_temple1"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 295 && mouseX < leftPos + 319 && mouseY > topPos + 60 && mouseY < topPos + 84) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.player_level_gui.tooltip_more_levels_coming_soon"), mouseX, mouseY);
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -5, this.topPos + -2, 0, 0, 356, 106, 356, 106);
		if (ReturnLevel1PProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_1, this.leftPos + 128, this.topPos + 19, 0, 0, 32, 32, 32, 32);
		}
		guiGraphics.blit(IMAGE_2, this.leftPos + 20, this.topPos + 55, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(IMAGE_3, this.leftPos + 52, this.topPos + 55, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(IMAGE_4, this.leftPos + 83, this.topPos + 55, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(IMAGE_5, this.leftPos + 115, this.topPos + 55, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(IMAGE_6, this.leftPos + 149, this.topPos + 55, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(IMAGE_7, this.leftPos + 184, this.topPos + 55, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(IMAGE_8, this.leftPos + 218, this.topPos + 55, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(IMAGE_9, this.leftPos + 254, this.topPos + 55, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(IMAGE_10, this.leftPos + 290, this.topPos + 55, 0, 0, 32, 32, 32, 32);
		if (ReturnLevel2PProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_11, this.leftPos + 128, this.topPos + 19, 0, 0, 32, 32, 32, 32);
		}
		if (ReturnLevel3PProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_12, this.leftPos + 128, this.topPos + 19, 0, 0, 32, 32, 32, 32);
		}
		if (ReturnLevel4PProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_13, this.leftPos + 128, this.topPos + 19, 0, 0, 32, 32, 32, 32);
		}
		if (ReturnLevel5PProcedure.execute(entity)) {
			guiGraphics.blit(IMAGE_14, this.leftPos + 128, this.topPos + 19, 0, 0, 32, 32, 32, 32);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.player_level_gui.label_level"), 97, 28, -1, false);
		guiGraphics.drawString(this.font, ReturnPlayerLevelPProcedure.execute(entity), 139, 30, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.player_level_gui.label_1"), 33, 69, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.player_level_gui.label_5"), 65, 69, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.player_level_gui.label_51"), 96, 69, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.player_level_gui.label_8"), 128, 69, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.player_level_gui.label_10"), 160, 69, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.player_level_gui.label_12"), 194, 69, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.player_level_gui.label_17"), 229, 69, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.player_level_gui.label_171"), 265, 69, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.player_level_gui.label_20"), 301, 68, -1, false);
		guiGraphics.drawString(this.font, ReturnLevelRemainingProcedure.execute(entity), 182, 28, -256, false);
		guiGraphics.drawString(this.font, ReturnTimePlayedProcedure.execute(entity), 97, 102, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_quests = Button.builder(Component.translatable("gui.craft_defense.player_level_gui.button_quests"), e -> {
			int x = PlayerLevelGUIScreen.this.x;
			int y = PlayerLevelGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new PlayerLevelGUIButtonMessage(0, x, y, z));
				PlayerLevelGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 32, this.topPos + 22, 56, 20).build();
		this.addRenderableWidget(button_quests);
		button_free_unit = Button.builder(Component.translatable("gui.craft_defense.player_level_gui.button_free_unit"), e -> {
			int x = PlayerLevelGUIScreen.this.x;
			int y = PlayerLevelGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new PlayerLevelGUIButtonMessage(1, x, y, z));
				PlayerLevelGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 255, this.topPos + 22, 70, 20).build();
		this.addRenderableWidget(button_free_unit);
	}
}