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

import net.juujks.craft_defense.world.inventory.RaidManagerGUI2Menu;
import net.juujks.craft_defense.procedures.C901pProcedure;
import net.juujks.craft_defense.procedures.C1000PProcedure;
import net.juujks.craft_defense.procedures.B901PProcedure;
import net.juujks.craft_defense.procedures.B1000PProcedure;
import net.juujks.craft_defense.network.RaidManagerGUI2ButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class RaidManagerGUI2Screen extends AbstractContainerScreen<RaidManagerGUI2Menu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_dcu3;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/raidmanageamento2.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("craft_defense:textures/screens/act00.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("craft_defense:textures/screens/act00.png");

	public RaidManagerGUI2Screen(RaidManagerGUI2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 350;
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
		guiTools$orderedImages : {
			guiTools$alphaBlit(guiGraphics, IMAGE_0, this.leftPos + -1, this.topPos + -2, 0, 0, 350, 220, 350, 220);
			if (this.enhanced_image_button_story2u != null && this.enhanced_image_button_story2u.visible) {
				this.enhanced_image_button_story2u.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (C901pProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_1, this.leftPos + 39, this.topPos + 124, 0, 0, 128, 72, 128, 72);
			}
			if (C1000PProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_2, this.leftPos + 183, this.topPos + 43, 0, 0, 128, 72, 128, 72);
			}
			if (this.enhanced_image_button_inf21u != null && this.enhanced_image_button_inf21u.visible) {
				this.enhanced_image_button_inf21u.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_inf22u != null && this.enhanced_image_button_inf22u.visible) {
				this.enhanced_image_button_inf22u.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_inf23u != null && this.enhanced_image_button_inf23u.visible) {
				this.enhanced_image_button_inf23u.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_br2u != null && this.enhanced_image_button_br2u.visible) {
				this.enhanced_image_button_br2u.render(guiGraphics, mouseX, mouseY, partialTicks);
			}
			if (this.enhanced_image_button_e1u != null && this.enhanced_image_button_e1u.visible) {
				this.enhanced_image_button_e1u.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui_2.label_main_maps"), 44, 102, -1, true);
		if (B1000PProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui_2.label_infinity_mode"), 188, 102, -1, true);
		if (B901PProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui_2.label_boss_rush"), 44, 183, -1, true);
		if (C901pProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui_2.label_unlocked_if_map_2"), 62, 149, -1, false);
		if (C901pProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui_2.label_completion"), 80, 160, -1, false);
		if (C1000PProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui_2.label_unlocked_in_map_1"), 201, 66, -1, false);
		if (C1000PProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui_2.label_completion1"), 219, 79, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui_2.label_1_year_anniversary_event"), 188, 183, -1, true);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.raid_manager_gui_2.label_custom_maps_are_temporarily_disa"), 80, 199, -13421773, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_dcu3 = new ImageButton(this.leftPos + 314, this.topPos + 183, 32, 32, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/dcu3.png"), ResourceLocation.parse("craft_defense:textures/screens/dch3.png")), e -> {
			int x = RaidManagerGUI2Screen.this.x;
			int y = RaidManagerGUI2Screen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RaidManagerGUI2ButtonMessage(0, x, y, z));
				RaidManagerGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiTools$alphaBlit(guiGraphics, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_dcu3);
		enhanced_image_button_story2u = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 39, this.topPos + 43, 128, 72, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/story3u.png"), net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/story3h.png")), e -> {
					int x = RaidManagerGUI2Screen.this.x;
					int y = RaidManagerGUI2Screen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.juujks.craft_defense.network.RaidManagerGUI2ButtonMessage(1, x, y, z));
						net.juujks.craft_defense.network.RaidManagerGUI2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/story3u.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/story3h.png");
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_story2u);
		enhanced_image_button_inf21u = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 183, this.topPos + 43, 128, 72, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/inf1u.png"), net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/inf1h.png")), e -> {
					int x = RaidManagerGUI2Screen.this.x;
					int y = RaidManagerGUI2Screen.this.y;
					if (net.juujks.craft_defense.procedures.Inf1PProcedure.execute(world, entity)) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.juujks.craft_defense.network.RaidManagerGUI2ButtonMessage(2, x, y, z));
						net.juujks.craft_defense.network.RaidManagerGUI2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/inf1u.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/inf1h.png");
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_inf21u);
		enhanced_image_button_inf22u = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 183, this.topPos + 43, 128, 72, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/inf2u.png"), net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/inf2h.png")), e -> {
					int x = RaidManagerGUI2Screen.this.x;
					int y = RaidManagerGUI2Screen.this.y;
					if (net.juujks.craft_defense.procedures.Inf2PProcedure.execute(world, entity)) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.juujks.craft_defense.network.RaidManagerGUI2ButtonMessage(3, x, y, z));
						net.juujks.craft_defense.network.RaidManagerGUI2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/inf2u.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/inf2h.png");
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_inf22u);
		enhanced_image_button_inf23u = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 183, this.topPos + 43, 128, 72, new net.minecraft.client.gui.components.WidgetSprites(
				net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/inf3u.png"), net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/inf3h.png")), e -> {
					int x = RaidManagerGUI2Screen.this.x;
					int y = RaidManagerGUI2Screen.this.y;
					if (net.juujks.craft_defense.procedures.Inf3PProcedure.execute(world, entity)) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.juujks.craft_defense.network.RaidManagerGUI2ButtonMessage(4, x, y, z));
						net.juujks.craft_defense.network.RaidManagerGUI2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/inf3u.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/inf3h.png");
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_inf23u);
		enhanced_image_button_br2u = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 39, this.topPos + 124, 128, 72,
				new net.minecraft.client.gui.components.WidgetSprites(net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/bru.png"), net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/brh.png")),
				e -> {
					int x = RaidManagerGUI2Screen.this.x;
					int y = RaidManagerGUI2Screen.this.y;
					if (net.juujks.craft_defense.procedures.B901PProcedure.execute(entity)) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.juujks.craft_defense.network.RaidManagerGUI2ButtonMessage(5, x, y, z));
						net.juujks.craft_defense.network.RaidManagerGUI2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/bru.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/brh.png");
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_br2u);
		enhanced_image_button_e1u = new net.minecraft.client.gui.components.ImageButton(this.leftPos + 183, this.topPos + 124, 128, 72,
				new net.minecraft.client.gui.components.WidgetSprites(net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/eu.png"), net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/eh.png")),
				e -> {
					int x = RaidManagerGUI2Screen.this.x;
					int y = RaidManagerGUI2Screen.this.y;
					if (true) {
						net.neoforged.neoforge.network.PacketDistributor.sendToServer(new net.juujks.craft_defense.network.RaidManagerGUI2ButtonMessage(6, x, y, z));
						net.juujks.craft_defense.network.RaidManagerGUI2ButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(net.minecraft.client.gui.GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				net.minecraft.resources.ResourceLocation guiTools$normalTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/eu.png");
				net.minecraft.resources.ResourceLocation guiTools$hoveredTexture = net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/eh.png");
				net.minecraft.resources.ResourceLocation guiTools$pressedTexture = guiTools$hoveredTexture;
				boolean mouseOverButton = mouseX >= getX() && mouseY >= getY() && mouseX < getX() + width && mouseY < getY() + height;
				boolean mousePressed = mouseOverButton && org.lwjgl.glfw.GLFW.glfwGetMouseButton(net.minecraft.client.Minecraft.getInstance().getWindow().getWindow(), org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT) == org.lwjgl.glfw.GLFW.GLFW_PRESS;
				net.minecraft.resources.ResourceLocation buttonTexture = mousePressed ? guiTools$pressedTexture : mouseOverButton ? guiTools$hoveredTexture : guiTools$normalTexture;
				guiTools$alphaBlit(guiGraphics, buttonTexture, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addWidget(enhanced_image_button_e1u);
	}

	private static final boolean guiTools$enhancedImageButton = true;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_story2u;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_inf21u;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_inf22u;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_inf23u;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_br2u;
	private net.minecraft.client.gui.components.ImageButton enhanced_image_button_e1u;

	@Override
	protected void containerTick() {
		super.containerTick();
		this.enhanced_image_button_inf21u.visible = net.juujks.craft_defense.procedures.Inf1PProcedure.execute(world, entity);
		this.enhanced_image_button_inf22u.visible = net.juujks.craft_defense.procedures.Inf2PProcedure.execute(world, entity);
		this.enhanced_image_button_inf23u.visible = net.juujks.craft_defense.procedures.Inf3PProcedure.execute(world, entity);
		this.enhanced_image_button_br2u.visible = net.juujks.craft_defense.procedures.B901PProcedure.execute(entity);
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