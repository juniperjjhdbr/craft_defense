package net.juujks.craft_defense.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.NonNullList;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.juujks.craft_defense.init.CraftDefenseModJeiPlugin;
import net.juujks.craft_defense.init.CraftDefenseModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

import java.util.List;
import java.util.ArrayList;

public class UnitMachineJEIRecipeCategory implements IRecipeCategory<UnitMachineJEIRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("craft_defense:unit_machine_jei");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("craft_defense:textures/screens/um_jei.png");
	private final IDrawable background;
	private final IDrawable icon;
	private final Minecraft mc = Minecraft.getInstance();

	public UnitMachineJEIRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 147, 58);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(CraftDefenseModBlocks.UNIT_MACHINE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<UnitMachineJEIRecipe> getRecipeType() {
		return CraftDefenseModJeiPlugin.UnitMachineJEI_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Unit Machine");
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public int getWidth() {
		return this.background.getWidth();
	}

	@Override
	public int getHeight() {
		return this.background.getHeight();
	}

	@Override
	public void draw(UnitMachineJEIRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);

	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, UnitMachineJEIRecipe recipe, IFocusGroup focuses) {
		List<ItemStack> stacks = new ArrayList<>();
		List<ItemStack> recipeOutputs = recipe.getResultItems();
		List<ItemStack> actualOutputs = NonNullList.withSize(1, ItemStack.EMPTY);
		for (int i = 0; i < recipeOutputs.size(); i++) {
			actualOutputs.set(i, recipeOutputs.get(i));
		}
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(0).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(0)));
		builder.addSlot(RecipeIngredientRole.INPUT, 30, 24).addItemStacks(stacks);
		builder.addSlot(RecipeIngredientRole.OUTPUT, 113, 24).addItemStack(actualOutputs.get(0));
	}
}