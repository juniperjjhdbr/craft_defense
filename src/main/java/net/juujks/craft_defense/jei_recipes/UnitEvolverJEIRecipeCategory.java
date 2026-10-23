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

public class UnitEvolverJEIRecipeCategory implements IRecipeCategory<UnitEvolverJEIRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("craft_defense:unit_evolver_jei");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("craft_defense:textures/screens/evo_jei.png");
	private final IDrawable background;
	private final IDrawable icon;
	private final Minecraft mc = Minecraft.getInstance();

	public UnitEvolverJEIRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 153, 93);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(CraftDefenseModBlocks.UNIT_EVOLVER.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<UnitEvolverJEIRecipe> getRecipeType() {
		return CraftDefenseModJeiPlugin.UnitEvolverJEI_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Unit Evolver");
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
	public boolean needsRecipeBorder() {
		return false;
	}

	@Override
	public void draw(UnitEvolverJEIRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);

	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, UnitEvolverJEIRecipe recipe, IFocusGroup focuses) {
		List<ItemStack> stacks = new ArrayList<>();
		List<ItemStack> recipeOutputs = recipe.getResultItems();
		List<ItemStack> actualOutputs = NonNullList.withSize(1, ItemStack.EMPTY);
		for (int i = 0; i < recipeOutputs.size(); i++) {
			actualOutputs.set(i, recipeOutputs.get(i));
		}
		builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 20).addItemStack(actualOutputs.get(0));
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(0).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(0)));
		builder.addSlot(RecipeIngredientRole.INPUT, 25, 11).addItemStacks(stacks);
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(1).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(1)));
		builder.addSlot(RecipeIngredientRole.INPUT, 43, 11).addItemStacks(stacks);
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(2).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(2)));
		builder.addSlot(RecipeIngredientRole.INPUT, 61, 11).addItemStacks(stacks);
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(3).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(3)));
		builder.addSlot(RecipeIngredientRole.INPUT, 25, 29).addItemStacks(stacks);
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(4).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(4)));
		builder.addSlot(RecipeIngredientRole.INPUT, 43, 29).addItemStacks(stacks);
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(5).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(5)));
		builder.addSlot(RecipeIngredientRole.INPUT, 61, 29).addItemStacks(stacks);
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(6).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(6)));
		builder.addSlot(RecipeIngredientRole.INPUT, 43, 65).addItemStacks(stacks);
		stacks.clear();
		for (ItemStack item : (List<ItemStack>) List.of(recipe.getIngredients().get(7).getItems()))
			stacks.add(new ItemStack(item.getItem(), recipe.integers().get(7)));
		builder.addSlot(RecipeIngredientRole.INPUT, 25, 65).addItemStacks(stacks);
	}
}