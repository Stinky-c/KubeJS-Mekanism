package dev.latvian.kubejs.mekanism.chemical;

import dev.latvian.mods.kubejs.recipe.RecipeExceptionJS;
import mekanism.api.chemical.slurry.Slurry;
import mekanism.api.chemical.slurry.SlurryStack;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;


public interface SlurryJS {
	static Slurry of(@Nullable Object o) {
		if (o instanceof SlurryStack stack) {
			return stack.getType();
		} else if (o instanceof ResourceLocation location) {
			return Slurry.getFromRegistry(location);
		} else if (o instanceof CharSequence str) {
			// This does not look for amounts, use the wrapper
			return Slurry.getFromRegistry(new ResourceLocation(str.toString()));
		}

		throw new RecipeExceptionJS("Got unexpected value:" + o);
	}

}
