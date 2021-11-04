package de.butbetter.keksys;

public interface Calculator {

	/**
	 * takes a price and a percentage,
	 * and returns the value with the
	 * given percentage of that value on top
	 *
	 * @param price input value
	 * @param percent percentage to add
	 * @return value plus percentage of that value
	 * @throws IllegalArgumentException thrown, if calculated value is bigger than float allows
	 */
	Float calculateVAT(float price, float percent) throws IllegalArgumentException, ArithmeticException;
}
