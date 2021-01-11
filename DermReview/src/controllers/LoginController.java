package controllers;

import DBConnection.DBHandler;
import application.Main;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	
	@FXML
    public JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton btnSignUp,btnLogin,forgotpassword;

    @FXML
    private ImageView progress;
	
    //variables
    
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    private static LoginController instance;
    
    public LoginController() {
    	instance=this;
    }
    
    public static LoginController getInstance() {
    	return instance;
    }
    
    public String username() {
    	return username.getText();
    }
 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		username.setStyle("-fx-text-inner-color: #3944BC;");
		password.setStyle("-fx-text-inner-color: #3944BC;");
		handler = new DBHandler();//create new object from DBHandler class
	}
	
	@FXML
	public void loginAction(ActionEvent e) {
		
		  if (username.getText().isEmpty() || password.getText().isEmpty() ) {
	        	Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Please fill in all fields!");
				alert.show();
	        } 
		  else {

			  System.out.print("Login Successfully");
		
	Main.username = username.getText();
			
	connection = handler.getConnection();
	// Find the input username & pw // Throw error when not found
	String q1 = "SELECT * FROM users WHERE name=? and password=?";
	
	try {
		pst = connection.prepareStatement(q1);
		pst.setString(1, username.getText()); //fx:id is username, in SQL is name
		pst.setString(2, password.getText());
		
		ResultSet rs = pst.executeQuery();//object of ResultSet maintains cursor point to a row of a table
		
		int count = 0;
		
		while(rs.next()) {
			count=count+1;
		}
		if(count == 1) {
			
			//hide current scene
			btnLogin.getScene().getWindow().hide();
			
			// set new stage named home
			Stage home = new Stage();
						
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/fxml/HOME.fxml"));	
					Scene scene = new Scene(root);//create new scene and append root
					home.setScene(scene);//set scene to the stage
					home.show();//show the stage			
					} catch (IOException e1) {		
					e1.printStackTrace();
					}//end try
	
		}//end if
		else {
			
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Username & Password are not correct");
			alert.show();
			progress.setVisible(false);
		}
		
	}catch(SQLException e1) {
		e1.printStackTrace();
	}
	
	finally {
			try {
				connection.close();
				} catch (SQLException e1) {
				e1.printStackTrace();
				}//end try
	}
		  }

}// end loginAction
	
	@FXML

	// btnSignUp action
	public void signupAction() throws Exception { 

		Parent root = FXMLLoader.load(getClass().getResource("/fxml/SignUp.fxml"));
		Stage window = (Stage) btnSignUp.getScene().getWindow();
		window.setScene(new Scene(root, 750,500));
	}
	
	
}// end Class
