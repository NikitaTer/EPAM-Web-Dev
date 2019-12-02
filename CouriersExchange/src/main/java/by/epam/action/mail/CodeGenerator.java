package by.epam.action.mail;

import by.epam.model.CodeUserStorage;

public class CodeGenerator {

    private String code;

    private final static int MAX = 90;
    private final static int MIN = 65;

    public CodeGenerator() {
        do {
            code = generateCode();
        } while (CodeUserStorage.getInstance().isCodeExist(code));
    }

    public String getCode() {
        return code;
    }

    private String generateCode() {
        char[] chars = new char[6];

        chars[0] = (char) ((int)(Math.random() * (MAX - MIN + 1)) + MIN);
        chars[1] = (char) ((int)(Math.random() * (MAX - MIN + 1)) + MIN);
        chars[2] = (char) ((int)(Math.random() * (57 - 48 + 1)) + 48);
        chars[3] = (char) ((int)(Math.random() * (57 - 48 + 1)) + 48);
        chars[4] = (char) ((int)(Math.random() * (MAX - MIN + 1)) + MIN);
        chars[5] = (char) ((int)(Math.random() * (MAX - MIN + 1)) + MIN);

        return String.valueOf(chars);
    }
}
