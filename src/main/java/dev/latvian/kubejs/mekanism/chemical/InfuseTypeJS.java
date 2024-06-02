package dev.latvian.kubejs.mekanism.chemical;

import dev.latvian.mods.kubejs.recipe.RecipeExceptionJS;
import mekanism.api.chemical.infuse.InfuseType;
import mekanism.api.chemical.infuse.InfusionStack;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;


public interface InfuseTypeJS {
	static InfuseType of(@Nullable Object o) {
		if (o instanceof InfusionStack stack) {
			return stack.getType();
		} else if (o instanceof ResourceLocation location) {
			return InfuseType.getFromRegistry(location);
		} else if (o instanceof CharSequence str) {
			// This does not look for amounts, use the wrapper
			return InfuseType.getFromRegistry(new ResourceLocation(str.toString()));
		}
		throw new RecipeExceptionJS("Got unexpected value:" + o);

	}

}
