package senlatest.task06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Данный класс играет роль портфеля, в который можно класть вещи (Thing)
 * @see Thing - класс вещи
 * {@link #maxWeight} - максимальная грузоподъемность портфеля
 * {@link #things} - вещи, которые лежат в портфеле
 */
public class Backpack implements Comparable {
    private int maxWeight;
    private ArrayList<Thing> things;

    /**
     * Конструктор объекта
     * @param maxWeight - максимальная грузоподъемность портфеля
     */
    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
        things = new ArrayList<>();
    }

    /**
     * Конструктор копирования
     * @param backpack - экземпляр, из которого будут скопированы значния полей
     */
    public Backpack(Backpack backpack){
        this.maxWeight = backpack.maxWeight;
        this.things = new ArrayList<>(backpack.things);
    }

    /**
     * Добавление вещи в портфель
     * @param thing - добавляемая вещь
     * @return - возвращает true если вещь была добавлена, и false - если вещь не была добавлена (превышена
     * грузоподьемность или попытка добавить одну и ту же вещь дважды)
     */
    public boolean addThing(Thing thing){
        if (things.contains(thing)) return false;
        if (thing.getWeight()+getCurrentWeight()>maxWeight) return false;
        things.add(thing);
        Collections.sort(things);
        return true;

    }

    /**
     * Получение текущего веса портфеля
     * @return - текущий вес портфеля
     */
    public int getCurrentWeight(){
        int weight = 0;
        for (int i = 0; i < things.size(); i++) {
            weight+=things.get(i).getWeight();
        }
        return weight;
    }

    /**
     * Получений суммарной стоимости всех вещей, находящихся в портфеле
     * @return - суммарная стоимость всех вещей внути портфеля
     */
    public int getCurrentCost(){
        int cost = 0;
        for (int i = 0; i < things.size(); i++) {
            cost+=things.get(i).getCost();
        }
        return cost;
    }

    /**
     * Получение вещей из портфеля
     * @return - список вещей, которые содержатся в портфеле
     */
    public ArrayList<Thing> getThings() {
        return things;
    }

    /**
     * Сравнение портфелей
     * @param o - потрфель, с которым будем сравнивать текущий портфель
     * @return - возвращает true если оба портфеля имеют одинаковые вещи и вес
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Backpack)) return false;
        Backpack backpack = (Backpack) o;
        return maxWeight == backpack.maxWeight &&
                things.equals(backpack.things);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxWeight, things);
    }

    /**
     * Сравнение портфелей по их стоимости
     * @param o - потрфель, с которым будем сравнивать текущий портфель
     * @return - возвращает -1, если содержимое текущего портфеля дешевле,
     * 0 - если стоимость содержимого обоих портфелей совпадает и
     * 1 - если вещи в текушем портфеле суммарно стоят дороже, чем в сравниваемом
     */
    @Override
    public int compareTo(Object o) {
        Backpack backpack = (Backpack) o;
        if (this.getCurrentCost()<backpack.getCurrentCost()) return -1;
        else if (this.getCurrentCost() == backpack.getCurrentCost()) return 0;
        else return 1;
    }
}
