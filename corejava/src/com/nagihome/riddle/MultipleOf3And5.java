/**
 * 
 */
package com.nagihome.riddle;

/**
 * @author nageswararao
 *
 */
public class MultipleOf3And5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int multipleOf3 = sumOfNumberBelowLimit(3, 1000 - 1);
		int multipleOf5 = sumOfNumberBelowLimit(5, 1000 - 1);
		int multipleOf15 = sumOfNumberBelowLimit(15, 1000 - 1);

		System.out.format("multipleOf3: %s, multipleOf5: %s, multipleOf15: %s ", multipleOf3, multipleOf5,
				multipleOf15);
		
		int finalValue = multipleOf3 + multipleOf5 - multipleOf15;
		
		System.out.format("finalValue: %s",finalValue);
		
		
	}

	private static int sumOfNumberBelowLimit(int num, int limit) {

		int nthValue = limit / num;
		
		System.out.format("nthValue: %s \n", nthValue);

		// (n(n + 1) / 2)
		return num * (nthValue * (nthValue + 1) / 2 );
	}

}
