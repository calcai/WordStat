import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class WordStat {
    ArrayList<String> wordList;
    HashTable singleWord;
    HashTable doubleWord;
    HashTable collocs;
    ArrayList<HashEntry> wordsSorted;
    ArrayList<HashEntry> wordPairsSorted;
    ArrayList<HashEntry> collocsSorted;

    public WordStat(String file) throws FileNotFoundException {
        Tokenizer tokenFile = new Tokenizer(file);
        wordList = tokenFile.wordList();
        singleWord = new HashTable();
        doubleWord = new HashTable();
        wordsSorted = new ArrayList<HashEntry>();
        wordPairsSorted = new ArrayList<HashEntry>();
        collocsSorted = new ArrayList<HashEntry>();

        //This loop puts the single words in a hash table with the word as the key and the number of occurrences as the value
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (singleWord.get(word) > 0) {
                singleWord.update(word, singleWord.get(word) + 1);
            } else {
                singleWord.put(word, 1);
            }
        }

        //This loops puts the double words in a hash table with the word as the key and the number of occurrences as the value
        for (int i = 0; i < wordList.size() -1; i++) {
            String wordPair = wordList.get(i) + " " + wordList.get(i + 1);
            if (doubleWord.get(wordPair) != -1) {
                doubleWord.update(wordPair, doubleWord.get(wordPair) + 1);

            } else {
                doubleWord.put(wordPair, 1);
            }
        }

        //This loop adds the HashEntries into an ArrayList
        for (int i = 0; i < singleWord.getHashTableSize(); i++) {
            HashEntry currNode = singleWord.firstNode(i);
            while (currNode != null) {
                wordsSorted.add(currNode);
                currNode = currNode.getNext();
            }
        }

        //This loop uses bubble sort to arrange the ArrayList by value(number of occurrences)
        for (int i = 0; i < wordsSorted.size() - 1; i++) {
            for (int j = 0; j < wordsSorted.size() - i - 1; j++) {
                if (wordsSorted.get(j).getValue() < wordsSorted.get(j + 1).getValue()) {
                    HashEntry temp = wordsSorted.get(j);
                    wordsSorted.set(j, wordsSorted.get(j + 1));
                    wordsSorted.set(j + 1, temp);
                }
            }
        }
        for (int i = 0; i < doubleWord.getHashTableSize(); i++) {
            HashEntry currNode = doubleWord.firstNode(i);
            while (currNode != null) {
                wordPairsSorted.add(currNode);
                currNode = currNode.getNext();
            }
        }
        //This loop uses sorts to arrange the ArrayList pairs by value(number of occurrences)
        for (int i = 0; i < wordPairsSorted.size() - 1; i++) {
            for (int j = 0; j < wordPairsSorted.size() - i - 1; j++) {
                if (wordPairsSorted.get(j).getValue() < wordPairsSorted.get(j + 1).getValue()) {
                    HashEntry temp = wordPairsSorted.get(j);
                    wordPairsSorted.set(j, wordPairsSorted.get(j + 1));
                    wordPairsSorted.set(j + 1, temp);
                }
            }
        }
    }

    public WordStat(String[] words) {
        Tokenizer tokenFile = new Tokenizer(words);
        wordList = tokenFile.wordList();
        singleWord = new HashTable();
        doubleWord = new HashTable();
        wordsSorted = new ArrayList<HashEntry>();
        wordPairsSorted = new ArrayList<HashEntry>();
        collocsSorted = new ArrayList<HashEntry>();

        //This loop puts the single words in a hash table with the word as the key and the number of occurrences as the value
        for (int i = 0; i < words.length; i++) {
            String word = wordList.get(i);
            if (singleWord.get(word) > 0) {
                singleWord.update(word, singleWord.get(word) + 1);
            } else {
                singleWord.put(word, 1);
            }
        }

        //This loops puts the double words in a hash table with the word as the key and the number of occurrences as the value
        for (int i = 0; i < wordList.size() -1; i++) {
            String wordPair = wordList.get(i) + " " + wordList.get(i + 1);
            if (doubleWord.get(wordPair) != -1) {
                doubleWord.update(wordPair, doubleWord.get(wordPair) + 1);

            } else {
                doubleWord.put(wordPair, 1);
            }
        }

        //This loop adds the HashEntries into an ArrayList
        for (int i = 0; i < singleWord.getHashTableSize(); i++) {
            HashEntry currNode = singleWord.firstNode(i);
            while (currNode != null) {
                wordsSorted.add(currNode);
                currNode = currNode.getNext();
            }
        }

        //This loop uses bubble sort to arrange the ArrayList by value(number of occurrences)
        for (int i = 0; i < wordsSorted.size() - 1; i++) {
            for (int j = 0; j < wordsSorted.size() - i - 1; j++) {
                if (wordsSorted.get(j).getValue() < wordsSorted.get(j + 1).getValue()) {
                    HashEntry temp = wordsSorted.get(j);
                    wordsSorted.set(j, wordsSorted.get(j + 1));
                    wordsSorted.set(j + 1, temp);
                }
            }
        }
        for (int i = 0; i < doubleWord.getHashTableSize(); i++) {
            HashEntry currNode = doubleWord.firstNode(i);
            while (currNode != null) {
                wordPairsSorted.add(currNode);
                currNode = currNode.getNext();
            }
        }
        //This loop uses sorts to arrange the ArrayList pairs by value(number of occurrences)
        for (int i = 0; i < wordPairsSorted.size() - 1; i++) {
            for (int j = 0; j < wordPairsSorted.size() - i - 1; j++) {
                if (wordPairsSorted.get(j).getValue() < wordPairsSorted.get(j + 1).getValue()) {
                    HashEntry temp = wordPairsSorted.get(j);
                    wordPairsSorted.set(j, wordPairsSorted.get(j + 1));
                    wordPairsSorted.set(j + 1, temp);
                }
            }
        }
    }

    public int wordCount(String word) {
        return singleWord.get(word.replaceAll("\\p{Punct}", ""));
    }

    public int wordPairCount(String w1, String w2) {
        return doubleWord.get(w1.replaceAll("\\p{Punct}", "").toLowerCase() + w2.replaceAll("\\p{Punct}", "").toLowerCase());

    }

    public int wordRank(String word) {
        return wordsSorted.indexOf(singleWord.findHash(word.replaceAll("\\p{Punct}", ""))) + 1;
    }

    public int wordPairRank(String w1, String w2) {
        return wordPairsSorted.indexOf(doubleWord.findHash(w1.replaceAll("\\p{Punct}", "").toLowerCase() + w2.replaceAll("\\p{Punct}", "").toLowerCase()));
    }

    public String[] mostCommonWords(int k) {
        String[] commonWords = new String[k];
        for (int i = 0; i < commonWords.length; i++) {
            commonWords[i] = wordsSorted.get(i).getKey();
        }
        return commonWords;
    }

    public String[] leastCommonWords(int k) {
        String[] leastCommonWords = new String[k];
        for (int i = 0; i < leastCommonWords.length; i++) {
            leastCommonWords[i] = wordsSorted.get(wordsSorted.size() - i - 1).getKey();
        }
        return leastCommonWords;
    }

    public String[] mostCommonWordsPairs(int k) {
        String[] commonWordPairs = new String[k];
        for (int i = 0; i < commonWordPairs.length; i++) {
            commonWordPairs[i] = wordPairsSorted.get(i).getKey();
        }
        return commonWordPairs;
    }

    public String[] mostCommonCollocs(int k, String baseWord, int i) throws ArrayIndexOutOfBoundsException {
        ArrayList<HashEntry> collocsSorted = new ArrayList<HashEntry>();
        collocs = new HashTable();
        for (int j = 0; j < this.wordList.size(); j++) {
            String targetWord = baseWord + i;
            if (collocs.get(targetWord) > 0) {
                collocs.put(targetWord, collocs.get(targetWord) + 1);
            } else {
                collocs.put(targetWord, 1);
            }
        }
        for (int j = 0; j < singleWord.getHashTableSize(); j++) {
            HashEntry currNode = collocs.firstNode(j);
            while (currNode != null) {
                collocsSorted.add(currNode);
                currNode = currNode.getNext();
            }
        }
        for (int b = 0; b < collocsSorted.size() - 1; b++) {
            for (int j = 0; j < collocsSorted.size() - b - 1; j++) {
                if (collocsSorted.get(j).getValue() < collocsSorted.get(j + 1).getValue()) {
                    HashEntry temp = collocsSorted.get(j);
                    collocsSorted.set(j, collocsSorted.get(j + 1));
                    collocsSorted.set(j + 1, temp);
                }
            }
        }
        String[] commonCollocs = new String[k];
        for(i = 0; i < k; i++){
            commonCollocs[i] = collocsSorted.get(i).getKey();
        }
        return commonCollocs;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] cai = {"calvin", "cai", "calvin", "cai", "calvin ", "c", "cai", "calvin", "y"};
        WordStat calvin = new WordStat(cai);
        System.out.println(calvin.wordPairCount("calvin", "cai"));
        System.out.println(calvin.singleWord.get("calvin"));
        System.out.println(calvin.wordCount("calvin"));
        System.out.println(calvin.wordRank("calvin"));
        System.out.println(calvin.wordRank("cai"));
        System.out.println(calvin.wordRank("c"));
        System.out.println(Arrays.toString(calvin.mostCommonWords(3)));
        System.out.println(Arrays.toString(calvin.leastCommonWords(3)));
        String c = "calvin";
        String c1 = "calvin c";
        System.out.println(Math.abs(c.hashCode()) % 100);
        System.out.println(Math.abs(c1.hashCode() % 100));
        System.out.println(Arrays.toString(calvin.mostCommonCollocs(3, "calvin", 1)));
    }
}
