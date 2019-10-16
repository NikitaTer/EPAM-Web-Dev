package by.epam.entity;

import java.util.Objects;

public class Goods implements Comparable<Goods> {
    private String name;
    private int weight;
    private int priority;

    public Goods(String name, int weight, boolean isPerishable) {
        if (isPerishable) {
            priority = 1;
        } else {
            priority = 0;
        }
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Goods goods) {
        return Integer.compare(weight, goods.weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Goods goods = (Goods) o;
        return  weight == goods.weight &&
                priority == goods.priority &&
                name.equals(goods.name);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result += 31 * weight;
        result += 31 * priority;
        result += 31 * name.hashCode();

        return result;
    }
}