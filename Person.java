package TaskAssignForPractice;

//Person
//zawiera podstawowe dane o osobie
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(){}

    @Override
    public String toString() {
        return "\n Information about you: " + firstName + " " + lastName + " " + age;

    }

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    };

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
