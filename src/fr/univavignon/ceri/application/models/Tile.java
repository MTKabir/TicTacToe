/**
 * 
 */
package fr.univavignon.ceri.application.models;

import java.io.InputStream;

import fr.univavignon.ceri.application.Main;
import fr.univavignon.ceri.application.config.Colors;
import fr.univavignon.ceri.application.config.Settings;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * A Tile
 * @author Yanis Labrak
 */
public class Tile extends StackPane {
	
	/**
	 * Content of the {@code Tile} :
	 * <br>
	 * null => Blank
	 * <br>
	 * x => Cross
	 * <br>
	 * o => Round
	 */
	public Text content;
	
	/**
	 * Constructor
	 */
	public Tile() {
		
		this.content = new Text("x");
		this.content.setFill(Color.WHITE);
		this.content.setStyle("-fx-font: 60 arial;");
		
		Rectangle shape = new Rectangle(Settings.getSize(),Settings.getSize());
//				
//		InputStream input = this.getClass().getResourceAsStream("../ressources/images/circle.png");
//        Image image = new Image(input);		
//		ImagePattern imagePattern = new ImagePattern(image);
//		shape.setFill(imagePattern);
		
		// Fill colors and stroke
		shape.setFill(Color.web(Colors.TILE_FILL));
		shape.setStroke(Color.web(Colors.TILE_STROKE));
		
		// Rounded corners
		shape.setArcWidth(Settings.RADIUS);
		shape.setArcHeight(Settings.RADIUS);
		
		// Font size
		this.content.resize(Settings.SIZE_TEXT_TILE, Settings.SIZE_TEXT_TILE);
		
		setAlignment(Pos.CENTER);
		
//		getChildren().addAll(shape);
		getChildren().addAll(shape, this.content);
		
		setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				this.drawCross();
				
			} else if (event.getButton() == MouseButton.SECONDARY) {
				this.drawCircle();
			}
		});
	}

	/**
	 * Draw a cross
	 */
	private void drawCross() {
		this.content.setText("x");
	}

	/**
	 * Draw a cross
	 */
	private void drawCircle() {
		this.content.setText("o");
	}
	
	@Override
	public String toString() {
		return this.content.getText();
	}

}
