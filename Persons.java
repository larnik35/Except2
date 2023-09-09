
public class Persons {
    private String secondName;
    private String firstName;
    private String midleName;
    private long phone;

    public Persons(String secondName, String firstName, String midleName, long phone) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.midleName = midleName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%d>", secondName, firstName, midleName, phone);
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMidleName() {
        return midleName;
    }

    public long getPhone() {
        return phone;
    }
}
