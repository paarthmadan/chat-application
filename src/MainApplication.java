import gui.CreateScreen;
import gui.StartScreen;
import javafx.application.*;
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
		private StartScreen startScreen;
		private CreateScreen serverScreen;
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			this.window = primaryStage;
			
			loadStartScreen();
			windowConfiguration();

			//LAUNCH
			window.show();
		}
		
		//WINDOW CONFIGURATIONS
		private void windowConfiguration() {
			window.setHeight(SCREEN_HEIGHT);
			window.setWidth(SCREEN_WIDTH);
			window.setOnCloseRequest(null);
			window.setTitle(WINDOW_TITLE);
			window.setResizable(false);
		}


		private void loadStartScreen(){
			startScreen = new StartScreen();
			window.setScene(startScreen.getScene());
			
			//CREATE
			startScreen.getCreateButton().setOnAction(e -> {
				loadCreateScreen();
			});
			
			//JOIN
			startScreen.getJoinButton().setOnAction(e -> {
				
			});	
		}
		
		private void loadCreateScreen(){
			serverScreen = new CreateScreen();
			window.setScene(serverScreen.getScene());
			
			serverScreen.getBackButton().setOnAction(e -> {
				loadStartScreen();
			});
			
			serverScreen.getCreateButton().setOnAction(e -> {
				if(serverScreen.checkValues())
					System.out.println("Success!");
			});
			
		}
		
		public static void main(String [] args){
			launch(args);
		}
}
