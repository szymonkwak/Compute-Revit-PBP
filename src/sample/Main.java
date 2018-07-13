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
        primaryStage.setScene(new Scene(root, 288, 530));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);

        PointNE p1 = new PointNE(0,0);
        PointNE p2 = new PointNE(10,0);
        System.out.println(CoordintesComputation.DistanceBtwPoints(p1,p2));
        System.out.println(CoordintesComputation.Azimuth(p1,p2));



    }
}
