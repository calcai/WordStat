import org.junit.Test;
import org.junit.Assert;

public class TestTokenizer {

    @Test
    public void testWordList(){
        String[] animals = {"cat", "dog!", "Mouse"};
        String[] animalsResult = {"cat", "dog", "mouse"};
        Tokenizer stringArray1 = new Tokenizer(animalsResult);
        Tokenizer stringArray2 = new Tokenizer(animals);
        Assert.assertEquals("Testing word list", stringArray1.wordList(), stringArray2.wordList());
    }

}
