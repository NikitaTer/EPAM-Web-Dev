package by.epam.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    private static final Logger logger = LogManager.getLogger(XmlValidator.class);
    private static final String XML_PATH = "src/main/resources/data/Candies.xml";
    private static final String XSD_PATH = "src/main/resources/data/schema.xsd";

    public static boolean isFileValid() {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(XSD_PATH);

        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(XML_PATH);
            validator.validate(source);
            return true;
        } catch (SAXException | IOException e) {
            logger.error("Validation: " + XML_PATH + " is not valid because " + e.getMessage());
            System.out.println("Validation: " + XML_PATH + " is not valid because " + e.getMessage());
            return false;
        }
    }

    public static String getXmlPath() {
        return XML_PATH;
    }

    public static String getXsdPath() {
        return XSD_PATH;
    }
}