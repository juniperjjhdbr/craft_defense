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

import net.juujks.craft_defense.world.inventory.RewardGUIMenu;
import net.juujks.craft_defense.procedures.*;
import net.juujks.craft_defense.network.RewardGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class RewardGUIScreen extends AbstractContainerScreen<RewardGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_claim;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/level_complete2.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("craft_defense:textures/screens/towergem.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("craft_defense:textures/screens/w1throphy.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("craft_defense:textures/screens/w2throphy.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("craft_defense:textures/screens/traitcube.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("craft_defense:textures/screens/w3throphy.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("craft_defense:textures/screens/evolution_crystal1.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("craft_defense:textures/screens/porkchop.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("craft_defense:textures/screens/mutton.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("craft_defense:textures/screens/chicken.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("craft_defense:textures/screens/beef.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("craft_defense:textures/screens/spruce_sapling.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("craft_defense:textures/screens/coal.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("craft_defense:textures/screens/rotten_flesh.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("craft_defense:textures/screens/bone.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("craft_defense:textures/screens/string.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("craft_defense:textures/screens/gunpowder.png");
	private static final ResourceLocation IMAGE_17 = ResourceLocation.parse("craft_defense:textures/screens/emerald.png");
	private static final ResourceLocation IMAGE_18 = ResourceLocation.parse("craft_defense:textures/screens/wheat.png");
	private static final ResourceLocation IMAGE_19 = ResourceLocation.parse("craft_defense:textures/screens/carrot.png");
	private static final ResourceLocation IMAGE_20 = ResourceLocation.parse("craft_defense:textures/screens/potato.png");
	private static final ResourceLocation IMAGE_21 = ResourceLocation.parse("craft_defense:textures/screens/cactus_je4.png");
	private static final ResourceLocation IMAGE_22 = ResourceLocation.parse("craft_defense:textures/screens/dead_bush.png");
	private static final ResourceLocation IMAGE_23 = ResourceLocation.parse("craft_defense:textures/screens/skeleton_item.png");
	private static final ResourceLocation IMAGE_24 = ResourceLocation.parse("craft_defense:textures/screens/common_exp_candy.png");
	private static final ResourceLocation IMAGE_25 = ResourceLocation.parse("craft_defense:textures/screens/feather.png");
	private static final ResourceLocation IMAGE_26 = ResourceLocation.parse("craft_defense:textures/screens/white_wool_je2_be2.png");
	private static final ResourceLocation IMAGE_27 = ResourceLocation.parse("craft_defense:textures/screens/leather.png");
	private static final ResourceLocation IMAGE_28 = ResourceLocation.parse("craft_defense:textures/screens/honey_bottle.png");
	private static final ResourceLocation IMAGE_29 = ResourceLocation.parse("craft_defense:textures/screens/rabbit_foot.png");
	private static final ResourceLocation IMAGE_30 = ResourceLocation.parse("craft_defense:textures/screens/iron_ingot.png");
	private static final ResourceLocation IMAGE_31 = ResourceLocation.parse("craft_defense:textures/screens/iron_ingot.png");
	private static final ResourceLocation IMAGE_32 = ResourceLocation.parse("craft_defense:textures/screens/gold_ingot.png");
	private static final ResourceLocation IMAGE_33 = ResourceLocation.parse("craft_defense:textures/screens/diamond.png");
	private static final ResourceLocation IMAGE_34 = ResourceLocation.parse("craft_defense:textures/screens/redstonedust.png");
	private static final ResourceLocation IMAGE_35 = ResourceLocation.parse("craft_defense:textures/screens/lapis_lazuli.png");
	private static final ResourceLocation IMAGE_36 = ResourceLocation.parse("craft_defense:textures/screens/coal.png");
	private static final ResourceLocation IMAGE_37 = ResourceLocation.parse("craft_defense:textures/screens/diamond.png");
	private static final ResourceLocation IMAGE_38 = ResourceLocation.parse("craft_defense:textures/screens/obsidian_je3_be2.png");
	private static final ResourceLocation IMAGE_39 = ResourceLocation.parse("craft_defense:textures/screens/iron_ingot.png");
	private static final ResourceLocation IMAGE_40 = ResourceLocation.parse("craft_defense:textures/screens/villager_item.png");
	private static final ResourceLocation IMAGE_41 = ResourceLocation.parse("craft_defense:textures/screens/diamond.png");
	private static final ResourceLocation IMAGE_42 = ResourceLocation.parse("craft_defense:textures/screens/common_exp_candy.png");
	private static final ResourceLocation IMAGE_43 = ResourceLocation.parse("craft_defense:textures/screens/iron_ingot.png");
	private static final ResourceLocation IMAGE_44 = ResourceLocation.parse("craft_defense:textures/screens/stray_item.png");
	private static final ResourceLocation IMAGE_45 = ResourceLocation.parse("craft_defense:textures/screens/common_exp_candy.png");
	private static final ResourceLocation IMAGE_46 = ResourceLocation.parse("craft_defense:textures/screens/common_exp_candy.png");
	private static final ResourceLocation IMAGE_47 = ResourceLocation.parse("craft_defense:textures/screens/rare_exp_candy.png");
	private static final ResourceLocation IMAGE_48 = ResourceLocation.parse("craft_defense:textures/screens/common_exp_candy.png");
	private static final ResourceLocation IMAGE_49 = ResourceLocation.parse("craft_defense:textures/screens/rare_exp_candy.png");
	private static final ResourceLocation IMAGE_50 = ResourceLocation.parse("craft_defense:textures/screens/epic_exp_candy.png");
	private static final ResourceLocation IMAGE_51 = ResourceLocation.parse("craft_defense:textures/screens/w4throphy.png");
	private static final ResourceLocation IMAGE_52 = ResourceLocation.parse("craft_defense:textures/screens/w5throphy.png");
	private static final ResourceLocation IMAGE_53 = ResourceLocation.parse("craft_defense:textures/screens/w6throphy2.png");
	private static final ResourceLocation IMAGE_54 = ResourceLocation.parse("craft_defense:textures/screens/breeze_item.png");
	private static final ResourceLocation IMAGE_55 = ResourceLocation.parse("craft_defense:textures/screens/rare_exp_candy.png");
	private static final ResourceLocation IMAGE_56 = ResourceLocation.parse("craft_defense:textures/screens/duplication_token.png");
	private static final ResourceLocation IMAGE_57 = ResourceLocation.parse("craft_defense:textures/screens/23_sem_titulo_20260816204235.png");

	public RewardGUIScreen(RewardGUIMenu container, Inventory inventory, Component text) {
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 20, this.topPos + 0, 0, 0, 464, 261, 464, 261);
		if (TraitCubeCondition2Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_1, this.leftPos + 258, this.topPos + 81, 0, 0, 16, 16, 16, 16);
		}
		if (WaveReturnPProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_2, this.leftPos + 348, this.topPos + 113, 0, 0, 16, 16, 16, 16);
		}
		if (WaveReturnP2Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_3, this.leftPos + 348, this.topPos + 113, 0, 0, 16, 16, 16, 16);
		}
		if (TraitCubeConditionProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_4, this.leftPos + 348, this.topPos + 81, 0, 0, 16, 16, 16, 16);
		}
		if (WaveReturnP3Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_5, this.leftPos + 348, this.topPos + 113, 0, 0, 16, 16, 16, 16);
		}
		if (ReturnEvolutionCrystalChanceProcedure.execute(world)) {
			guiGraphics.blit(IMAGE_6, this.leftPos + 258, this.topPos + 113, 0, 0, 16, 16, 16, 16);
		}
		if (L1Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_7, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L2Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_8, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L3Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_9, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L4Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_10, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L5Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_11, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L6Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_12, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L7Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_13, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L8Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_14, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L9Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_15, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L10Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_16, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L11Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_17, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L12Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_18, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L13Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_19, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L14Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_20, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L15Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_21, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L16Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_22, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L17Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_23, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L18Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_24, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL1Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_25, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL2Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_26, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL3Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_27, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL4Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_28, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL5Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_29, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL6Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_30, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL7Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_31, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL8Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_32, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL9Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_33, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL10Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_34, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL11Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_35, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL12Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_36, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL13Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_37, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL14Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_38, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL15Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_39, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL16Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_40, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL17Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_41, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (L18Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_42, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL19Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_43, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LL20Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_44, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (C1Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_45, this.leftPos + 317, this.topPos + 171, 0, 0, 16, 16, 16, 16);
		}
		if (C2Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_46, this.leftPos + 317, this.topPos + 171, 0, 0, 16, 16, 16, 16);
		}
		if (C3Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_47, this.leftPos + 317, this.topPos + 171, 0, 0, 16, 16, 16, 16);
		}
		if (C4Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_48, this.leftPos + 317, this.topPos + 171, 0, 0, 16, 16, 16, 16);
		}
		if (C5Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_49, this.leftPos + 317, this.topPos + 171, 0, 0, 16, 16, 16, 16);
		}
		if (C6Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_50, this.leftPos + 317, this.topPos + 171, 0, 0, 16, 16, 16, 16);
		}
		if (WaveReturnP4Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_51, this.leftPos + 348, this.topPos + 113, 0, 0, 16, 16, 16, 16);
		}
		if (WaveReturnP5Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_52, this.leftPos + 348, this.topPos + 113, 0, 0, 16, 16, 16, 16);
		}
		if (WaveReturnP6Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_53, this.leftPos + 348, this.topPos + 113, 0, 0, 16, 16, 16, 16);
		}
		if (LBR1Procedure.execute(world, entity)) {
			guiGraphics.blit(IMAGE_54, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (LBR2Procedure.execute(world, entity)) {
			guiGraphics.blit(IMAGE_55, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (M1Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_56, this.leftPos + 348, this.topPos + 144, 0, 0, 16, 16, 16, 16);
		}
		if (M1Procedure.execute(world)) {
			guiGraphics.blit(IMAGE_57, this.leftPos + 258, this.topPos + 144, 0, 0, 16, 16, 16, 16);
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
		if (TraitCubeCondition2Procedure.execute(world))
			guiGraphics.drawString(this.font, GemsToGiveProcedure.execute(world), 276, 86, -1, false);
		if (TraitCubeCondition2Procedure.execute(world))
			guiGraphics.drawString(this.font, XpGrantedProcedure.execute(world), 312, 185, -13369549, false);
		if (WaveReturnP0Procedure.execute(world))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.reward_gui.label_1x"), 366, 117, -1, false);
		if (TraitCubeConditionProcedure.execute(world))
			guiGraphics.drawString(this.font, TraitsCubeReturnProcedure.execute(world), 366, 86, -1, false);
		if (ReturnEvolutionCrystalChanceProcedure.execute(world))
			guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.reward_gui.label_1x1"), 276, 117, -1, false);
		guiGraphics.drawString(this.font, ReturnCommonAmountProcedure.execute(world), 276, 149, -1, false);
		guiGraphics.drawString(this.font, ReturnRareAmountProcedure.execute(world), 366, 149, -1, false);
		guiGraphics.drawString(this.font, ReturnCandyAmountProcedure.execute(world), 335, 176, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_claim = Button.builder(Component.translatable("gui.craft_defense.reward_gui.button_claim"), e -> {
			int x = RewardGUIScreen.this.x;
			int y = RewardGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new RewardGUIButtonMessage(0, x, y, z));
				RewardGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 308, this.topPos + 194, 51, 20).build();
		this.addRenderableWidget(button_claim);
	}
}