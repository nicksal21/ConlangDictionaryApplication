import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewDictionaryPage extends Application{
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Conlang Dictionary Creator");

        GridPane grid = MainPage.makeGrid(Pos.TOP_LEFT);

        Text title = MainPage.makeTextLsbel("Dictionary", "Arial", FontWeight.EXTRA_BOLD, 32);

        Text addNameLabel = MainPage.makeTextLsbel("Name: ", "Arial", FontWeight.NORMAL, 16);

        TextField addNameField = MainPage.makeTextField();


        Button addDictButton = MainPage.makeButton("New Dictionary");
        addDictButton.setOnAction(event -> {
            Dictionary dict = new Dictionary(addNameField.getText());
            dict.makeNewFile();
            MainPage.dictName = addNameField.getText();
            LoadDictionaryPage loadDictionaryPage = new LoadDictionaryPage();
            loadDictionaryPage.start(new Stage());
            primaryStage.hide();
        });

        Button backButton = MainPage.makeButton("Back");
        backButton.setOnAction(event -> {
            MainPage mp = new MainPage();
            Stage mainStage = new Stage();
            mp.start(mainStage);
            primaryStage.hide();
        });

        HBox addDictBox = MainPage.makeHBox(addDictButton, 10, Pos.CENTER);
        HBox addBackButton = MainPage.makeHBox(backButton, 10, Pos.CENTER);

        // Add elements to grid
        grid.add(title, 0, 0, 2 ,1);
        grid.add(addNameLabel, 0, 1, 1 ,1);
        grid.add(addNameField, 1, 1, 1 ,1);
        grid.add(addDictBox, 2, 1, 1 ,1);
        grid.add(addBackButton, 3, 1, 1 ,1);

        // Creates scene
        Scene scene = new Scene(grid, 500, 500);

        // Sets scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
