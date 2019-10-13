package by.epam.app.action.parser;

import by.epam.app.entity.BaseTextItem;

public interface BasicParser {

    BaseTextItem parse(String string);
    void setNextParser(BasicParser nextParser);
}