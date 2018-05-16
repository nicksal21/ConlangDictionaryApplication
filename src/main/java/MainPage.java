import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Function;

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
        Button loadDictButton = makeButton("Load Dictionary");
        newDictButton.setOnAction(event -> {NewDictionaryPage newDictionaryPage = new NewDictionaryPage(); newDictionaryPage.start(new Stage());});

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


    public static Text makeTextLabel(String label, String fontFamily, FontWeight weight, int size){
        Text text = new Text(label);
        text.setFont(Font.font(fontFamily, weight, size));
        return text;
    }

    public static TextField makeTextLabel(){
        return new TextField();
    }
}
