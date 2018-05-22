import javafx.scene.control.Alert;

public class Error {

    public Alert.AlertType type;
    public String header;
    public String errorText;

    public Error(Alert.AlertType type, String header, String errorText){
        this.type = type;
        this.header = header;
        this.errorText = errorText;
    }

    public Alert.AlertType getType() {
        return type;
    }

    public void setType(Alert.AlertType type) {
        this.type = type;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public static void sendAlert(Error e) {
        Alert alert = new Alert(e.getType());
        alert.setHeaderText(e.getHeader());
        alert.setContentText(e.getErrorText());
        alert.showAndWait();
    }
}
