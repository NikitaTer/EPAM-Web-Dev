package by.epam.entity;

import java.util.Objects;

public class CandyIngredients {

    private int water;
    private int sugar;
    private int fructose;
    private int vanillin;

    private String chocolateType = null;

    public CandyIngredients() {
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getFructose() {
        return fructose;
    }

    public void setFructose(int fructose) {
        this.fructose = fructose;
    }

    public int getVanillin() {
        return vanillin;
    }

    public void setVanillin(int vanillin) {
        this.vanillin = vanillin;
    }

    public String getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(String chocolateType) {
        this.chocolateType = chocolateType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CandyIngredients that = (CandyIngredients) o;

        return  water == that.water &&
                sugar == that.sugar &&
                fructose == that.fructose &&
                vanillin == that.vanillin &&
                chocolateType.equals(that.chocolateType);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result += 31 * water;
        result += 31 * sugar;
        result += 31 * fructose;
        result += 31 * vanillin;
        result += 31 * chocolateType.hashCode();

        return result;
    }
}