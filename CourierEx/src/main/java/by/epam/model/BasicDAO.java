package by.epam.model;

import by.epam.entity.*;

import java.util.List;

public interface BasicDAO {
    List<Client> getClients();
    void addClient(Client client);
    List<Courier> getCouriers();
    void addCourier(Courier courier);
    List<Admin> getAdmins();
    void addAdmin(Admin admin);
    ClientsRequest getRequest(Client client);
    void addRequest(ClientsRequest request);
    Vehicle getVehicle(int id);
    void addVehicle(Vehicle vehicle);
}
