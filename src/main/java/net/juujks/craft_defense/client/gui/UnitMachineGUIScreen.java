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

import net.juujks.craft_defense.world.inventory.UnitMachineGUIMenu;
import net.juujks.craft_defense.procedures.*;
import net.juujks.craft_defense.network.UnitMachineGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class UnitMachineGUIScreen extends AbstractContainerScreen<UnitMachineGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_roll;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("craft_defense:textures/screens/unit_machine_gui.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/eba3.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("craft_defense:textures/screens/towergem.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("craft_defense:textures/screens/creeperunit2.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("craft_defense:textures/screens/zombie_unit2.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("craft_defense:textures/screens/skeleton2.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("craft_defense:textures/screens/slime.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("craft_defense:textures/screens/witch.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("craft_defense:textures/screens/spider.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("craft_defense:textures/screens/villager_-_converted.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("craft_defense:textures/screens/cave_spider.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("craft_defense:textures/screens/stray2.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("craft_defense:textures/screens/zombified_piglin_-_converted.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("craft_defense:textures/screens/piglin_-_converted.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("craft_defense:textures/screens/puffer_fish_small_-_converted.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("craft_defense:textures/screens/iron_golem_-_converted.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("craft_defense:textures/screens/eba.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("craft_defense:textures/screens/snogolem3.png");
	private static final ResourceLocation IMAGE_17 = ResourceLocation.parse("craft_defense:textures/screens/husk.png");
	private static final ResourceLocation IMAGE_18 = ResourceLocation.parse("craft_defense:textures/screens/magma_cube.png");
	private static final ResourceLocation IMAGE_19 = ResourceLocation.parse("craft_defense:textures/screens/polar_bear.png");
	private static final ResourceLocation IMAGE_20 = ResourceLocation.parse("craft_defense:textures/screens/chargedcreeperunit2.png");
	private static final ResourceLocation IMAGE_21 = ResourceLocation.parse("craft_defense:textures/screens/ravager2.png");
	private static final ResourceLocation IMAGE_22 = ResourceLocation.parse("craft_defense:textures/screens/endermana.png");
	private static final ResourceLocation IMAGE_23 = ResourceLocation.parse("craft_defense:textures/screens/wolf.png");
	private static final ResourceLocation IMAGE_24 = ResourceLocation.parse("craft_defense:textures/screens/pillager.png");
	private static final ResourceLocation IMAGE_25 = ResourceLocation.parse("craft_defense:textures/screens/bogged.png");

	public UnitMachineGUIScreen(UnitMachineGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 230;
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
		if (mouseX > leftPos + 90 && mouseX < leftPos + 114 && mouseY > topPos + 120 && mouseY < topPos + 144) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.unit_machine_gui.tooltip_roll"), mouseX, mouseY);
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
		guiTools$alphaBlit(guiGraphics, BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiTools$orderedImages : {
			guiTools$alphaBlit(guiGraphics, IMAGE_0, this.leftPos + 99, this.topPos + 21, 0, 0, 90, 90, 90, 90);
			guiTools$alphaBlit(guiGraphics, IMAGE_1, this.leftPos + 18, this.topPos + 125, 0, 0, 16, 16, 16, 16);
			if (LRCreeperProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_2, this.leftPos + 131, this.topPos + 35, 0, 0, 32, 65, 32, 65);
			}
			if (LRZombieProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_3, this.leftPos + 126, this.topPos + 44, 0, 0, 32, 56, 32, 56);
			}
			if (LRSkeletonProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_4, this.leftPos + 126, this.topPos + 39, 0, 0, 32, 57, 32, 57);
			}
			if (LRSlimeProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_5, this.leftPos + 126, this.topPos + 53, 0, 0, 32, 35, 32, 35);
			}
			if (LRWitchProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_6, this.leftPos + 126, this.topPos + 30, 0, 0, 32, 74, 32, 74);
			}
			if (LRSpiderProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_7, this.leftPos + 113, this.topPos + 39, 0, 0, 64, 53, 64, 53);
			}
			if (LRVillagerProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_8, this.leftPos + 131, this.topPos + 39, 0, 0, 32, 54, 32, 54);
			}
			if (LRCaveSpiderProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_9, this.leftPos + 113, this.topPos + 48, 0, 0, 64, 45, 64, 45);
			}
			if (LRStrayProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_10, this.leftPos + 126, this.topPos + 35, 0, 0, 32, 58, 32, 58);
			}
			if (LRZombifiedPiglinProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_11, this.leftPos + 126, this.topPos + 39, 0, 0, 32, 57, 32, 57);
			}
			if (LRPiglinProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_12, this.leftPos + 108, this.topPos + 30, 0, 0, 64, 76, 64, 76);
			}
			if (LRPufferFishProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_13, this.leftPos + 113, this.topPos + 30, 0, 0, 64, 67, 64, 67);
			}
			if (LRIronGolemProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_14, this.leftPos + 131, this.topPos + 35, 0, 0, 32, 60, 32, 60);
			}
			if (EpicLegendaryReturnProcedure.execute(world, x, y, z)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_15, this.leftPos + 198, this.topPos + 102, 0, 0, 108, 108, 108, 108);
			}
			if (LRSnowGolemProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_16, this.leftPos + 131, this.topPos + 35, 0, 0, 32, 61, 32, 61);
			}
			if (LRHuskProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_17, this.leftPos + 126, this.topPos + 44, 0, 0, 32, 53, 32, 53);
			}
			if (LRMagmaCubeProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_18, this.leftPos + 113, this.topPos + 30, 0, 0, 64, 71, 64, 71);
			}
			if (LRPolarBearProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_19, this.leftPos + 113, this.topPos + 39, 0, 0, 64, 59, 64, 59);
			}
			if (LRChargedCreeperProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_20, this.leftPos + 126, this.topPos + 39, 0, 0, 32, 56, 32, 56);
			}
			if (LRRavagerProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_21, this.leftPos + 113, this.topPos + 35, 0, 0, 64, 60, 64, 60);
			}
			if (LREndermanProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_22, this.leftPos + 135, this.topPos + 35, 0, 0, 16, 64, 16, 64);
			}
			if (LRWolfProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_23, this.leftPos + 113, this.topPos + 39, 0, 0, 64, 58, 64, 58);
			}
			if (LRPillagerProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_24, this.leftPos + 108, this.topPos + 26, 0, 0, 64, 83, 64, 83);
			}
			if (LRBoggedProcedure.execute(entity)) {
				guiTools$alphaBlit(guiGraphics, IMAGE_25, this.leftPos + 131, this.topPos + 35, 0, 0, 33, 64, 33, 64);
			}
			if (net.juujks.craft_defense.procedures.LRDrownedProcedure.execute(entity)) {
				int guiTools$xOffset = 0;
				int guiTools$yOffset = 0;
				int guiTools$visibleWidth = 48;
				int guiTools$visibleHeight = 79;
				net.minecraft.resources.ResourceLocation guiTools$image = guiTools$dynamicTexture("", net.minecraft.resources.ResourceLocation.parse("craft_defense:textures/screens/drowned.png"));
				if (guiTools$image != null && guiTools$visibleWidth > 0 && guiTools$visibleHeight > 0)
					guiTools$alphaBlit(guiGraphics, guiTools$image, this.leftPos + 118 + guiTools$xOffset, this.topPos + 26 + guiTools$yOffset, 0, 0, guiTools$visibleWidth, guiTools$visibleHeight, 48, 79);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_machine_gui.label_unit_machine"), 9, 8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_machine_gui.label_info"), 36, 21, -12829636, false);
		guiGraphics.drawString(this.font, ReturnAmountOfGemsProcedure.execute(world, entity), 36, 129, -12829636, false);
		guiGraphics.drawString(this.font, ReturnNameOfEntityProcedure.execute(entity), 5, 39, -12829636, false);
		guiGraphics.drawString(this.font, ReturnRarityProcedure.execute(entity), 5, 57, -12829636, false);
		guiGraphics.drawString(this.font, ReturnEntityTypeProcedure.execute(entity), 5, 75, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_machine_gui.label_upgrades"), 27, 93, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_machine_gui.label_2x_gems_to_roll"), 72, 111, -12829636, false);
		if (EpicLegendaryReturnProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_machine_gui.label_index"), 239, 107, -1, false);
		if (EpicUpReturnProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_machine_gui.label_rare_80_chance"), 203, 125, -13369345, false);
		if (EpicLegendaryReturnProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_machine_gui.label_epic_20"), 203, 138, -3407668, false);
		if (LegendaryUpReturnProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_machine_gui.label_legendary_5"), 203, 152, -205, false);
		guiGraphics.drawString(this.font, ReturnAdditionalLuckPProcedure.execute(entity), 203, 170, -10027162, false);
		guiGraphics.drawString(this.font, LegendaryPityTextProcedure.execute(world, x, y, z, entity), 203, 188, -393472, false);
		if (LegendaryUpReturnProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_machine_gui.label_rare_75_chance"), 203, 125, -13369345, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_roll = new ImageButton(this.leftPos + 91, this.topPos + 121, 24, 24, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/roll.png"), ResourceLocation.parse("craft_defense:textures/screens/rollh.png")), e -> {
			int x = UnitMachineGUIScreen.this.x;
			int y = UnitMachineGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new UnitMachineGUIButtonMessage(0, x, y, z));
				UnitMachineGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiTools$alphaBlit(guiGraphics, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_roll);
	}

	private static net.minecraft.resources.ResourceLocation guiTools$dynamicTexture(String value, net.minecraft.resources.ResourceLocation fallback) {
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