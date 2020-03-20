package senlatest.task02;

import senlatest.numericUtils.NumericUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Task02 {
    public static BufferedReader reader = null;
    public static void main(String []args){
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выбор режима работы программы\n" +
                "1 - Использовать методы встроенного класса BigInteger\n" +
                "2 - Использовать написанный алгоритм");
        int choise = 0;
        try {
            choise = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println("Некорректный ввод пункта меню");
            System.exit(-1);
        }
        switch (choise){
            case 1:
                programExampleWithBigIntegerMethods();
                break;
            case 2:
                programExampleWithManualAlgorithm();
                break;
            default:
                System.out.println("Нет такого пункта меню");
        }
    }

    public static void programExampleWithBigIntegerMethods(){
        BigInteger firstVal;
        BigInteger secondVal;
        while (true){
            try {
                System.out.println("Введите первое целое число");
                firstVal = new BigInteger(reader.readLine());
                System.out.println("Введите второе целое число");
                secondVal = new BigInteger(reader.readLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("Допускается ввод только целых чисел. Попробуйте ввести числа ещё раз");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Что-то пошло не так");
                System.exit(-1);
            }
        }
        BigInteger gcd = firstVal.gcd(secondVal);
        BigInteger nok = (firstVal.multiply(secondVal)).divide(gcd); //НОК(firstVal, secondVal) = firstVal * secondVal / НОД(firstVal, secondVal)
        System.out.println("Наибольший общий делитель: "+gcd);
        System.out.println("Наименьшее общее кратное: "+nok);
    }

    public static void programExampleWithManualAlgorithm(){
        int firstVal = 0;
        int secondVal = 0;
        while (true){
            try {
                System.out.println("Введите первое целое число");
                firstVal = Integer.parseInt(reader.readLine());
                System.out.println("Введите второе целое число");
                secondVal = Integer.parseInt(reader.readLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("Допускается ввод только целых чисел. Попробуйте ввести числа ещё раз");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Что-то пошло не так");
                System.exit(-1);
            }
        }
        int gcd = NumericUtils.findCommonLargestDivisor(firstVal,secondVal);
        int nok = NumericUtils.findLeastCommonMultiple(firstVal, secondVal); //НОК(firstVal, secondVal) = firstVal * secondVal / НОД(firstVal, secondVal)
        System.out.println("Наибольший общий делитель: "+gcd);
        System.out.println("Наименьшее общее кратное: "+nok);
    }
}
