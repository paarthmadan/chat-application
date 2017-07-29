package gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorPrompt {
	
	public ErrorPrompt(String title, String headerText, String errorMessage){
		Alert prompt = new Alert(AlertType.ERROR);
		prompt.setTitle(title);
		prompt.setHeaderText(headerText);
		prompt.setContentText(errorMessage);
		prompt.showAndWait();
	}
}
