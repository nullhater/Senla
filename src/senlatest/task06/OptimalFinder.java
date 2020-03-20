package senlatest.task06;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Данный класс рекурсивно вычисляет оптимальный способ заполнения рюкзака вещами таким образом,
 * что бы вещи, находящиеся в нем, давали максимальную общую сумму стоимости из всех возможных коомбинаций заполнения портфеля
 * {@link #things} - вещи, которые следует положить в портфель
 * {@link #backpack} - портфель, в который будут добавляться вещи
 * {@link #resultBackpacks} - лист с портфелями, заполненный всеми возвожными коомбинациями вещей
 * @see Thing - класс вещей
 * @see Backpack - класс портфеля
 */
public class OptimalFinder {
    private ArrayList<Thing> things;
    private Backpack backpack;
    private static ArrayList<Backpack> resultBackpacks = new ArrayList<>();

    /**
     * Конструктор
     * @param things - вещи, которые нужно поместить в портфель
     * @param backpack - порфель, в который будут помещены вещи
     */
    public OptimalFinder(ArrayList<Thing> things, Backpack backpack) {
        this.things = new ArrayList<>(things);
        this.backpack = new Backpack(backpack);
    }

    /**
     * Начальная инициализация. Создание результирующего листа
     */
    public static void init(){
        resultBackpacks = new ArrayList<>();
    }

    /**
     * Рекурсивный поиск всех коомбинаций
     */
    public void find(){
        Backpack tempBackpack = new Backpack(backpack);
        for (int i = 0; i < things.size(); i++) {
            Thing currentThing = things.get(i);
            ArrayList<Thing> tempThings = new ArrayList<>(things);
            tempThings.remove(currentThing);
            if (backpack.addThing(currentThing)){
                Backpack nextBackpacks = new Backpack(backpack);
                if (!resultBackpacks.contains(nextBackpacks)) {
                    resultBackpacks.add(nextBackpacks);
                }
                OptimalFinder optimalFinder = new OptimalFinder(tempThings,backpack);
                optimalFinder.find();
                backpack = new Backpack(tempBackpack);
            }
        }
    }

    /**
     * Возвращение всех коомбинаций заполнения портфелей
     * @return - возвращает список портфелей, заполненных разыми коомбинациями вещей,
     * в начале списка - худшие коомбинации, в конце списка - наилучшие коомбинации
     */
    public static ArrayList<Backpack> getResultBackpacks() {
        Collections.sort(resultBackpacks);
        return resultBackpacks;
    }
}
