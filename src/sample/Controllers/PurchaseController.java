package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sample.Models.DataBase;
import sample.Models.Train;

import java.io.IOException;
import java.util.List;

public class PurchaseController {
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private DatePicker date;
    @FXML
    private Button bt1;

    public void buy() throws IOException, ClassNotFoundException {
        List<Train> trains = DataBase.getTrains();
        for (Train t : trains){
            if(date.getValue().equals(t.getDateDep())&&Integer.parseInt(tf1.getText())==(t.getTrainNumber())){
                t.setFreePlace(t.getFreePlace()-1);
                Controller.tickets+=Integer.parseInt(tf2.getText());
                break;
            }
        }
        DataBase.saveTrains(trains);
    }
}
