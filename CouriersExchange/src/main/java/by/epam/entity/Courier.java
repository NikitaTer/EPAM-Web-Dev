package by.epam.entity;

import java.util.Date;
import java.util.Objects;

public class Courier {

    private String login;
    private String name;
    private String password;
    private String salt;
    private String email;

    private int vehocleId;

    private boolean isOnline;
    private boolean inUse;

    private Date lastTimeSeen;

    public Courier() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVehocleId() {
        return vehocleId;
    }

    public void setVehocleId(int vehocleId) {
        this.vehocleId = vehocleId;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public Date getLastTimeSeen() {
        return lastTimeSeen;
    }

    public void setLastTimeSeen(Date lastTimeSeen) {
        this.lastTimeSeen = lastTimeSeen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Courier courier = (Courier) o;
        return  vehocleId == courier.vehocleId &&
                isOnline == courier.isOnline &&
                inUse == courier.inUse &&
                login.equals(courier.login) &&
                name.equals(courier.name) &&
                password.equals(courier.password) &&
                salt.equals(courier.salt) &&
                email.equals(courier.email) &&
                lastTimeSeen.equals(courier.lastTimeSeen);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result += 31 * vehocleId;
        result += 31 * name.hashCode();
        result += 31 * password.hashCode();
        result += 31 * salt.hashCode();
        result += 31 * login.hashCode();
        result += 31 * email.hashCode();
        result += 31 * Boolean.hashCode(inUse);
        result += 31 * Boolean.hashCode(isOnline);
        result += 31 * lastTimeSeen.hashCode();

        return result;
    }
}
