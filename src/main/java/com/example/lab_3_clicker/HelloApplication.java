package com.example.lab_3_clicker;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    private int score = 0;
    private int upgrades = 0;
    private int coutAmelioration = 10;
    private int automaticUwU = 0;
    private int perSecond = 1;

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("UwU Clicker");
        stage.setWidth(1000);
        stage.setHeight(600);

        //Scène 1
        Button button = new Button("UwU");
        button.setPrefSize(300, 300);
        button.setTranslateY(100);
        button.setTranslateX(100);

        Label texte = new Label("UwU Count: ");
        texte.setTranslateX(150);
        texte.setTranslateY(50);

        Label point = new Label("0");
        point.setTranslateX(300);
        point.setTranslateY(50);

        //Bouton principal
        button.setOnAction((event) -> {
            compteur();
            point.setText(Integer.toString(score));
        });

        Label texteAmelioration = new Label("Cout de l'amélioration : " + coutAmelioration);
        texteAmelioration.setTranslateX(150);
        texteAmelioration.setTranslateY(500);

        //Timer pour l'amélioration automatique
        final var temps = new PauseTransition(Duration.seconds(perSecond));
        var timer = new SequentialTransition(temps);
        temps.setOnFinished(event -> {
            score = score + automaticUwU;
            point.setText(String.valueOf(score));
        });
        timer.setCycleCount(PauseTransition.INDEFINITE);
        timer.play();

        //Améliorations
        Button more = new Button("More UwU");
        more.setOnAction((event) -> {
            if (score >= coutAmelioration) {
                upgrades++;
                score = score - coutAmelioration;
                coutAmelioration = coutAmelioration * 2;
                texteAmelioration.setText(Integer.toString(coutAmelioration));
            }
        });
        more.setTranslateY(100);
        more.setTranslateX(600);

        Button automatic = new Button("Good Luck UwU");
        automatic.setOnAction((event) -> {
            if (score >= coutAmelioration) {
                if (Math.random() * 1 >= 0.99) {
                    score = score + 100000;
                } else {
                    score = 0;
                }
                texteAmelioration.setText(Integer.toString(coutAmelioration));
            }
        });
        automatic.setTranslateY(200);
        automatic.setTranslateX(600);

        Button discount = new Button("Discount UwU");
        discount.setOnAction((event) -> {
            if (score >= coutAmelioration) {
                coutAmelioration = coutAmelioration / 2;
                texteAmelioration.setText(Integer.toString(coutAmelioration));
            }
        });
        discount.setTranslateY(300);
        discount.setTranslateX(600);

        Button faster = new Button("Faster UwU");
        faster.setOnAction((event) -> {
            if (score >= coutAmelioration) {
                score = score - coutAmelioration;
                perSecond = perSecond / 2;
                texteAmelioration.setText(Integer.toString(coutAmelioration));
            }
        });
        faster.setTranslateY(400);
        faster.setTranslateX(600);

        Button upgradeAutomatic = new Button("More UwU per second");
        upgradeAutomatic.setOnAction((event) -> {
            if (score >= coutAmelioration) {
                score = score - coutAmelioration;
                point.setText(String.valueOf(score));
                automaticUwU++;
                coutAmelioration = coutAmelioration * 2;
                texteAmelioration.setText(Integer.toString(coutAmelioration));
            }
        });
        upgradeAutomatic.setTranslateY(500);
        upgradeAutomatic.setTranslateX(600);

        //Groupe et affichage
        Group caracteresMenu = new Group(button, texte, point, texteAmelioration, more, automatic, discount, faster, upgradeAutomatic);
        Scene scene = new Scene(caracteresMenu);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void compteur() {
        score += 1 + upgrades;
    }
}