package net.juujks.craft_defense.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.juujks.craft_defense.world.inventory.UnitInfoGUIMenu;
import net.juujks.craft_defense.procedures.ShowEntityTestProcedure;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class UnitInfoGUIScreen extends AbstractContainerScreen<UnitInfoGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/unitinfo.png");

	public UnitInfoGUIScreen(UnitInfoGUIMenu container, Inventory inventory, Component text) {
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
		if (ShowEntityTestProcedure.execute(world, x, y, z, entity) instanceof LivingEntity livingEntity) {
			CraftDefenseModScreens.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 97, this.topPos + 245, 100, 0f + (float) Math.atan((this.leftPos + 97 - mouseX) / 40.0), (float) Math.atan((this.topPos + 196 - mouseY) / 40.0),
					livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + 7, this.topPos + 1, 0, 0, 464, 261, 464, 261);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_deploy_price"), 213, 86, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_200"), 285, 86, -13369549, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_steve"), 213, 72, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_steve1"), 267, 72, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_rarity"), 213, 99, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_common"), 254, 99, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_level"), 213, 113, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_1"), 249, 113, -13369345, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_trait"), 213, 126, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_swordsman"), 249, 126, -26368, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_owner"), 213, 140, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_polarks9"), 249, 140, -256, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_basic_info"), 231, 63, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_evolved"), 213, 153, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_no"), 317, 153, -13369600, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_times_used"), 213, 167, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_100"), 272, 167, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.unit_info_gui.label_total_damage_dealed"), 213, 180, -1, false);
	}

	@Override
	public void init() {
		super.init();
	}
}