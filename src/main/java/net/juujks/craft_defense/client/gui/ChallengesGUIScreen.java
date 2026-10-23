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

import net.juujks.craft_defense.world.inventory.ChallengesGUIMenu;
import net.juujks.craft_defense.network.ChallengesGUIButtonMessage;
import net.juujks.craft_defense.init.CraftDefenseModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class ChallengesGUIScreen extends AbstractContainerScreen<ChallengesGUIMenu> implements CraftDefenseModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_cancel;
	private ImageButton imagebutton_chaa1h;
	private ImageButton imagebutton_chaa2u;
	private ImageButton imagebutton_chaa3u;
	private ImageButton imagebutton_chaa4u;
	private ImageButton imagebutton_chaa5u;
	private ImageButton imagebutton_chaa6u;
	private ImageButton imagebutton_chaa7u;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("craft_defense:textures/screens/act1.png");

	public ChallengesGUIScreen(ChallengesGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 162;
		this.imageHeight = 170;
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
		if (mouseX > leftPos + 13 && mouseX < leftPos + 37 && mouseY > topPos + 41 && mouseY < topPos + 65) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.challenges_gui.tooltip_half_money"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 49 && mouseX < leftPos + 73 && mouseY > topPos + 41 && mouseY < topPos + 65) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.challenges_gui.tooltip_unsellable"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 89 && mouseX < leftPos + 113 && mouseY > topPos + 41 && mouseY < topPos + 65) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.challenges_gui.tooltip_hard_mode"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 130 && mouseX < leftPos + 154 && mouseY > topPos + 41 && mouseY < topPos + 65) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.challenges_gui.tooltip_insane_mode"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 31 && mouseX < leftPos + 55 && mouseY > topPos + 86 && mouseY < topPos + 110) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.challenges_gui.tooltip_aerial_enemies"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 71 && mouseX < leftPos + 95 && mouseY > topPos + 86 && mouseY < topPos + 110) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.challenges_gui.tooltip_single_units"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 112 && mouseX < leftPos + 136 && mouseY > topPos + 86 && mouseY < topPos + 110) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.craft_defense.challenges_gui.tooltip_no_unit_level"), mouseX, mouseY);
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 464, 261, 464, 261);
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
	}

	@Override
	public void init() {
		super.init();
		button_cancel = Button.builder(Component.translatable("gui.craft_defense.challenges_gui.button_cancel"), e -> {
			int x = ChallengesGUIScreen.this.x;
			int y = ChallengesGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ChallengesGUIButtonMessage(0, x, y, z));
				ChallengesGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 53, this.topPos + 135, 56, 20).build();
		this.addRenderableWidget(button_cancel);
		imagebutton_chaa1h = new ImageButton(this.leftPos + 8, this.topPos + 36, 32, 32, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/chaa1u.png"), ResourceLocation.parse("craft_defense:textures/screens/chaa1h.png")),
				e -> {
					int x = ChallengesGUIScreen.this.x;
					int y = ChallengesGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new ChallengesGUIButtonMessage(1, x, y, z));
						ChallengesGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_chaa1h);
		imagebutton_chaa2u = new ImageButton(this.leftPos + 47, this.topPos + 36, 32, 32, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/chaa2u.png"), ResourceLocation.parse("craft_defense:textures/screens/chaa2h.png")),
				e -> {
					int x = ChallengesGUIScreen.this.x;
					int y = ChallengesGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new ChallengesGUIButtonMessage(2, x, y, z));
						ChallengesGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_chaa2u);
		imagebutton_chaa3u = new ImageButton(this.leftPos + 85, this.topPos + 36, 32, 32, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/chaa3u.png"), ResourceLocation.parse("craft_defense:textures/screens/chaa3h.png")),
				e -> {
					int x = ChallengesGUIScreen.this.x;
					int y = ChallengesGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new ChallengesGUIButtonMessage(3, x, y, z));
						ChallengesGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_chaa3u);
		imagebutton_chaa4u = new ImageButton(this.leftPos + 125, this.topPos + 36, 32, 32, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/chaa4u.png"), ResourceLocation.parse("craft_defense:textures/screens/chaa4h.png")),
				e -> {
					int x = ChallengesGUIScreen.this.x;
					int y = ChallengesGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new ChallengesGUIButtonMessage(4, x, y, z));
						ChallengesGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_chaa4u);
		imagebutton_chaa5u = new ImageButton(this.leftPos + 26, this.topPos + 81, 32, 32, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/chaa5u.png"), ResourceLocation.parse("craft_defense:textures/screens/chaa5h.png")),
				e -> {
					int x = ChallengesGUIScreen.this.x;
					int y = ChallengesGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new ChallengesGUIButtonMessage(5, x, y, z));
						ChallengesGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_chaa5u);
		imagebutton_chaa6u = new ImageButton(this.leftPos + 67, this.topPos + 81, 32, 32, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/chaa6u.png"), ResourceLocation.parse("craft_defense:textures/screens/chaa6h.png")),
				e -> {
					int x = ChallengesGUIScreen.this.x;
					int y = ChallengesGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new ChallengesGUIButtonMessage(6, x, y, z));
						ChallengesGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_chaa6u);
		imagebutton_chaa7u = new ImageButton(this.leftPos + 107, this.topPos + 81, 32, 32, new WidgetSprites(ResourceLocation.parse("craft_defense:textures/screens/chaa7u.png"), ResourceLocation.parse("craft_defense:textures/screens/chaa7h.png")),
				e -> {
					int x = ChallengesGUIScreen.this.x;
					int y = ChallengesGUIScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new ChallengesGUIButtonMessage(7, x, y, z));
						ChallengesGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_chaa7u);
	}
}