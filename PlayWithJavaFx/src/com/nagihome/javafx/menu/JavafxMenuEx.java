package com.nagihome.javafx.menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavafxMenuEx extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		MenuItem menuItem1 = new MenuItem("Option 01");
		menuItem1.setOnAction(value -> System.out.println("menuitem 1 is clicked"));
		
		MenuItem menuItem2 = new MenuItem("Option 02");
		menuItem2.setOnAction(value -> System.out.println("menuitem 2 is clicked"));

		MenuItem menuItem3 = new MenuItem("Option 03");
		menuItem3.setOnAction(value -> System.out.println("menuitem 3 is clicked"));

		MenuItem menuItem4 = new MenuItem("Option 04");
		menuItem4.setOnAction(value -> System.out.println("menuitem 4 is clicked"));

		MenuButton menuButton = new MenuButton("Options", null, menuItem1, menuItem2, menuItem3, menuItem4);

		HBox hBox = new HBox(menuButton);
		
		Scene scene = new Scene(hBox, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
