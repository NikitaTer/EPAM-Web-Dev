package by.epam.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ConnectionPool {

    private static ConnectionPool instance;

    private static final String URL = "jdbc:mysql://localhost/courier_ex";
    private final static Properties prop = new Properties();
    static {
        prop.put("user", "root");
        prop.put("password", "Teror667");
        prop.put("useUnicode", "true");
        prop.put("useJDBCCompliantTimezoneShift", "true");
        prop.put("useLegacyDatetimeCode", "false");
        prop.put("serverTimezone", "UTC");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
    }
    private BlockingQueue<Connection> freeConnections;
    private Queue<Connection> givenConnections;

    private static final int DEFAULT_POOL_SIZE = 32;

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = freeConnections.take();
            givenConnections.offer(connection);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        givenConnections.remove(connection);
        freeConnections.offer(connection);
    }

    public void destroyPool() {

        try {

            for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
                freeConnections.take().close();
            }

            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ConnectionPool() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
            givenConnections = new ArrayDeque<>();

            for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(URL, prop);
                freeConnections.add(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
