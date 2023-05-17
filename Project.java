package TaskAssignForPractice;//Project
//zawiera opis, developera teamleadera , liste technologii uzywanych w projekcie (moze byc
//po prostu jako string). Date startu (Doczytaj o localdate albo uzyj stringa), date
//przewidywanego zakonczenia, tytul projektu, oraz klienta
//ktory z niego korzysta

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project {
    Project project;
    private String description;
    private TeamLeader teamLeader;

    private List<String> technologies;
    private LocalDate startProject;
    private LocalDate endProject;
    private String projectName;
    private String customer;

    public String getDescription() {
        return description;
    }

    public TeamLeader getTeamLeader() {
        return teamLeader;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public LocalDate getStartProject() {
        return startProject;
    }

    public LocalDate getEndProject() {
        return endProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getCustomer() {
        return customer;
    }

    public Project() {
    }

    public Project(String description, TeamLeader teamLeader, List<String> technologies, LocalDate startProject, LocalDate endProject, String projectName, String customer) {
        this.description = description;
        this.teamLeader = teamLeader;
        this.technologies = technologies;
        this.startProject = startProject;
        this.endProject = endProject;
        this.projectName = projectName;
        this.customer = customer;

    }

    public Project createProject() {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter project description:");
        String description = scanner.nextLine();

        System.out.println("Choose team leader:");
        System.out.println("1. Frontend Team Leader");
        System.out.println("2. Backend Team Leader");

        int choice = scanner.nextInt();
        scanner.nextLine();

//cos chce z tym pokminic jak cos wymysle to dodam tu, na razie zostawiam to tak

        if (choice == 1) {
            TeamLeader teamLeaderFrontend = new TeamLeader("Frontend", "Senior");
        } else if (choice == 2) {
            TeamLeader teamLeaderBackend = new TeamLeader("Backend", "Senior");
        } else {
            throw new IllegalArgumentException("Invalid choice");
        }

        System.out.println("Enter technologies used in the project (one per line, enter 'done' to finish):");
        List<String> technologies = new ArrayList<>();
        String technology;
        while (!(technology = scanner.nextLine()).equalsIgnoreCase("done")) {
            technologies.add(technology);
        }

        System.out.println("Enter project start date (YYYY-MM-DD):");
        String startDateString = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(startDateString);

        System.out.println("Enter project end date (YYYY-MM-DD):");
        String endDateString = scanner.nextLine();
        LocalDate endDate = LocalDate.parse(endDateString);

        System.out.println("Enter project name:");
        String projectName = scanner.nextLine();

        System.out.println("Enter client name:");
        String clientName = scanner.nextLine();

        return new Project(description, teamLeader, technologies, startDate, endDate, projectName, clientName);
    }

    public void displayProjectInfo() {
        try {
            System.out.println("Project Information:");

            System.out.println("Title: " + this.project.getProjectName());
            System.out.println("Description: " + this.project.getDescription());
            System.out.println("Customer: " + this.project.getCustomer());
            System.out.println("Start Date: " + this.project.getStartProject());
            System.out.println("End Date: " + this.project.getEndProject());
            System.out.println("Technologies: " + this.project.getTechnologies());
            System.out.println("Team Leader: " + getTeamLeader().getFirstName() + " " + getTeamLeader().getLastName());
        } catch (NullPointerException e) {
            System.out.println("We don't have any project right now!");

        }
    }
}

