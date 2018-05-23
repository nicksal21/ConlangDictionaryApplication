import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateWordPage extends Application{
    @Override
    public void start(Stage primaryStage) {
        String dictName = MainPage.dictName;
        Dictionary dict = new Dictionary(dictName);

        primaryStage.setTitle("Conlang Dictionary Creator");

        GridPane outerGrid = MainPage.makeGrid(Pos.TOP_LEFT);
        GridPane topGrid = MainPage.makeGrid(Pos.TOP_LEFT);
        GridPane bottomGrid = MainPage.makeGrid(Pos.TOP_LEFT);

        Text title = MainPage.makeTextLsbel("Create Word", "Arial", FontWeight.EXTRA_BOLD, 32);

        Text wordLabel = MainPage.makeTextLsbel("Word: ", "Arial", FontWeight.NORMAL, 16);
        TextField wordField = MainPage.makeTextField();

        Text ipaLabel = MainPage.makeTextLsbel("IPA Pronunciation: ", "Arial", FontWeight.NORMAL, 16);
        TextField ipaField = MainPage.makeTextField();
        Button ipaKeyboardButton = MainPage.makeButton("IPA Keyboard");
        HBox ipaButtonHBox = MainPage.makeHBox(ipaKeyboardButton, 10, Pos.CENTER);

        Text pluralLabel = MainPage.makeTextLsbel("Plural: ", "Arial", FontWeight.NORMAL, 16);
        TextField pluralField = MainPage.makeTextField();
        pluralField.setDisable(true);

        Text pluralIpaLabel = MainPage.makeTextLsbel("Plural IPA: ", "Arial", FontWeight.NORMAL, 16);
        TextField pluralIpaField = MainPage.makeTextField();
        pluralIpaField.setDisable(true);

        Text partOfSpeechLabel = MainPage.makeTextLsbel("Part of Speech: ", "Arial", FontWeight.NORMAL, 16);
        ComboBox<PartOfSpeech> partOfSpeechBox = MainPage.makeSpeechComboBox();
        for (PartOfSpeech partOfSpeech : PartOfSpeech.values()) {
            partOfSpeechBox.getItems().add(partOfSpeech);
        }
        partOfSpeechBox.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
                    if(newValue.equals(PartOfSpeech.Noun)){
                        pluralField.setDisable(false);
                        pluralIpaField.setDisable(false);
                    } else {
                        pluralField.setDisable(true);
                        pluralIpaField.setDisable(true);
                    }
                }
        );

        Text classificationLabel = MainPage.makeTextLsbel("Classification: ", "Arial", FontWeight.NORMAL, 16);
        TextField classificationField = MainPage.makeTextField();

        Text definitionLabel = MainPage.makeTextLsbel("Definition", "Arial", FontWeight.NORMAL, 16);
        TextArea definitionTextArea = MainPage.makeTextArea();

        Text specialNotesLabel = MainPage.makeTextLsbel("Special Notes", "Arial", FontWeight.NORMAL, 16);
        TextArea specialNotesArea = MainPage.makeTextArea();

        Button createButton = MainPage.makeButton("Create");
        createButton.setOnAction(event -> {
            Word newWord;
            String word = wordField.getText();
            String ipa = ipaField.getText();
            String plural;
            String pluralIpa;
            PartOfSpeech partOfSpeech = partOfSpeechBox.getValue();
            String classification;
            String definition = definitionTextArea.getText();
            String specialNotes;

            if(pluralField.isDisabled()){
                plural = " - ";
                pluralIpa = " - ";
            } else {
                if(pluralField.getText().isEmpty()){
                    plural = " - ";
                } else {
                    plural = pluralField.getText();
                }
                if(pluralIpaField.getText().isEmpty()){
                    pluralIpa = " - ";
                } else {
                    pluralIpa = pluralIpaField.getText();
                }
            }

            if(classificationField.getText().isEmpty()){
                classification = " - ";
            } else {
                classification = classificationField.getText();
            }



            if(specialNotesArea.getText().isEmpty()){
                specialNotes = " - ";
            } else {
                specialNotes = specialNotesArea.getText();
            }

            newWord = new Word(word, ipa, plural, pluralIpa, partOfSpeech, classification, definition, specialNotes);

            if(wordField.getText().isEmpty() || ipaField.getText().isEmpty() || partOfSpeechBox.getSelectionModel().isEmpty() || definitionTextArea.getText().isEmpty()){
                Error e = new Error (Alert.AlertType.ERROR, "Error", "Fill out Word, IPA, Part of Speech, and Definition!");
                Error.sendAlert(e);
            } else {
                dict.addWord(newWord);
            }
        });
        HBox createHBox = MainPage.makeHBox(createButton, 10, Pos.CENTER);

        Button cancelButton = MainPage.makeButton("Cancel");
        cancelButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you would like to cancel?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();
            if(alert.getResult() == ButtonType.YES){
                primaryStage.close();
            }
        });
        HBox cancelHBox = MainPage.makeHBox(cancelButton, 10, Pos.CENTER);

        // Add elements to grid
        topGrid.add(title, 0, 0, 3,1);
        topGrid.add(wordLabel, 0, 1, 1,1);
        topGrid.add(wordField, 1, 1, 1,1);
        topGrid.add(ipaLabel, 0, 2, 1,1);
        topGrid.add(ipaField, 1, 2, 1,1);
        topGrid.add(ipaButtonHBox, 2, 2, 1,1);
        topGrid.add(pluralLabel, 0, 3, 1,1);
        topGrid.add(pluralField, 1, 3, 1,1);
        topGrid.add(pluralIpaLabel, 0, 4, 1,1);
        topGrid.add(pluralIpaField, 1, 4, 1,1);
        topGrid.add(partOfSpeechLabel, 0, 5, 1,1);
        topGrid.add(partOfSpeechBox, 1, 5, 1,1);
        topGrid.add(classificationLabel, 0, 6, 1,1);
        topGrid.add(classificationField, 1, 6, 1,1);
        topGrid.add(definitionLabel, 0, 7, 1,1);
        topGrid.add(definitionTextArea, 0, 8, 3,1);
        topGrid.add(specialNotesLabel, 0, 9, 1,1);
        topGrid.add(specialNotesArea, 0, 10, 3,1);

        bottomGrid.add(createHBox, 0, 0, 1,1);
        bottomGrid.add(cancelHBox, 1, 0, 1,1);

        outerGrid.add(topGrid, 0, 0);
        outerGrid.add(bottomGrid, 0, 1);

        // Creates scene
        Scene scene = new Scene(outerGrid, 850, 800);

        // Sets scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
