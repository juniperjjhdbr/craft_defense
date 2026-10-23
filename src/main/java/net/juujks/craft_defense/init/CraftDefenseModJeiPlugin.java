package net.juujks.craft_defense.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.juujks.craft_defense.jei_recipes.UnitMachineJEIRecipeCategory;
import net.juujks.craft_defense.jei_recipes.UnitMachineJEIRecipe;
import net.juujks.craft_defense.jei_recipes.UnitEvolverJEIRecipeCategory;
import net.juujks.craft_defense.jei_recipes.UnitEvolverJEIRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.stream.Collectors;
import java.util.Objects;
import java.util.List;

@JeiPlugin
public class CraftDefenseModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<UnitEvolverJEIRecipe> UnitEvolverJEI_Type = new mezz.jei.api.recipe.RecipeType<>(UnitEvolverJEIRecipeCategory.UID, UnitEvolverJEIRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<UnitMachineJEIRecipe> UnitMachineJEI_Type = new mezz.jei.api.recipe.RecipeType<>(UnitMachineJEIRecipeCategory.UID, UnitMachineJEIRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("craft_defense:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new UnitEvolverJEIRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new UnitMachineJEIRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<UnitEvolverJEIRecipe> UnitEvolverJEIRecipes = recipeManager.getAllRecipesFor(UnitEvolverJEIRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(UnitEvolverJEI_Type, UnitEvolverJEIRecipes);
		List<UnitMachineJEIRecipe> UnitMachineJEIRecipes = recipeManager.getAllRecipesFor(UnitMachineJEIRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(UnitMachineJEI_Type, UnitMachineJEIRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(CraftDefenseModBlocks.UNIT_EVOLVER.get().asItem()), UnitEvolverJEI_Type);
		registration.addRecipeCatalyst(new ItemStack(CraftDefenseModBlocks.UNIT_MACHINE.get().asItem()), UnitMachineJEI_Type);
	}
}