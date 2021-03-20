package com.eauction.util;

import com.eauction.constant.Constants;

public class Utility {

	public static boolean checkBiddingAmount(Long existMaxAmount, Long bidderInput) {

		return existMaxAmount >= bidderInput ? true : false;
	}
	
	public static boolean isMultipleofIncrementPrice (long n) 
		{ 
			while (n > 0) 
				n = n - Constants.INCREMENT_PRICE; 

			if (n == 0) 
				return true; 

			return false; 
		} 
}
