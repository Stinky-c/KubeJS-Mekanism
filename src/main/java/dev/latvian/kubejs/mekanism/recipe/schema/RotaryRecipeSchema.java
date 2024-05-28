package dev.latvian.kubejs.mekanism.recipe.schema;

import dev.latvian.kubejs.mekanism.recipe.MekComponents;
import dev.latvian.kubejs.mekanism.recipe.MekanismRecipeJS;
import dev.latvian.mods.kubejs.fluid.OutputFluid;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.FluidComponents;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import mekanism.api.JsonConstants;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import mekanism.api.recipes.ingredients.FluidStackIngredient;

public interface RotaryRecipeSchema {
	RecipeKey<FluidStackIngredient> FLUID_INPUT = MekComponents.INPUT_FLUID.key(JsonConstants.FLUID_INPUT);
	RecipeKey<GasStack> GAS_OUTPUT = MekComponents.GAS_OUTPUT.key(JsonConstants.GAS_OUTPUT);
	RecipeKey<ChemicalStackIngredient.GasStackIngredient> GAS_INPUT = MekComponents.GAS_INPUT.key(JsonConstants.GAS_INPUT);
	RecipeKey<OutputFluid> FLUID_OUTPUT = FluidComponents.OUTPUT.key(JsonConstants.FLUID_OUTPUT);

	RecipeSchema SCHEMA = new RecipeSchema(MekanismRecipeJS.class, MekanismRecipeJS::new, FLUID_INPUT, FLUID_OUTPUT, GAS_INPUT, GAS_OUTPUT);
}
