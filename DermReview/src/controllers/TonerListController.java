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

public class TonerListController implements Initializable {
	
	 	@FXML
	    private AnchorPane home,toppane,leftpane;

	    @FXML
	    private JFXButton simple,skincode,back,btnHome,btnLogOut,GardenofEden,ahc,mamonde,sukin;
	    
	    @FXML
	    private Label user;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		String username = Main.username;
		user.setText(username);	
	}
	
	@FXML
	public void simpleAction() throws Exception 
	{	
		Main.brand = simple.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/TonerReview.fxml"));
		Stage window = (Stage) simple.getScene().getWindow();
		window.setScene(new Scene(root, 760,670));

	}
	
	@FXML
	public void skincodeAction() throws Exception //HERE -> PASS BRAND NAME TO Review Controller
	{	
		Main.brand = skincode.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/TonerReview.fxml"));
		Stage window = (Stage) simple.getScene().getWindow();
		window.setScene(new Scene(root, 760,670));

	}
	
	@FXML
	public void edenAction() throws Exception
	{	
		Main.brand = GardenofEden.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/TonerReview.fxml"));
		Stage window = (Stage) simple.getScene().getWindow();
		window.setScene(new Scene(root, 760,670));

	}
	
	@FXML
	public void ahcAction() throws Exception 
	{	
		Main.brand = ahc.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/TonerReview.fxml"));
		Stage window = (Stage) simple.getScene().getWindow();
		window.setScene(new Scene(root, 760,670));

	}
	
	@FXML
	public void mamondeAction() throws Exception
	{	
		Main.brand = mamonde.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/TonerReview.fxml"));
		Stage window = (Stage) simple.getScene().getWindow();
		window.setScene(new Scene(root, 760,670));

	}
	
	@FXML
	public void sukinAction() throws Exception
	{	
		Main.brand = sukin.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/TonerReview.fxml"));
		Stage window = (Stage) simple.getScene().getWindow();
		window.setScene(new Scene(root, 760,670));

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
		window.setScene(new Scene(root, 750,500));

	}
	public void backAction() throws Exception{
		
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/HOME.fxml"));
		Stage window = (Stage) back.getScene().getWindow();
		window.setScene(new Scene(root, 758,552));
	}

}
