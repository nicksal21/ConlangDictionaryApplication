import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
    public String name;
    public ArrayList<Word> words;

    public Dictionary(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void makeNewFile() {
        String path = getName() + ".txt";
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

    public void addWord(){

    }
}
