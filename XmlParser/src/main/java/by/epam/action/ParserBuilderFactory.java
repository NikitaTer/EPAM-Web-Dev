package by.epam.action;

import by.epam.action.builder.CandyBuilder;
import by.epam.action.builder.DomBuilder;
import by.epam.action.builder.SaxBuilder;
import by.epam.action.builder.StAxBuilder;
import by.epam.entity.ParserType;

public class ParserBuilderFactory {
    public static CandyBuilder createCandyBuilder(ParserType type) {
        switch (type){
            case DOM:
                return new DomBuilder();
            case SAX:
                return new SaxBuilder();
            case StAX:
                return new StAxBuilder();
            default:
                return null;
        }
    }
}
