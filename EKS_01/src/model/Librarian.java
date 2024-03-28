package model;

public class Librarian {
    private String name;
    private String surname;
    private String personCode;
    private boolean isAdminLibrarian;

    public Librarian() throws Exception {
        setName("Jebediah");
        setSurname("Grass");
        setPersonCode("000000-00000");
        setAdminLibrarian(false);
    }

    public Librarian(String name, String surname, String personCode, boolean isAdminLibrarian) throws Exception {
        setName(name);
        setSurname(surname);
        setPersonCode(personCode);
        setAdminLibrarian(isAdminLibrarian);
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

    public void setAdminLibrarian(boolean isAdminLibrarian) {
        this.isAdminLibrarian = isAdminLibrarian;
    }

    public String getName() {
        return name;
    }
    public String getPersonCode() {
        return personCode;
    }
    public String getSurname() {
        return surname;
    }
    public boolean getIsAdminLibrarian() {
        return isAdminLibrarian;
    }

    public String toString() {
        return "[ "+ this.name + "," + this.surname + "," + this.personCode + "," + this.isAdminLibrarian + " ]";
    }
}
