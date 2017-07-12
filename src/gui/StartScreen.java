package gui;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartScreen extends Application{

	final String WINDOW_TITLE = "Chat Application";
	final String CREATE_BUTTON_STRING = "CREATE";
	final String JOIN_BUTTON_STRING = "JOIN";
	
	final int SCREEN_WIDTH = 500;
	final int SCREEN_HEIGHT = 300;
	final int BUTTON_HEIGHT = 215;
	final int BUTTON_WIDTH = 160;
	final int TASKBAR_HEIGHT = 21;
	
	final double BUTTON_HEIGHT_MARGIN = (SCREEN_HEIGHT - BUTTON_HEIGHT - TASKBAR_HEIGHT) / 2;
	final double BUTTON_WIDTH_MARGIN = 50.0;
	
	private Stage window;
	private Scene scene;
	private BorderPane mainLayout;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		StartButton createButton = new StartButton(BUTTON_WIDTH, BUTTON_HEIGHT, CREATE_BUTTON_STRING, this.getClass().getResource("create-button-img.png").toExternalForm(), "left", BUTTON_WIDTH_MARGIN, BUTTON_HEIGHT_MARGIN);
		StartButton joinButton = new StartButton(BUTTON_WIDTH, BUTTON_HEIGHT, JOIN_BUTTON_STRING, this.getClass().getResource("join-button-img.png").toExternalForm(), "right", BUTTON_WIDTH_MARGIN, BUTTON_HEIGHT_MARGIN);
		
		mainLayout = new BorderPane();
		
		mainLayout.setLeft(createButton);
		mainLayout.setRight(joinButton);
		
		scene = new Scene(mainLayout);
		
		scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
		Font.loadFont(this.getClass().getResource("Fresca-Regular.ttf").toExternalForm().replaceAll("%20", " "), 24);
		
		window.setMinHeight(SCREEN_HEIGHT);
		window.setMinWidth(SCREEN_WIDTH);
		
		window.setOnCloseRequest(null);
		window.setScene(scene);
		window.setTitle(WINDOW_TITLE);
		window.setResizable(false);
		
		window.show();
	}
	
	public static void main(String [] args){
		launch(args);
	}
	
}
