package com.nagihome.javafx.chapter01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFXApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		Text message = new Text("Hello World");		
		VBox root = new VBox();		
		root.getChildren().add(message);
		Scene scene = new Scene(root, 500, 300);
		stage.setScene(scene);
		stage.setTitle("Hello World Java Application");
		
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);		
	}

}
