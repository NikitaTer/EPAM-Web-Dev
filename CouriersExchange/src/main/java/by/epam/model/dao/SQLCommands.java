package by.epam.model.dao;

public class SQLCommands {
    public final static String FIND_ALL_CLIENTS = "SELECT * FROM users WHERE isCourier=FALSE;";
    public final static String FIND_ALL_ADMINS = "SELECT * FROM users WHERE isAdmins=true;";
    public final static String FIND_ALL_COURIERS = "SELECT * FROM users WHERE isCourier=TRUE;";

    public final static String FIND_USER = "SELECT * FROM users WHERE login=?;";
    public final static String FIND_REQUEST = "SELECT * FROM requests WHERE id=?";
    public final static String FIND_VEHICLE = "SELECT * FROM vehicles WHERE id=?";

    public final static String FIND_COURIER = "SELECT user.login FROM users INNER JOIN requests " +
            "ON users.login = requests.courier WHERE requests.id=?";

    public final static String INSERT_USER = "INSERT INTO users " +
            "(login, password, salt, name, email, isCourier) " +
            "VALUES(?,?,?,?,?,?)";
    public final static String INSERT_REQUEST = "INSERT INTO requests " +
            "(client, vehicleType, description, deliveryFrom, deliveryTo) " +
            "VALUES(?,?,?,?,?)";

    public final static String UPDATE_USER_ONLINE = "UPDATE users SET isOnline=? WHERE login=?";
    public final static String UPDATE_USER_STATUS = "UPDATE users SET isAdmin=? WHERE login=?";
    public final static String UPDATE_REQUEST = "UPDATE users SET courier=?, status=? WHERE id=?";

    public final static String DELETE_USER = "DELETE FROM users WHERE login=?";
}