package lab2;

/**
 * This class generates pseudorandom numbers
 * 
 * @author Hang Ngo
 *
 */

public class Pseudorandom {
	private int multiplier;
	private int increment;
	private int modulus;
	private int seed;

	/**
	 * Construct a pseudorandom number of a given multiplier, seed, increment
	 * and modulus
	 * 
	 * @param multiplier - the multiplier
	 * @param seed - the seed
	 * @param increment - the increment
	 * @param modulus - the modulus
	 */
	public Pseudorandom(int multiplier, int seed, int increment, int modulus) {
		this.multiplier = multiplier;
		this.seed = seed;
		this.increment = increment;
		this.modulus = modulus;
	}

	/**
	 * Change the seed with a new value new_seed
	 * 
	 * @param new_seed - a new value of seed
	 */
	public void changeSeed(int new_seed) {
		if (modulus != 0) {
			new_seed = (multiplier * seed + increment) % modulus;
			seed = new_seed;
		}
	}

	/**
	 * Generate and return a pseudorandom integer number
	 * 
	 * @return pseudorandomInt - a pseudorandom integer number
	 */
	public int nextInt() {
		int pseudorandomInt = 0;
		if (modulus != 0) {
			pseudorandomInt = (multiplier * seed + increment) % modulus;
		}
		return pseudorandomInt;

	}

	/**
	 * Generate and return a pseudorandom double number in the range [0..1).
	 * Modulus must not be equal to 0.
	 * 
	 * @return pseudorandomDouble - a pseudorandom double number
	 */
	public double nextDouble() {
		double modulus1 = (double) modulus;
		if (modulus == 0) {
			return -1;
		} else {
			double pseudorandomDouble = ((multiplier * seed + increment) % modulus)
					/ modulus1;
			return pseudorandomDouble;
		}
	}

	/**
	 * Get the value of seed
	 * 
	 * @return seed - the value of seed
	 */
	public int getSeed() {
		return seed;
	}

}
