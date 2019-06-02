package sample.Models;

import java.io.Serializable;
import java.time.LocalDate;

public class Train implements Serializable {
    private int trainNumber;
    private String departure;
    private String arrival;
    private LocalDate dateDep;
    private LocalDate dateArrive;
    private int freePlace;
    private int placeCost;

    public Train(int trainNumber, String departure, String arrival, LocalDate dateDep, LocalDate dateArrive, int freePlace, int placeCost) {
        this.trainNumber = trainNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.dateDep = dateDep;
        this.dateArrive = dateArrive;
        this.freePlace = freePlace;
        this.placeCost = placeCost;
    }

    public Train() {
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public LocalDate getDateDep() {
        return dateDep;
    }

    public void setDateDep(LocalDate dateDep) {
        this.dateDep = dateDep;
    }

    public LocalDate getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(LocalDate dateArrive) {
        this.dateArrive = dateArrive;
    }

    public int getFreePlace() {
        return freePlace;
    }

    public void setFreePlace(int freePlace) {
        this.freePlace = freePlace;
    }

    public int getPlaceCost() {
        return placeCost;
    }

    public void setPlaceCost(int placeCost) {
        this.placeCost = placeCost;
    }
}
