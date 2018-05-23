import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
// import java.util.ArrayList;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class Dictionary {
    private String name;
    // public ArrayList<Word> words;

    Dictionary(String name){
        this.name = name;
    }

    private String getName() {
        return name;
    }

    public void makeNewFile() {
        String path = "src/main/java/Dictionaries/" + getName() + ".txt";
        File file = new File(path);
        if (!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        path = "src/main/java/Grammars/" + getName() + "Grammar.txt";
        file = new File(path);
        if (!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dropFile(String dict){
        String path = "src/main/java/Dictionaries/" + dict + ".txt";
        File file = new File(path);
        if ( file.exists() )
        {
            file.delete();
        }
        path = "src/main/java/Grammars/" + dict + "Grammar.txt";
        file = new File(path);
        if (file.exists())
        {
            file.delete();
        }
    }

    public ObservableList<Word> getWordList(String dictionary) throws IOException {
        ObservableList<Word> words = FXCollections.observableArrayList();
        File file = new File("src/main/java/Dictionaries/" + getName() + ".txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        while (br.readLine() != null) {

        }
        return words;
    }

    public void addWord(Word word) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(getName() + ".txt"), "utf-8"))) {
            writer.write(word.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addRule(Rule rule) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(getName() + "Grammar.txt"), "utf-8"))) {
            writer.write(rule.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
