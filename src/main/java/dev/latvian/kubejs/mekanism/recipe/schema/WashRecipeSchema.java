package dev.latvian.kubejs.mekanism.recipe.schema;

import dev.latvian.kubejs.mekanism.recipe.MekComponents;
import dev.latvian.kubejs.mekanism.recipe.MekanismRecipeJS;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import mekanism.api.JsonConstants;
import mekanism.api.chemical.slurry.SlurryStack;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import mekanism.api.recipes.ingredients.FluidStackIngredient;

public interface WashRecipeSchema {
	RecipeKey<FluidStackIngredient> FLUID_INPUT = MekComponents.INPUT_FLUID.key(JsonConstants.FLUID_INPUT);
	RecipeKey<ChemicalStackIngredient.SlurryStackIngredient> SLURRY_INPUT = MekComponents.SLURRY_INPUT.key(JsonConstants.SLURRY_INPUT);
	RecipeKey<SlurryStack> OUTPUT = MekComponents.SLURRY_OUTPUT.key(JsonConstants.OUTPUT);

	RecipeSchema SCHEMA = new RecipeSchema(MekanismRecipeJS.class, MekanismRecipeJS::new, OUTPUT, SLURRY_INPUT, FLUID_INPUT);

}
