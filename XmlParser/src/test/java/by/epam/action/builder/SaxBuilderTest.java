package by.epam.action.builder;

import by.epam.action.XmlValidator;
import by.epam.entity.Candy;
import by.epam.entity.CandyIngredients;
import by.epam.entity.CandyType;
import by.epam.entity.CandyValue;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.testng.Assert.*;

public class SaxBuilderTest {

    private Candy candy;
    private CandyValue value;
    private CandyIngredients ingredients;

    @BeforeClass
    public void preSet(){
        value = new CandyValue();
        value.setProteins(333);
        value.setFats(444);
        value.setCarbo(555);

        ingredients = new CandyIngredients();
        ingredients.setChocolateType("Sweat-P");
        ingredients.setVanillin(20);
        ingredients.setFructose(411);
        ingredients.setSugar(114);
        ingredients.setWater(124);

        candy = new Candy();
        candy.setName("NikiTers");
        candy.setId("bggg");
        candy.setEnergy(666);
        candy.setExpiry(70);
        candy.setProduction("Tsiareshchnka Inc.");
        try {
            candy.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-21"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        candy.setType(CandyType.CHOCOLATE_WITH);
        candy.setValue(value);
        candy.setIngredients(ingredients);
    }

    @Test
    public void testBuildCandies() {
        CandyBuilder builder = new SaxBuilder();
        builder.buildCandies(XmlValidator.getXmlPath());
        Candy actual = builder.getCandies().get(2);
        Assert.assertEquals(actual, candy);
    }
}