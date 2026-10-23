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

import net.juujks.craft_defense.world.inventory.RaidManagerGUIMenu;
import net.juujks.craft_defense.procedures.*;
import net.juujks.craft_defense.network.RaidManagerGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class RaidManagerGUIScreen extends AbstractContainerScreen<RaidManagerGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_next_page;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/map3.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("craft_defense:textures/screens/act00.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("craft_defense:textures/screens/act00.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("craft_defense:textures/screens/act00.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("craft_defense:textures/screens/act00.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("craft_defense:textures/screens/act00.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("craft_defense:textures/screens/act00.png");

	public RaidManagerGUIScreen(RaidManagerGUIMenu container, Inventory inventory, Component text) {
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
		guiTools$orderedImages : {
			guiTools$alphaBlit(guiGraphics, IMAGE_0, this.leftPos + 2, this.topPos + 0, 0, 0, 464, 261, 464, 261);
			guiTools$alphaBlit(guiGraphics, IMAGE_1, this.leftPos + 168, this.topPos + 135, 0, 0, 128, 72, 128, 72);
			if (ActUnlockedP1Procedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_2, this.leftPos + 168, this.topPos + 41, 0, 0, 128, 72, 128, 72);
			}
			if (ActUnlockedP2Procedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_3, this.leftPos + 308, this.topPos + 41, 0, 0, 128, 72, 128, 72);
			}
			if (ActUnlockedP3Procedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_4, this.leftPos + 29, this.topPos + 135, 0, 0, 128, 72, 128, 72);
			}
			if (ActUnlockedP4Procedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_5, this.leftPos + 168, this.topPos + 135, 0, 0, 128, 72, 128, 72);
			}
			if (ActUnlockedP5Procedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_6, this.leftPos + 308, this.topPos + 135, 0, 0, 128, 72, 128, 72);
			}
			if (this.enhanced_image_button_a1u != null && this.enhanced_image_button_a1u.visible) {
				this.enhanced_image_button_a1u.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_a2u != null && this.enhanced_image_button_a2u.visible) {
				this.enhanced_image_button_a2u.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_a3u != null && this.enhanced_image_button_a3u.visible) {
				this.enhanced_image_button_a3u.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_a4u != null && this.enhanced_image_button_a4u.visible) {
				this.enhanced_image_button_a4u.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_a5u != null && this.enhanced_image_button_a5u.visible) {
				this.enhanced_image_button_a5u.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_a6u != null && this.enhanced_image_button_a6u.visible) {
				this.enhanced_image_button_a6u.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_act_1_plains"), 33, 99, -1, true);
		if (ActLockedP2Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_avaiable_in_update_2"), 312, 99, -1, true);
		if (ActLockedP3Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_coming_soon"), 33, 194, -1, true);
		if (ActLockedP4Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_coming_soon1"), 173, 194, -1, true);
		if (ActLockedP5Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_coming_soon3"), 312, 194, -1, true);
		if (ActLockedP1Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_2_snow"), 173, 99, -1, true);
		if (ActUnlockedP1Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_map_unlocked_in_level_3"), 173, 72, -1, true);
		if (ActUnlockedP2Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_map_unlocked_in_level_5"), 312, 72, -1, true);
		if (ActUnlockedP3Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_map_unlocked_in_level_12"), 51, 158, -1, true);
		if (ActUnlockedP3Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_level_12"), 69, 167, -1, true);
		if (ActUnlockedP4Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_map_unlocked_in"), 195, 158, -1, true);
		if (ActUnlockedP4Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_level_121"), 213, 167, -1, true);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_press_b_to_view_player_stats"), 294, 239, -12829636, false);
		if (ActUnlockedP5Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_map_unlocked_in1"), 335, 158, -1, true);
		if (ActUnlockedP5Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui.label_level_17"), 353, 167, -1, true);
	}

	@Override
	public void init() {
		super.init();
		button_next_page = Button.builder(Component.translatable("gui.craft_defense.raid_manager_gui.button_next_page"), e -> {
			int x = RaidManagerGUIScreen.this.x;
			int y = RaidManagerGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RaidManagerGUIButtonMessage(0, x, y, z));
				RaidManagerGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 200, this.topPos + 225, 72, 20).build();
		this.addRenderableWidget(button_next_page);
		enhanced_image_button_a1u = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 29, this.topPos + 41, 128, 72, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act12u.png"), net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act12h.png")), e -> {
					int x = RaidManagerGUIScreen.this.x;
					int y = RaidManagerGUIScreen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.juujks.craft_defense.network.RaidManagerGUIButtonMessage(1, x, y, z));
						net.juujks.craft_defense.network.RaidManagerGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act12u.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act12h.png");
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_a1u);
		enhanced_image_button_a2u = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 168, this.topPos + 41, 128, 72, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act22u.png"), net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act22h.png")), e -> {
					int x = RaidManagerGUIScreen.this.x;
					int y = RaidManagerGUIScreen.this.y;
					if (net.juujks.craft_defense.procedures.ActLockedP1Procedure.execute(entity)) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.juujks.craft_defense.network.RaidManagerGUIButtonMessage(2, x, y, z));
						net.juujks.craft_defense.network.RaidManagerGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act22u.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act22h.png");
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_a2u);
		enhanced_image_button_a3u = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 308, this.topPos + 41, 128, 72, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act3u.png"), net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act3h.png")), e -> {
					int x = RaidManagerGUIScreen.this.x;
					int y = RaidManagerGUIScreen.this.y;
					if (net.juujks.craft_defense.procedures.ActLockedP2Procedure.execute(entity)) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.juujks.craft_defense.network.RaidManagerGUIButtonMessage(3, x, y, z));
						net.juujks.craft_defense.network.RaidManagerGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act3u.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act3h.png");
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_a3u);
		enhanced_image_button_a4u = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 29, this.topPos + 135, 128, 72, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act4u.png"), net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act4u.png")), e -> {
					int x = RaidManagerGUIScreen.this.x;
					int y = RaidManagerGUIScreen.this.y;
					if (net.juujks.craft_defense.procedures.ActLockedP3Procedure.execute(entity)) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.juujks.craft_defense.network.RaidManagerGUIButtonMessage(4, x, y, z));
						net.juujks.craft_defense.network.RaidManagerGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act4u.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act4u.png");
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_a4u);
		enhanced_image_button_a5u = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 168, this.topPos + 135, 128, 72, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act5u.png"), net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act5h.png")), e -> {
					int x = RaidManagerGUIScreen.this.x;
					int y = RaidManagerGUIScreen.this.y;
					if (net.juujks.craft_defense.procedures.ActLockedP4Procedure.execute(entity)) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.juujks.craft_defense.network.RaidManagerGUIButtonMessage(5, x, y, z));
						net.juujks.craft_defense.network.RaidManagerGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act5u.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act5h.png");
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_a5u);
		enhanced_image_button_a6u = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 308, this.topPos + 135, 128, 72, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act6u.png"), net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act6h.png")), e -> {
					int x = RaidManagerGUIScreen.this.x;
					int y = RaidManagerGUIScreen.this.y;
					if (net.juujks.craft_defense.procedures.ActLockedP5Procedure.execute(entity)) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.juujks.craft_defense.network.RaidManagerGUIButtonMessage(6, x, y, z));
						net.juujks.craft_defense.network.RaidManagerGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act6u.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/act6h.png");
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_a6u);
	}

	private static final boolean guiTools$enhancedImageButton = true;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_a1u;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_a2u;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_a3u;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_a4u;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_a5u;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_a6u;

	@Override
	protected void containerTick() {
		super.containerTick();
		this.enhanced_image_button_a2u.visible = net.juujks.craft_defense.procedures.ActLockedP1Procedure.execute(entity);
		this.enhanced_image_button_a3u.visible = net.juujks.craft_defense.procedures.ActLockedP2Procedure.execute(entity);
		this.enhanced_image_button_a4u.visible = net.juujks.craft_defense.procedures.ActLockedP3Procedure.execute(entity);
		this.enhanced_image_button_a5u.visible = net.juujks.craft_defense.procedures.ActLockedP4Procedure.execute(entity);
		this.enhanced_image_button_a6u.visible = net.juujks.craft_defense.procedures.ActLockedP5Procedure.execute(entity);
	}

	private static net.minecraft.resources.ResourceLocation guiTools$buttonTexture(String value, net.minecraft.resources.ResourceLocation fallback) {
		if (value == null || value.isBlank())
			return fallback;
		try {
			String texture = value.trim().replace('\\', '/');
			if (texture.indexOf(':') >= 0)
				return net.minecraft.resources.ResourceLocation.parse(texture);
			while (texture.startsWith("/"))
				texture = texture.substring(1);
			if (texture.startsWith("textures/screens/"))
				texture = texture.substring("textures/screens/".length());
			if (!texture.endsWith(".png"))
				texture += ".png";
			return net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("craft_defense", "textures/screens/" + texture);
		} catch (RuntimeException ignored) {
			return fallback;
		}
	}

	private static void guiTools$alphaBlit(net.minecraft.client.gui.GuiGraphics graphics, net.minecraft.resources.ResourceLocation texture, int x, int y, float u, float v, int width, int height, int textureWidth, int textureHeight) {
		boolean wasBlending = org.lwjgl.opengl.GL11.glIsEnabled(org.lwjgl.opengl.GL11.GL_BLEND);
		com.mojang.blaze3d.systems.RenderSystem.enableBlend();
		com.mojang.blaze3d.systems.RenderSystem.defaultBlendFunc();
		try {
			graphics.blit(texture, x, y, u, v, width, height, textureWidth, textureHeight);
		} finally {
			if (!wasBlending)
				com.mojang.blaze3d.systems.RenderSystem.disableBlend();
		}
	}
}