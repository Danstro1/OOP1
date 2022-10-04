package com.example.oop1;

import javafx.scene.shape.Line;

import java.util.Random;

public class MyLine implements com.example.oop1.Line {

    private int startX;
    private int startY;
    private int endX;
    private final int endY;

    private Line line;

    public MyLine(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

    }

    void moveTo(String position) {
        switch (position) {
            case ("left") -> line.setLayoutX(line.getLayoutX() - 5);
            case ("right") -> line.setLayoutX(line.getLayoutX() + 5);
        }
    }

    public void setLayoutX(double x){
        line.setLayoutX(x);
    }

    public void setLayoutY(double x){
        line.setLayoutY(x);
    }

    @Override
    public void random() {
        int randomX = new Random().nextInt(1000);
        int randomY = new Random().nextInt(500);
        line.setLayoutX(randomX);
        line.setLayoutY(randomY);
    }

    void rotateTo(String position){
        switch (position) {
            case ("left") -> line.setRotate(line.getRotate() - 5);
            case ("right") -> line.setRotate(line.getRotate() + 5);
        }
    }

    public void setRotate(double rotate) {
        line.setRotate(rotate);
    }

    public Line getLine() {
        return line;
    }
    @Override
    public Line create() {
        line = new Line(startX, startY, endX, endY);
        return line;
    }

}
