/**
 * 
 */
package com.nagihome.fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author nageswararao
 *
 */
public class HelloWorld extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Button button = new Button();
		button.setText("Say 'Hello World'");
		button.setOnAction(new EventHandler<ActionEvent>() {

			/* (non-Javadoc)
			 * @see javafx.event.EventHandler#handle(javafx.event.Event)
			 */
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
			}
		});

		StackPane root = new StackPane();
		root.getChildren().add(button);

		Scene scene = new Scene(root, 300, 250);
		stage.setTitle("Hello World Window");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
