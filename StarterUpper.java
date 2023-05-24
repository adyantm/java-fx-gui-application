package com.example.workingdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

/**
 * This class represents a com.example.demo.StarterUpper application.
 *
 * @author adyantm.
 * @version 1.0.
 */
public class StarterUpper extends Application {

    public static ArrayList<StartUpIdea> ideas = new ArrayList<StartUpIdea>();
    private File saveFile = null;

    /**
     * Main method.
     *
     * @param args String.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Sets and builds the stage for the application.
     *
     * @param primaryStage Stage.
     */
    @Override
    public void start(Stage primaryStage) {
        TextField problem = new TextField();
        Label problem1 = new Label("What is the problem? ");
        TextField target = new TextField();
        Label target1 = new Label("Who is the target customer? ");
        TextField howBadly = new TextField();
        Label howBadly1 = new Label("How badly does the customer NEED "
                + "this problem fixed(1-10)? ");
        TextField people = new TextField();
        Label people1 = new Label("How many people do you know who might"
                + " experience this problem? ");
        TextField howBig = new TextField();
        Label howBig1 = new Label("How big is the target market? ");
        TextField comp = new TextField();
        Label comp1 = new Label("Who are the competitors/existing solutions? ");
        TextField extraQuestion = new TextField();
        Label extraQuestion1 = new Label("How cost effective "
                + "is the solution? ");
        Button button = new Button();
        button.setText("Add Idea");

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String problemCheck = problem1.getText();
                if (problemCheck.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Error detected, please "
                            + "tell us the problem");
                    alert.show();
                    return;
                }
                String problemA = problemCheck;

                String targetProblem = target.getText();
                if (targetProblem.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Error detected, please tell us "
                            + "the target customer");
                    alert.show();
                    return;
                }

                String targetA = targetProblem;

                try {
                    int badly1 = Integer.parseInt(howBadly.getText());
                    if (badly1 > 10 || badly1 < 1) {
                        Alert a2 = new Alert(Alert.AlertType.NONE);
                        a2.setAlertType(Alert.AlertType.ERROR);
                        a2.setContentText("Invalid Number Entered "
                                + "Enter a number between 1-10");
                        a2.show();
                        return;
                    }
                    int getBad = badly1;
                } catch (NumberFormatException nfe) {
                    Alert a3 = new Alert(Alert.AlertType.NONE);
                    a3.setAlertType(Alert.AlertType.ERROR);
                    a3.setContentText("Invalid Number Entered "
                            + "Enter a number between 1-10");
                    a3.show();
                    return;
                }
                int badA = Integer.parseInt(howBadly.getText());


                try {
                    int getPeople = Integer.parseInt(people.getText());
                    if (getPeople < 0) {
                        Alert a4 = new Alert(Alert.AlertType.NONE);
                        a4.setAlertType(Alert.AlertType.ERROR);
                        a4.setContentText("Invalid Number Entered "
                                + "Enter a number greater than 0");
                        a4.show();
                        return;
                    }
                    int addPeople = getPeople;
                } catch (NumberFormatException nfe) {
                    Alert a5 = new Alert(Alert.AlertType.NONE);
                    a5.setAlertType(Alert.AlertType.ERROR);
                    a5.setContentText("Invalid Number Entered "
                            + "Enter a number greather than 0");
                    a5.show();
                    return;
                }
                int peopleA = Integer.parseInt(people.getText());

                try {
                    int getBig = Integer.parseInt(howBig.getText());
                } catch (NumberFormatException nfe) {
                    Alert a6 = new Alert(Alert.AlertType.NONE);
                    a6.setAlertType(Alert.AlertType.ERROR);
                    a6.setContentText("Error: Please enter a number");
                    a6.show();
                    return;
                }
                int bigA = Integer.parseInt(howBig.getText());

                String probComp = comp.getText();
                if (probComp.isEmpty()) {
                    Alert a7 = new Alert(Alert.AlertType.NONE);
                    a7.setAlertType(Alert.AlertType.ERROR);
                    a7.setContentText("Error: Please enter a correct answer");
                    a7.show();
                    return;
                }
                String compA = probComp;

                StartUpIdea idea1 = new StartUpIdea(problemA, targetA,
                        badA, peopleA, bigA, compA);
                ideas.add(idea1);
                problem.setText("");
                target.setText("");
                howBadly.setText("");
                people.setText("");
                howBig.setText("");
                comp.setText("");
            }
        };
        button.setOnAction(event);

        Button button2 = new Button();
        button2.setText("Sorting Ideas");
        button2.setOnAction(eventNew -> Collections.sort(ideas));

        Button button3 = new Button();
        button3.setText("Reset Form");
        EventHandler<ActionEvent> reset = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert x = new Alert(Alert.AlertType.ERROR);
                x.setTitle("Delete File");
                x.setContentText("Are you sure you want "
                        + "to reset the list of ideas");
                Optional<ButtonType> optional = x.showAndWait();
                if (optional.get() == ButtonType.OK) {
                    ideas.clear();
                    problem.setText("");
                    target.setText("");
                    howBadly.setText("");
                    people.setText("");
                    howBig.setText("");
                    comp.setText("");
                    saveFile.delete();
                }
            }
        };
        button3.setOnAction(reset);

        Button button4 = new Button();
        button4.setText("Save Form");
        EventHandler<ActionEvent> save = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveFile = new File("ideas.txt");
                boolean saveNow = FileUtil.saveIdeasToFile(ideas, saveFile);
            }
        };
        button4.setOnAction(save);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.add(problem1, 0, 0, 8, 2);
        gridPane.add(problem, 12, 0);
        gridPane.add(target1, 0, 2, 8, 2);
        gridPane.add(target, 12, 2);
        gridPane.add(howBadly1, 0, 4, 8, 2);
        gridPane.add(howBadly, 12, 4);
        gridPane.add(people1, 0, 6, 8, 2);
        gridPane.add(people, 12, 6);
        gridPane.add(howBig1, 0, 8, 8, 2);
        gridPane.add(howBig, 12, 8);
        gridPane.add(comp1, 0, 10, 8, 2);
        gridPane.add(comp, 12, 10);
        Label label = new Label("Adyant Mishra");
        label.setFont(Font.font("Times New Roman", 20));
        gridPane.add(label, 0, 35);
        gridPane.add(button, 0, 36);
        gridPane.add(button2, 2, 36);
        gridPane.add(button3, 4, 36);
        gridPane.add(button4, 6, 36);
        Image image = new Image("File:image/new-USA-of-startups-map-2.15.17-V6.png");
        gridPane.getChildren().add(new ImageView(image));

        primaryStage.setTitle("Problem Ideation Form");
        Scene scene = new Scene(gridPane, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

