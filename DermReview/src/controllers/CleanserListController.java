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

public class CleanserListController implements Initializable {
	
	 	@FXML
	    private AnchorPane home,toppane,leftpane;

	    @FXML
	    private JFXButton back,btnHome,btnLogOut,neutrogena,Dermalogica,cosrx,sk2;
	    
	    @FXML
	    private Label user;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		String username = Main.username;
		user.setText(username);	
	}
	
	@FXML
	public void neutrogenaAction() throws Exception 
	{	
		Main.brand = neutrogena.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/CleanserReview.fxml"));
		Stage window = (Stage) neutrogena.getScene().getWindow();
		window.setScene(new Scene(root, 760,670));

	}
	
	@FXML
	public void dermalogicaAction() throws Exception //HERE -> PASS BRAND NAME TO Review Controller
	{	
		Main.brand = Dermalogica.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/CleanserReview.fxml"));
		Stage window = (Stage) Dermalogica.getScene().getWindow();
		window.setScene(new Scene(root, 760,670));

	}
	
	@FXML
	public void cosrxAction() throws Exception //HERE -> PASS BRAND NAME TO Review Controller
	{	
		Main.brand = cosrx.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/CleanserReview.fxml"));
		Stage window = (Stage) cosrx.getScene().getWindow();
		window.setScene(new Scene(root, 760,670));

	}
	@FXML
	public void sk2Action() throws Exception 
	{	
		Main.brand = sk2.getId();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/CleanserReview.fxml"));
		Stage window = (Stage) sk2.getScene().getWindow();
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
