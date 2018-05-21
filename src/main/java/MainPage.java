import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class MainPage extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage){
        // Sets Stage Title
        primaryStage.setTitle("Conlang Dictionary Creator");

        // Make Grids
        GridPane grid = makeGrid(Pos.CENTER);
        GridPane buttons = makeGrid(Pos.CENTER);

        // Make Elements
        Text title = makeTextLabel("Conlang Dictionary Maker", "Arial", FontWeight.EXTRA_BOLD, 32);

        Button newDictButton = makeButton("New Dictionary");
        newDictButton.setOnAction(event -> {
            getDictFileNames();
            NewDictionaryPage newDictionaryPage = new NewDictionaryPage();
            newDictionaryPage.start(new Stage());
            primaryStage.hide();
        });

        Button loadDictButton = makeButton("Load Dictionary");
        loadDictButton.setOnAction(event -> {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(primaryStage);
            dialog.setTitle("Select Dictionary");

            GridPane dialogGrid = makeGrid(Pos.TOP_LEFT);

            Text dialogTitle = makeTextLabel("Select Dictionary", "Arial", FontWeight.BOLD, 28);

            ComboBox dictionaries = makeComboBox();
            ObservableList<String> dicts = getDictFileNames();
            dictionaries.setItems(dicts);

            dialogGrid.add(dialogTitle, 0, 0, 3,1);
            dialogGrid.add(dictionaries, 0, 1, 1,1);

            Scene dialogScene = new Scene(dialogGrid, 400, 400);
            dialog.setScene(dialogScene);
            dialog.show();
        });

        HBox newDict = makeHBox(newDictButton, 10, Pos.CENTER);
        HBox loadDict = makeHBox(loadDictButton, 10, Pos.CENTER);

        // Add to Buttons Grid
        buttons.add(newDict, 0, 0, 1 ,1);
        buttons.add(loadDict, 0, 1, 1 ,1);

        // Add to Grid
        grid.add(title, 0, 0, 2 ,1);
        grid.add(buttons, 0, 1, 2 ,1);

        // Creates scene
        Scene scene = new Scene(grid, 500, 500);

        // Sets scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }






    // Make grid with default spacing, insets (10, each)
    public static GridPane makeGrid(Pos alignment){
            GridPane grid = new GridPane();
        grid.setAlignment(alignment);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        return grid;
    }

    // Make grid with default insets (10)
    public static GridPane makeGrid(Pos alignment, int Hgap, int Vgap){
        GridPane grid = new GridPane();
        grid.setAlignment(alignment);
        grid.setHgap(Hgap);
        grid.setVgap(Vgap);
        grid.setPadding(new Insets(10, 10, 10, 10));
        return grid;
    }

    // Make grid with Position, Spacing, and Padding Variable
    public static GridPane makeGrid(Pos alignment, int Hgap, int Vgap, int top_pad, int right_pad, int bottom_pad, int left_pad){
        GridPane grid = new GridPane();
        grid.setAlignment(alignment);
        grid.setHgap(Hgap);
        grid.setVgap(Vgap);
        grid.setPadding(new Insets(top_pad, right_pad, bottom_pad, left_pad));
        return grid;
    }

    public static Button makeButton(String text){
        return new Button(text);
    }

    public static HBox makeHBox(Button button, int spacing, Pos alignment){
        HBox hbox = new HBox(spacing);
        hbox.setAlignment(alignment);
        hbox.getChildren().add(button);
        return hbox;
    }

    public static VBox makeVBox(Button button, int spacing, Pos alignment){
        VBox vbox = new VBox(spacing);
        vbox.setAlignment(alignment);
        if(button != null){
            vbox.getChildren().add(button);
        }
        return vbox;
    }


    public static Text makeTextLabel(String label, String fontFamily, FontWeight weight, int size){
        Text text = new Text(label);
        text.setFont(Font.font(fontFamily, weight, size));
        return text;
    }

    public static TextField makeTextLabel(){
        return new TextField();
    }

    public static ComboBox makeComboBox(){
        return new ComboBox();
    }

    public static ComboBox makeComboBox(ObservableList options){
        return new ComboBox(options);
    }

    public static ObservableList<String> getDictFileNames(){
        ObservableList<String> strings = FXCollections.observableArrayList();
        File folder = new File("Dictionaries");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    strings.add(file.getName().substring(0, file.getName().indexOf('.')));
                    System.out.println(file.getName().substring(0, file.getName().indexOf('.')));
                }
            }
        }

        return strings;
    }
}
