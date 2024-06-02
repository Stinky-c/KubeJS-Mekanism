package dev.latvian.kubejs.mekanism.util;

import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.kubejs.typings.Param;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.chemical.infuse.InfuseType;
import mekanism.api.chemical.infuse.InfusionStack;
import mekanism.api.chemical.pigment.Pigment;
import mekanism.api.chemical.pigment.PigmentStack;
import mekanism.api.chemical.slurry.Slurry;
import mekanism.api.chemical.slurry.SlurryStack;

import static dev.latvian.kubejs.mekanism.util.ChemicalWrapper.*;

public interface ChemicalBinding {

	@Info(value = """
		Gas stack builder
		""", params = {@Param(name = "name", value = "A string repersenting a Gas")})
	static GasStack gas(Gas gas) {
		return new GasStack(gas, GAS.defaultAmount());
	}

	@Info(value = """
		Gas stack builder
		""", params = {
		@Param(name = "name", value = "A string repersenting a Gas"),
		@Param(name = "amount", value = "An optional amount of this chemical")
	})
	static GasStack gas(Gas gas, long amount) {
		return new GasStack(gas, amount);
	}

	@Info(value = """
		InfuseType Stack builder
		""", params = {@Param(name = "name", value = "A string repersenting a InfuseType")})
	static InfusionStack infusetype(InfuseType name) {
		return new InfusionStack(name, INFUSE_TYPE.defaultAmount());
	}

	@Info(value = """
		InfuseType stack builder
		""", params = {
		@Param(name = "name", value = "A string repersenting a InfuseType"),
		@Param(name = "amount", value = "An optional amount of this chemical")
	})
	static InfusionStack infusetype(InfuseType name, long amount) {
		return new InfusionStack(name, amount);
	}

	@Info(value = """
		Pigment stack builder
		""", params = {@Param(name = "name", value = "A string repersenting a Pigment")})
	static PigmentStack pigment(Pigment name) {
		return new PigmentStack(name, PIGMENT.defaultAmount());
	}

	@Info(value = """
		Pigment stack builder
		""", params = {
		@Param(name = "name", value = "A string repersenting a Pigment"),
		@Param(name = "amount", value = "An optional amount of this chemical")
	})
	static PigmentStack pigment(Pigment name, long amount) {
		return new PigmentStack(name, amount);
	}

	@Info(value = """
		Slurry stack builder
		""", params = {@Param(name = "name", value = "A string repersenting a slurry")})
	static SlurryStack slurry(Slurry name) {
		return new SlurryStack(name, SLURRY.defaultAmount());
	}

	@Info(value = """
		Slurry stack builder
		""", params = {
		@Param(name = "name", value = "A string repersenting a Slurry"),
		@Param(name = "amount", value = "An optional amount of this chemical")
	})
	static SlurryStack slurry(Slurry name, long amount) {
		return new SlurryStack(name, amount);
	}


}