package model.person;

public class Person {
    private String name;
    private String surname;
    private String personCode;

    public Person() throws Exception {
        setName("Jebediah");
        setSurname("Grass");
        setPersonCode("000000-00000");
    }

    public Person(String name, String surname, String personCode) throws Exception {
        setName(name);
        setSurname(surname);
        setPersonCode(personCode);
    }

    public void setName(String name) throws Exception {
        if (name != null && name.matches("[A-Z]{1}[a-z]+(( [A-Z]{1}[a-z]+)?)+") && name.length() < 100) {
            this.name = name;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments");
    }

    public void setSurname(String surname) throws Exception {
        if (surname != null && surname.matches("[A-Z]{1}[a-z]+(( [A-Z]{1}[a-z]+)?)+") && surname.length() < 100) {
            this.surname = surname;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments");
    }

    public void setPersonCode(String personCode) throws Exception {
        if (personCode != null && personCode.matches("[0-9]{6}-[0-9]{5}")) {
            this.personCode = personCode;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments");
    }

    public String toString() {
        return "[ "+ this.name + " , " + this.surname + " , " + this.personCode + " ]";
    }
}
