package dev.latvian.kubejs.mekanism.recipe.schema;

import dev.latvian.kubejs.mekanism.recipe.MekComponents;
import dev.latvian.kubejs.mekanism.recipe.MekanismRecipeJS;
import dev.latvian.mods.kubejs.item.OutputItem;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import mekanism.api.JsonConstants;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import mekanism.api.recipes.ingredients.ItemStackIngredient;
//import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
//import mekanism.common.tags.MekanismTags;

public interface MetallurgicInfusingRecipeSchema {
	RecipeKey<OutputItem> OUTPUT = ItemComponents.OUTPUT.key(JsonConstants.OUTPUT);
	RecipeKey<ItemStackIngredient> ITEM_INPUT = MekComponents.INPUT_ITEM.key(JsonConstants.ITEM_INPUT);
	RecipeKey<ChemicalStackIngredient.InfusionStackIngredient> CHEMICAL_INPUT = MekComponents.INFUSE_TYPE_INPUT.key(JsonConstants.CHEMICAL_INPUT);
//			.optional(IngredientCreatorAccess.infusion().from(MekanismTags.InfuseTypes.REDSTONE, 10)); // Is it out of scope to set defaults here?

	RecipeSchema SCHEMA = new RecipeSchema(MekanismRecipeJS.class, MekanismRecipeJS::new, OUTPUT, ITEM_INPUT, CHEMICAL_INPUT);
}
