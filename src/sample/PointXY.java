package sample;

public class PointXY {

    private double X;
    private double Y;

    public PointXY(double x, double y) {
        X = x;
        Y = y;
    }

    public void setX(double x) {
        X = x;
    }
    public void setY(double y) {
        Y = y;
    }

    public double getX() {
        return X;
    }
    public double getY() {
        return Y;
    }

    public String XtoString(){
        return String.valueOf(X);
    }
    public String YtoString(){
        return String.valueOf(Y);
    }
}
