package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        for(Train t : trains){
            if(t.getDeparture().equals(tfDep.getText())
                    &&t.getArrival().equals(tfArr.getText())
                    && LocalDate.from(t.getDateDep()).equals(date.getValue())){
                ta1.appendText(t.getTrainNumber()+" ");
            }
        }
    }

    public void admin() throws IOException {
        Stage stage = new Stage();
        if(tfDep.getText().equals("admin")&&tfArr.getText().equals("admin"))
            FXMLDocumentController(stage);
    }

    protected void FXMLDocumentController(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
