package by.epam.entity;

import java.util.HashMap;
import java.util.Map;

public enum  CandyMark {
    CANDIES("Candies"),
    CANDY("candy"),
    PRODUCTION("production"),
    NAME("name"),
    ENERGY("energy"),
    CANDY_TYPE("type"),
    CHOCOLATE_TYPE("type-of-chocolate"),
    DATE("date"),
    EXPIRY("expiry"),
    ID("id"),

    INGREDIENTS("ingredients"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    VANILLIN("vanillin"),

    VALUE("value"),
    PROTEINS("proteins"),
    FATS("fats"),
    CARBO("carbo");

    private String value;
    private static final Map<String,CandyMark> pair;

    static {
        pair = new HashMap<>();
        for(CandyMark mark : CandyMark.values()){
            pair.put(mark.value, mark);
        }
    }

    CandyMark(String value){
        this.value = value;
    }

    public static CandyMark getMatk(String value){
        return pair.get(value);
    }

    public String getValue() {
        return value;
    }
}
