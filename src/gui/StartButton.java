package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class StartButton extends Button{
	
	private ImageView image;
	private VBox verticalLayout;
	private Text buttonText;
	
	public StartButton(double width, double height, String text, String imgRes, String pos, double marginWidth, double marginHeight){
		
		verticalLayout = new VBox(37);
		
		buttonText = new Text(text);
		buttonText.setTextAlignment(TextAlignment.CENTER);
		buttonText.setFont(new Font(24));
		
		setMinWidth(width);
		setMinHeight(height);
		
		if(pos.equalsIgnoreCase("Left")){
			BorderPane.setMargin(this, new Insets(marginHeight, 0, 0, marginWidth));	
		}else{
			BorderPane.setMargin(this, new Insets(marginHeight, marginWidth, 0, 0));
		}
		
		image = new ImageView(imgRes);
		
		verticalLayout.setAlignment(Pos.CENTER);
		
		verticalLayout.getChildren().add(image);
		verticalLayout.getChildren().add(buttonText);
		
		this.setGraphic(verticalLayout);
		}
}
