package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class AccountSummaryController{
	@FXML
	private Button backtohome;
	@FXML
	private Button loadaccounts;
	@FXML
	private TextArea accountoutput;
	
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
    void LoadAccountsButtonListener(ActionEvent e) throws FileNotFoundException {
    	File fw = new File("C:\\Users\\edenb\\energyreading.txt");
    	Scanner inputFile = new Scanner(fw);
    	String str = "";
    	while (inputFile.hasNext()) {
    		str += inputFile.nextLine() + "\n";
    		
    	}
    	accountoutput.setText(str);
    		System.out.println(str);
    	inputFile.close();
    }
}







