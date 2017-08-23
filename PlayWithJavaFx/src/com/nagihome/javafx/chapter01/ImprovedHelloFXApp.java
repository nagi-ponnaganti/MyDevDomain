package com.nagihome.javafx.chapter01;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImprovedHelloFXApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		Label nameLbl = new Label("Enter Your Name: ");
		TextField nameText = new TextField("Name");
		Label textMsg = new Label();
		textMsg.setStyle("-fx-text-fill: blue;");
		Button submitBtn = new Button("Submit");
		Button exitBtn = new Button("Exit");

		submitBtn.setOnAction(e -> {
			if (nameText.getText().length() > 0) {
				textMsg.setText("Hello " + nameText.getText());
			} else {
				textMsg.setText("Hello There");
			}
		});

		exitBtn.setOnAction(e -> Platform.exit());

		VBox root = new VBox(5);
		root.getChildren().addAll(nameLbl, nameText, textMsg, submitBtn, exitBtn);
		
		Scene scene = new Scene(root, 500, 300);
		
		stage.setScene(scene);
		stage.setTitle("Improved Hello World Application");
		
		stage.show();
		
	}

}
