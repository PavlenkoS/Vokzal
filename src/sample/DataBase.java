package sample;

import java.io.*;
import java.util.List;

public class DataBase {

    public static List<Train> getTrains() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("trains.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Train> trains = (List<Train>) ois.readObject();
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
