package AeroTaxi;

public class User {

    private String name;
    private String lastName;
    private String DNI;
    private int age;

    public User(String name, String lastName, String DNI, int age) {
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
        this.age = age;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DNI='" + DNI + '\'' +
                ", age=" + age +
                '}';
    }
}
