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

import net.juujks.craft_defense.world.inventory.FreeUnitsGUIMenu;
import net.juujks.craft_defense.procedures.*;
import net.juujks.craft_defense.network.FreeUnitsGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class FreeUnitsGUIScreen extends AbstractContainerScreen<FreeUnitsGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_skeleton_item2x;
	private ImageButton imagebutton_zombie_item2x;
	private ImageButton imagebutton_witch_item2x;
	private ImageButton imagebutton_villager_item2x;
	private ImageButton imagebutton_stray_item2x;
	private ImageButton imagebutton_husk_item2x;
	private ImageButton imagebutton_iron_golem_item2x;
	private ImageButton imagebutton_ravagerunit;
	private ImageButton imagebutton_bogged_item2x;

	public FreeUnitsGUIScreen(FreeUnitsGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 512;
		this.imageHeight = 512;
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
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.free_units_gui.label_you_leveled_up"), 219, 207, -1, true);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.free_units_gui.label_please_select_a_free_unit"), 192, 218, -1, true);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_skeleton_item2x = new ImageButton(this.leftPos + 160, this.topPos + 270, 32, 32,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/skeleton_item-2x.png"), ResourceLocation.parse("craft_defense:textures/screens/skeleton_item-2x.png")), e -> {
					int x = FreeUnitsGUIScreen.this.x;
					int y = FreeUnitsGUIScreen.this.y;
					if (Level2to4PProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new FreeUnitsGUIButtonMessage(0, x, y, z));
						FreeUnitsGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_skeleton_item2x);
		imagebutton_zombie_item2x = new ImageButton(this.leftPos + 240, this.topPos + 270, 32, 32,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/zombie_item-2x.png"), ResourceLocation.parse("craft_defense:textures/screens/zombie_item-2x.png")), e -> {
					int x = FreeUnitsGUIScreen.this.x;
					int y = FreeUnitsGUIScreen.this.y;
					if (Level2to4P2Procedure.execute(entity)) {
						PacketDistributor.sendToServer(new FreeUnitsGUIButtonMessage(1, x, y, z));
						FreeUnitsGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_zombie_item2x);
		imagebutton_witch_item2x = new ImageButton(this.leftPos + 322, this.topPos + 270, 32, 32,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/witch_item-2x.png"), ResourceLocation.parse("craft_defense:textures/screens/witch_item-2x.png")), e -> {
					int x = FreeUnitsGUIScreen.this.x;
					int y = FreeUnitsGUIScreen.this.y;
					if (Level2to4P3Procedure.execute(entity)) {
						PacketDistributor.sendToServer(new FreeUnitsGUIButtonMessage(2, x, y, z));
						FreeUnitsGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_witch_item2x);
		imagebutton_villager_item2x = new ImageButton(this.leftPos + 160, this.topPos + 270, 32, 32,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/villager_item-2x.png"), ResourceLocation.parse("craft_defense:textures/screens/villager_item-2x.png")), e -> {
					int x = FreeUnitsGUIScreen.this.x;
					int y = FreeUnitsGUIScreen.this.y;
					if (Level5to7PProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new FreeUnitsGUIButtonMessage(3, x, y, z));
						FreeUnitsGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_villager_item2x);
		imagebutton_stray_item2x = new ImageButton(this.leftPos + 240, this.topPos + 270, 32, 32,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/stray_item-2x.png"), ResourceLocation.parse("craft_defense:textures/screens/stray_item-2x.png")), e -> {
					int x = FreeUnitsGUIScreen.this.x;
					int y = FreeUnitsGUIScreen.this.y;
					if (Level5to7P2Procedure.execute(entity)) {
						PacketDistributor.sendToServer(new FreeUnitsGUIButtonMessage(4, x, y, z));
						FreeUnitsGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_stray_item2x);
		imagebutton_husk_item2x = new ImageButton(this.leftPos + 322, this.topPos + 270, 32, 32,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/husk_item-2x.png"), ResourceLocation.parse("craft_defense:textures/screens/husk_item-2x.png")), e -> {
					int x = FreeUnitsGUIScreen.this.x;
					int y = FreeUnitsGUIScreen.this.y;
					if (Level5to7P3Procedure.execute(entity)) {
						PacketDistributor.sendToServer(new FreeUnitsGUIButtonMessage(5, x, y, z));
						FreeUnitsGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_husk_item2x);
		imagebutton_iron_golem_item2x = new ImageButton(this.leftPos + 160, this.topPos + 270, 32, 32,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/iron_golem_item-2x.png"), ResourceLocation.parse("craft_defense:textures/screens/iron_golem_item-2x.png")), e -> {
					int x = FreeUnitsGUIScreen.this.x;
					int y = FreeUnitsGUIScreen.this.y;
					if (Level8to12PProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new FreeUnitsGUIButtonMessage(6, x, y, z));
						FreeUnitsGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_iron_golem_item2x);
		imagebutton_ravagerunit = new ImageButton(this.leftPos + 240, this.topPos + 270, 32, 32,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/ravagerunit.png"), ResourceLocation.parse("craft_defense:textures/screens/ravagerunit.png")), e -> {
					int x = FreeUnitsGUIScreen.this.x;
					int y = FreeUnitsGUIScreen.this.y;
					if (Level8to12P2Procedure.execute(entity)) {
						PacketDistributor.sendToServer(new FreeUnitsGUIButtonMessage(7, x, y, z));
						FreeUnitsGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_ravagerunit);
		imagebutton_bogged_item2x = new ImageButton(this.leftPos + 322, this.topPos + 270, 32, 32,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/bogged_item-2x.png"), ResourceLocation.parse("craft_defense:textures/screens/bogged_item-2x.png")), e -> {
					int x = FreeUnitsGUIScreen.this.x;
					int y = FreeUnitsGUIScreen.this.y;
					if (Level8to12P3Procedure.execute(entity)) {
						PacketDistributor.sendToServer(new FreeUnitsGUIButtonMessage(8, x, y, z));
						FreeUnitsGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_bogged_item2x);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.imagebutton_skeleton_item2x.visible = Level2to4PProcedure.execute(entity);
		this.imagebutton_zombie_item2x.visible = Level2to4P2Procedure.execute(entity);
		this.imagebutton_witch_item2x.visible = Level2to4P3Procedure.execute(entity);
		this.imagebutton_villager_item2x.visible = Level5to7PProcedure.execute(entity);
		this.imagebutton_stray_item2x.visible = Level5to7P2Procedure.execute(entity);
		this.imagebutton_husk_item2x.visible = Level5to7P3Procedure.execute(entity);
		this.imagebutton_iron_golem_item2x.visible = Level8to12PProcedure.execute(entity);
		this.imagebutton_ravagerunit.visible = Level8to12P2Procedure.execute(entity);
		this.imagebutton_bogged_item2x.visible = Level8to12P3Procedure.execute(entity);
	}
}