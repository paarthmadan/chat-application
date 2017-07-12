package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class StartButton extends Button{
	public StartButton(double width, double height, String text, String imgRes, String pos, double marginWidth, double marginHeight){
		setMinWidth(width);
		setMinHeight(height);
		setText(text);
		if(pos.equalsIgnoreCase("Left")){
			BorderPane.setMargin(this, new Insets(marginHeight, 0, 0, marginWidth));	
		}else{
			BorderPane.setMargin(this, new Insets(marginHeight, marginWidth, 0, 0));
		}
	}
}
