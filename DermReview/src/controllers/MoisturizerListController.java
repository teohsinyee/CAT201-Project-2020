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

public class MoisturizerListController implements Initializable {
	
	 	@FXML
	    private AnchorPane home,toppane,leftpane;

	    @FXML
	    private JFXButton back,btnHome,btnLogOut,bioEssence,fresh,origin,bodyShop;
	    
	    @FXML
	    private Label user;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		String username = Main.username;
		user.setText(username);	
	}
	
	@FXML
	public void bioAction() throws Exception 
	{	
		Main.brand = bioEssence.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/MoisturizerReview.fxml"));
		Stage window = (Stage) bioEssence.getScene().getWindow();
		window.setScene(new Scene(root, 760,670));

	}
	
	@FXML
	public void bodyAction() throws Exception 
	{	
		Main.brand = bodyShop.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/MoisturizerReview.fxml"));
		Stage window = (Stage) bodyShop.getScene().getWindow();
		window.setScene(new Scene(root, 760,670));

	}
	
	@FXML
	public void freshAction() throws Exception //HERE -> PASS BRAND NAME TO Review Controller
	{	
		Main.brand = fresh.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/MoisturizerReview.fxml"));
		Stage window = (Stage) fresh.getScene().getWindow();
		window.setScene(new Scene(root, 760,670));

	}
	@FXML
	public void originAction() throws Exception 
	{	
		Main.brand = origin.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/MoisturizerReview.fxml"));
		Stage window = (Stage) origin.getScene().getWindow();
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
