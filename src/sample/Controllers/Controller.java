package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Models.DataBase;
import sample.Models.Train;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class Controller {
    @FXML
    private Button bt1;
    @FXML
    private TextArea ta1;
    @FXML
    private TextField tfDep;
    @FXML
    private TextField tfArr;
    @FXML
    private DatePicker date;

    public void find() throws IOException, ClassNotFoundException {
        List<Train> trains = DataBase.getTrains();
        ta1.appendText("Можливі поїзди на цю дату: ");
        for(Train t : trains){
            if(t.getDeparture().equals(tfDep.getText())
                    && t.getArrival().equals(tfArr.getText())
                    && t.getDateDep().equals(date.getValue())){
                ta1.appendText("\nНомер "+t.getTrainNumber()+", прибуття "+t.getDateArrive()+",\nВільних місць "+
                        t.getFreePlace()+", ціна за місце "+t.getPlaceCost());
            }
        }
    }

    public void admin() throws IOException {
        if(tfDep.getText().equals("admin")&&tfArr.getText().equals("admin")){
            FXMLDocumentController(new Stage(), "admin.fxml");
        }
    }

    protected void FXMLDocumentController(Stage stage, String file) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(file));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
