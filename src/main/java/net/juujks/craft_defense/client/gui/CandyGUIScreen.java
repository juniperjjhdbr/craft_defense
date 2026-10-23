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
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.juujks.craft_defense.world.inventory.CandyGUIMenu;
import net.juujks.craft_defense.procedures.*;
import net.juujks.craft_defense.network.CandyGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class CandyGUIScreen extends AbstractContainerScreen<CandyGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_max_all;
	private ImageButton imagebutton_confirm;
	private ImageButton imagebutton_plus;
	private ImageButton imagebutton_minus;
	private ImageButton imagebutton_plus1;
	private ImageButton imagebutton_minus1;
	private ImageButton imagebutton_plus2;
	private ImageButton imagebutton_minus2;
	private ImageButton imagebutton_plus3;
	private ImageButton imagebutton_minus3;
	private ImageButton imagebutton_cancel;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("craft_defense:textures/screens/candy_gui.png");

	public CandyGUIScreen(CandyGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
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
		if (mouseX > leftPos + 45 && mouseX < leftPos + 69 && mouseY > topPos + 96 && mouseY < topPos + 120) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.candy_gui.tooltip_confirm"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 244 && mouseX < leftPos + 268 && mouseY > topPos + 96 && mouseY < topPos + 120) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.candy_gui.tooltip_reset"), mouseX, mouseY);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.candy_gui.label_evolution_crystal"), 5, 6, -12829636, false);
		guiGraphics.drawString(this.font, ReturnUnitName2Procedure.execute(entity), 5, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.candy_gui.label_common"), 118, 6, -12829636, false);
		guiGraphics.drawString(this.font, ReturnCommonCandyProcedure.execute(world, entity), 158, 6, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.candy_gui.label_rare"), 118, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.candy_gui.label_epic"), 118, 83, -12829636, false);
		guiGraphics.drawString(this.font, ReturnRareCandyProcedure.execute(world, entity), 149, 42, -10027009, false);
		guiGraphics.drawString(this.font, ReturnEpicCandyProcedure.execute(world, entity), 149, 83, -6749953, false);
		guiGraphics.drawString(this.font, ReturnLevelPProcedure.execute(entity), 32, 47, -12829636, false);
		guiGraphics.drawString(this.font, ReturnXPPProcedure.execute(entity), 32, 60, -12829636, false);
		guiGraphics.drawString(this.font, ReturnXPToAddProcedure.execute(entity), 23, 83, -16711681, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.craft_defense.candy_gui.label_legendary"), 212, 6, -12829636, false);
		guiGraphics.drawString(this.font, ReturnLegendaryCandyProcedure.execute(world, entity), 266, 6, -256, false);
	}

	@Override
	public void init() {
		super.init();
		button_max_all = Button.builder(Component.translatable("gui.craft_defense.candy_gui.button_max_all"), e -> {
			int x = CandyGUIScreen.this.x;
			int y = CandyGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CandyGUIButtonMessage(0, x, y, z));
				CandyGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 226, this.topPos + 74, 61, 20).build();
		this.addRenderableWidget(button_max_all);
		imagebutton_confirm = new ImageButton(this.leftPos + 45, this.topPos + 96, 24, 24, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/confirm.png"), ResourceLocation.parse("craft_defense:textures/screens/confirmh.png")),
				e -> {
					int x = CandyGUIScreen.this.x;
					int y = CandyGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CandyGUIButtonMessage(1, x, y, z));
						CandyGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_confirm);
		imagebutton_plus = new ImageButton(this.leftPos + 136, this.topPos + 20, 16, 16, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/plus.png"), ResourceLocation.parse("craft_defense:textures/screens/plush.png")), e -> {
			int x = CandyGUIScreen.this.x;
			int y = CandyGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CandyGUIButtonMessage(2, x, y, z));
				CandyGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_plus);
		imagebutton_minus = new ImageButton(this.leftPos + 154, this.topPos + 20, 16, 16, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/minus.png"), ResourceLocation.parse("craft_defense:textures/screens/minush.png")),
				e -> {
					int x = CandyGUIScreen.this.x;
					int y = CandyGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CandyGUIButtonMessage(3, x, y, z));
						CandyGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_minus);
		imagebutton_plus1 = new ImageButton(this.leftPos + 136, this.topPos + 56, 16, 16, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/plus.png"), ResourceLocation.parse("craft_defense:textures/screens/plush.png")), e -> {
			int x = CandyGUIScreen.this.x;
			int y = CandyGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CandyGUIButtonMessage(4, x, y, z));
				CandyGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_plus1);
		imagebutton_minus1 = new ImageButton(this.leftPos + 154, this.topPos + 56, 16, 16, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/minus.png"), ResourceLocation.parse("craft_defense:textures/screens/minush.png")),
				e -> {
					int x = CandyGUIScreen.this.x;
					int y = CandyGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CandyGUIButtonMessage(5, x, y, z));
						CandyGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_minus1);
		imagebutton_plus2 = new ImageButton(this.leftPos + 136, this.topPos + 96, 16, 16, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/plus.png"), ResourceLocation.parse("craft_defense:textures/screens/plush.png")), e -> {
			int x = CandyGUIScreen.this.x;
			int y = CandyGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CandyGUIButtonMessage(6, x, y, z));
				CandyGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_plus2);
		imagebutton_minus2 = new ImageButton(this.leftPos + 154, this.topPos + 96, 16, 16, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/minus.png"), ResourceLocation.parse("craft_defense:textures/screens/minush.png")),
				e -> {
					int x = CandyGUIScreen.this.x;
					int y = CandyGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CandyGUIButtonMessage(7, x, y, z));
						CandyGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_minus2);
		imagebutton_plus3 = new ImageButton(this.leftPos + 230, this.topPos + 20, 16, 16, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/plus.png"), ResourceLocation.parse("craft_defense:textures/screens/plush.png")), e -> {
			int x = CandyGUIScreen.this.x;
			int y = CandyGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CandyGUIButtonMessage(8, x, y, z));
				CandyGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_plus3);
		imagebutton_minus3 = new ImageButton(this.leftPos + 248, this.topPos + 20, 16, 16, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/minus.png"), ResourceLocation.parse("craft_defense:textures/screens/minush.png")),
				e -> {
					int x = CandyGUIScreen.this.x;
					int y = CandyGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CandyGUIButtonMessage(9, x, y, z));
						CandyGUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_minus3);
		imagebutton_cancel = new ImageButton(this.leftPos + 244, this.topPos + 96, 24, 24, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/cancel.png"), ResourceLocation.parse("craft_defense:textures/screens/cancelh.png")),
				e -> {
					int x = CandyGUIScreen.this.x;
					int y = CandyGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CandyGUIButtonMessage(10, x, y, z));
						CandyGUIButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cancel);
	}
}