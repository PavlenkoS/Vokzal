package sample.Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public static List<Train> getTrains() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("trains.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Train> trains;
        try {
            trains = (List<Train>) ois.readObject();
        }catch (Exception e){
            trains = new ArrayList<>();
            ois.close();
            return trains;
        }

        ois.close();
        return trains;
    }

    public static void saveTrains(List<Train> trains) throws IOException {
        FileOutputStream fos = new FileOutputStream("trains.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(trains);
        oos.close();
    }
}
