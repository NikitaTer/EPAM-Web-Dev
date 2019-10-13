package by.epam.app.action.parser;

import by.epam.app.entity.BaseTextItem;
import by.epam.app.entity.ElementType;
import by.epam.app.entity.TextRegEx;
import by.epam.app.entity.TextNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser implements BasicParser {

    private BasicParser nextParser;

    private final static Logger logger = LogManager.getLogger();

    public ParagraphParser(BasicParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public BaseTextItem parse(String string) {
        BaseTextItem paragraph = new TextNode(ElementType.NEW_LINE);

        String[] strings = string.split(TextRegEx.SPLIT_SENTENCE);

        for (String s : strings) {
            paragraph.add(nextParser.parse(s));
        }

        logger.info("Paragraph was formed");
        return paragraph;
    }

    @Override
    public void setNextParser(BasicParser nextParser) {
        this.nextParser = nextParser;
    }
}