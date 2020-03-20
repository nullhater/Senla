package senlatest.task06;

import java.util.Objects;

/**
 * Данный класс играет роль вещи, которую можно положить в портфель
 * @see Backpack - класс портфеля
 * {@link #id} - идентификационный номер вещи
 * {@link #weight} - вес вещи
 * {@link #cost} - стоимость вещи
 */

public class Thing implements Comparable {
    private static int idCounter = 0;
    private int id;
    private int weight;
    private int cost;

    /**
     * Конструктор вещи
     * @param weight - вес вещи
     * @param cost - стоимость вещи
     */
    public Thing(int weight, int cost) {
        id = ++idCounter;
        this.weight = weight;
        this.cost = cost;
    }


    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    /**
     * Сравнение двух вещей на идентичность
     * @param o - сравниваемая вещь
     * @return - возвращает true, если у текущей вещи и сравниваемой совпадают id,
     * в ином случае возвращает false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Thing)) return false;
        Thing thing = (Thing) o;
        return id == thing.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Сравнение двух вещей по id
     * @param o - сравниваемая вещь
     * @return - возвращает -1, если у текущей вещи id меньше, чем у сравниваемой,
     * 0 - если id вещей равны,
     * 1 - если у текущей вещи id больше, чем у сравниваемой
     */
    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (!(o instanceof Thing)) return -1;
        Thing thing = (Thing) o;
        if (id<thing.id) return -1;
        else if (id == thing.id) return 0;
        else return 1;
    }
}
