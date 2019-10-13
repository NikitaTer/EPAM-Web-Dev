package by.epam.app.action.parser;

import by.epam.app.entity.BaseTextItem;
import by.epam.app.entity.ElementType;
import by.epam.app.entity.TextRegEx;
import by.epam.app.entity.TextNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser implements BasicParser {

    private BasicParser nextParser;
    private final static Logger logger = LogManager.getLogger();

    public TextParser(BasicParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public BaseTextItem parse(String string) {
        BaseTextItem text = new TextNode(ElementType.NON);

        String[] strings = string.split(TextRegEx.SPLIT_PARAGRAPH);

        for (String s : strings) {
            text.add(nextParser.parse(s));
        }

        logger.info("Text was formed");
        return text;
}

    @Override
    public void setNextParser(BasicParser nextParser) {
        this.nextParser = nextParser;
    }
}
