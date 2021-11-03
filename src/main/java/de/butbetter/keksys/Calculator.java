package de.butbetter.keksys;

public interface Calculator {

	/**
	 * takes a value and a percentage,
	 * and returns the value with the
	 * given percentage of that value on op
	 *
	 * when given negative values, the value will
	 * be instead changed to 0 and the rest will continue
	 *
	 * @param input input value
	 * @param percent percentage to add
	 * @return value plus percentage of that value
	 * @throws IllegalArgumentException thrown, if calculated value is bigger than float allows
	 */
	Float calculateVAT(float input, float percent) throws IllegalArgumentException;
}
