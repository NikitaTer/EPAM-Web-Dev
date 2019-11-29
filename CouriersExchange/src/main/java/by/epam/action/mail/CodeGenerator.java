package by.epam.action.mail;

public class CodeGenerator {

    private String code;

    private final static int MAX = 90;
    private final static int MIN = 65;

    public CodeGenerator() {
        char[] chars = new char[6];

        chars[0] = (char) ((int)(Math.random() * (MAX - MIN + 1)) + MIN);
        chars[1] = (char) ((int)(Math.random() * (MAX - MIN + 1)) + MIN);
        chars[2] = (char) ((int)(Math.random() * (57 - 48 + 1)) + 48);
        chars[3] = (char) ((int)(Math.random() * (57 - 48 + 1)) + 48);
        chars[4] = (char) ((int)(Math.random() * (MAX - MIN + 1)) + MIN);
        chars[5] = (char) ((int)(Math.random() * (MAX - MIN + 1)) + MIN);

        code = String.valueOf(chars);
    }

    public String getCode() {
        return code;
    }
}
