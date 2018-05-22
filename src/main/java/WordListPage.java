import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WordListPage extends Application{
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Conlang Dictionary Creator");

        GridPane outerGrid = MainPage.makeGrid(Pos.TOP_LEFT);
        GridPane topGrid = MainPage.makeGrid(Pos.TOP_LEFT);
        GridPane bottomGrid = MainPage.makeGrid(Pos.TOP_LEFT);

        Text title = MainPage.makeTextLsbel("Word List", "Arial", FontWeight.EXTRA_BOLD, 32);

        Text searchLabel = MainPage.makeTextLsbel("Search: ", "Arial", FontWeight.NORMAL, 16);

        TextField searchBar = MainPage.makeTextField();

        Button searchButton = MainPage.makeButton("Search");
        searchButton.setOnAction(event -> {
//            TODO: Create searchable field and searching method, sorting method for dictionaries
            Error.sendAlert(new Error(Alert.AlertType.ERROR, "Error", "Unimplemented! Need to make search function"));
        });
        HBox searchHBox = MainPage.makeHBox(searchButton, 10, Pos.CENTER);

        TableView ruleTable = MainPage.makeTableView();
        TableColumn name = MainPage.makeTableColumn("Name");
        TableColumn type = MainPage.makeTableColumn("Type");
        TableColumn description = MainPage.makeTableColumn("Description");

        ruleTable.getColumns().addAll(name, type, description);


        // Add elements to grid
        topGrid.add(title, 0, 0, 3,1);
        topGrid.add(searchLabel, 0, 1, 1,1);
        topGrid.add(searchBar, 1, 1, 1,1);
        topGrid.add(searchHBox, 2, 1, 1,1);
        bottomGrid.add(ruleTable, 0, 0, 1, 1);

        outerGrid.add(topGrid, 0, 0);
        outerGrid.add(bottomGrid, 0, 1);

        // Creates scene
        Scene scene = new Scene(outerGrid, 500, 500);

        // Sets scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
