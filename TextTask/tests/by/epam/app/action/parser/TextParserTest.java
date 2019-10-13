package by.epam.app.action.parser;

import by.epam.app.action.TextReader;
import by.epam.app.entity.ElementType;
import by.epam.app.entity.TextLeaf;
import by.epam.app.entity.TextNode;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextParserTest {

    @Test
    public void testParse() {
        TextParser textParser = new TextParser(new ParagraphParser(new SentenceParser(new LeafParser())));
        TextNode actualText = (TextNode) textParser.parse(TextReader.read());
        String actualString = actualText.toString();
        String expectedString = "What, was going to happen to him? Would he be arrested, or would he simply be outlawed from the wizarding world? He thought of Ron and Hermione, and his heart sank even lower. Harry was sure that, criminal or not, Ron and Hermione would want to help him now, but they were both abroad, and with Hedwig gone, he had no means of contacting them.\n" +
                                "He didn't have any Muggle money, either. There was a little wizard gold in the money bag at the bottom of his trunk, but the rest of the fortune his parents had left him was stored in a vault at Gringotts Wizarding Bank in London. He'd never be able to drag his trunk all the way to London. Unless...\n" +
                                "He looked down at his wand, which he was still clutching in his hand. If he was already expelled, his heart was. now thumping painfully fast, a bit more magic couldn't hurt. He had the Invisibility Cloak he had inherited from his father - what if he bewitched the trunk to make it feather-light, tied it to his broomstick, covered himself in the cloak, and flew to London? Then he could get the rest of his money out of his vault and... Begin his life as an outcast. It was a horrible prospect, but he couldn't sit on this wall forever, or he'd find himself trying to explain to Muggle police why he was out in the dead of night with a trunk full of spell books and a broomstick.\n" +
                                "Harry opened his trunk again and pushed the contents aside, looking for the Invisibility Cloak - but before he had found it, he straightened up suddenly, looking around him once more.\n" +
                                "A funny prickling on the back of his neck had made Harry feel he was being watched, but the street appeared to be deserted, and no lights shone from any of the large square houses.\n";

        assertEquals(actualString, expectedString);
    }
}