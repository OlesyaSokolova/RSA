package ru.nsu.fit.sokolova;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    private static final String INPUT_FORM_PATH = "/ru/nsu/fit/sokolova/views/inputForm.fxml";
    private static final String PROGRAM_TITLE = "RSA";
    private static final double RESULT_WIDTH = 600;
    private static final double RESULT_HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource(INPUT_FORM_PATH));
        primaryStage.setTitle(PROGRAM_TITLE);
        primaryStage.setScene(new Scene(root, RESULT_WIDTH, RESULT_HEIGHT));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}