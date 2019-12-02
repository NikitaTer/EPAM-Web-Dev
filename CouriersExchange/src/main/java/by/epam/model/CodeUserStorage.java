package by.epam.model;

import by.epam.entity.User;

import java.util.HashMap;
import java.util.Map;

public class CodeUserStorage {
    private static CodeUserStorage instance = new CodeUserStorage();

    private Map<String, User> codeUser = new HashMap<String, User>();

    private CodeUserStorage() {

    }

    public static CodeUserStorage getInstance() {
        return instance;
    }

    public void putCodeUser(String code, User user) {
        codeUser.put(code, user);
    }

    public User getUser(String code) {
        return codeUser.get(code);
    }

    public void removeUser(String code) {
        codeUser.remove(code);
    }

    public boolean isCodeExist(String code) {
        return codeUser.get(code) != null;
    }
}
