package net.juujks.craft_defense.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.juujks.craft_defense.world.inventory.CraftDefenseConfigGUIMenu;
import net.juujks.craft_defense.network.CraftDefenseConfigGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class CraftDefenseConfigGUIScreen extends AbstractContainerScreen<CraftDefenseConfigGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Checkbox diablespawning;
	private Checkbox disablegui;
	private Button button_reset_raid_manager;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("craft_defense:textures/screens/craft_defense_config_gui.png");

	public CraftDefenseConfigGUIScreen(CraftDefenseConfigGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("diablespawning")) {
				if (diablespawning.selected() != logicState)
					diablespawning.onPress();
			} else if (name.equals("disablegui")) {
				if (disablegui.selected() != logicState)
					disablegui.onPress();
			}
		}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.craft_defense_config_gui.label_craft_defense_config"), 6, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.craft_defense_config_gui.label_v30"), 150, 151, -6710887, false);
	}

	@Override
	public void init() {
		super.init();
		button_reset_raid_manager = Button.builder(Component.translatable("gui.craft_defense.craft_defense_config_gui.button_reset_raid_manager"), e -> {
			int x = CraftDefenseConfigGUIScreen.this.x;
			int y = CraftDefenseConfigGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CraftDefenseConfigGUIButtonMessage(0, x, y, z));
				CraftDefenseConfigGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 142, 119, 20).build();
		this.addRenderableWidget(button_reset_raid_manager);
		diablespawning = Checkbox.builder(Component.translatable("gui.craft_defense.craft_defense_config_gui.diablespawning"), this.font).pos(this.leftPos + 6, this.topPos + 34).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "diablespawning", value, false);
		}).build();
		this.addRenderableWidget(diablespawning);
		disablegui = Checkbox.builder(Component.translatable("gui.craft_defense.craft_defense_config_gui.disablegui"), this.font).pos(this.leftPos + 6, this.topPos + 61).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "disablegui", value, false);
		}).build();
		this.addRenderableWidget(disablegui);
	}
}