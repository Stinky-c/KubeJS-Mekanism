package dev.latvian.kubejs.mekanism.recipe.schema;

import dev.latvian.kubejs.mekanism.recipe.MekComponents;
import dev.latvian.kubejs.mekanism.recipe.MekanismRecipeJS;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import mekanism.api.JsonConstants;
import mekanism.api.chemical.pigment.PigmentStack;
import mekanism.api.recipes.ingredients.ItemStackIngredient;

public interface PigmentExtractRecipeSchema {
	RecipeKey<ItemStackIngredient> ITEM_INPUT = MekComponents.INPUT_ITEM.key(JsonConstants.INPUT);
	RecipeKey<PigmentStack> PIGMENT_OUTPUT = MekComponents.PIGMENT_OUTPUT.key(JsonConstants.OUTPUT);


	RecipeSchema SCHEMA = new RecipeSchema(MekanismRecipeJS.class, MekanismRecipeJS::new, ITEM_INPUT, PIGMENT_OUTPUT);
}




