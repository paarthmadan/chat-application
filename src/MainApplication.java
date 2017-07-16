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
		}

		private void loadStartScreen(){
			currentScene = startScreen.getScene();
			window.setScene(currentScene);
			
			startScreen.getCreateButton().setOnAction(e -> {
				create();
			});
			
			startScreen.getJoinButton().setOnAction(e -> {
				join();
			});
			
		}
		
		public static void main(String [] args){
			launch(args);
		}
		
		//Create Method
		public void create(){
			window.setScene(null);
		}
		
		//Join Method
		public void join(){
			window.setScene(null);
		}
}
