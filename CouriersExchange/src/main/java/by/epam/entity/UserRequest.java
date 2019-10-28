package by.epam.entity;

public class UserRequest {

    private int id;
    private CargoType cargoType;
    private String cargoName;
    private String courierLogin;
    private String vehicle;

    public UserRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public String getCourierLogin() {
        return courierLogin;
    }

    public void setCourierLogin(String courierLogin) {
        this.courierLogin = courierLogin;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserRequest userRequest = (UserRequest) o;
        return  cargoType == userRequest.cargoType &&
                cargoName.equals(userRequest.cargoName) &&
                courierLogin.equals(userRequest.courierLogin) &&
                vehicle.equals(userRequest.vehicle);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result += 31 * cargoType.hashCode();
        result += 31 * cargoName.hashCode();
        result += 31 * courierLogin.hashCode();
        result += 31 * vehicle.hashCode();

        return result;
    }
}
