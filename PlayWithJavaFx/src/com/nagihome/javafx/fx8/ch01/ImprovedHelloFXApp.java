package com.nagihome.javafx.fx8.ch01;

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
    public void start(Stage primaryStage) throws Exception {
        Label nameLbl = new Label("Enter the Name: ");
        TextField text = new TextField("enter here");
        Label msg = new Label();
        msg.setStyle("-fx-fill-text: blue;");

        Button sayHelloBtn = new Button("Say Hello");
        Button exitBtn = new Button("Exit");
        sayHelloBtn.setOnAction((e) -> {
            if (text.getText() != null)
                msg.setText(sayHelloBtn.getText() + " " + text.getText());
            else
                msg.setText(sayHelloBtn.getText());
        });
        exitBtn.setOnAction(e -> Platform.exit());

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.getChildren().addAll(nameLbl, text, msg, sayHelloBtn, exitBtn);

        Scene scene = new Scene(vBox, 300, 300);
        scene.setRoot(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World Application");
        primaryStage.show();
    }
}
