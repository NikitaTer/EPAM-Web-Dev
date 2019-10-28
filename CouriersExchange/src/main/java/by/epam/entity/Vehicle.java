package by.epam.entity;

import java.util.Objects;

public class Vehicle {

    private int id;
    private String name;
    private CargoType cargoType;
    private int cargoId;
    private boolean inUse;

    public Vehicle() {
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

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vehicle vehicle = (Vehicle) o;
        return  name.equals(vehicle.name) &&
                cargoType == vehicle.cargoType;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result += 31 * cargoType.hashCode();
        result += 31 * name.hashCode();

        return result;
    }
}
