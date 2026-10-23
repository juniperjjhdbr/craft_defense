package net.juujks.craft_defense.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;

import net.juujks.craft_defense.jei_recipes.UnitMachineJEIRecipe;
import net.juujks.craft_defense.jei_recipes.UnitEvolverJEIRecipe;

@EventBusSubscriber
public class CraftDefenseModRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "craft_defense");
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "craft_defense");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = ModList.get().getModContainerById("craft_defense").get().getEventBus();
		event.enqueueWork(() -> {
			RECIPE_TYPES.register(bus);
			SERIALIZERS.register(bus);
			RECIPE_TYPES.register("unit_evolver_jei", () -> UnitEvolverJEIRecipe.Type.INSTANCE);
			SERIALIZERS.register("unit_evolver_jei", () -> UnitEvolverJEIRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("unit_machine_jei", () -> UnitMachineJEIRecipe.Type.INSTANCE);
			SERIALIZERS.register("unit_machine_jei", () -> UnitMachineJEIRecipe.Serializer.INSTANCE);
		});
	}
}