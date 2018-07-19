package sample;

import javafx.geometry.Pos;
import javafx.scene.control.*;


import javax.swing.*;
import javax.xml.soap.Text;


public class Controller {

   //region Variables
   public Button btnCompute;
   public TextField txtLocalN1, txtLocalE1,
                    txtLocalN2, txtLocalE2,
                    txtLocalN3, txtLocalE3,
                    txtGlobalN1, txtGlobalE1,
                    txtGlobalN2, txtGlobalE2,
                    txtGlobalN3, txtGlobalE3,
           txtPBPE, txtPBPN, txtPBPAngle;
   //endregion

   //region Points instance creation
   PointNE loc1 = new PointNE(0,0);
   PointNE loc2 = new PointNE(0,0);
   PointNE loc3 = new PointNE(0,0);
   PointNE glob1 = new PointNE(0,0);
   PointNE glob2 = new PointNE(0,0);
   PointNE glob3 = new PointNE(0,0);
   //endregion

    private String showResult (double d){
        //Zamienia double na String i formatuje wyświetlanie na 0.000
        String str = String.format("%.3f",d);
        if (str.contains(",")) return str.replace(",",".");
        else return str;
    }

    private double textFieldToDouble (TextField txtField){
        return Double.parseDouble(txtField.getText());
    }

    private void setPointCoordinatesFromTextFieldData(PointNE point, TextField txtNorthing, TextField txtEasting){
        point.setN(textFieldToDouble(txtNorthing));
        point.setE(textFieldToDouble(txtEasting));
    }

    //To można jakoś poprawić
    public void showWarning(){
        JPanel jPanel = new JPanel();
        JOptionPane.showMessageDialog(jPanel,"Nieprawidłowe dane wejściowe","Błąd",JOptionPane.ERROR_MESSAGE);
    }





    public void btnOnClick(){

        txtPBPN.clear(); txtPBPE.clear(); txtPBPAngle.clear();
        //region Compute PBP_N, PBP_E, PBP_Angle
        try {
            setPointCoordinatesFromTextFieldData(loc1, txtLocalN1, txtLocalE1);
            setPointCoordinatesFromTextFieldData(loc2, txtLocalN2, txtLocalE2);
            setPointCoordinatesFromTextFieldData(glob1, txtGlobalN1, txtGlobalE1);
            setPointCoordinatesFromTextFieldData(glob2, txtGlobalN2, txtGlobalE2);

            double locAzim = CoordintesComputation.Azimuth(loc1,loc2);
            double globAzim = CoordintesComputation.Azimuth(glob1,glob2);
            double PBPAngle = globAzim - locAzim ;
            txtPBPAngle.setText(showResult(PBPAngle));

            double p1_00_Azim = CoordintesComputation.Azimuth(loc1,0,0);
            double p1_PBP_AzimRad = (( p1_00_Azim + PBPAngle ) / 360 ) * ( 2 * Math.PI );

            // N = N(p1) + distance(p1 -> 0,0)*cos(Azimuth(p1 -> 0,0)
            double N_PBP = CoordintesComputation.computeCoordinateN(glob1,CoordintesComputation.distanceBtwPoints(loc1,0,0),p1_PBP_AzimRad);
            double E_PBP = CoordintesComputation.computeCoordinateE(glob1,CoordintesComputation.distanceBtwPoints(loc1,0,0),p1_PBP_AzimRad);
            txtPBPN.setText(showResult(N_PBP));
            txtPBPE.setText(showResult(E_PBP));

        } catch (NumberFormatException e){
            showWarning();
        }
        //endregion


        //region Verification on point 3
        try {
            setPointCoordinatesFromTextFieldData(loc3, txtLocalN3, txtLocalE3);
            setPointCoordinatesFromTextFieldData(glob3, txtGlobalN3, txtGlobalE3);


        } catch (NumberFormatException e){}
        //endregion



        //Ustawić przecinek zamiast kropki-done
        //Kiedy błędne dane nie działa-done
        //Rozszerzyć txtField z Kątem
        //Sprawdzić czy dobrze liczy na prawdziwym przypadku

    }


}
