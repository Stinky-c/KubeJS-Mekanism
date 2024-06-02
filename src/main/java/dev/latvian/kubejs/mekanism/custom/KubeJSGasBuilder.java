package dev.latvian.kubejs.mekanism.custom;

import dev.latvian.kubejs.mekanism.MekanismKubeJSPlugin;
import dev.latvian.kubejs.mekanism.util.CachingGasProvider;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.kubejs.typings.Param;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasBuilder;
import mekanism.api.chemical.gas.attribute.GasAttributes;
import mekanism.api.math.FloatingLong;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;


@SuppressWarnings("unused")
public class KubeJSGasBuilder extends KubeJSChemicalBuilder<Gas, GasBuilder, KubeJSGasBuilder> {

	private ResourceLocation texture = null;

	public KubeJSGasBuilder(ResourceLocation id) {
		super(id);
	}

	@Override
	protected Supplier<GasBuilder> bindBuilder() {
		return () -> texture == null ? GasBuilder.builder() : GasBuilder.builder(texture);
	}

	/**
	 * Sets the custom texture of the slurry.
	 * <b>If you are planning to use a custom texture, this should be the first method you call</b>,
	 * otherwise the default texture will be used.
	 *
	 * @param texture Resource location of the texture.
	 * @return This builder.
	 */
	@Info(value = """
		Allows setting texture location use ResourceLocation
		""", params = {@Param(name = "texture", value = "ResourceLocation of the texture")})
	public KubeJSGasBuilder texture(ResourceLocation texture) {
		this.texture = texture;
		return this;
	}

	/**
	 * Declares that this gas is radioactive.
	 * Due to the nature of radioactive gases, this means this gas will not be accepted
	 * by most chemical containers including fission reactor ports, see {@link GasAttributes.Radiation#needsValidation()}.
	 *
	 * @param radioactivity The radioactivity of this gas (in Sv/h).
	 * @return This builder.
	 */
	@Info(value = """
		Declares that this gas is radioactive.
		Due to the nature of radioactive gases, this means this gas will not be accepted by most chemical containers
		Mutually exclusive with coolant.
		""", params = {
		@Param(name = "radioactivity", value = "The radioactivity of this gas (in Sv/h)")
	})
	public KubeJSGasBuilder radioactivity(double radioactivity) {
		return with(new GasAttributes.Radiation(radioactivity));
	}




	@Info(value = """
		Declares that this gas is a coolant that may be used inside a fission reactor.
		Mutually exclusive with radioactivity.
		""", params = {
		@Param(name = "heated", value = "Whether this is the heated form of the coolant."),
		@Param(name = "counterpart", value = "The cooled (or heated if this is the cooled form) counterpart of this gas."),
		@Param(name = "thermalEnthalpy", value = "The thermal enthalpy of this gas, referring to the amount of thermal energy it takes to heat up 1mB of it. (i.e. lower values = more coolant required) (Sodium defaults to 2)"),
		@Param(name = "conductivity", value = "The thermal conductivity of this gas, this is the fraction of a reactor's heat that may be used to convert this coolant's cool variant to its heated variant at any given time. (should be between 0 and 1)"),
	})
	public KubeJSGasBuilder coolant(boolean heated, ResourceLocation counterpart, double thermalEnthalpy, double conductivity) {
		if (heated) {
			return with(new GasAttributes.HeatedCoolant(new CachingGasProvider(counterpart), thermalEnthalpy, conductivity));
		} else {
			return with(new GasAttributes.CooledCoolant(new CachingGasProvider(counterpart), thermalEnthalpy, conductivity));
		}
	}
	@Info("""
		Alias to coolant, but takes a KubeJSGasBuilder for counterpart.
		""")
	public KubeJSGasBuilder coolant(boolean heated, KubeJSGasBuilder counterpart, double thermalEnthalpy, double conductivity) {
		return coolant(heated, counterpart.get().getRegistryName(), thermalEnthalpy, conductivity);

	}

	@Info("""
		Alias to coolant, but is heated variant
		""")
	public KubeJSGasBuilder heatedCoolant(ResourceLocation counterpart, double thermalEnthalpy, double conductivity) {
		return coolant(true, counterpart, thermalEnthalpy, conductivity);
	}

	@Info("""
		Alias to coolant, but is cooled variant
		""")
	public KubeJSGasBuilder cooledCoolant(ResourceLocation counterpart, double thermalEnthalpy, double conductivity) {
		return coolant(false, counterpart, thermalEnthalpy, conductivity);
	}

	/**
	 * Declares that this gas may be burned as fuel in a gas generator.
	 *
	 * @param burnTicks The amount of time it takes to burn 1mB of this gas.
	 * @param energy    The amount of energy 1mB of this gas burns for.
	 * @return This builder.
	 */
	@Info(value = """
		Declares that this gas may be burned as fuel in a gas generator.
		""", params = {
		@Param(name = "burnTicks", value = "The amount of time it takes to burn 1mB of this gas."),
		@Param(name = "energy", value = "The amount of energy 1mB of this gas burns for.")
	})
	public KubeJSGasBuilder fuel(int burnTicks, double energy) {
		var density = FloatingLong.createConst(energy);
		return with(new GasAttributes.Fuel(burnTicks, density));
	}

	@Override
	public RegistryInfo getRegistryType() {
		return MekanismKubeJSPlugin.GAS;
	}

	@Override
	public Gas createObject() {
		if (barColor == null) {
			return new Gas(builder());
		} else {
			int color = barColor;
			return new Gas(builder()) {
				@Override
				public int getColorRepresentation() {
					return color;
				}
			};
		}
	}
}
