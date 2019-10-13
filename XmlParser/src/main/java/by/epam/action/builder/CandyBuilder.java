package by.epam.action.builder;

import by.epam.entity.Candy;

import java.util.List;

public interface CandyBuilder {

    List<Candy> getCandies();
    void setCandies(List<Candy> candies);
    void buildCandies(String fileName);
}
