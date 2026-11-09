
public class Patient {

    private String id;
    private String name;
    private int age;
    private String reason;

    public Patient(String id, String name, int age, String reason) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id
                + "\nName: " + name
                + "\nAge: " + age
                + "\nReason: " + reason;
    }
}
