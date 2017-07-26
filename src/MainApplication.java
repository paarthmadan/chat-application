import gui.CreateScreen;
import gui.StartScreen;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application{

		//CONSTANTS
	
		//STRINGS
		final String WINDOW_TITLE = "Chat Application";
		
		//INTEGERS
		final int SCREEN_WIDTH = 490;
		final int SCREEN_HEIGHT = 300;

		//GUI COMPONENTS
		private Stage window;
		private Scene currentScene;
		private StartScreen startScreen;
		private CreateScreen serverScreen;
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			window = primaryStage;
			
			createScenes();
			loadStartScreen();
			windowConfiguration();
			
			//LAUNCH
			window.show();
		}
		
		//WINDOW CONFIGURATIONS
		private void windowConfiguration() {
			window.setMinHeight(SCREEN_HEIGHT);
			window.setMinWidth(SCREEN_WIDTH);
			window.setOnCloseRequest(null);
			window.setScene(currentScene);
			window.setTitle(WINDOW_TITLE);
			window.setResizable(false);
		}

		private void createScenes() {
			this.startScreen = new StartScreen();
			this.serverScreen = new CreateScreen();
		}

		private void loadStartScreen(){
			currentScene = startScreen.getScene();
			window.setScene(currentScene);
			
			//CREATE
			startScreen.getCreateButton().setOnAction(e -> {
				loadCreateScreen();
			});
			
			//JOIN
			startScreen.getJoinButton().setOnAction(e -> {
				
			});	
		}
		
		private void loadCreateScreen(){
			currentScene = serverScreen.getScene();
			window.setScene(currentScene);
		}
		
		
		public static void main(String [] args){
			launch(args);
		}
}
