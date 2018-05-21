import java.io.File;
import java.io.IOException;
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
        if ( ! file.exists( ) )
        {
            try {
                file.createNewFile( );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*public void addWord(){

    }*/
}
