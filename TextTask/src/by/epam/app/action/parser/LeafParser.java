package by.epam.app.action.parser;

import by.epam.app.entity.BaseTextItem;
import by.epam.app.entity.ElementType;
import by.epam.app.entity.TextLeaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeafParser implements BasicParser {

    @Override
    public BaseTextItem parse(String string) {

        if (string.contains(" ")) {
            return new TextLeaf(string.replace(" ", ""), ElementType.SPACE);
        } else {
            return new TextLeaf(string, ElementType.NON);
        }
    }

    @Override
    public void setNextParser(BasicParser nextParser) {

    }
}
