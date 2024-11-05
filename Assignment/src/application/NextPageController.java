package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NextPageController {


    @FXML
    private Button backToHome;
    @FXML
    private TextField userName;
    @FXML
    private TextField userTariff;
    @FXML
    private TextField opening;
    @FXML
    private TextField closing;
    @FXML
    private Button submit;
    @FXML
    private Label output;
    
    public void BackToHomeButtonListener(ActionEvent e) throws Exception {
    	Parent parent = FXMLLoader.load(
	               getClass().getResource("HomePage.fxml")); 
	      
	      // Build the scene graph.
	      Scene scene = new Scene(parent); 
	
	      Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	      // Display our window, using the scene graph.
	      stage.setTitle("Home Page"); 
	      stage.setScene(scene);
	      stage.show(); 
    }
    @FXML
    void submitButtonListener(ActionEvent event) throws Exception {
    	String name = userName.getText();
    	String tariff = userTariff.getText();
    	String openingReading = opening.getText();
    	String closingReading = closing.getText();
    	double days = 33;
    	double c = Double.parseDouble(closingReading);
    	double o = Double.parseDouble(openingReading);
    	double t = Double.parseDouble(tariff);
    	double kWh = c - o;
    	double rate = 0.19349;
    	double price = kWh * rate;
    	double standingCharge = days * (t/100);
    	double totalSupplyCharges = standingCharge + price;
    	double VAT = totalSupplyCharges * 0.05;
    	double totalNewElectricityCharges = totalSupplyCharges + VAT;
    	String total = Double.toString(totalNewElectricityCharges);
    	String run = name + "'s Total New Electricity Charges: " + total;
    	
    	output.setText(run);
    	FileWriter fw = new FileWriter("C:\\Users\\edenb\\energyreading.txt", true);
    	PrintWriter pw = new PrintWriter(fw);
    	pw.println("User Name: " + name);
    	pw.println("Tariff: " + tariff + "p");
    	pw.println("Days: " + days);
    	pw.println("Total Units: " + kWh + "kWh");
    	pw.println("Rate(£): " + rate);
    	pw.println("Unit Rate Per kWh: £" + price);
    	pw.println("Standing Charge: £" + standingCharge);
    	pw.println("Total New Electricity Charges: £" + total);
    	pw.println("--------------------------------------------------");
    	pw.close();
    	
    }

}
