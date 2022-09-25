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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.*;


public class ConfirmBox {
    public static final int DEFAULT_MIN_WIDTH = 200;
    public static final int DEFAULT_MIN_Height = 120;

    private static Boolean response;

    
    public static Boolean display(String title, String message, int minWidth, int minHeight) {
        // create the window
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(minWidth);
        window.setMinHeight(minHeight);
        window.setOnCloseRequest(e -> {
            ConfirmBox.response = null;
            window.close();
        });

       
        Label label = new Label();
        label.setText(message);

       
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

       
        yesButton.setOnAction(e -> {
            ConfirmBox.response = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            ConfirmBox.response = false;
            window.close();
        });

        
        BorderPane subLayout = new BorderPane();
        int sideMargin = (int) (minWidth * 1.0 / 4);
        subLayout.setPadding(new Insets(0, sideMargin,0, sideMargin));
        subLayout.setLeft(yesButton);
        subLayout.setRight(noButton);

        VBox layout = new VBox();
        layout.setSpacing(20);
        layout.getChildren().addAll(label, subLayout);
        layout.setAlignment(Pos.CENTER);

        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return ConfirmBox.response;
    }

    
    public static Boolean display(String title, String message) {
        return ConfirmBox.display(title, message, ConfirmBox.DEFAULT_MIN_WIDTH, ConfirmBox.DEFAULT_MIN_Height);
    }
}
