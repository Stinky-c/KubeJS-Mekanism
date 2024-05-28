package dev.latvian.kubejs.mekanism.recipe.schema;

import dev.latvian.kubejs.mekanism.recipe.MekComponents;
import dev.latvian.kubejs.mekanism.recipe.MekanismRecipeJS;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import mekanism.api.JsonConstants;
import mekanism.api.chemical.infuse.InfusionStack;
import mekanism.api.recipes.ingredients.ItemStackIngredient;

public interface InfuseConversionRecipeSchema {
	RecipeKey<ItemStackIngredient> INPUT = MekComponents.INPUT_ITEM.key(JsonConstants.INPUT);
	RecipeKey<InfusionStack> OUTPUT = MekComponents.INFUSE_TYPE_OUTPUT.key(JsonConstants.OUTPUT);

	RecipeSchema SCHEMA = new RecipeSchema(MekanismRecipeJS.class, MekanismRecipeJS::new, INPUT, OUTPUT);
}
