package com.nagihome.javafx.layout;

import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GroupLayoutEx extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label nameLbl = new Label("Name: ");
		nameLbl.setLayoutX(10);
		nameLbl.setLayoutY(10);

		TextField nameTxtFld = new TextField();
		NumberBinding nameFldXBinding = nameLbl.layoutXProperty().add(nameLbl.widthProperty().add(10));
		nameTxtFld.layoutXProperty().bind(nameFldXBinding);
		nameTxtFld.layoutYProperty().bind(nameLbl.layoutYProperty());

		Label passwdLbl = new Label("Password: ");
		NumberBinding passwdXBinding = nameTxtFld.layoutXProperty().add(nameTxtFld.widthProperty().add(10));
		passwdLbl.layoutXProperty().bind(passwdXBinding);
		passwdLbl.layoutYProperty().bind(nameTxtFld.layoutYProperty());

		TextField passwdFld = new TextField();
		NumberBinding passwdFldXBinding = passwdLbl.layoutXProperty().add(passwdLbl.widthProperty().add(10));
		passwdFld.layoutXProperty().bind(passwdFldXBinding);
		passwdFld.layoutYProperty().bind(passwdLbl.layoutYProperty());

		Button loginButton = new Button("Login");
		NumberBinding buttonXBinding = passwdFld.layoutXProperty().add(passwdFld.widthProperty().add(10));
		loginButton.layoutXProperty().bind(buttonXBinding);
		loginButton.layoutYProperty().bind(passwdFld.layoutYProperty());
		// NumberBinding login

		Group group = new Group(nameLbl, nameTxtFld, passwdLbl, passwdFld, loginButton);

		Scene scene = new Scene(group);
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
