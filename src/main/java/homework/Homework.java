package homework;

public class Homework {
    public static void main(String[] args) {
        int sum = sumOfEvenNumbers(10);
        // 10 +8+2 + 6+4 = 30
        System.out.println("Sum:" + sum);

        boolean isPalindrom = checkPalindrom("madfdam");
        System.out.println(isPalindrom);
    }

    private static boolean checkPalindrom(String input) {
        if (input.length() < 2) {
            return true;
        }
        char leftChar = input.charAt(0);
        char rightChar = input.charAt(input.length() - 1);
        boolean extremitiesAreEqual = leftChar == rightChar;
        return extremitiesAreEqual && checkPalindrom(input.substring(1, input.length() - 1));
    }

    private static int sumOfEvenNumbers(int currentNumber) {
        if (currentNumber == 0) {
            return 0;
        }
        /*
            if(currentNumber % 2 != 0){
                return 0;
            } else {
                return currentNumber;
            }
         */
        return (currentNumber % 2 != 0 ? 0 : currentNumber) + sumOfEvenNumbers(currentNumber - 1);
    }


}
