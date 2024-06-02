package dev.latvian.kubejs.mekanism.chemical;

import dev.latvian.mods.kubejs.recipe.RecipeExceptionJS;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;
// https://github.com/KubeJS-Mods/KubeJS/blob/fc38ad01dc7b98683bbdfc9aed1dbd727cf684b4/README.md#adding-bindings
// https://github.com/KubeJS-Mods/KubeJS/blob/fc38ad01dc7b98683bbdfc9aed1dbd727cf684b4/common/src/main/java/dev/latvian/mods/kubejs/BuiltinKubeJSPlugin.java#L339-L416

public interface GasJS {


	// String, resource location, list of those or nothing
	// if i get something i dont like fuck the user

	// https://github.com/KubeJS-Mods/KubeJS/blob/fc38ad01dc7b98683bbdfc9aed1dbd727cf684b4/common/src/main/java/dev/latvian/mods/kubejs/item/ItemStackJS.java#L74
	static Gas of(@Nullable Object o) {
		if (o instanceof GasStack stack) {
			return stack.getType();
		} else if (o instanceof ResourceLocation location) {
			return Gas.getFromRegistry(location);
		} else if (o instanceof CharSequence str) {
			// This does not look for amounts, use the wrapper
			return Gas.getFromRegistry(new ResourceLocation(str.toString()));
		}

		throw new RecipeExceptionJS("Got unexpected value: " + o);

	}

}
