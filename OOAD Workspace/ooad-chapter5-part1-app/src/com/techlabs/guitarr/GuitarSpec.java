package com.techlabs.guitarr;

import com.techlabs.enumclass.Builder;
import com.techlabs.enumclass.Type;
import com.techlabs.enumclass.Wood;

public class GuitarSpec extends InstrumentSpec {
	private int numStrings;

	public GuitarSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
		super(builder, model, type, backWood, topWood);
		this.numStrings = numStrings;
	}

	public int getNumStrings() {
		return numStrings;
	}

	public boolean matches(InstrumentSpec otherSpec) {
		if (!super.matches(otherSpec))
			return false;
		if (!(otherSpec instanceof GuitarSpec))
			return false;
		GuitarSpec spec = (GuitarSpec) otherSpec;
		if (numStrings != spec.numStrings)
			return false;
		return true;
	}

}
