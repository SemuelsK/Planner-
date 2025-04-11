import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private TextArea eventDisplay = new TextArea();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        DatePicker datePicker = new DatePicker();
        TextField eventInput = new TextField();
        Button addButton = new Button("Add Event");
        
        VBox root = new VBox(10, 
            new Label("Simple Calendar"),
            datePicker,
            eventInput,
            addButton,
            eventDisplay
        );
        root.setStyle("-fx-padding: 20;");
        
        addButton.setOnAction(e -> {
            String event = datePicker.getValue() + ": " + eventInput.getText();
            eventDisplay.appendText(event + "\n");
            eventInput.clear();
        });
        
        Scene scene = new Scene(root, 300, 400);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.setTitle("Mini Calendar");
        stage.show();
    }
}