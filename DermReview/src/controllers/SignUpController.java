package controllers;

import DBConnection.DBHandler;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignUpController implements Initializable {

	 	@FXML
	    private AnchorPane parentPane;

	    @FXML
	    private JFXRadioButton male,female;

	    @FXML
	    private ToggleGroup genders;

	    @FXML
	    private JFXButton login,btnSignUp;

	    @FXML
	    private ImageView progress;

	    @FXML
	    private JFXTextField name,email;

	    @FXML
	    private JFXPasswordField password; 
	
	    //variables
	    
	    private Connection connection;
	    private DBHandler handler;
	    private PreparedStatement pst;
	    
	 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		progress.setVisible(false);
		handler = new DBHandler();
	}
	
	
@FXML
public void signupAction() throws SQLException,Exception {

	if (name.getText().isEmpty() || password.getText().isEmpty() || email.getText().isEmpty()  ) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setContentText("Please fill in all fields!");
		alert.show();
	 }
	else if(!isValid(email.getText())){
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setContentText("Email is invalid! Eg. john@email.com ");
		alert.show();
		
	}
	 else {
		 
		// Save data into db
		String insert = "INSERT INTO users(email,name,password,gender)"+"VALUES(?,?,?,?)";
		
		connection = handler.getConnection();
		
		try {
			pst = connection.prepareStatement(insert);
			}catch (SQLException e1) {
				e1.printStackTrace();
			}//end try
		
		//set input value
		try {
			pst.setString(1, email.getText());
			pst.setString(2, name.getText());
			pst.setString(3, password.getText());
			pst.setString(4, getGender());
			pst.executeUpdate();
			}catch (SQLException e1) {
			e1.printStackTrace();
			}//end try
		
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setContentText("Congratulations! You have sign up successfully! Login Now!");
		alert.show();
				
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
			Stage window = (Stage) btnSignUp.getScene().getWindow();
			window.setScene(new Scene(root, 750,500));
			} catch (IOException e1) {
				e1.printStackTrace();
			}//end try
		 }
	System.out.print("SignUp Successfully");				
	}//end signupAction

	public String getGender() {
		
		String gen = "";
		
		if(male.isSelected()) {
			gen = "Male";
		}else if(female.isSelected()){
			gen = "Female";
		}
		
		return gen;
	}
	
	public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
  

	
}// end Class
