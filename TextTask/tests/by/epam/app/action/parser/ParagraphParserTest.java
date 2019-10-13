package by.epam.app.action.parser;

import by.epam.app.entity.ElementType;
import by.epam.app.entity.TextLeaf;
import by.epam.app.entity.TextNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParagraphParserTest {

    @Test
    public void testParse() {
        ParagraphParser paragraphParser = new ParagraphParser(new SentenceParser(new LeafParser()));
        TextNode expectedParagraph = new TextNode(ElementType.NEW_LINE);
        TextNode firstSen = new TextNode(ElementType.NON);
        TextNode secondSen = new TextNode(ElementType.NON);
        TextNode thirdSen = new TextNode(ElementType.NON);

        firstSen.add(new TextLeaf("Hello", ElementType.NON));
        firstSen.add(new TextLeaf(",", ElementType.SPACE));
        firstSen.add(new TextLeaf("how", ElementType.SPACE));
        firstSen.add(new TextLeaf("are", ElementType.SPACE));
        firstSen.add(new TextLeaf("you", ElementType.SPACE));
        firstSen.add(new TextLeaf("doing", ElementType.NON));
        firstSen.add(new TextLeaf("?", ElementType.SPACE));

        secondSen.add(new TextLeaf("Fine", ElementType.NON));
        secondSen.add(new TextLeaf(",", ElementType.SPACE));
        secondSen.add(new TextLeaf("how", ElementType.SPACE));
        secondSen.add(new TextLeaf("are", ElementType.SPACE));
        secondSen.add(new TextLeaf("you", ElementType.NON));
        secondSen.add(new TextLeaf("?", ElementType.SPACE));

        thirdSen.add(new TextLeaf("Oh", ElementType.NON));
        thirdSen.add(new TextLeaf(",", ElementType.SPACE));
        thirdSen.add(new TextLeaf("great", ElementType.NON));
        thirdSen.add(new TextLeaf(",", ElementType.SPACE));
        thirdSen.add(new TextLeaf("great", ElementType.NON));
        thirdSen.add(new TextLeaf("...", ElementType.NON));

        expectedParagraph.add(firstSen);
        expectedParagraph.add(secondSen);
        expectedParagraph.add(thirdSen);

        TextNode actualParagraph = (TextNode) paragraphParser.parse("Hello, how are you doing? Fine, how are you? Oh, great, great...");

        assertEquals(actualParagraph, expectedParagraph);
    }
}