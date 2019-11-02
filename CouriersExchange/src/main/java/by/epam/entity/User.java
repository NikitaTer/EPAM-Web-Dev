package by.epam.entity;

import java.util.Date;
import java.util.Objects;

public class User {
    private String login;
    private String name;
    private String password;
    private String salt;
    private String email;

    private int requestId;

    private boolean isOnline;
    private boolean isAdmin;

    private Date lastTimeSeen;

    public User() {
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

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
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

        User user = (User) o;

        return requestId == user.requestId &&
                isOnline == user.isOnline &&
                isAdmin == user.isAdmin &&
                login.equals(user.login) &&
                name.equals(user.name) &&
                password.equals(user.password) &&
                salt.equals(user.salt) &&
                email.equals(user.email) &&
                lastTimeSeen.equals(user.lastTimeSeen);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result += 31 * requestId;
        result += 31 * name.hashCode();
        result += 31 * password.hashCode();
        result += 31 * salt.hashCode();
        result += 31 * login.hashCode();
        result += 31 * email.hashCode();
        result += 31 * Boolean.hashCode(isAdmin);
        result += 31 * Boolean.hashCode(isOnline);
        result += 31 * lastTimeSeen.hashCode();

        return result;
    }
}