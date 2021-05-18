package ru.nsu.fit.sokolova.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.nsu.fit.sokolova.algorithm.AlgorithmContainer;
import ru.nsu.fit.sokolova.algorithm.keys.OpenKey;

import java.io.IOException;

public class InputFormController
{
    private static final String RESULT_PATH = "/ru/nsu/fit/sokolova/views/result.fxml";
    private static final String PROGRAM_TITLE = "RSA";
    private static final String EMPTY_STRING = "";

    @FXML
    private Label openKey;

    @FXML
    private TextField input;

    @FXML
    private Label n;

    @FXML
    private Button startButton;

    @FXML
    void initialize()
    {
        AlgorithmContainer algorithmContainer = new AlgorithmContainer();
        OpenKey key = algorithmContainer.getOpenKey();
        openKey.setText(key.toString());
        n.setText(String.valueOf(key.getN()));

        startButton.setOnAction(event ->
        {
            String inputText = input.getText();
            if(inputText != EMPTY_STRING)
            {
                int originalMessage = Integer.valueOf(inputText);

                if(originalMessage < key.getN())
                {
                    Stage thisStage = (Stage)startButton.getScene().getWindow();
                    thisStage.close();

                    algorithmContainer.perform(originalMessage);

                    FXMLLoader fxmlLoader_ = new FXMLLoader(getClass().getResource(RESULT_PATH));
                    Scene scene  = null;
                    try {
                        scene = new Scene(fxmlLoader_.load());
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    Stage resultStage = new Stage();
                    resultStage.setScene(scene);

                    ResultController resultController = fxmlLoader_.getController();
                    resultController.setResult(algorithmContainer);

                    resultStage.setTitle(PROGRAM_TITLE);
                    resultStage.show();
                }
            }
        });
    }
}

