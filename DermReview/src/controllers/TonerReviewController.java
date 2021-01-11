
package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class TonerReviewController implements Initializable {
	
	@FXML
	private AnchorPane mainpane;
	
    @FXML
    private GridPane cardHolder;
    
    @FXML
    private Pane submitBox;
    
    @FXML
    private JFXButton btnHome,btnLogOut,back;
    
    @FXML
    private Label user;
    
    ObservableList<ReviewCard> list = FXCollections.observableArrayList();
    ArrayList<String> comments = new ArrayList<>();
	ArrayList<String> dates = new ArrayList<>();
	ArrayList<String> ratings = new ArrayList<>();
	ReviewDAO dao = new ReviewDAO(); //Data Access Object
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	String username = Main.username;
		user.setText(username);	
    	
    	/* ++++++ Add Review Area ++++++ */
    	FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/fxml/AddTonerReview.fxml"));
		
		try {
			submitBox.getChildren().add(fxmlLoader.load());
			} 
			catch (IOException e1) {
			e1.printStackTrace();
			}
    	
    	//++++++++++++++++++++++++++++++++++++++++++
    	
		try {
			dao.getComment(Main.brand,comments);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}//end 
		
		try {
			dao.getDate(Main.brand,dates);
			} 
		catch (Exception e) {
			e.printStackTrace();
			}
		
		try {
			dao.getRating(Main.brand, ratings);
			} catch (Exception e) {
			e.printStackTrace();
			}
		
		for (int i=0;i<comments.size();i++){
			String str = comments.get(i);
			String dateget = dates.get(i);
			String ratingget = ratings.get(i);
			
			list.add(new ReviewCard(str, dateget, ratingget,"Rating:"));
		}

    	cardHolder.setAlignment(Pos.CENTER);
        cardHolder.setVgap(20.00);
        cardHolder.setHgap(20.00);
        cardHolder.setStyle("-fx-padding:10px;-fx-border-color:transparent");

        onSearch();
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
	
	public void backAction() throws Exception
	{	
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/TonerList.fxml"));
		Stage window = (Stage) back.getScene().getWindow();
		window.setScene(new Scene(root, 729,552));
	}

    @FXML
    public void onSearch() {
        int count = 0;
        for (int i = 0; i < comments.size(); i++) {
            for (int j = 0; j < 1; j++) {
                cardHolder.add(list.get(count), j, i);
                count++;
            }
        }// end outer for

    }// end fx
    
    
}//end class


class ReviewDAO{
	
	String itemID;
	// Get Comment based on 'brand'	
	public Review getComment(String brand,ArrayList<String> comments) throws Exception {
		
		
		String query = "SELECT comment FROM sinyee.toner_review WHERE brand="+"'"+brand+"'";
		Review r = new Review();
		r.brand = brand;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinyee?serverTimezone=UTC", "root", "");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
	
		while(rs.next()) {
			String comment = rs.getString(1);
			comments.add(comment);//add into array list	
		}	
		return r;
	}
//Return DATE
public Review getDate(String brand,ArrayList<String> dates) throws Exception {
		
		
		String query = "SELECT date FROM sinyee.toner_review WHERE brand="+"'"+brand+"'";
		Review r = new Review();
		r.brand = brand;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinyee?serverTimezone=UTC", "root", "");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
	
		while(rs.next()) {
			String date = rs.getString(1);
			dates.add(date);//add into array list	
		}
		return r;
	}

// Return Rating

	public Review getRating(String brand,ArrayList<String> ratings) throws Exception {
		
		
		String query = "SELECT rating FROM sinyee.toner_review WHERE brand="+"'"+brand+"'";
		Review r = new Review();
		r.brand = brand;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinyee?serverTimezone=UTC", "root", "");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
	
		while(rs.next()) {
			String rating = rs.getString(1);
			ratings.add(rating);//add into array list
		}
		return r;
	}
	
}

class Review{
	
	String brand;
	
}

