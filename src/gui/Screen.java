package gui;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Screen {
	
	//INTEGERS
	final int SCREEN_WIDTH = 490;
	final int SCREEN_HEIGHT = 300;
	final int BUTTON_HEIGHT = 215;
	final int BUTTON_WIDTH = 160;
	final int TASKBAR_HEIGHT = 21;
	
	//DOUBLES
	final double BUTTON_HEIGHT_MARGIN = (SCREEN_HEIGHT - BUTTON_HEIGHT - TASKBAR_HEIGHT) / 2;
	final double BUTTON_WIDTH_MARGIN = 50.0;
	
	//GUI COMPONENTS
	protected Scene scene;
	
	public Scene getScene(){
		return this.scene;
	}
	
	public void deleteScreen(){
		this.scene = null;
	}
	
}
