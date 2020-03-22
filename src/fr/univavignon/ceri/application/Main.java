package fr.univavignon.ceri.application;
	
import fr.univavignon.ceri.application.config.Settings;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

/**
 * Tic Tac Toe
 * @author Yanis Labrak
 * @author Valentin Vougeot
 */
public class Main extends Application {
	
	/**
	 * The scenes
	 */
	public static Scene scene;
	
	/**
	 * Size of the screen
	 */
	public static Rectangle2D screenBounds;
		
	@Override
	public void start(Stage primaryStage) {
		
		try {

			// Set the title
			primaryStage.setTitle("Tic-Tac-Toe");
			
			// Set a favicon to the window
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("ressources/images/ttt1.png")));

			// Get the dimensions of the monitor
		    Main.screenBounds = Screen.getPrimary().getBounds();
		    
		    // Load the FXML
		    Parent layout = FXMLLoader.load(getClass().getResource("vues/Main.fxml"));
			
			scene = new Scene(layout,layout.getLayoutY(), layout.getLayoutX());
			scene.getStylesheets().add(getClass().getResource("vues/application.css").toExternalForm());
			
			// Set the width of the window to the 7/10 of the monitor width
			Settings.WIDTH_BOARD.set(screenBounds.getWidth() * 0.7);
			primaryStage.setWidth(Settings.WIDTH_BOARD.get());
			primaryStage.setMinWidth(Settings.WIDTH_BOARD.get());

			// Set the height of the window to the half of the monitor height
			Settings.HEIGHT_BOARD.set(screenBounds.getHeight() * 0.8);
			primaryStage.setHeight(Settings.HEIGHT_BOARD.get());
			primaryStage.setMinHeight(Settings.HEIGHT_BOARD.get());

			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
