package by.epam.app.action.comparator;

import by.epam.app.action.TextReader;
import by.epam.app.action.parser.LeafParser;
import by.epam.app.action.parser.ParagraphParser;
import by.epam.app.action.parser.SentenceParser;
import by.epam.app.action.parser.TextParser;
import by.epam.app.entity.TextNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ListIterator;

import static org.testng.Assert.*;

public class IdComparatorTest {

    private TextNode expectedText;
    private TextNode actualText;

    @BeforeClass
    public void preSet() {
        TextParser parser = new TextParser(new ParagraphParser(new SentenceParser(new LeafParser())));
        expectedText = (TextNode) parser.parse(TextReader.read());
        actualText = (TextNode) parser.parse(TextReader.read());
        actualText.sort(new QuantityComparator());

        ListIterator iterator = actualText.createListIterator();

        while (iterator.hasNext()) {
            TextNode temp1 = (TextNode) iterator.next();
            temp1.sort(new QuantityComparator());
            ListIterator iterator1 = temp1.createListIterator();

            while (iterator1.hasNext()) {
                TextNode temp2 = (TextNode) iterator1.next();
                temp2.sort(new QuantityComparator());
            }
        }
    }

    @Test
    public void testCompare() {
        actualText.restore();

        assertEquals(actualText, expectedText);
    }
}