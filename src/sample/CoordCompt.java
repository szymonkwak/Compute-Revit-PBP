package sample;

public class CoordCompt {

    public static double distanceBtwPoints(PointNE p1, PointNE p2){
        return Math.sqrt( Math.pow((p2.getN()-p1.getN()),2) + Math.pow((p2.getE()-p1.getE()),2) );

    }
    public static double distanceBtwPoints(PointNE p1, double N, double E){
        return Math.sqrt( Math.pow((N-p1.getN()),2) + Math.pow((E-p1.getE()),2) );

    }

    private static double czwartak (double dN, double dE){

        double czRadian = -1, Azimuth = -1;

        //Obliczenie czwartaka
        if (dN != 0) {
            czRadian = Math.atan(Math.abs(dE) / Math.abs(dN));
        } else if (dN == 0 & dE > 0 ){
            Azimuth = ( Math.PI * 0.5 ); // 90stopni
        } else if (dN == 0 & dE < 0 ){
            Azimuth = ( Math.PI * 1.5 ); // 270stopni
        }

        //Obliczenie azymutu w zależności od ćwiartki
        if (dE >= 0 & dN >0){
            Azimuth = czRadian;
        } else if (dE >= 0 & dN < 0){
            Azimuth = Math.PI - czRadian;
        } else if (dE <= 0 & dN < 0) {
            Azimuth = Math.PI +  czRadian;
        } else if (dE <= 0 & dN > 0) {
            Azimuth = (Math.PI * 2) - czRadian;
        }

        return Azimuth;
    }

    //Metoda oblicza Azymut od p1 do p2. Wynik w radianach
    public static double azimuth(PointNE p1, PointNE p2){

        double dN = p2.getN() - p1.getN();
        double dE = p2.getE() - p1.getE();

       return czwartak(dN,dE);

    }
    public static double azimuth(PointNE p1, double N, double E){

        double czRadian = 0, czDegree, Azimuth = -1;

        double dN = N - p1.getN();
        double dE = E - p1.getE();

        return czwartak(dN,dE);
    }
    public static double azimuth(double N, double E, PointNE p2){

        double czRadian = 0, czDegree, Azimuth = -1;

        double dN = p2.getN() - N;
        double dE = p2.getE() - E;

        return czwartak(dN,dE);
    }

    public static double computeCoordN(PointNE point, double distance, double azimuth){
        //double N_PBP = glob1.getN() + ( CoordCompt.DistanceBtwPoints(loc1,0,0) * Math.cos(p1_PBP_AzimRad) );
        return point.getN() + ( distance * Math.cos(azimuth) );
    }
    public static double computeCoordE(PointNE point, double distance, double azimuth) {
        return point.getE() + (distance * Math.sin(azimuth));
    }

    public static double radToDegrees(double a){
        return (a * 360) / (2 * Math.PI);
    }

    public static double degreesToRad(double a){
        return (a / 360) * (2 * Math.PI);
    }


}
