package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sample.Models.DataBase;
import sample.Models.Train;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class AdminController {
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;
    @FXML
    private TextField tf5;
    @FXML
    private DatePicker date1;
    @FXML
    private DatePicker date2;
    @FXML
    private Button bt1;

    public void addTrain() throws IOException, ClassNotFoundException {
        List<Train> trains = DataBase.getTrains();

        int num = Integer.parseInt(tf1.getText());
        String dep = tf2.getText();
        String arr = tf3.getText();
        int places = Integer.parseInt(tf4.getText());
        int cost = Integer.parseInt(tf5.getText());
        LocalDate dateDep = date1.getValue();
        LocalDate dateArr = date2.getValue();

        Train train = new Train(num, dep, arr, dateDep, dateArr, places, cost);
        trains.add(train);
        DataBase.saveTrains(trains);
    }


}
