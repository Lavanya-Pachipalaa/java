public class GCD {
  private int number1;
  private int number2;

  /**
   * Constructor that initializes the two numbers.
   * 
   * @param number1: The first number.
   * @param number2: The second number.
   */
  public GCD(int number1, int number2) {
    this.number1 = number1;
    this.number2 = number2;
  }

  /**
   * Getter for the first number.
   * 
   * @return the first number.
   */
  public int getNumber1() {
    return number1;
  }

  /**
   * Getter for the second number.
   * 
   * @return the second number.
   */
  public int getNumber2() {
    return number2;
  }

  /**
   * Calculates and returns the greatest common divisor (GCD) of the two numbers.
   * Edge case: If either number is negative, returns 1 as the GCD for negative
   * numbers is 1.
   * Edge case: If either number is zero, returns 0 as the GCD of 0 and any other
   * number is 0.
   * Edge case: If two numbers are equal, returns the number as the GCD of two
   * equal numbers is the number itself.
   * 
   * @return GCD of the two numbers, or 1 if either number is negative, or 0 if
   *         either number is zero.
   */
  public int calculateGCD() {
    // Write your code here
    if (number1 == 0 || number2 == 0)
      return 0;
    if (number1 < 0 || number2 < 0)
      return 1;
    if (number1 == number2)
      return number1;
    int min = Math.min(number1, number2);
    for (int i = min; i > 0; i--) {
      if (number1 % i == 0 && number2 % i == 0)
        return i;
    }
    return 1;
  }
}