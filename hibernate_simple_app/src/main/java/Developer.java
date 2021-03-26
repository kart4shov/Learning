public class Developer {

    private int id;

    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String firstName;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String specialty;

    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty){
        this.specialty = specialty;
    }

    private int experience;

    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Developer() {

    }

    public Developer(String firstName, String lastName, String specialty, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", experience=" + experience +
                '}';
    }
}
