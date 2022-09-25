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
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Slider;
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;  
import javafx.scene.layout.Region;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;

public class Main extends Application {

    private Stage window;

    
    public Scene buildScene() {

        
        Label heightLabel = new Label("Height:");
        Label weightLabel = new Label("Weight:");
	TextField heightInput = new TextField();
	TextField weightInput = new TextField();
	Label weightUnitLabel = new Label();
	Label heightUnitLabel = new Label();
	Button calcButton = new Button();
	TableView tableView = new TableView();
	final Slider heightSlider = new Slider(10, 200, 10);
	final Slider weightSlider = new Slider(10, 150, 10);
	RadioButton firstUnit= new RadioButton("cm/Kg");
	RadioButton secondUnit= new RadioButton("in/lb");

	heightLabel.setStyle("-fx-background-color: #2FED54");
	weightLabel.setStyle("-fx-background-color: #2FED54");
	heightLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
	weightLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
        heightInput.setPromptText("Enter numbers");
	heightInput.setStyle("-fx-background-color: #AE42CF");
        weightInput.setPromptText("Enter numbers");
	weightInput.setStyle("-fx-background-color: #AE42CF");
	heightInput.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
	weightInput.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
	weightUnitLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
	heightUnitLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
	
        calcButton.setText("Calculate");
        calcButton.setOnAction(e -> {
            Double bmi = calculateBMI(heightInput, weightInput, heightUnitLabel);
            if (bmi != null) {
                displayBMI(bmi);
            }
        });

      	TableColumn<Chart, String> column1 = 
      new TableColumn<>("BMI");
    
      column1.setCellValueFactory(
        new PropertyValueFactory<>("BMI"));

   	 TableColumn<Chart, String> column2 = 
   	 new TableColumn<>("WeightStatus");
    
   	 column2.setCellValueFactory(
        	new PropertyValueFactory<>("WeightStatus"));


	 tableView.getColumns().add(column1);
    	 tableView.getColumns().add(column2);

   	 tableView.getItems().add(
     	 new Chart("Below 18.5", "Underweight"));
    	tableView.getItems().add(
     	 new Chart("18.5-24.9", "Normal"));
	 tableView.getItems().add(
      	new Chart("25.0-29.9", "Overweight"));
    	tableView.getItems().add(
      	new Chart("30 and Above", "Obese"));


	heightSlider.setMajorTickUnit(10.0);
	heightSlider.setMinorTickCount(2);
	heightSlider.setSnapToTicks(true);
	heightSlider.setShowTickMarks(true);
	heightSlider.setShowTickLabels(true);
	heightSlider.setPrefWidth(200);
        heightSlider.setPrefHeight(150);

	 heightSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    
                    heightInput.setText(String.format("%.2f", new_val));
            }
        });

	weightSlider.setMajorTickUnit(10.0);
	weightSlider.setMinorTickCount(2);
	weightSlider.setSnapToTicks(true);
	weightSlider.setShowTickMarks(true);
	weightSlider.setShowTickLabels(true);
	weightSlider.setPrefWidth(400);
        weightSlider.setPrefHeight(150);

	
	 weightSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    
                    weightInput.setText(String.format("%.2f", new_val));
                }
           });



	firstUnit.selectedProperty().addListener(
       (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) ->{
        heightUnitLabel.setText("cm");
	weightUnitLabel.setText("Kg");

      });

	secondUnit.selectedProperty().addListener(
      (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) ->{
         heightUnitLabel.setText("in");
	 weightUnitLabel.setText("lb");

      });
 
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(0,0,0,0));
        grid.setVgap(25);
        grid.setHgap(10);	
	grid.setStyle("-fx-background-color: #40948C;");

        GridPane.setConstraints(heightLabel, 0,0);
        GridPane.setConstraints(weightLabel, 0,1);
        GridPane.setConstraints(heightInput,1,0);
        GridPane.setConstraints(weightInput, 1,1);
        GridPane.setConstraints(heightUnitLabel,2,0);
        GridPane.setConstraints(weightUnitLabel,2,1);
        GridPane.setConstraints(calcButton,1,4);
	GridPane.setConstraints(tableView ,3,4);
	GridPane.setConstraints(heightSlider ,3,0);
	GridPane.setConstraints(weightSlider ,3,1);
	GridPane.setConstraints(firstUnit ,0,3);
	GridPane.setConstraints(secondUnit ,1,3);

        grid.getChildren().addAll(heightLabel, weightLabel, heightInput, weightInput,
                heightUnitLabel,weightUnitLabel,calcButton, tableView, heightSlider, weightSlider, firstUnit, secondUnit);


        
        return new Scene(grid, 950, 450);
    }

    public Double calculateBMI(TextField heightInput, TextField weightInput, Label heightUnitLabel) {
        Double bmi = null;
        try {
		if(heightUnitLabel.getText()=="cm"){
            double height = Double.parseDouble(heightInput.getText()) / 100;
            double weight = Double.parseDouble(weightInput.getText());
            if (height <= 0 || weight <= 0) {
                throw new IllegalArgumentException();
            }
            bmi = (weight / (height * height));
	}
	else{
	    double height = Double.parseDouble(heightInput.getText());
            double weight = Double.parseDouble(weightInput.getText());
            if (height <= 0 || weight <= 0) {
                throw new IllegalArgumentException();
            }
		bmi=(weight*703)/(height*height);
	
	}

        } catch(NumberFormatException e1) {
            AlertBox.display("Error", "Height and Weight\nmust be numerical!");
        } catch(IllegalArgumentException e2) {
            AlertBox.display("Error", "Height and Weight\nmust be positive!");
        }

        
        if (bmi == null) {
            heightInput.setText("");
            weightInput.setText("");
        }

        return bmi;
    }

    public void displayBMI(double bmi) {
        String comment;
        if (bmi >=40) {
            comment = "are very extremely obese";
        } else if (bmi >= 35) {
            comment = "are extremely obese";
        } else if (bmi >= 30) {
            comment = "are moderately obese";
        } else if (bmi >= 25) {
            comment = "are slightly overweight";
        } else if (bmi >= 18.5) {
            comment = "have a healthy weight";
        } else if (bmi >= 16) {
            comment = "are slightly underweight";
        } else if (bmi >= 15) {
            comment = "are moderately underweight";
        } else {
            comment = "are extremely underweight";
        }
        AlertBox.display("Result", String.format("Your BMI is %.2f,\n You %s.",bmi, comment));
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("BMI Calculator");

         Scene scene = buildScene();   
   	window.setScene(scene);
	
	
	
        window.setOnCloseRequest(e -> {
            e.consume();
            Boolean response = ConfirmBox.display("Closing", "Are you sure to exit?");
            if (response != null && response == true) {
                window.close();
            }
        });

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}