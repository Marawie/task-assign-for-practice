import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Developer
//Jest albo frontendowcem albo backendowcem, ma okreslone seniority
//(JUNIOR,MID,SENIOR), posiada Task czyli
//zadanie ktore ma do wykonania.
//Developer moze zglosic ze zadanie jest zrobione jak rowniez zaraportowac ilsoc czasu
//poswiecona na jego wykonanie np 5 godzin.
public class Developer extends Person {
    private String whoProgrammerYouAre;
    private String seniority;
    private String reportAfterTasks;
    private int howManyHoursSpendOnTask;

    public List<Task> getTasks() {
        return tasks;
    }

    private List<Task> tasks;
    Person person;

    Scanner scanner = new Scanner(System.in);


    private List<Developer> ourProgrammer = new ArrayList<>();

    public List<Developer> getOurProgrammer() {
        return ourProgrammer;
    }

    public String getWhoProgrammerYouAre() {
        return whoProgrammerYouAre;
    }

    public String getSeniority() {
        return seniority;
    }

    public String getReportAfterTasks() {
        return reportAfterTasks;
    }

    public int getHowManyHoursSpendOnTask() {
        return howManyHoursSpendOnTask;
    }


    public Developer(String whoProgrammerYouAre, String seniority) {
        super();
        System.out.println("What's your first name?");
        String firstName = scanner.next();
        System.out.println("What's your last name?");
        String lastName = scanner.next();
        System.out.println("What's your age?");
        int age = scanner.nextInt();
        this.person = new Person(firstName, lastName, age);
        this.whoProgrammerYouAre = whoProgrammerYouAre;
        this.seniority = seniority;
        this.tasks = new ArrayList<>();
    }
// stworze kilka instacji zeby dodac je do listy, zeby miec na czym operowac jako teamleader


    public Person getPerson() {
        return person;
    }

    public Developer() {
    }

    @Override
    public String toString() {
        return "Your main tech and seniority lvl: " + whoProgrammerYouAre + " " + seniority + " " + person + getOurProgrammer();
    }
}


