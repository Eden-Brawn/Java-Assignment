package application;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageController {

    @FXML
    private Button nextPageButton;
    @FXML
    private Button accountsSummaryButton;
    
    public void nextPageButtonListener(ActionEvent e) throws Exception {
    	Parent parent = FXMLLoader.load(
	               getClass().getResource("RegisterCustomer.fxml")); 
	      
	      // Build the scene graph.
	      Scene scene = new Scene(parent); 
	
	      Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	      // Display our window, using the scene graph.
	      stage.setTitle("Register A Customer"); 
	      stage.setScene(scene);
	      stage.show(); 
    }
    public void accountsSummaryButtonListener(ActionEvent event) throws Exception{
    	Parent parent = FXMLLoader.load(getClass().getResource("AccountsSummary.fxml"));
    	Scene scene = new Scene(parent);
    	
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	
    	stage.setTitle("Accounts Summary");
    	stage.setScene(scene);
    	stage.show();
    }

}
