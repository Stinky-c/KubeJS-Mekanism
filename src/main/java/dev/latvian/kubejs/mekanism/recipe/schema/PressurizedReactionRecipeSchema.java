package dev.latvian.kubejs.mekanism.recipe.schema;

import dev.latvian.kubejs.mekanism.recipe.MekComponents;
import dev.latvian.kubejs.mekanism.recipe.MekanismRecipeJS;
import dev.latvian.mods.kubejs.item.OutputItem;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.component.TimeComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import mekanism.api.JsonConstants;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import mekanism.api.recipes.ingredients.FluidStackIngredient;
import mekanism.api.recipes.ingredients.ItemStackIngredient;

public interface PressurizedReactionRecipeSchema {
	RecipeKey<ItemStackIngredient> ITEM_INPUT = MekComponents.INPUT_ITEM.key(JsonConstants.ITEM_INPUT);
	RecipeKey<FluidStackIngredient> FLUID_INPUT = MekComponents.INPUT_FLUID.key(JsonConstants.FLUID_INPUT);
	RecipeKey<ChemicalStackIngredient.GasStackIngredient> GAS_INPUT = MekComponents.GAS_INPUT.key(JsonConstants.GAS_INPUT);
	RecipeKey<Integer> ENERGY_REQUIRED = NumberComponent.INT.key(JsonConstants.ENERGY_REQUIRED).optional(0);
	RecipeKey<Long> DURATION = TimeComponent.TICKS.key(JsonConstants.DURATION);
	RecipeKey<OutputItem> ITEM_OUTPUT = ItemComponents.OUTPUT.key(JsonConstants.ITEM_OUTPUT);
	RecipeKey<GasStack> GAS_OUTPUT = MekComponents.GAS_OUTPUT.key(JsonConstants.GAS_OUTPUT);


	// I feel like im close, either one or both
	// -- SNIP --
	// Reaction recipes combine an item, gas, and fluid into an item and gas.
	// At least one output either itemOutput or gasOutput is required.
	// If you only want the recipe to have one output type, you should just omit the line for the type you do not want.
	// -- SNIP
	RecipeSchema SCHEMA = new RecipeSchema(MekanismRecipeJS.class, MekanismRecipeJS::new, ITEM_INPUT, FLUID_INPUT, GAS_INPUT, DURATION, ITEM_OUTPUT, GAS_OUTPUT, ENERGY_REQUIRED) // Both outputs
		.constructor(ITEM_INPUT, FLUID_INPUT, GAS_INPUT, DURATION, GAS_OUTPUT, ENERGY_REQUIRED) // No item output
		.constructor(ITEM_INPUT, FLUID_INPUT, GAS_INPUT, DURATION, ITEM_OUTPUT, ENERGY_REQUIRED); // no gas output
}
