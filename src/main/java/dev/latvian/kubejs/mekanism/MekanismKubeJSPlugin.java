package dev.latvian.kubejs.mekanism;

import dev.latvian.kubejs.mekanism.custom.KubeJSGasBuilder;
import dev.latvian.kubejs.mekanism.custom.KubeJSInfuseTypeBuilder;
import dev.latvian.kubejs.mekanism.custom.KubeJSPigmentBuilder;
import dev.latvian.kubejs.mekanism.custom.KubeJSSlurryBuilder;
import dev.latvian.kubejs.mekanism.recipe.schema.*;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import mekanism.api.MekanismAPI;

public class MekanismKubeJSPlugin extends KubeJSPlugin {
	// registry builders for all mekanism chemical subtypes
	public static final RegistryInfo GAS = RegistryInfo.of(MekanismAPI.GAS_REGISTRY_NAME);
	public static final RegistryInfo INFUSE_TYPE = RegistryInfo.of(MekanismAPI.INFUSE_TYPE_REGISTRY_NAME);
	public static final RegistryInfo PIGMENT = RegistryInfo.of(MekanismAPI.PIGMENT_REGISTRY_NAME);
	public static final RegistryInfo SLURRY = RegistryInfo.of(MekanismAPI.SLURRY_REGISTRY_NAME);

	@Override
	public void init() {
		GAS.addType("basic", KubeJSGasBuilder.class, KubeJSGasBuilder::new);
		INFUSE_TYPE.addType("basic", KubeJSInfuseTypeBuilder.class, KubeJSInfuseTypeBuilder::new);
		PIGMENT.addType("basic", KubeJSPigmentBuilder.class, KubeJSPigmentBuilder::new);
		SLURRY.addType("basic", KubeJSSlurryBuilder.Basic.class, KubeJSSlurryBuilder.Basic::new);
		SLURRY.addType("dirty", KubeJSSlurryBuilder.Dirty.class, KubeJSSlurryBuilder.Dirty::new);
		SLURRY.addType("clean", KubeJSSlurryBuilder.Clean.class, KubeJSSlurryBuilder.Clean::new);
	}

	@Override
	public void registerRecipeSchemas(RegisterRecipeSchemasEvent event) {
		// Follows order defined on mek json page as of 24/5/22
		// https://github.com/mekanism/Mekanism/wiki/Recipe-Type-JSON-Syntax
		event.namespace(MekanismAPI.MEKANISM_MODID)
			.register("activating", ActivateRecipeSchema.SCHEMA)
			.register("centrifuging", CentrifugeRecipeSchema.SCHEMA)
			.register("dissolution", ChemicalDissolutionRecipeSchema.SCHEMA)
			.register("chemical_infusing", ChemicalInfusingRecipeSchema.SCHEMA)
			.register("combining", CombiningRecipeSchema.SCHEMA)
			.register("compressing", ItemAndGasToItemRecipeSchema.SCHEMA)
			.register("crushing", ItemToItemRecipeSchema.SCHEMA)
			.register("crystallizing", CrystallizingRecipeSchema.SCHEMA)
			.register("enriching", ItemToItemRecipeSchema.SCHEMA)
			.register("evaporating", EvaporateRecipeSchema.SCHEMA)
			.register("injecting", ItemAndGasToItemRecipeSchema.SCHEMA)
			.register("energy_conversion", EnergyConversionRecipeSchema.SCHEMA)
			.register("gas_conversion", GasConversionRecipeSchema.SCHEMA)
			.register("infusion_conversion", InfuseConversionRecipeSchema.SCHEMA)
			.register("metallurgic_infusing", MetallurgicInfusingRecipeSchema.SCHEMA)
			.register("nucleosynthesizing", NucleosynthesizingRecipeSchema.SCHEMA)
			.register("oxidizing", OxidizingRecipeSchema.SCHEMA)
			.register("painting", PaintRecipeSchema.SCHEMA)
			.register("pigment_extracting", PigmentExtractRecipeSchema.SCHEMA)
			.register("pigment_mixing", PigmentMixRecipeSchema.SCHEMA)
			.register("purifying", ItemAndGasToItemRecipeSchema.SCHEMA)
			.register("reaction", PressurizedReactionRecipeSchema.SCHEMA)
			.register("rotary", RotaryRecipeSchema.SCHEMA)
			.register("sawing", SawingRecipeSchema.SCHEMA)
			.register("separating", SeparatingRecipeSchema.SCHEMA)
			.register("smelting", ItemToItemRecipeSchema.SCHEMA)
			.register("washing", WashRecipeSchema.SCHEMA);
	}

}
// TODO: custom bindings
// https://github.com/KubeJS-Mods/KubeJS/blob/fc38ad01dc7b98683bbdfc9aed1dbd727cf684b4/README.md#adding-bindings
// https://github.com/KubeJS-Mods/KubeJS/blob/fc38ad01dc7b98683bbdfc9aed1dbd727cf684b4/common/src/main/java/dev/latvian/mods/kubejs/BuiltinKubeJSPlugin.java#L339-L416
// Globals like InputItem or Ingredient
// They must be handled by `ChemicalWrapper`


// FIXME: A bunch of test cases?
// all chemicals
// all schemas
//

// TODO: docs?
// TODO: order the schema inputs/outputs better


// TODO: what does CachingGasProvider do?