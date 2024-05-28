package dev.latvian.kubejs.mekanism.recipe.schema;

import dev.latvian.kubejs.mekanism.recipe.MekComponents;
import dev.latvian.kubejs.mekanism.recipe.MekanismRecipeJS;
import dev.latvian.mods.kubejs.fluid.OutputFluid;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.FluidComponents;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import mekanism.api.JsonConstants;
import mekanism.api.recipes.ingredients.FluidStackIngredient;

public interface EvaporateRecipeSchema {
	RecipeKey<FluidStackIngredient> INPUT = MekComponents.INPUT_FLUID.key(JsonConstants.INPUT);
	RecipeKey<OutputFluid> OUTPUT = FluidComponents.OUTPUT.key(JsonConstants.OUTPUT);


	RecipeSchema SCHEMA = new RecipeSchema(MekanismRecipeJS.class, MekanismRecipeJS::new, INPUT, OUTPUT);
}
