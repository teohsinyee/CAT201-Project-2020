package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import DBConnection.DBHandler;

public class AddCleanserReviewController implements Initializable{
	

	@FXML
    private ComboBox<String> user_brand;
    @FXML
    private JFXTextArea user_comment;
    @FXML
    private TextField user_rating;
    @FXML
    private Button btnSave;
    
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    	//Edit ComboBox // Add selection to BRAND
        user_brand.getItems().addAll("neutrogena","Dermalogica","cosrx","sk2");
        handler = new DBHandler();
    }

    @FXML
    private void HandleEvents(MouseEvent event) {
        //check if not empty
        if (user_comment.getText().isEmpty() || user_rating.getText().isEmpty() ) {
        	Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText("Submit Review");
			alert.setContentText("Please fill in all fields!");
			alert.show();
        } else {
            saveData();
        }

    }

    private void clearFields() {
    	user_comment.clear();
    	user_rating.clear();
     
    }

    private void saveData() {
    	
    	connection = handler.getConnection();

        try {
            String st = "INSERT INTO toner_review ( brand, comment, rating) VALUES (?,?,?)";
            pst = (PreparedStatement) connection.prepareStatement(st);
            
            pst.setString(1, user_brand.getValue().toString());
            pst.setString(2, user_comment.getText());
            pst.setString(3, user_rating.getText());
            pst.executeUpdate();
            //clear fields
            clearFields();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Thank you. Your review is submitted successfully!");
			alert.show();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
 
        }
    }

}
