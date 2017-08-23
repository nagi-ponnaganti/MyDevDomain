package com.nagihome.javafx.label;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFxLabelEx extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("JavaFx Label");
		
		Label label = new Label("This is Label");

		FileInputStream fio = new FileInputStream("resources/images/lion_image_1.jpg");
		Image image = new Image(fio, 500, 300, true, false);
		ImageView imageView = new ImageView(image);
		HBox hBox = new HBox(imageView, label);

		Scene scene = new Scene(hBox, 800, 600);

		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
