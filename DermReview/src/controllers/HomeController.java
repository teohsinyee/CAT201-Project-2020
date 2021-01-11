package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class HomeController implements Initializable {

	 	@FXML
	    private AnchorPane home,toppane,leftpane;
	 	
	    @FXML
	    private JFXButton btnCleanser,btnSunscreen,btnToner,btnMoisturizer,btnHome,btnLogOut;
	    
	    @FXML
	    private Label user;
	  
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		String username = Main.username;
		user.setText(username);
		System.out.println(Main.username);}
	
	@FXML
	public void cleanserAction() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/CleanserList.fxml"));
		Stage window = (Stage) btnCleanser.getScene().getWindow();
		window.setScene(new Scene(root, 738,551));

	}
	
	@FXML
	public void tonerAction() throws Exception
	{	
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/TonerList.fxml"));
		Stage window = (Stage) btnToner.getScene().getWindow();
		window.setScene(new Scene(root, 729,552));
	}
	
	@FXML
	public void moisturizerAction() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/MoisturizerList.fxml"));
		Stage window = (Stage) btnMoisturizer.getScene().getWindow();
		window.setScene(new Scene(root, 729,552));

	}
	
	@FXML
	public void sunscreenAction() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/SunscreenList.fxml"));
		Stage window = (Stage) btnSunscreen.getScene().getWindow();
		window.setScene(new Scene(root, 729,552));

	}
	
	@FXML
	public void homeAction() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/HOME.fxml"));
		Stage window = (Stage) btnHome.getScene().getWindow();
		window.setScene(new Scene(root, 758,552));

	}
	
	@FXML
	public void logoutAction() throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
		Stage window = (Stage) btnLogOut.getScene().getWindow();
		window.setScene(new Scene(root, 736,524));

	}

	
}//end class
