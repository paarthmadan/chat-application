package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class CreateScreen extends Screen{
	
	private TextField groupNameTextField;
	private TextField nickNameTextField;
	private TextField portNumberTextField;
	private TextField limitTextField;
	private CheckBox accessCheckBox;
	private Button backButton;
	private Button createButton;
	
	private Scene scene;
	
	public CreateScreen(){
		groupNameTextField = new TextField("group name");
		nickNameTextField = new TextField("nickname");
		
		portNumberTextField = new TextField("port number");
		accessCheckBox = new CheckBox("private");
		limitTextField = new TextField("limit");

		HBox horizontalContainer = new HBox(5);
		horizontalContainer.getChildren().addAll(portNumberTextField, accessCheckBox, limitTextField);
		
		backButton = new Button("BACK");
		createButton = new Button("CREATE");

		HBox horizontalButtonContainer = new HBox(30);
		horizontalButtonContainer.getChildren().addAll(backButton, createButton);
		
		
		VBox verticalContainer = new VBox(10);
		verticalContainer.setAlignment(Pos.CENTER);
		verticalContainer.getChildren().addAll(groupNameTextField, nickNameTextField, horizontalContainer, horizontalButtonContainer);
		
		BorderPane mainLayout = new BorderPane();
		
		mainLayout.setCenter(verticalContainer);
		scene = new Scene(mainLayout);

		scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
		
		//LOAD FONT
		Font.loadFont(this.getClass().getResource("Fresca-Regular.ttf").toExternalForm().replaceAll("%20", " "), 24);

	}
	
	public Scene getScene(){
		return this.scene;
	}
	
}
