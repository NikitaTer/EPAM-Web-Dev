package by.epam.model.dao;

public class SQLCommands {
    public final static String FIND_ALL_USERS = "SELECT * FROM users;";
    public final static String FIND_ALL_ADMINS = "SELECT * FROM users WHERE isAdmins=true;";
    public final static String FIND_ALL_COURIERS = "SELECT * FROM couriers;";

    public final static String FIND_COURIER = "SELECT * FROM couriers WHERE login=?;";
    public final static String FIND_USER = "SELECT * FROM users WHERE login=?;";
    public final static String FIND_REQUEST = "SELECT * FROM requests WHERE id=?";
    public final static String FIND_VEHICLE = "SELECT * FROM vehicles WHERE id=?";

    public final static String INSERT_USER = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?)";
    public final static String INSERT_COURIER = "INSERT INTO couriers VALUES(?,?,?,?,?,?,?,?,?)";
    public final static String INSERT_REQUEST = "INSERT INTO requests VALUES(?,?,?,?,?)";

    public final static String UPDATE_USER = "UPDATE users SET login=?, password=?, salt=?, name=?, WHERE login=?";

    public final static String DELETE_USER = "DELETE FROM users WHERE login=?";
}
