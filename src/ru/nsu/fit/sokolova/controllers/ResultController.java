package ru.nsu.fit.sokolova.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ru.nsu.fit.sokolova.algorithm.AlgorithmContainer;

import java.io.IOException;


public class ResultController
{
    private static final String INPUT_FORM_PATH = "/ru/nsu/fit/sokolova/views/inputForm.fxml";
    private static final String PROGRAM_TITLE = "RSA";
    private static final double RESULT_WIDTH = 600;
    private static final double RESULT_HEIGHT = 400;

    @FXML
    private Label result;

    @FXML
    private Label originalMessage;

    @FXML
    private Button tryAgain;

    @FXML
    void initialize()
    {
        tryAgain.setOnAction(event ->
        {
            Stage thisStage = (Stage)tryAgain.getScene().getWindow();
            thisStage.close();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource(INPUT_FORM_PATH));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle(PROGRAM_TITLE);
            stage.setScene(new Scene(root, RESULT_WIDTH, RESULT_HEIGHT));
            stage.show();
        });

    }

    public void setResult(AlgorithmContainer algorithmContainer)
    {
        originalMessage.setText(String.valueOf(algorithmContainer.getOriginalMessage()));
        result.setText(String.valueOf(algorithmContainer.getDecryptedMessage()));
    }
}

