package by.epam.entity;

import java.util.Objects;

public class CandyValue {

    private int proteins;
    private int fats;
    private int carbo;

    public CandyValue() {
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCarbo() {
        return carbo;
    }

    public void setCarbo(int carbo) {
        this.carbo = carbo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CandyValue that = (CandyValue) o;

        return  proteins == that.proteins &&
                fats == that.fats &&
                carbo == that.carbo;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result += 31 * proteins;
        result += 31 * fats;
        result += 31 * carbo;

        return result;
    }
}