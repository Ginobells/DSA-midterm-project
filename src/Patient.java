
public class Patient {

    private String txtid;
    private String txtname;
    private int txtage;
    private String txtreason;

    public Patient(String id, String name, int age, String reason) {
        this.txtid = id;
        this.txtname = name;
        this.txtage = age;
        this.txtreason = reason;
    }

    public String getId() {
        return txtid;
    }

    public String getName() {
        return txtname;
    }

    public int getAge() {
        return txtage;
    }

    public String getReason() {
        return txtreason;
    }

    @Override
    public String toString() {
        return txtid + " - " + txtname + " - " + txtage + " - " + txtreason;
    }
}
