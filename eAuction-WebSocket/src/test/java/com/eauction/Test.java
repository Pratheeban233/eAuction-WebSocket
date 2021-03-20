package com.eauction;

public class Test {
	
	 static boolean isMultipleof500 (int n) 
	{ 
		while (n > 0) 
			n = n - 500; 

		if (n == 0) 
			return true; 

		return false; 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		int n = 1200; 
		if (isMultipleof500(n) == true) 
			System.out.printf("%d is multiple of 500\n", n); 
		else
			System.out.printf("%d is not a multiple of 500\n", n); 
	} 

}
