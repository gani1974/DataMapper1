public class Person {
    private int idPerson;
    private String lastName;
    private String firstName;

    public Person() {
    }

    public Person(int idPerson, String firstName, String lastName) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
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
}
