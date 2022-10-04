package com.example.oop1;


import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;


public class MyCircle implements com.example.oop1.Circle {
    private Circle circle;
    private double radius;
    private double centerX;
    private double centerY;
    private final String[] colors = new String[]{"BLUE", "RED", "YELLOW", "BLACK", "GREEN", "DARKRED", "MAGENTA", "CYAN", "WHITE", "GRAY", "PINK", "ORANGE"};

    public MyCircle(double radius, double centerX, double centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    void moveTo(String position) {
        switch (position) {
            case ("left") -> circle.setCenterX(circle.getCenterX() - 10);
            case ("right") -> circle.setCenterX(circle.getCenterX() + 10);
        }
    }

    @Override
    public void setRadius(double radius) {
        circle.setRadius(radius);
    }

    void setRandomColor() {
        int random = new Random().nextInt(colors.length);
        circle.setFill(Paint.valueOf(colors[random]));
    }


    public void random() {
        int randomX = new Random().nextInt(1000);
        int randomY = new Random().nextInt(500);
        circle.setCenterX(randomX);
        circle.setCenterY(randomY);
    }


    void increaseRadius() {
        circle.setRadius(circle.getRadius() - 5);
    }

    void reduceRadius() {
        circle.setRadius(circle.getRadius() + 5);
    }


    public Circle create() {
        circle = new Circle(centerX, centerY, radius);
        return circle;
    }


}
