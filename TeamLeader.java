//TEAM LEADER
//Team leader ma miec pole Developer ktore przechowywac bedzie developera ktory jest jego
//podopiecznym w projekcie.
//Ma miec mozliwosc przydzielenia zadania do developera jak rowniez zabrania zadania
//developerowi.
//To zadaniem team leadera jest stworzenie zadania oraz jego wycena (liczba godzin
//potrzebnych na wykonanie danego zadania).
//Team leader moze przydzielic zadanie tylko swojemu podopiecznemu (np. pracujacemu
//tylko na froncie lub tylko na backendzie)

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TeamLeader extends Developer {
    Scanner scanner;
    Developer developer;
    List<Developer> programmerList;

    public List<Developer> getProgrammerList() {
        return programmerList;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public HashMap<List<Task>, Integer> getMapOfTasksAndHours() {
        return mapOfTasksAndHours;
    }

    HashMap<List<Task>, Integer> mapOfTasksAndHours;

    public TeamLeader() {
    }

    public TeamLeader(String whoProgrammerYouAre, String seniority) {
        super(whoProgrammerYouAre, seniority);
        this.programmerList = getOurProgrammer();
        this.mapOfTasksAndHours = new HashMap<>();
    }

    public void manageTeam() {
        Project project = new Project();
        Scanner scanner = new Scanner(System.in);
        int choice;

        boolean exit = false;

        System.out.println("There is 2 TL in our company, who you are?");
        System.out.println("1- Backend TeamLeader" + "\n" + "2- Frontend TeamLeader");
        int teamLeaderChoice = scanner.nextInt();
        if (teamLeaderChoice == 1) {
            TeamLeader teamLeaderBackend = new TeamLeader("Backend", "Senior");
        } else if (teamLeaderChoice == 2) {
            TeamLeader teamLeaderFrontend = new TeamLeader("Frontend", "Senior");

        } else throw new IllegalArgumentException();

        while (!exit) {
            System.out.println("\nTeam Leader Menu:");
            System.out.println("1. View Developers!");
            System.out.println("2. Assign Task!");
            System.out.println("3. View Task Estimations!");
            System.out.println("4. Revoke Task!");
            System.out.println("5. Add new developer to team!");
            System.out.println("6. Create new project!");
            System.out.println("7. View information about project!");
            System.out.println("8. Exit!");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewDevelopers();
                    break;
                case 2:
                    assignTask();
                    break;
                case 3:
                    viewTaskEstimations();
                    break;
                case 4:
                    revokeTask();
                    break;
                case 5:
                    addNewDeveloper();
                    break;
                case 6:
                    project.createProject();
                    break;
                case 7:
                    project.displayProjectInfo();
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewDevelopers() {
        System.out.println("Developers in the team:");
        if (getProgrammerList() != null) {
            for (int i = 0; i < getProgrammerList().size(); i++) {
                System.out.println(getProgrammerList().get(i));
            }
        } else {
            System.out.println("No programmers in the team.");
        }
    }

    private void assignTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the developer number to assign the task: ");
        int developerNumber = scanner.nextInt();

        if (developerNumber >= 1 && developerNumber <= getOurProgrammer().size()) {
            Developer developer = getOurProgrammer().get(developerNumber - 1);
            System.out.print("Enter the task description: ");
            String taskDescription = scanner.next();
            System.out.print("Enter the estimated hours for the task: ");
            int estimatedHours = scanner.nextInt();

            Task newTask = new Task(taskDescription, estimatedHours);
            developer.getTasks().add(newTask);

            System.out.println("Task assigned to " + developer.getPerson().getLastName());
        } else {
            System.out.println("Invalid developer number.");
        }
    }

    private void viewTaskEstimations() {
        System.out.println("Task Estimations:");
        for (Map.Entry<List<Task>, Integer> entry : mapOfTasksAndHours.entrySet()) {
            List<Task> tasks = entry.getKey();
            int estimation = entry.getValue();
            System.out.println("Tasks: " + tasks);
            System.out.println("Estimation (hours): " + estimation);
        }
    }

    private void revokeTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the task description to revoke: ");
        String taskDescription = scanner.next();

        for (Developer developer : getOurProgrammer()) {
            List<Task> tasks = developer.getTasks();
            for (Task task : tasks) {
                if (task.getDescriptionOfTask().equalsIgnoreCase(taskDescription)) {
                    tasks.remove(task);
                    System.out.println("Task revoked from " + developer.getLastName());
                }


            }
        }
    }
}