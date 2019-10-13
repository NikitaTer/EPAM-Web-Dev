package by.epam.app.action.parser;

import by.epam.app.entity.BaseTextItem;
import by.epam.app.entity.ElementType;
import by.epam.app.entity.TextRegEx;
import by.epam.app.entity.TextNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser implements BasicParser {

    private BasicParser nextParser;
    private final static Logger logger = LogManager.getLogger();

    public SentenceParser(BasicParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public BaseTextItem parse(String string) {
        BaseTextItem sentence = new TextNode(ElementType.NON);

        String[] strings = string.split(TextRegEx.SPLIT_LEAF);

        for (String s : strings) {
            sentence.add(nextParser.parse(s));
        }

        logger.info("Sentence was formed");
        return sentence;
    }

    @Override
    public void setNextParser(BasicParser nextParser) {
        this.nextParser = nextParser;
    }
}
