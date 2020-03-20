package senlatest.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task04 {
    public static void main(String []args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = null;
        String word = null;
        try{
            System.out.println("Введите текст");
            text = reader.readLine();
            System.out.println("Введите слово");
            word = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Что-то пошло не так");
        }
        text = text.toLowerCase(); //Преобразуем весь текст в нижний регистр
        word = word.toLowerCase();
        Pattern pattern = Pattern.compile("\\b"+word+"\\b");//Укзаываем, что искать нужно слово, а не часть слова, например слова
        // "котенок" и "кот" имею общую часть "кот", которая не должна учитываться при поиске, если она является частью слова
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        System.out.println("Слово '"+word+"' встречается в тексте "+count+" раз(а)");
    }
}
