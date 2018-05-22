import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GrammarRulesPage extends Application{
    @Override
    public void start(Stage primaryStage) {
        String dictName = MainPage.dictName;
        primaryStage.setTitle("Conlang Dictionary Creator");

        GridPane outerGrid = MainPage.makeGrid(Pos.TOP_LEFT);
        GridPane topGrid = MainPage.makeGrid(Pos.TOP_LEFT);
        GridPane bottomGrid = MainPage.makeGrid(Pos.TOP_LEFT);

        Text title = MainPage.makeTextLsbel(dictName + " Grammar Rules", "Arial", FontWeight.EXTRA_BOLD, 32);

        Text searchLabel1 = MainPage.makeTextLsbel("Search by Name: ", "Arial", FontWeight.NORMAL, 16);
        TextField searchBar1 = MainPage.makeTextField();

        Text searchLabel2 = MainPage.makeTextLsbel("Search by Type: ", "Arial", FontWeight.NORMAL, 16);
        TextField searchBar2 = MainPage.makeTextField();

        Text searchLabel3 = MainPage.makeTextLsbel("Search by Description: ", "Arial", FontWeight.NORMAL, 16);
        TextField searchBar3 = MainPage.makeTextField();

        Button searchButtonType = MainPage.makeButton("Search");
        searchButtonType.setOnAction(event -> {
//            TODO: Create searchable field and searching method, sorting method by type and description
            Error.sendAlert(new Error(Alert.AlertType.ERROR, "Error", "Unimplemented! Need to make search function"));
        });
        HBox searchTypeHBox = MainPage.makeHBox(searchButtonType, 10, Pos.CENTER);

        Button editButton = MainPage.makeButton("Edit Selected");
        editButton.setOnAction(event -> {
//            TODO: Create searchable field and searching method, sorting method for dictionaries
            Error.sendAlert(new Error(Alert.AlertType.ERROR, "Error", "Unimplemented! Need to make interface"));
        });
        HBox editHBox = MainPage.makeHBox(editButton, 10, Pos.CENTER);

        Button createButton = MainPage.makeButton("Create Rule");
        createButton.setOnAction(event -> {
//            TODO: Create searchable field and searching method, sorting method for dictionaries
            Error.sendAlert(new Error(Alert.AlertType.ERROR, "Error", "Unimplemented! Need to make interface"));
        });
        HBox createHBox = MainPage.makeHBox(createButton, 10, Pos.CENTER);

        TableView ruleTable = MainPage.makeTableView();
        TableColumn name = MainPage.makeTableColumn("Name");
        name.setPrefWidth(150);
        TableColumn type = MainPage.makeTableColumn("Type");
        type.setPrefWidth(150);
        TableColumn description = MainPage.makeTableColumn("Description");
        description.setPrefWidth(300);

        ruleTable.getColumns().addAll(name, type, description);
        ruleTable.setPrefWidth(600);


        // Add elements to grid
        topGrid.add(title, 0, 0, 3,1);
        topGrid.add(searchLabel1, 0, 1, 1,1);
        topGrid.add(searchBar1, 1, 1, 1,1);
        topGrid.add(searchLabel2, 0, 2, 1,1);
        topGrid.add(searchBar2, 1, 2, 1,1);
        topGrid.add(searchLabel3, 0, 3, 1,1);
        topGrid.add(searchBar3, 1, 3, 1,1);
        topGrid.add(searchTypeHBox, 2, 1, 1,1);
        topGrid.add(editHBox, 3, 1, 1,1);
        topGrid.add(createHBox, 4, 1, 1,1);
        bottomGrid.add(ruleTable,0,0,1,1);

        outerGrid.add(topGrid, 0, 0);
        outerGrid.add(bottomGrid, 0, 1);

        // Creates scene
        Scene scene = new Scene(outerGrid, 700, 500);

        // Sets scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
