package gui;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class StartScreen extends Screen{
	
	//CONSTANTS
	
	//STRINGS
	final String CREATE_BUTTON_STRING = "CREATE";
	final String JOIN_BUTTON_STRING = "JOIN";
	
	private StartButton createButton;
	private StartButton joinButton;
	private Scene scene;
	
	public StartScreen(){
		
		//CONSTRUCTOR PARAMETERS -> WIDTH, HEIGHT, BUTTON TEXT, IMG RESOURCE, SIDE, WIDTH-MARGIN, HEIGHT-MARGIN
		createButton = new StartButton(BUTTON_WIDTH, BUTTON_HEIGHT, CREATE_BUTTON_STRING, this.getClass().getResource("create-button-img.png").toExternalForm(), "left", BUTTON_WIDTH_MARGIN, BUTTON_HEIGHT_MARGIN);
		joinButton = new StartButton(BUTTON_WIDTH, BUTTON_HEIGHT, JOIN_BUTTON_STRING, this.getClass().getResource("join-button-img.png").toExternalForm(), "right", BUTTON_WIDTH_MARGIN, BUTTON_HEIGHT_MARGIN);
		
		//Layout Instantiation
		BorderPane mainLayout = new BorderPane();
		
		//Component Mapping
		mainLayout.setLeft(createButton);
		mainLayout.setRight(joinButton);
		
		//Scene Instantiation
		scene = new Scene(mainLayout);
		
		//SCENE CSS
		scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
		
		//LOAD FONT
		Font.loadFont(this.getClass().getResource("Fresca-Regular.ttf").toExternalForm().replaceAll("%20", " "), 24);
	}
	
	public StartButton getCreateButton(){
		return this.createButton;
	}

	public StartButton getJoinButton(){
		return this.joinButton;
	}
	
	public Scene getScene(){
		return this.scene;
	}
}
