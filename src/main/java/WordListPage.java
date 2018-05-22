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
        String dictName = MainPage.dictName;
        primaryStage.setTitle("Conlang Dictionary Creator");

        GridPane outerGrid = MainPage.makeGrid(Pos.TOP_LEFT);
        GridPane topGrid = MainPage.makeGrid(Pos.TOP_LEFT);
        GridPane bottomGrid = MainPage.makeGrid(Pos.TOP_LEFT);

        Text title = MainPage.makeTextLsbel(dictName + " Word List", "Arial", FontWeight.EXTRA_BOLD, 32);

        Text searchLabel1 = MainPage.makeTextLsbel("Search by Word: ", "Arial", FontWeight.NORMAL, 16);
        TextField searchBar1 = MainPage.makeTextField();

        Text searchLabel2 = MainPage.makeTextLsbel("Search by Part of Speech: ", "Arial", FontWeight.NORMAL, 16);
        TextField searchBar2 = MainPage.makeTextField();

        Text searchLabel3 = MainPage.makeTextLsbel("Search by Definition: ", "Arial", FontWeight.NORMAL, 16);
        TextField searchBar3 = MainPage.makeTextField();

        Button searchButton = MainPage.makeButton("Search");
        searchButton.setOnAction(event -> {
//            TODO: Create searchable field and searching method, sorting method for dictionaries
            Error.sendAlert(new Error(Alert.AlertType.ERROR, "Error", "Unimplemented! Need to make search function"));
        });
        HBox searchHBox = MainPage.makeHBox(searchButton, 10, Pos.CENTER);

        Button editButton = MainPage.makeButton("Edit Selected");
        editButton.setOnAction(event -> {
//            TODO: Create searchable field and searching method, sorting method for dictionaries
            Error.sendAlert(new Error(Alert.AlertType.ERROR, "Error", "Unimplemented! Need to make interface"));
        });
        HBox editHBox = MainPage.makeHBox(editButton, 10, Pos.CENTER);

        Button createButton = MainPage.makeButton("Create Word");
        createButton.setOnAction(event -> {
//            TODO: Create searchable field and searching method, sorting method for dictionaries
            Error.sendAlert(new Error(Alert.AlertType.ERROR, "Error", "Unimplemented! Need to make interface"));
        });
        HBox createHBox = MainPage.makeHBox(createButton, 10, Pos.CENTER);

        TableView wordTable = MainPage.makeTableView();
        TableColumn word = MainPage.makeTableColumn("Word");
        word.setPrefWidth(150);
        TableColumn ipa = MainPage.makeTableColumn("IPA Pronunciation");
        ipa.setPrefWidth(150);
        TableColumn plural = MainPage.makeTableColumn("Plural");
        plural.setPrefWidth(150);
        TableColumn pluralIPA = MainPage.makeTableColumn("Plural IPA Pronunciation");
        pluralIPA.setPrefWidth(150);
        TableColumn partOfSpeech = MainPage.makeTableColumn("Part of Speech");
        partOfSpeech.setPrefWidth(150);
        TableColumn classification = MainPage.makeTableColumn("Classification");
        classification.setPrefWidth(150);
        TableColumn definition = MainPage.makeTableColumn("Definition");
        definition.setPrefWidth(150);
        TableColumn specialNotes = MainPage.makeTableColumn("Special Notes");
        specialNotes.setPrefWidth(150);

        wordTable.getColumns().addAll(word, ipa, plural, pluralIPA, partOfSpeech, classification, definition, specialNotes);
        wordTable.setPrefWidth(1200);
        wordTable.setEditable(false);


        // Add elements to grid
        topGrid.add(title, 0, 0, 3,1);
        topGrid.add(searchLabel1, 0, 1, 1,1);
        topGrid.add(searchBar1, 1, 1, 1,1);
        topGrid.add(searchLabel2, 0, 2, 1,1);
        topGrid.add(searchBar2, 1, 2, 1,1);
        topGrid.add(searchLabel3, 0, 3, 1,1);
        topGrid.add(searchBar3, 1, 3, 1,1);
        topGrid.add(searchHBox, 2, 1, 1,1);
        topGrid.add(editHBox, 3, 1, 1,1);
        topGrid.add(createHBox, 4, 1, 1,1);
        bottomGrid.add(wordTable, 0, 0, 1, 1);

        outerGrid.add(topGrid, 0, 0);
        outerGrid.add(bottomGrid, 0, 1);

        // Creates scene
        Scene scene = new Scene(outerGrid, 1250, 500);

        // Sets scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
