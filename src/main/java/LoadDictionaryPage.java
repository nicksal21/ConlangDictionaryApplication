import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoadDictionaryPage extends Application {
    @Override
    public void start(Stage primaryStage){
        String dictName = MainPage.dictName;
        Stage wordStage = new Stage();
        Stage grammarStage = new Stage();

        primaryStage.setTitle("Load Dictionary");

        GridPane grid = MainPage.makeGrid(Pos.CENTER);

        Text title = MainPage.makeTextLsbel( dictName + " Dictionary", "Arial", FontWeight.EXTRA_BOLD, 32);

        Button wordListButton = MainPage.makeButton("View Word List");
        wordListButton.setOnAction(event -> {
            WordListPage wordListPage = new WordListPage();
            wordListPage.start(wordStage);
            wordListButton.setDisable(true);
            wordStage.setOnCloseRequest(eventClose -> {
                wordListButton.setDisable(false);
            });
        });

        Button grammarListButton = MainPage.makeButton("View Grammar Rules");
        grammarListButton.setOnAction(event -> {
            GrammarRulesPage grammarRulesPage = new GrammarRulesPage();
            grammarRulesPage.start(grammarStage);
            grammarListButton.setDisable(true);
            grammarStage.setOnCloseRequest(eventClose -> {
                grammarListButton.setDisable(false);
            });
        });

        Button backButton = MainPage.makeButton("Back");
        backButton.setOnAction(event -> {
            MainPage mp = new MainPage();
            Stage mainStage = new Stage();
            mp.start(mainStage);
            if(wordStage.isShowing()){
                wordStage.hide();
            }
            if(grammarStage.isShowing()){
                grammarStage.hide();
            }
            primaryStage.hide();
        });

        wordListButton.setMaxWidth(Double.MAX_VALUE);
        grammarListButton.setMaxWidth(Double.MAX_VALUE);
        backButton.setMaxWidth(Double.MAX_VALUE);

        VBox buttonVBox = MainPage.makeVBox(null, 10, Pos.CENTER);
        buttonVBox.setPadding(new Insets(0, 15, 10, 15));
        buttonVBox.getChildren().addAll(wordListButton, grammarListButton, backButton);

        // Add elements to grid
        grid.add(title, 0, 0, 2 ,1);
        grid.add(buttonVBox, 1, 3, 1 ,1);

        // Creates scene
        Scene scene = new Scene(grid, 500, 500);

        // Sets scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}