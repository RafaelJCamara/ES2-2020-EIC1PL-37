package Group37ESII;

/**
 * @author Group37 ESII
 * @version 1.0
 * @since 22 march 2020
 *
 */


public class Calculator {
    
	
	/**
	 * @param num1 The first parameter of add method.
	 * @param num2 The second parameter of add method.
	 * @return The sum of num1 and num2
	 */
	public int add(int num1, int num2) {
		return num1+num2;
	}
	
	
	/**
	 * @param num1 The first parameter of subtract method.
	 * @param num2 The second parameter of subtract method.
	 * @return The subtraction of num1 by num2 (in that order)
	 */
	public int subtract(int num1, int num2) {
		return num1-num2;
	}
	
	
	/**
	 * @param num1 The first parameter of multiplication method.
	 * @param num2 The second parameter of multiplication method.
	 * @return The multiplication of num1 by num2.
	 */
	public int multiplication(int num1, int num2) {
		return num1*num2;
	}
	
	
	
	/**
	 * @param num1 The first parameter of division method.
	 * @param num2 The second parameter of division method.
	 * @return The division of num1 by num2.
	 */
	public double division(int num1, int num2) {
		return (double) num1/num2;
	}
	
	
	
}