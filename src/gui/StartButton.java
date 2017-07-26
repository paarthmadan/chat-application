package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class StartButton extends Button{
	
	private final int VBOX_MARGIN_HEIGHT = 37;
	
	private ImageView image;
	private VBox verticalLayout;
	private Label buttonText;
	
	public StartButton(double width, double height, String text, String imgRes, String pos, double marginWidth, double marginHeight){
		
		verticalLayout = new VBox(VBOX_MARGIN_HEIGHT);
		
		buttonText = new Label(text);
		buttonText.setTextAlignment(TextAlignment.CENTER);
		buttonText.getStyleClass().add(".button-text");
		
		this.setMinWidth(width);
		this.setMinHeight(height);
		
		if(pos.equalsIgnoreCase("Left")){
			BorderPane.setMargin(this, new Insets(marginHeight, 0, 0, marginWidth));	
		}else{
			BorderPane.setMargin(this, new Insets(marginHeight, marginWidth, 0, 0));
		}
		
		image = new ImageView(imgRes);
		
		VBox.setMargin(image, new Insets(10, 0, 0, 0));
		verticalLayout.setAlignment(Pos.CENTER);
		
		verticalLayout.getChildren().add(image);
		verticalLayout.getChildren().add(buttonText);
		
		this.setGraphic(verticalLayout);
		this.getStyleClass().add(".start-button");
		}
}
