package by.epam.model;

public class SQLStatements {
    public final static String GET_ALL_CLIENTS = "SELECT * FROM clients";
    public final static String GET_ALL_ADMINS = "SELECT * FROM admins";
    public final static String GET_ALL_COURIERS = "SELECT * FROM clients";
    public final static String GET_REQUEST = "SELECT * FROM requests WHERE id=?";
    public final static String GET_VEHICLE= "SELECT * FROM vehicles WHERE id=?";

    public final static String ADD_CLIENT = "INSERT INTO clients VALUES(?,?,?,?)";
    public final static String ADD_ADMIN = "INSERT INTO admins VALUES(?,?,?,?)";
    public final static String ADD_COURIER = "INSERT INTO couriers VALUES(?,?,?,?,?,?)";
    public final static String ADD_REQUEST = "INSERT INTO requests VALUES(?,?,?)";
}
