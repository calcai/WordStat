import org.junit.Test;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class TestWordStat {

    //My word pair methods don't work but they are commented by how I would test them
    //My collocs method also does not work
    @Test
    public void testWordStat() throws FileNotFoundException {
        String[] cai = {"calvin", "cai", "calvin", "cai", "c", "cai", "calvin", "cai", "y"};
        WordStat calvin = new WordStat(cai);
        Assert.assertEquals("Testing word rank", 1, calvin.wordRank("cai"));
        Assert.assertEquals("Testing word rank again", 3, calvin.wordRank("y"));
        //Assert.assertEquals("Testing word pair Rank", 1, calvin.wordPairRank("calvin", "cai"));
        //Assert.assertEquals("Testing word pair rank again", 2, calvin.wordPairRank("cai", "calvin"));
        Assert.assertEquals("Testing word count", 3, calvin.wordCount("calvin"));
        Assert.assertEquals("Testing most common words", "[cai, calvin]", Arrays.toString(calvin.mostCommonWords(2)));
        Assert.assertEquals("Testing most common words again", "[cai, calvin, y]", Arrays.toString(calvin.mostCommonWords(3)));
        Assert.assertEquals("Testing least common words", "[c, y]", Arrays.toString(calvin.leastCommonWords(2)));
    }

}
