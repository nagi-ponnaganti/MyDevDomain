package com.nagihome.javafx.first;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MyFxApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("My First JavaFx App");
		
		Label label = new Label("Hello World, JavaFX !");
		Scene scene = new Scene(label, 400, 200);
		stage.setScene(scene);
				
		
		stage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
