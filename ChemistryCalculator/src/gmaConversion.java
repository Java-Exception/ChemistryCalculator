import java.lang.Math;

public class gmaConversion
{

	double grams;
	double moles;
	double atoms;

	// Grams to-- conversions
	double gramsToMoles(double grams, double molarMass)
	{

		moles = grams / molarMass;
		return moles;
	}

	double gramsToAtoms(double grams, double molarMass)
	{
		atoms = grams * Math.pow(molarMass, -1) *  (6.022140857747 * Math.pow(10, 23));
		return atoms;
	}

	// Mole to-- conversions
	double molesToGrams(double moles, double molarMass)
	{
		grams = moles * molarMass;
		return grams;
	}

	double molesToAtoms(double moles)
	{

		atoms = moles * (6.022140857747 * Math.pow(10, 23));
		return atoms;
	}

	// Atom to-- conversions
	double atomsToGrams(double atoms, double molarMass)
	{
		moles = atoms / (6.022140857747 * Math.pow(10, 23));
		grams = moles * molarMass;
		return grams;
	}

	double atomsToMoles(double atoms)
	{
		moles = atoms / (6.022140857747 * Math.pow(10, 23));
		return moles;
	}

}
