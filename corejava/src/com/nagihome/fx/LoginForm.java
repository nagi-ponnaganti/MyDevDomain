/**
 * 
 */
package com.nagihome.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author nageswararao
 *
 */
public class LoginForm extends Application {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage stage) throws Exception {

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(gridPane, 600, 550);
		stage.setScene(scene);
		
		Text sceneTitle = new Text();
		sceneTitle.setText("Welcome");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		gridPane.add(sceneTitle, 0, 0, 2, 1);
		
		Label userName = new Label("User Name");
		gridPane.add(userName, 0, 1);
		
		TextField userNameText = new TextField();
		gridPane.add(userNameText, 1, 1);
		
		Label password = new Label("Password");
		gridPane.add(password, 0, 2);
		
		PasswordField passText = new PasswordField();
		gridPane.add(passText, 1, 2);
		
		Button signIn = new Button("Log In");
		HBox hbButton = new HBox(10);
		hbButton.setAlignment(Pos.CENTER);
		hbButton.getChildren().add(signIn);
		
		gridPane.add(signIn, 0, 4);
		
		Text actionTarget = new Text();
		gridPane.add(actionTarget, 1, 6);
		
		signIn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				actionTarget.setFill(Color.FIREBRICK);
				actionTarget.setText("Sign in button pressed");
				
			}
		});
				
		stage.show();
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}

}
