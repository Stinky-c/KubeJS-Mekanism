package dev.latvian.kubejs.mekanism.recipe.schema;

import dev.latvian.kubejs.mekanism.recipe.MekComponents;
import dev.latvian.kubejs.mekanism.recipe.MekanismRecipeJS;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import mekanism.api.JsonConstants;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.math.FloatingLong;
import mekanism.api.recipes.ingredients.FluidStackIngredient;

public interface SeparatingRecipeSchema {
	RecipeKey<FluidStackIngredient> INPUT = MekComponents.INPUT_FLUID.key(JsonConstants.INPUT);
	RecipeKey<FloatingLong> ENERGY_MULTIPLIER = MekComponents.FLOATING_LONG.key(JsonConstants.ENERGY_MULTIPLIER).optional(FloatingLong.ONE);
	RecipeKey<GasStack> LEFT_OUTPUT = MekComponents.GAS_OUTPUT.key(JsonConstants.LEFT_GAS_OUTPUT);
	RecipeKey<GasStack> RIGHT_OUTPUT = MekComponents.GAS_OUTPUT.key(JsonConstants.RIGHT_GAS_OUTPUT);

	RecipeSchema SCHEMA = new RecipeSchema(MekanismRecipeJS.class, MekanismRecipeJS::new, INPUT, LEFT_OUTPUT, RIGHT_OUTPUT, ENERGY_MULTIPLIER);
}
