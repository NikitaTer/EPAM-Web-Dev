package by.epam.app.action.parser;

import by.epam.app.entity.ElementType;
import by.epam.app.entity.TextLeaf;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LeafParserTest {

    @Test
    public void testParse() {
        LeafParser leafParser = new LeafParser();
        TextLeaf expectedWord = new TextLeaf("hello", ElementType.NON);

        TextLeaf actualWord = (TextLeaf) leafParser.parse("hello");

        assertEquals(actualWord, expectedWord);
    }
}