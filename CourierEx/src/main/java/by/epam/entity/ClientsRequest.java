package by.epam.entity;

public class ClientsRequest {
    private int id;
    private String cargoType;
    private String courierLogin;
    private String vehicle;

    public ClientsRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
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
}
