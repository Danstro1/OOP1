package com.example.oop1;


import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class MyRectangle implements com.example.oop1.Rectangle {
    private Rectangle rectangle;
    private final double X;
    private final double Y;
    private final double translateX;
    private final double translateY;
    private String color = "";
    private final String[] Colors = new String[] {"BLUE","RED","YELLOW","BLACK","GREEN","DARKRED","MAGENTA","CYAN","WHITE","GRAY","PINK","ORANGE"};




    public MyRectangle(double X, double Y,double translateX,double translateY) {
        this.X = X;
        this.Y = Y;
        this.translateX = translateX;
        this.translateY = translateY;
    }

    public MyRectangle(double X, double Y,double translateX,double translateY,String color){
        this.X = X;
        this.Y = Y;
        this.translateX = translateX;
        this.translateY = translateY;
        this.color = color;
    }

    @Override
    public void random() {
        int randomX = new Random().nextInt(1000);
        int randomY = new Random().nextInt(500);
        rectangle.setTranslateX(randomX);
        rectangle.setTranslateY(randomY);
    }
    @Override
    public Rectangle create() {
        rectangle = new Rectangle(X, Y);
        if (!color.equals("")){
            rectangle.setFill(Paint.valueOf(color));

        }
        rectangle.setTranslateX(translateX);
        rectangle.setTranslateY(translateY);
        return rectangle;
    }


    void randomColor(){
        int randomColor = new Random().nextInt(Colors.length);
        rectangle.setFill(Paint.valueOf(Colors[randomColor]));
    }

    void moveTo(String position){
        switch (position){
            case "up":
                rectangle.setY(rectangle.getY() + 5);
                break;
            case "down":
                rectangle.setY(rectangle.getY() - 5);
                break;

        }
    }

}
