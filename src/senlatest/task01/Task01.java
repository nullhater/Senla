package senlatest.task01;

import senlatest.numericUtils.NumericUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task01 {
    public static void main(String []args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите целое число");
        int value;
        while (true) {
            try {
                String text = reader.readLine();
                value = Integer.parseInt(text);
                break;
            }catch (NumberFormatException e){
                System.out.println("Допускается ввод только целых чисел. Попробуйте ввести число ещё раз");
            } catch (IOException e) {
                System.out.println("Что-то пошло не так");
                return;
            }
        }
        if (NumericUtils.isEven(value)){
            System.out.println("Число четное");
        }else {
            System.out.println("Число нечетное");
        }
        if (NumericUtils.isPrime(value)){
            System.out.println("Число простое");
        }else {
            System.out.println("Число составное");
        }
    }
}
