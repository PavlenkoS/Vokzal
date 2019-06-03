package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Models.DataBase;
import sample.Models.Train;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    private TextArea ta1;
    @FXML
    private TextField tfDep;
    @FXML
    private TextField tfArr;
    @FXML
    private DatePicker date;
    @FXML
    private Label labelTickets;

    public static int tickets=0;

    public void find() throws IOException, ClassNotFoundException {
        ta1.setText("");
        List<Train> trains = DataBase.getTrains();
        if(tfDep.getText().equals("ALL")){
            ta1.appendText("Всі поїзди: ");
            for (Train t : trains){
                ta1.appendText("\nНомер " + t.getTrainNumber() + " з " +t.getDeparture()+" до "
                        +t.getArrival()+ ", відбуття " + t.getDateArrive());
            }
        }else {
            ta1.appendText("Можливі поїзди на цю дату: ");
            for (Train t : trains) {
                if (t.getDeparture().equals(tfDep.getText())
                        && t.getArrival().equals(tfArr.getText())
                        && t.getDateDep().equals(date.getValue())) {
                    ta1.appendText("\nНомер " + t.getTrainNumber() + ", прибуття " + t.getDateArrive() + ",\nВільних місць " +
                            t.getFreePlace() + ", ціна за місце " + t.getPlaceCost());
                }
            }
        }
    }

    public void updateTickets(){
        labelTickets.setText("Куплено квитків "+tickets);
    }

    public void admin() throws IOException {
        if(tfDep.getText().equals("admin")&&tfArr.getText().equals("admin")){
            URL url = new File("src/sample/admin.fxml").toURL();
            FXMLDocumentController(new Stage(), url);
        }
    }

    public void buy() throws IOException {
        URL url = new File("src/sample/purchase.fxml").toURL();
        FXMLDocumentController(new Stage(), url);
    }

    protected void FXMLDocumentController(Stage stage, URL file) throws IOException {
        Parent root = FXMLLoader.load((file));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
