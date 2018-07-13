package sample;

public class CoordintesComputation {

    public static double DistanceBtwPoints(PointNE p1, PointNE p2){
        return Math.sqrt( Math.pow((p2.getN()-p1.getN()),2) + Math.pow((p2.getE()-p1.getE()),2) );

    }

    //Metoda oblicza Azymut od p1 do p2. Wynik w stopniach
    public static double Azimuth (PointNE p1, PointNE p2){

        double czRadian = 0, czDegree, AzimuthDegree = -1;

        double dN = p2.getN() - p1.getN();
        double dE = p2.getE() - p1.getE();

       //Obliczenie czwartaka
        if (dN != 0) {
            czRadian = Math.atan(Math.abs(dE) / Math.abs(dN));
        } else if (dN == 0 & dE > 0 ){
            AzimuthDegree = 90;
        } else if (dN == 0 & dE < 0 ){
            AzimuthDegree = 270;
        }
         czDegree = ( czRadian / (2*Math.PI) ) * 360;

        //Obliczenie azymutu w zależności od ćwiartki
        if (dE >= 0 & dN >0){
            AzimuthDegree = czDegree;
        } else if (dE >= 0 & dN < 0){
            AzimuthDegree = 180 - czDegree;
        } else if (dE <= 0 & dN < 0) {
            AzimuthDegree = 180 +  czDegree;
        } else if (dE <= 0 & dN > 0) {
            AzimuthDegree = 360 - czDegree;
        }

        return AzimuthDegree;
    }

}
