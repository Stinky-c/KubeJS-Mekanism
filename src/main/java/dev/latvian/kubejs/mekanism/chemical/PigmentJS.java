package dev.latvian.kubejs.mekanism.chemical;

import dev.latvian.mods.kubejs.recipe.RecipeExceptionJS;
import mekanism.api.chemical.pigment.Pigment;
import mekanism.api.chemical.pigment.PigmentStack;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;


public interface PigmentJS {
	static Pigment of(@Nullable Object o) {
		if (o instanceof PigmentStack stack) {
			return stack.getType();
		} else if (o instanceof ResourceLocation location) {
			return Pigment.getFromRegistry(location);
		} else if (o instanceof CharSequence str) {
			// This does not look for amounts, use the wrapper
			return Pigment.getFromRegistry(new ResourceLocation(str.toString()));
		}

		throw new RecipeExceptionJS("Got unexpected value:" + o);

	}

}
