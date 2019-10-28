package by.epam.entity;

import java.util.Objects;

public class Cargo {
    private int id;
    private String name;
    private CargoType type;

    public Cargo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CargoType getType() {
        return type;
    }

    public void setType(CargoType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cargo cargo = (Cargo) o;
        return name.equals(cargo.name) &&
                type.equals(cargo.type);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result += 31 * type.hashCode();
        result += 31 * name.hashCode();

        return result;
    }
}
