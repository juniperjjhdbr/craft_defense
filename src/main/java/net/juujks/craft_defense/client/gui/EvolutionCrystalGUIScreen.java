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

import net.juujks.craft_defense.world.inventory.EvolutionCrystalGUIMenu;
import net.juujks.craft_defense.procedures.ReturnUnitName2Procedure;
import net.juujks.craft_defense.procedures.ReturnEvoCrystalAmountProcedure;
import net.juujks.craft_defense.network.EvolutionCrystalGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class EvolutionCrystalGUIScreen extends AbstractContainerScreen<EvolutionCrystalGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_confirm;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("craft_defense:textures/screens/evolution_crystal_gui.png");

	public EvolutionCrystalGUIScreen(EvolutionCrystalGUIMenu container, Inventory inventory, Component text) {
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
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 76 && mouseX < leftPos + 100 && mouseY > topPos + 58 && mouseY < topPos + 82) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.evolution_crystal_gui.tooltip_evolve"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.evolution_crystal_gui.label_evolution_crystal"), 6, 7, -12829636, false);
		guiGraphics.drawString(this.font, ReturnUnitName2Procedure.execute(entity), 6, 21, -12829636, false);
		guiGraphics.drawString(this.font, ReturnEvoCrystalAmountProcedure.execute(entity), 87, 43, -10027162, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_confirm = new ImageButton(this.leftPos + 76, this.topPos + 58, 24, 24, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/confirm.png"), ResourceLocation.parse("craft_defense:textures/screens/confirmh.png")),
				e -> {
					int x = EvolutionCrystalGUIScreen.this.x;
					int y = EvolutionCrystalGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new EvolutionCrystalGUIButtonMessage(0, x, y, z));
						EvolutionCrystalGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_confirm);
	}
}