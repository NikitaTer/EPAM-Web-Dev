package by.epam.app.action.parser;

import by.epam.app.entity.ElementType;
import by.epam.app.entity.TextLeaf;
import by.epam.app.entity.TextNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceParserTest {

    @Test
    public void testParse() {
        SentenceParser sentenceParser = new SentenceParser(new LeafParser());
        TextNode expectedSentence = new TextNode(ElementType.NON);

        expectedSentence.add(new TextLeaf("Hello", ElementType.NON));
        expectedSentence.add(new TextLeaf(",", ElementType.SPACE));
        expectedSentence.add(new TextLeaf("how", ElementType.SPACE));
        expectedSentence.add(new TextLeaf("are", ElementType.SPACE));
        expectedSentence.add(new TextLeaf("you", ElementType.SPACE));
        expectedSentence.add(new TextLeaf("doing", ElementType.NON));
        expectedSentence.add(new TextLeaf("?", ElementType.NON));

        TextNode actualSentence = (TextNode) sentenceParser.parse("Hello, how are you doing?");

        assertEquals(actualSentence, expectedSentence);
    }
}