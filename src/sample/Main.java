package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.FindProperty;

import java.awt.*;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Compute PBP");
        primaryStage.setScene(new Scene(root, 300, 500));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);

        PointXY p1 = new PointXY(0,0);
        PointXY p2 = new PointXY(10,10);
        System.out.println(CoordintesComputation.DistanceBtwPoints(p1,p2));



    }
}
