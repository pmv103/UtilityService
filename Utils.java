package com.utilityservice;

public class Utils {

	private static final String INVALID_NUM_MSG = "Prime factor can not be determined for given number. Kindly provide valid input greater than 2";
	private static final String SUCCESS_MSG = "Prime factors are:";
	private static final String PRIME_NUMBER_MSG = "Given number itself is a prime number. Therefore prime factors can not be determined.";
	private static final String ERROR_MSG = "Exception occurred.";

	/**
	 * 
	 * @param numString
	 * @return
	 */
	public static String getPrimeFactors(String numString) {

		/**
		 * StringBuilder used to print the prime factors
		 */
		StringBuilder stb = new StringBuilder();

		try {

			if (!numString.matches("\\d+") || numString.length() > 19) {
				return INVALID_NUM_MSG;
			}

			long number = Long.valueOf(numString);
			long inNumber = number;
			
			if (number == 0 || number == 1) {
				return INVALID_NUM_MSG;
			}

			for (long i = 2; i <= number / i; i++) {

				while (number % i == 0) {
					number = number / i;
					stb.append(i).append(" ");
				}

			}

			if (number > 1) {
				stb.append(number);
			}

			if (String.valueOf(inNumber).equals(stb.toString())) {
				return PRIME_NUMBER_MSG;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR_MSG;
		}

		return SUCCESS_MSG + stb.toString();
	}

}
