package by.epam.action.builder;

import by.epam.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DomBuilder implements CandyBuilder{

    private List<Candy> candies = new ArrayList<>();

    private static final Logger logger = LogManager.getLogger(DomBuilder.class);
    private DocumentBuilder documentBuilder;

    public DomBuilder(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        logger.info("Getting DocumentBuilderFactory singleton instance.");
        try{
            documentBuilder = factory.newDocumentBuilder();
            logger.info("Creating new XML file DOM parser.");
        }catch(ParserConfigurationException e){
            logger.error("Error in creating DOM parser.");
            throw new RuntimeException();
        }
    }

    private CandyValue buildCandyValue(Element element){
        logger.info("Creating value with DOM.");

        CandyValue value = new CandyValue();
        value.setProteins(Integer.parseInt(getNodeElement(element, CandyMark.PROTEINS.getValue()).getTextContent()));
        value.setFats(Integer.parseInt(getNodeElement(element, CandyMark.FATS.getValue()).getTextContent()));
        value.setCarbo(Integer.parseInt(getNodeElement(element, CandyMark.CARBO.getValue()).getTextContent()));

        return value;
    }

    private CandyIngredients buildCandyIngredients(Element element){
        logger.info("Creating ingredients with DOM.");

        CandyIngredients ingredients = new CandyIngredients();
        Node node = element.getChildNodes().item(7);

        if (node.hasAttributes()) {
            ingredients.setChocolateType(node.getAttributes().getNamedItem("type-of-chocolate").getTextContent());
        }

        ingredients.setFructose(Integer.parseInt(getNodeElement(element,CandyMark.FRUCTOSE.getValue()).getTextContent()));
        ingredients.setSugar(Integer.parseInt(getNodeElement(element,CandyMark.SUGAR.getValue()).getTextContent()));
        ingredients.setVanillin(Integer.parseInt(getNodeElement(element,CandyMark.VANILLIN.getValue()).getTextContent()));
        ingredients.setWater(Integer.parseInt(getNodeElement(element,CandyMark.WATER.getValue()).getTextContent()));

        return ingredients;
    }

    private Candy buildCandy(Element element) throws ParseException {
        logger.info("Creating candy with DOM.");


        Candy candy = new Candy();
        candy.setName(getNodeElement(element,CandyMark.NAME.getValue()).getTextContent());
        candy.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(element.getAttribute(CandyMark.DATE.getValue())));
        candy.setEnergy(Integer.parseInt(getNodeElement(element,CandyMark.ENERGY.getValue()).getTextContent()));
        candy.setExpiry(Integer.parseInt(element.getAttribute(CandyMark.EXPIRY.getValue())));
        candy.setId(element.getAttribute(CandyMark.ID.getValue()));
        candy.setIngredients(buildCandyIngredients(element));
        candy.setProduction(getNodeElement(element,CandyMark.PRODUCTION.getValue()).getTextContent());
        candy.setType(CandyType.getByName(getNodeElement(element,CandyMark.CANDY_TYPE.getValue()).getTextContent()));
        candy.setValue(buildCandyValue(element));

        return candy;
    }

    @Override
    public List<Candy> getCandies() {
        return candies;
    }

    @Override
    public void setCandies(List<Candy> candies) {
        this.candies = candies;
    }

    @Override
    public void buildCandies(String fileName){
        Document document;
        try{
            logger.info("Finding root element on XML file.");

            document = documentBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList candyList = root.getElementsByTagName(CandyMark.CANDY.getValue());
            for(int i = 0; i < candyList.getLength();i++){
                Element candyElement = (Element) candyList.item(i);
                Candy candy = buildCandy(candyElement);
                logger.info("Adding candy to candies.");
                candies.add(candy);
            }
        }catch(IOException | SAXException | ParseException e){
            logger.error("Can't build candies");

        }
    }

    public Node getNodeElement(Element element, String elementName){
        NodeList nodes = element.getElementsByTagName(elementName);
        return nodes.item(0);
    }
}
