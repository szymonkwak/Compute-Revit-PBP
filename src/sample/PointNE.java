package sample;

public class PointNE {
    private double N;
    private double E;

    public PointNE(double n, double e) {
        N = n;
        E = e;
    }

    public void setN(double n) {
        N = n;
    }
    public void setE(double e) {
        E = e;
    }

    public double getN() {
        return N;
    }
    public double getE() {
        return E;
    }

    public String NtoString (){
        return String.valueOf(N);
    }
    public String EtoString (){
        return String.valueOf(E);
    }
}
