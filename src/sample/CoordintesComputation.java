package sample;

public class CoordintesComputation {

    public static double Azimuth (double x1, double y1, double x2, double y2){
        //obliczanie azymutu
        return 0;
    }

    public static double DistanceBtwPoints(PointXY p1, PointXY p2){
        return Math.sqrt( Math.pow((p2.getX()-p1.getX()),2) + Math.pow((p2.getY()-p1.getY()),2) );

    }
}
