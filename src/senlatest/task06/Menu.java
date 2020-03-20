package senlatest.task06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    Данный класс представляет собой меню, через которое пользователь взаимодействует с программой
 */
public class Menu {
    private BufferedReader reader = null;
    public Menu() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Запуск меню
     */
    public void run(){
        int maxWeight = 0;
        Backpack backpack = null;
        while (true){
            try {
                System.out.println("Введите максимальную грузоподьемность портфеля (целое число)");
                maxWeight = Integer.parseInt(reader.readLine());
                backpack = new Backpack(maxWeight);
                break;
            }catch (Exception e){
                System.out.println("Некорректный ввод, попробуйте ещё раз");
            }
        }
        ArrayList<Thing> things = new ArrayList<>();
        while (true){
            try {
                System.out.println("Введите вес новой вещи (целое число) или напищите слово \"stop\" если ввели весь список вещей");
                String text = reader.readLine();
                if (text.equals("stop")) {
                    if (things.size() == 0) {
                        System.out.println("Список вещей пустой, введите хотя бы одну вещь");
                    } else break;
                } else {
                    int weight = Integer.parseInt(text);
                    System.out.println("Теперь введите стоимость вещи (целое число)");
                    int cost = Integer.parseInt(reader.readLine());
                    Thing thing = new Thing(weight, cost);
                    things.add(thing);
                    System.out.println("Добавлена вещь:");
                    System.out.println("Номер вещи: " + thing.getId() + "\nВес вещи: " + thing.getWeight() + "\nСтоимость вещи: " + thing.getCost());
                }
            }catch (Exception e){
                System.out.println("Некорректный ввод, попробуйте ещё раз");
            }
        }
        OptimalFinder.init();
        OptimalFinder optimalFinder = new OptimalFinder(things,backpack);
        optimalFinder.find();
        ArrayList<Backpack> result = OptimalFinder.getResultBackpacks();
        System.out.println("Самый оптимальный способ:");
        System.out.print("Вещи: ");
        ArrayList<Thing> resultThings = result.get(result.size()-1).getThings();
        for (int j = 0; j < resultThings.size(); j++) {
            System.out.print(resultThings.get(j).getId()+" ");
        }
        System.out.println("\nОбщая стоимость: "+result.get(result.size()-1).getCurrentCost());
        System.out.println("Общий вес: "+result.get(result.size()-1).getCurrentWeight()+"\n");
    }
}
