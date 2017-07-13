package gui;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartScreen extends Application{
	
	//CONSTANTS
	
	//STRINGS
	final String WINDOW_TITLE = "Chat Application";
	final String CREATE_BUTTON_STRING = "CREATE";
	final String JOIN_BUTTON_STRING = "JOIN";
	
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
	private Stage window;
	private Scene startScene;
	private BorderPane mainLayout;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		//CONSTRUCTOR PARAMETERS -> WIDTH, HEIGHT, BUTTON TEXT, IMG RESOURCE, SIDE, WIDTH-MARGIN, HEIGHT-MARGIN
		StartButton createButton = new StartButton(BUTTON_WIDTH, BUTTON_HEIGHT, CREATE_BUTTON_STRING, this.getClass().getResource("create-button-img.png").toExternalForm(), "left", BUTTON_WIDTH_MARGIN, BUTTON_HEIGHT_MARGIN);
		StartButton joinButton = new StartButton(BUTTON_WIDTH, BUTTON_HEIGHT, JOIN_BUTTON_STRING, this.getClass().getResource("join-button-img.png").toExternalForm(), "right", BUTTON_WIDTH_MARGIN, BUTTON_HEIGHT_MARGIN);
		
		//BUTTON HANDLERS
		createButton.setOnAction(e -> {
			create();
		});
		
		joinButton.setOnAction(e -> {
			join();
		});
		
		//Layout Instantiation
		mainLayout = new BorderPane();
		
		//Component Mapping
		mainLayout.setLeft(createButton);
		mainLayout.setRight(joinButton);
		
		//Scene Instantiation
		startScene = new Scene(mainLayout);
		
		//SCENE CSS
		startScene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
		
		//LOAD FONT
		Font.loadFont(this.getClass().getResource("Fresca-Regular.ttf").toExternalForm().replaceAll("%20", " "), 24);
		
		//WINDOW CONFIGURATIONS
		window.setMinHeight(SCREEN_HEIGHT);
		window.setMinWidth(SCREEN_WIDTH);
		window.setOnCloseRequest(null);
		window.setScene(startScene);
		window.setTitle(WINDOW_TITLE);
		window.setResizable(false);
		
		//LAUNCH
		window.show();
	}
	
	public static void main(String [] args){
		launch(args);
	}
	
	//Create Method
	public void create(){
		System.out.println("CREATE");
		window.setScene(null);
	}
	
	//Join Method
	public void join(){
		System.out.println("JOIN");
		window.setScene(null);
	}
	
}
