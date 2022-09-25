/**********************************************
Workshop #6
Course:<subject type> - 4
Last Name:<Himanshi>
First Name:<->
ID:<155860208>
Section:<ZBB>
This assignment represents my own work in accordance with Seneca Academic Policy.
Himanshi
Date:<17-07-2022>
**********************************************/
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class AlertBox {
    public static final int DEFAULT_MIN_WIDTH = 200;
    public static final int DEFAULT_MIN_Height = 120;
    public static final String DEFAULT_CONFIRM = "Close";
   
    public static void display(String title, String message, String confirm, int minWidth, int minHeight) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);
        window.setMinWidth(minWidth);
        window.setMinHeight(minHeight);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button(confirm);

        closeButton.setOnAction(e -> {
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #FFFFFF;");

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

  
    public static void display(String title, String message) {
        AlertBox.display(title, message,
                AlertBox.DEFAULT_CONFIRM,
                AlertBox.DEFAULT_MIN_WIDTH,
                AlertBox.DEFAULT_MIN_Height);
    }

   
    public static void display(String title, String message, String confirm) {
        AlertBox.display(title, message, confirm, AlertBox.DEFAULT_MIN_WIDTH, AlertBox.DEFAULT_MIN_Height);
    }
}
