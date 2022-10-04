package com.example.oop1;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class HelloApplication extends Application {
    AnchorPane anchorPane = new AnchorPane();
    int min = 2;
    int max = 5;
    int random = (int) Math.floor(Math.random() * (max - min + 1) + min);
    Circle[] circles = new Circle[random];
    Line[] lines = new Line[random];
    Rectangle[] rectangles = new Rectangle[random];

    Button buttonRightOfCircle = new Button("вправо круг");
    Button buttonLeftOfCircle = new Button("влево круг");
    Button buttonLeftOfCircleRadiusPlus = new Button("больше радиус круга");
    Button buttonLeftOfCircleRadiusMinus = new Button("меньше радиус круга");
    MyCircle circle = new MyCircle(30, 50, 50);

    Button buttonLineRotateOfRight = new Button("перевернуть вправо линию");
    Button buttonLineRotateLeft = new Button("перевернуть влево линию");
    Button buttonLineLeft = new Button("влево линию");
    Button buttonLineRight = new Button("вправо линию");
    MyLine line = new MyLine(50, 30, 150, 30);

    Button buttonRectanglePositionYMinus = new Button("вниз прямоугольник");
    Button buttonRectanglePositionYPlus = new Button("вверх прямоугольник");
    Button buttonChangeColorRectangle = new Button("очистить прямоугольник");
    MyRectangle rectangle = new MyRectangle(100, 50, 200, 10, "RED");

    Button generalCircleRadius = new Button("рандом радиус для всех");
    Button generalLineLeft = new Button("перенести линию для всех");

    Button buttonRandomOfCircle = new Button("сгенерировать рандом круг");
    Button buttonRandomOfLine = new Button("сгенерировать линию");

    Button buttonRandomOfRectangle = new Button("сгенерировать прямоугольник");
    Button buttonRandomOfRectangleMoveToLeft = new Button("перенести прямоугольники влево");
    Button buttonRandomOfRectangleMoveToRight = new Button("перенести прямоугольники вправо");


    @Override
    public void start(Stage stage) {


        generalCircleRadius.setTranslateY(-90);

        generalLineLeft.setTranslateY(-90);
        generalLineLeft.setTranslateX(270);

        buttonRandomOfRectangle.setTranslateX(500);
        buttonRandomOfRectangle.setTranslateY(-50);


        buttonRandomOfRectangleMoveToLeft.setTranslateX(500);
        buttonRandomOfRectangleMoveToLeft.setTranslateY(-90);

        buttonRandomOfRectangleMoveToRight.setTranslateX(750);
        buttonRandomOfRectangleMoveToRight.setTranslateY(-90);


        buttonRandomOfCircle.setTranslateY(-50);

        buttonRightOfCircle.setTranslateX(-20);
        buttonRightOfCircle.setTranslateY(30);

        buttonLeftOfCircle.setTranslateX(-20);
        buttonLeftOfCircleRadiusPlus.setTranslateX(100);
        buttonLeftOfCircleRadiusMinus.setTranslateY(30);
        buttonLeftOfCircleRadiusMinus.setTranslateX(100);

        buttonRandomOfLine.setTranslateY(-50);
        buttonRandomOfLine.setTranslateX(230);

        buttonLineRotateOfRight.setTranslateX(280);
        buttonLineRotateLeft.setTranslateX(280);
        buttonLineRotateLeft.setTranslateY(30);

        buttonLineLeft.setTranslateX(440);
        buttonLineRight.setTranslateX(440);
        buttonLineRight.setTranslateY(30);


        buttonRectanglePositionYMinus.setTranslateX(640);
        buttonRectanglePositionYPlus.setTranslateX(640);
        buttonRectanglePositionYPlus.setTranslateY(30);
        buttonChangeColorRectangle.setTranslateX(840);


        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(buttonRightOfCircle);
        stackPane.getChildren().add(buttonLeftOfCircle);
        stackPane.getChildren().add(buttonLeftOfCircleRadiusMinus);
        stackPane.getChildren().add(buttonLeftOfCircleRadiusPlus);
        stackPane.getChildren().add(buttonRandomOfCircle);
        stackPane.getChildren().add(buttonLineLeft);
        stackPane.getChildren().add(buttonLineRight);
        stackPane.getChildren().add(buttonChangeColorRectangle);
        stackPane.getChildren().add(buttonLineRotateOfRight);
        stackPane.getChildren().add(buttonLineRotateLeft);
        stackPane.getChildren().add(buttonRectanglePositionYMinus);
        stackPane.getChildren().add(buttonRectanglePositionYPlus);
        stackPane.getChildren().add(generalCircleRadius);
        stackPane.getChildren().add(buttonRandomOfLine);
        stackPane.getChildren().add(generalLineLeft);
        stackPane.getChildren().add(buttonRandomOfRectangleMoveToLeft);
        stackPane.getChildren().add(buttonRandomOfRectangle);
        stackPane.getChildren().add(buttonRandomOfRectangleMoveToRight);


        buttonLeftOfCircle.setOnAction(event -> circle.moveTo("left"));
        buttonRightOfCircle.setOnAction(event -> circle.moveTo("right"));
        buttonLeftOfCircleRadiusMinus.setOnAction(event -> circle.increaseRadius());
        buttonLeftOfCircleRadiusPlus.setOnAction(event -> circle.reduceRadius());

        buttonLineRight.setOnAction(event -> line.moveTo("right"));
        buttonLineLeft.setOnAction(event -> line.moveTo("left"));


        generalLineLeft.setOnAction(event -> {
            for (Line value : lines) {
                int randomRadius = new Random().nextInt(70);
                value.setLayoutY(randomRadius);
                value.setLayoutX(randomRadius);
                line.setLayoutX(randomRadius);
                line.setLayoutY(randomRadius);
            }
        });

        buttonRandomOfRectangleMoveToRight.setOnAction(event -> {

            for (Rectangle value : rectangles) {
                value.setTranslateX(value.getTranslateX() + 5);
            }

        });
        buttonRandomOfRectangleMoveToLeft.setOnAction(event -> {
            for (Rectangle value : rectangles) {
                value.setTranslateX(value.getTranslateX() - 5);
            }
        });

        generalCircleRadius.setOnAction(event -> {
            for (Circle value : circles) {
                int randomRadius = new Random().nextInt(70);
                value.setRadius(randomRadius);
                circle.setRadius(randomRadius);
            }
        });

        buttonChangeColorRectangle.setOnAction(event -> {
            for (int i = 0; i < random; i++) {
                anchorPane.getChildren().remove(rectangles[i]);
                anchorPane.getChildren().remove(rectangle);
                rectangle = null;
                rectangles[i] = null;
            }


        });


        buttonRandomOfRectangle.setOnAction(event -> {
            buttonRandomOfRectangle.setTranslateX(1000);
            buttonRandomOfRectangle.setTranslateY(1000);
            for (int i = 0; i < random; i++) {
                int x = new Random().nextInt(500);
                int y = new Random().nextInt(250);
                int translateX = new Random().nextInt(500);
                int translateY = new Random().nextInt(250);
                rectangles[i] = new MyRectangle(x, y, translateX, translateY).create();
                anchorPane.getChildren().add(rectangles[i]);
            }
        });


        buttonRandomOfLine.setOnAction(event -> {
            buttonRandomOfLine.setTranslateX(1000);
            buttonRandomOfLine.setTranslateX(1000);
            for (int i = 0; i < random; i++) {
                int startX = new Random().nextInt(1000);
                int startY = new Random().nextInt(500);
                int endX = new Random().nextInt(1000);
                int endY = new Random().nextInt(500);
                lines[i] = new MyLine(startX, startY, endX, endY).create();
                anchorPane.getChildren().add(lines[i]);
            }
        });

        buttonRandomOfCircle.setOnAction(event -> {
            buttonRandomOfCircle.setTranslateX(1000);
            buttonRandomOfCircle.setTranslateY(1000);
            for (int i = 0; i < random; i++) {
                int randomX = new Random().nextInt(1000);
                int randomY = new Random().nextInt(500);
                int randomRadius = new Random().nextInt(70);
                circles[i] = new MyCircle(randomRadius, randomX, randomY).create();
                anchorPane.getChildren().add(circles[i]);
            }
        });


        buttonLineRotateOfRight.setOnAction(event -> line.rotateTo("right"));
        buttonLineRotateLeft.setOnAction(event -> line.rotateTo("left"));

        buttonRectanglePositionYPlus.setOnAction(event -> rectangle.moveTo("up"));
        buttonRectanglePositionYMinus.setOnAction(event -> rectangle.moveTo("down"));

        anchorPane.getChildren().add(circle.create());
        anchorPane.getChildren().add(line.create());
        anchorPane.getChildren().add(rectangle.create());
        anchorPane.getChildren().add(stackPane);
        AnchorPane.setBottomAnchor(stackPane, 30d);

        Scene scene = new Scene(anchorPane, 1000, 500);
        stage.setTitle("управление фигурой");
        stage.setScene(scene);
        stage.show();
    }

}
