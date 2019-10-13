package by.epam.app.entity;

public class TextRegEx {
    public final static String SPLIT_PARAGRAPH = "\n";
    public final static String SPLIT_SENTENCE = "(?<=[\\.\\?!]\\s)";
    public final static String SPLIT_LEAF = "(?<=\\s)|(?=[,\\?!;:]|[A-Za-z0-9]\\.$|\\.\\.\\.| - )";
}