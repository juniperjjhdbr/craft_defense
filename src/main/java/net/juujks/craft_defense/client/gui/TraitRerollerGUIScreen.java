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

import net.juujks.craft_defense.world.inventory.TraitRerollerGUIMenu;
import net.juujks.craft_defense.procedures.*;
import net.juujks.craft_defense.network.TraitRerollerGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class TraitRerollerGUIScreen extends AbstractContainerScreen<TraitRerollerGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_roll;
	private ImageButton imagebutton_30_sem_titulo_20260817150557;
	private ImageButton imagebutton_30_sem_titulo_202608171505571;
	private ImageButton imagebutton_30_sem_titulo_202608171505572;
	private ImageButton imagebutton_30_sem_titulo_20260817150521;
	private ImageButton imagebutton_30_sem_titulo_202608171505211;
	private ImageButton imagebutton_30_sem_titulo_202608171505212;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("craft_defense:textures/screens/trait_reroller_gui.png");

	public TraitRerollerGUIScreen(TraitRerollerGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 220;
		this.imageHeight = 200;
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
		if (mouseX > leftPos + 99 && mouseX < leftPos + 123 && mouseY > topPos + 92 && mouseY < topPos + 116) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.trait_reroller_gui.tooltip_roll"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 185 && mouseX < leftPos + 209 && mouseY > topPos + 20 && mouseY < topPos + 44) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.trait_reroller_gui.tooltip_lock_stats_reroll_uses_1_stat"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 185 && mouseX < leftPos + 209 && mouseY > topPos + 47 && mouseY < topPos + 71) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.trait_reroller_gui.tooltip_lock_stats_reroll_uses_1_stat1"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 185 && mouseX < leftPos + 209 && mouseY > topPos + 74 && mouseY < topPos + 98) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.trait_reroller_gui.tooltip_lock_stats_reroll_uses_1_stat2"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.trait_reroller_gui.label_trait_reroller"), 5, 7, -12829636, false);
		guiGraphics.drawString(this.font, ReturnUnitTraitProcedure.execute(world, x, y, z), 27, 38, -12829636, false);
		guiGraphics.drawString(this.font, ReturnUnitNameProcedure.execute(world, x, y, z), 27, 25, -12829636, false);
		guiGraphics.drawString(this.font, ReturnUnitInfoProcedure.execute(world, x, y, z), 27, 52, -12829636, false);
		guiGraphics.drawString(this.font, ReturnTraitRarityProcedure.execute(entity), 27, 65, -12829636, false);
		guiGraphics.drawString(this.font, ReturnAdditionalLuckPProcedure.execute(entity), 104, 7, -10027264, false);
		guiGraphics.drawString(this.font, ReturnUnitFirstLevelStatsProcedure.execute(world, x, y, z), 27, 79, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.trait_reroller_gui.label_dmg"), 189, 20, -65536, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.trait_reroller_gui.label_rng"), 189, 47, -205, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.trait_reroller_gui.label_spa"), 189, 74, -16777012, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_roll = new ImageButton(this.leftPos + 99, this.topPos + 92, 24, 24, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/roll.png"), ResourceLocation.parse("craft_defense:textures/screens/rollh.png")), e -> {
			int x = TraitRerollerGUIScreen.this.x;
			int y = TraitRerollerGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new TraitRerollerGUIButtonMessage(0, x, y, z));
				TraitRerollerGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_roll);
		imagebutton_30_sem_titulo_20260817150557 = new ImageButton(this.leftPos + 180, this.topPos + 29, 15, 15,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/30_sem_titulo_20260817150557.png"), ResourceLocation.parse("craft_defense:textures/screens/30_sem_titulo_20260817153146.png")), e -> {
					int x = TraitRerollerGUIScreen.this.x;
					int y = TraitRerollerGUIScreen.this.y;
					if (LockCond1Procedure.execute(world, entity)) {
						PacketDistributor.sendToServer(new TraitRerollerGUIButtonMessage(1, x, y, z));
						TraitRerollerGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_30_sem_titulo_20260817150557);
		imagebutton_30_sem_titulo_202608171505571 = new ImageButton(this.leftPos + 180, this.topPos + 56, 15, 15,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/30_sem_titulo_20260817150557.png"), ResourceLocation.parse("craft_defense:textures/screens/30_sem_titulo_20260817153146.png")), e -> {
					int x = TraitRerollerGUIScreen.this.x;
					int y = TraitRerollerGUIScreen.this.y;
					if (LockCond3Procedure.execute(world, entity)) {
						PacketDistributor.sendToServer(new TraitRerollerGUIButtonMessage(2, x, y, z));
						TraitRerollerGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_30_sem_titulo_202608171505571);
		imagebutton_30_sem_titulo_202608171505572 = new ImageButton(this.leftPos + 180, this.topPos + 83, 15, 15,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/30_sem_titulo_20260817150557.png"), ResourceLocation.parse("craft_defense:textures/screens/30_sem_titulo_20260817153146.png")), e -> {
					int x = TraitRerollerGUIScreen.this.x;
					int y = TraitRerollerGUIScreen.this.y;
					if (LockCond5Procedure.execute(world, entity)) {
						PacketDistributor.sendToServer(new TraitRerollerGUIButtonMessage(3, x, y, z));
						TraitRerollerGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_30_sem_titulo_202608171505572);
		imagebutton_30_sem_titulo_20260817150521 = new ImageButton(this.leftPos + 198, this.topPos + 29, 15, 15,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/30_sem_titulo_20260817150521.png"), ResourceLocation.parse("craft_defense:textures/screens/30_sem_titulo_20260817153204.png")), e -> {
					int x = TraitRerollerGUIScreen.this.x;
					int y = TraitRerollerGUIScreen.this.y;
					if (LockCond2Procedure.execute(world, entity)) {
						PacketDistributor.sendToServer(new TraitRerollerGUIButtonMessage(4, x, y, z));
						TraitRerollerGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_30_sem_titulo_20260817150521);
		imagebutton_30_sem_titulo_202608171505211 = new ImageButton(this.leftPos + 198, this.topPos + 56, 15, 15,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/30_sem_titulo_20260817150521.png"), ResourceLocation.parse("craft_defense:textures/screens/30_sem_titulo_20260817153204.png")), e -> {
					int x = TraitRerollerGUIScreen.this.x;
					int y = TraitRerollerGUIScreen.this.y;
					if (LockCond4Procedure.execute(world, entity)) {
						PacketDistributor.sendToServer(new TraitRerollerGUIButtonMessage(5, x, y, z));
						TraitRerollerGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_30_sem_titulo_202608171505211);
		imagebutton_30_sem_titulo_202608171505212 = new ImageButton(this.leftPos + 198, this.topPos + 83, 15, 15,
				new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/30_sem_titulo_20260817150521.png"), ResourceLocation.parse("craft_defense:textures/screens/30_sem_titulo_20260817153204.png")), e -> {
					int x = TraitRerollerGUIScreen.this.x;
					int y = TraitRerollerGUIScreen.this.y;
					if (LockCond6Procedure.execute(world, entity)) {
						PacketDistributor.sendToServer(new TraitRerollerGUIButtonMessage(6, x, y, z));
						TraitRerollerGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_30_sem_titulo_202608171505212);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.imagebutton_30_sem_titulo_20260817150557.visible = LockCond1Procedure.execute(world, entity);
		this.imagebutton_30_sem_titulo_202608171505571.visible = LockCond3Procedure.execute(world, entity);
		this.imagebutton_30_sem_titulo_202608171505572.visible = LockCond5Procedure.execute(world, entity);
		this.imagebutton_30_sem_titulo_20260817150521.visible = LockCond2Procedure.execute(world, entity);
		this.imagebutton_30_sem_titulo_202608171505211.visible = LockCond4Procedure.execute(world, entity);
		this.imagebutton_30_sem_titulo_202608171505212.visible = LockCond6Procedure.execute(world, entity);
	}
}