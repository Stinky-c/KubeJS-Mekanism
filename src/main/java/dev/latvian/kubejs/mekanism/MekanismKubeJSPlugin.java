package dev.latvian.kubejs.mekanism;

import dev.latvian.kubejs.mekanism.chemical.GasJS;
import dev.latvian.kubejs.mekanism.chemical.InfuseTypeJS;
import dev.latvian.kubejs.mekanism.chemical.PigmentJS;
import dev.latvian.kubejs.mekanism.chemical.SlurryJS;
import dev.latvian.kubejs.mekanism.custom.KubeJSGasBuilder;
import dev.latvian.kubejs.mekanism.custom.KubeJSInfuseTypeBuilder;
import dev.latvian.kubejs.mekanism.custom.KubeJSPigmentBuilder;
import dev.latvian.kubejs.mekanism.custom.KubeJSSlurryBuilder;
import dev.latvian.kubejs.mekanism.recipe.schema.ActivateRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.CentrifugeRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.ChemicalDissolutionRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.ChemicalInfusingRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.CombiningRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.CrystallizingRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.EnergyConversionRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.EvaporateRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.GasConversionRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.InfuseConversionRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.ItemAndGasToItemRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.ItemToItemRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.MetallurgicInfusingRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.NucleosynthesizingRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.OxidizingRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.PaintRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.PigmentExtractRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.PigmentMixRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.PressurizedReactionRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.RotaryRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.SawingRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.SeparatingRecipeSchema;
import dev.latvian.kubejs.mekanism.recipe.schema.WashRecipeSchema;
import dev.latvian.kubejs.mekanism.util.ChemicalBinding;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.rhino.util.wrap.TypeWrappers;
import mekanism.api.MekanismAPI;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.infuse.InfuseType;
import mekanism.api.chemical.pigment.Pigment;
import mekanism.api.chemical.slurry.Slurry;

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
		event.namespace(MekanismAPI.MEKANISM_MODID).register("activating", ActivateRecipeSchema.SCHEMA).register("centrifuging", CentrifugeRecipeSchema.SCHEMA).register("dissolution", ChemicalDissolutionRecipeSchema.SCHEMA).register("chemical_infusing", ChemicalInfusingRecipeSchema.SCHEMA).register("combining", CombiningRecipeSchema.SCHEMA).register("compressing", ItemAndGasToItemRecipeSchema.SCHEMA).register("crushing", ItemToItemRecipeSchema.SCHEMA).register("crystallizing", CrystallizingRecipeSchema.SCHEMA).register("enriching", ItemToItemRecipeSchema.SCHEMA).register("evaporating", EvaporateRecipeSchema.SCHEMA).register("injecting", ItemAndGasToItemRecipeSchema.SCHEMA).register("energy_conversion", EnergyConversionRecipeSchema.SCHEMA).register("gas_conversion", GasConversionRecipeSchema.SCHEMA).register("infusion_conversion", InfuseConversionRecipeSchema.SCHEMA).register("metallurgic_infusing", MetallurgicInfusingRecipeSchema.SCHEMA).register("nucleosynthesizing", NucleosynthesizingRecipeSchema.SCHEMA).register("oxidizing", OxidizingRecipeSchema.SCHEMA).register("painting", PaintRecipeSchema.SCHEMA).register("pigment_extracting", PigmentExtractRecipeSchema.SCHEMA).register("pigment_mixing", PigmentMixRecipeSchema.SCHEMA).register("purifying", ItemAndGasToItemRecipeSchema.SCHEMA).register("reaction", PressurizedReactionRecipeSchema.SCHEMA).register("rotary", RotaryRecipeSchema.SCHEMA).register("sawing", SawingRecipeSchema.SCHEMA).register("separating", SeparatingRecipeSchema.SCHEMA).register("smelting", ItemToItemRecipeSchema.SCHEMA).register("washing", WashRecipeSchema.SCHEMA);
	}

	@Override
	public void registerBindings(BindingsEvent event) {
		event.add("Chemical", ChemicalBinding.class);
	}

	@Override
	public void registerTypeWrappers(ScriptType type, TypeWrappers typeWrappers) {
		typeWrappers.registerSimple(Gas.class, GasJS::of);
		typeWrappers.registerSimple(InfuseType.class, InfuseTypeJS::of);
		typeWrappers.registerSimple(Pigment.class, PigmentJS::of);
		typeWrappers.registerSimple(Slurry.class, SlurryJS::of);
	}
}


// FIXME: A bunch of test cases?
// all chemicals
// all schemas
//

// TODO: docs?
// TODO: order the schema inputs/outputs better
