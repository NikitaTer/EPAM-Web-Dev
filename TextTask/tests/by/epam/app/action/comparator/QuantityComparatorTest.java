package by.epam.app.action.comparator;

import by.epam.app.entity.ElementType;
import by.epam.app.entity.TextLeaf;
import by.epam.app.entity.TextNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuantityComparatorTest {

    @Test
    public void testCompare() {
        TextNode actualText = new TextNode(ElementType.NON);
        actualText.add(new TextLeaf("12345", ElementType.SPACE));
        actualText.add(new TextLeaf("123", ElementType.SPACE));
        actualText.add(new TextLeaf("1234", ElementType.SPACE));
        actualText.add(new TextLeaf("12", ElementType.SPACE));

        actualText.sort(new QuantityComparator());

        TextNode expectedText = new TextNode(ElementType.NON);
        expectedText.add(new TextLeaf("12", ElementType.SPACE));
        expectedText.add(new TextLeaf("123", ElementType.SPACE));
        expectedText.add(new TextLeaf("1234", ElementType.SPACE));
        expectedText.add(new TextLeaf("12345", ElementType.SPACE));

        assertEquals(actualText, expectedText);
    }
}