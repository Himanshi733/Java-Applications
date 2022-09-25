/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField location;
    @FXML
    private Button btn;
    @FXML
    private Text showlocation;
    @FXML
    private Text showdate;
    @FXML
    private Text showtemp;
    @FXML
    private Text showweather;
    @FXML
    private Text error;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void getUpdate(ActionEvent event) throws Exception{
        try{
            Registry reg = LocateRegistry.getRegistry("localhost", 9999);
            Adder ad = (Adder)reg.lookup("hi server");
            String lc = location.getText().toString();
            String[] result = ad.getWeatherUpdate(lc);
            if(result!=null){
                error.setText("");
                showlocation.setText(result[0]);
                showdate.setText(result[1]);
                showtemp.setText(result[2]+"°C");
                showweather.setText(result[3]);
            }
            else{
                showlocation.setText("");
                showdate.setText("");
                showtemp.setText("");
                showweather.setText("");
                error.setText("Please Enter Valid Location Name!");
            }
        }
        catch(NotBoundException|RemoteException e){
            System.out.println(e);
        }
    }
    void connectRemote() throws RemoteException{
        
    }
}
