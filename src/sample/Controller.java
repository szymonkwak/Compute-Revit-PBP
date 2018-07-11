package sample;

import javafx.scene.control.*;



public class Controller {


   public Button btnCompute;
   public TextField txtLocalN1, txtPBPN;

    public double TextFieldToDouble (TextField txtField){
        return Double.parseDouble(txtField.getText());
    }

    PointXY local1 = new PointXY(0,0);
    PointXY local2 = new PointXY(0,0);

    public void btnOnClick(){
        local1.setX(TextFieldToDouble(txtLocalN1));
        txtPBPN.setText(local1.XtoString());


   }


}
