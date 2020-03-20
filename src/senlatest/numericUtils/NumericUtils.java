package senlatest.numericUtils;

public class NumericUtils {

    public static boolean isEven(Integer value){
        if (value%2==0){
            return true;
        }else return false;
    }

    public static boolean isPrime(int value){
        if (value<0) value*=-1;
        for (int i = 2; i <= value / 2; i++) {
            if (value%i == 0) return false;
        }
        return true;
    }

    public static int findCommonLargestDivisor(int firstValue, int secondValue){
        if (firstValue < 0) firstValue*=-1;
        if (secondValue < 0) secondValue*=-1;
        if (firstValue < secondValue){
            int temp = secondValue;
            secondValue = firstValue;
            firstValue = temp;
        }
        int result = 1;
        for (int i = 1; i <= secondValue; i++) {
            if (firstValue%i == 0 && secondValue%i == 0){
                result = i;
            }
        }
        return result;
    }

    public static int findLeastCommonMultiple(int firstValue, int secondValue){
        int gcd = findCommonLargestDivisor(firstValue, secondValue);
        return (firstValue*secondValue)/gcd;
    }

    public static boolean isPalindrom(int value){
        return new StringBuilder(String.valueOf(value)).reverse().toString().equals(String.valueOf(value));
    }
}
