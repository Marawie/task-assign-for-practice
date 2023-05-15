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


    private List<Developer> OurProgrammer = new ArrayList<>();

    public List<Developer> getOurProgrammer() {
        return OurProgrammer;
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


    /* methods that can add dev like interview or sth like that
    -do poprawy trzeba zrobic tak zeby na samym koncu było wiadomo ilu mamy developerów w teamie // obsluga wyjatkow
    -ale to zrobie potem
    -kazdy dev jest osoba wiec trzeba tez to zrobic
    -moglem w sumie zrobic to za pomoca operatora || w if i polaczyc to, jak bede mial czas to poprawie
    -nie wiem dlaczego nie dodaja sie obiekty do listy chociaz zwracam liste i mam metode toString[edit: usunąłem toString()]
     teraz widze ze po usunieciu ja widze ze obiekt jest dodany wiec moze problem z tym? nie wiem dlaczego*/
    public void addNewDeveloper() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to join our team? Y/N");
        String choice = scanner.next();

        while (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N")) {
            System.out.println("Invalid choice. Please enter 'Y' or 'N'.");
            choice = scanner.next();
        }

        if (choice.equalsIgnoreCase("Y")) {
            System.out.println("Are you a Backend or Frontend developer?");
            String whoTheProgrammerIs = scanner.next();

            while (!whoTheProgrammerIs.equalsIgnoreCase("Backend") && !whoTheProgrammerIs.equalsIgnoreCase("Frontend")) {
                System.out.println("Invalid choice. Please enter 'Backend' or 'Frontend'.");
                whoTheProgrammerIs = scanner.next();
            }

            System.out.println("What is your seniority level? Junior/Mid/Senior");
            String seniority = scanner.next().toUpperCase();

            while (!seniority.equals("JUNIOR") && !seniority.equals("MID") && !seniority.equals("SENIOR")) {
                System.out.println("Invalid choice. Please enter 'Junior', 'Mid', or 'Senior'.");
                seniority = scanner.next().toUpperCase();
            }

            Developer newDev = new Developer(whoTheProgrammerIs, seniority);
            System.out.println(newDev);

            getOurProgrammer().add(newDev);
            System.out.println("Welcome to our team, " + newDev.person.getFirstName().toUpperCase() + "!");

        } else if (choice.equalsIgnoreCase("N")) {
            System.out.println(":( You chose not to join our team.");
        }
    }
}


