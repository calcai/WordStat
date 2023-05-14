import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Tokenizer {

    ArrayList<String> wordList;

    //Creates a tokenizer that can take a file as input and return an array with all words normalized in an array
    public Tokenizer(String file) throws FileNotFoundException {
        File text = new File(file);
        Scanner s = new Scanner(text);
        String words = "";
        while(s.hasNext()){
            words += " ";
            words += s.next();
        }
        String noPunctuation = words.replaceAll("\\p{Punct}", "");
        noPunctuation = noPunctuation.toLowerCase();
        wordList = new ArrayList<String>(Arrays.asList(noPunctuation.split(" ")));
    }
    //This constructor takes a string array instead of reading a file
    public Tokenizer (String[] words){
        wordList = new ArrayList<String>();
        for(int i = 0; i < words.length; i++){
            wordList.add(words[i].replaceAll("\\p{Punct}", "").toLowerCase(Locale.ROOT));
        }
    }
    //getter method for wordlist
    public ArrayList<String> wordList(){
        return wordList;
    }

    //Tested and returns the entirety of harry potter book one
    public static void main(String[] args) throws FileNotFoundException {
        Tokenizer harry = new Tokenizer("C:\\Users\\caica\\OneDrive\\Desktop\\CSDS 233\\P4\\HarryPotter1.txt");
        System.out.println(harry.wordList());
    }
}
