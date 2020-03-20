package senlatest.task05;

import senlatest.numericUtils.NumericUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task05 {
    public static final int MAX_NUMBER = 100;
    public static void main(String []args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите N");
        int count = Integer.parseInt(reader.readLine());
        if (count> MAX_NUMBER){
            System.out.println("N нельзя устанавливать больше "+ MAX_NUMBER +". Програмно устанавливаем N значение "+ MAX_NUMBER);
            count = MAX_NUMBER;
        }
        for (int i = 0; i < count; i++) {
            if (NumericUtils.isPalindrom(i)) System.out.println(i);
        }
    }

}
