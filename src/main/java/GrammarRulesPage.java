import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GrammarRulesPage extends Application{
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Conlang Dictionary Creator");

        GridPane grid = MainPage.makeGrid(Pos.TOP_LEFT);

        Text title = MainPage.makeTextLsbel("Grammar Rules List", "Arial", FontWeight.EXTRA_BOLD, 32);

        Text searchLabelType = MainPage.makeTextLsbel("Search by Type: ", "Arial", FontWeight.NORMAL, 16);

        TextField searchBarType = MainPage.makeTextField();

        Button searchButtonType = MainPage.makeButton("Search");
        searchButtonType.setOnAction(event -> {
//            TODO: Create searchable field and searching method, sorting method by type and description
            Error.sendAlert(new Error(Alert.AlertType.ERROR, "Error", "Unimplemented! Need to make search function"));
        });
        HBox searchTypeHBox = MainPage.makeHBox(searchButtonType, 10, Pos.CENTER);


        // Add elements to grid
        grid.add(title, 0, 0, 3,1);
        grid.add(searchLabelType, 0, 1, 1,1);
        grid.add(searchBarType, 1, 1, 1,1);
        grid.add(searchTypeHBox, 2, 1, 1,1);

        // Creates scene
        Scene scene = new Scene(grid, 500, 500);

        // Sets scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
