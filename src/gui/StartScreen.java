package gui;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartScreen extends Application{

	final String WINDOW_TITLE = "Chat Application";
	final int SCREEN_WIDTH = 500;
	final int SCREEN_HEIGHT = 300;
	
	private Stage window;
	private Scene scene;
	private BorderPane mainLayout;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		mainLayout = new BorderPane();
		
		scene = new Scene(mainLayout);
		
		window.setMinHeight(SCREEN_HEIGHT);
		window.setMinWidth(SCREEN_WIDTH);
		
		window.setScene(scene);
		window.setTitle(WINDOW_TITLE);
		window.setResizable(false);
		
		
		window.show();
	}
	
	public static void main(String [] args){
		launch(args);
	}
	
}
