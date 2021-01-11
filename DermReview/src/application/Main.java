package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	public static String brand;
	public static String username;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        primaryStage.setResizable(false);
        Scene scene=new Scene(root, 736,524);
        primaryStage.setScene(scene);
        primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
