package shilaev.librarymanager.models;

public class Client {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymicName;
    private String birthday;
    private String phone;
    private String email;

    public Client(int id, String lastName, String firstName, String patronymicalName, String birthday, String phone, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymicName = patronymicalName;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }
}
