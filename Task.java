// Task ma opis, informacje czy jest na front czy na backend, wycene godzinowa, osobe
//odpowiedzialna za jego wykonanie, osobe odpowiedzialna za jego sprawdzenie,
//ma status (W TOKU, OCZEKUJACY, WYKONANY)

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Task {
    Scanner scanner = new Scanner(System.in);

    private String descriptionOfTask;
    private String howWouldGetThisTask;
    private int howManyHours;
    private String forWhoThisTaskIs;
    private String statusOfTask;

    public Task(String taskDescription, int estimatedHours) {
        this.descriptionOfTask = taskDescription;
        this.howManyHours = estimatedHours;
    }

    // zrobilem to ale nie wiem czy sie przyda moze cos z tym pokminie

    public String getDescriptionOfTask() {
        return descriptionOfTask;
    }

    public String getHowWouldGetThisTask() {
        return howWouldGetThisTask;
    }

    public int getHowManyHours() {
        return howManyHours;
    }

    public String getForWhoThisTaskIs() {
        return forWhoThisTaskIs;
    }

    public String getStatusOfTask() {
        return statusOfTask;
    }

}
