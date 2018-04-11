import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainPage extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage){
        // Sets Stage Title
        primaryStage.setTitle("Conlang Dictionary Creator");

        GridPane grid = makeGrid(Pos.CENTER);

        GridPane buttons = makeGrid(Pos.CENTER);

        Text title = makeTextLabel("Conlang Dictionary Maker", "Arial", FontWeight.EXTRA_BOLD, 32);

        HBox newDict = makeButtonWithHBox("New Dictionary", 0, Pos.CENTER);
        HBox loadDict = makeButtonWithHBox("Load Dictionary", 0, Pos.CENTER);



        buttons.add(newDict, 0, 0, 1 ,1);
        buttons.add(loadDict, 0, 1, 1 ,1);

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


    public static HBox makeButtonWithHBox(String text, int spacing, Pos alignment){
        Button button = new Button(text);
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
}
