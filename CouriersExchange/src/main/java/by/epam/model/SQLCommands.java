package by.epam.model;

public class SQLCommands {
    public final static String GET_ALL_USERS = "SELECT * FROM users;";
    public final static String GET_ALL_ADMINS = "SELECT * FROM users WHERE isAdmins=true;";
    public final static String GET_ALL_COURIERS = "SELECT * FROM couriers;";
    public final static String GET_REQUEST = "SELECT * FROM requests WHERE id=?";
    public final static String GET_VEHICLE= "SELECT * FROM vehicles WHERE id=?";

    public final static String ADD_USER = "INSERT INTO users VALUES(?,?,?,?)";
    public final static String ADD_COURIER = "INSERT INTO couriers VALUES(?,?,?,?,?,?)";
    public final static String ADD_REQUEST = "INSERT INTO requests VALUES(?,?,?)";
}
