package model;

import model.person.Person;

public class Driver extends Person{
    private static long auto_dID = 0;
    
    private long dID;
    private String licenseNo;
    private float experienceInYears;

    public Driver() throws Exception {
        super();
        this.dID = auto_dID++;
        setLicenseNo("AA123456");
        setExperienceInYears((float) 1.5);
    }

    public Driver(String name, String surname, String personCode) throws Exception {
        super(name, surname, personCode);
        this.dID = auto_dID++;
    }

    public void setLicenseNo(String licenseNo) throws Exception {
        if (licenseNo != null && licenseNo.matches("[A-Z]{2}[0-9]{6}")) {
            this.licenseNo = licenseNo;
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments");    
    }

    public void setExperienceInYears(float experienceInYears) throws Exception {
        if (experienceInYears > 0) {
            this.experienceInYears = experienceInYears;  
            return;
        }
        throw new IllegalArgumentException("[ERROR]: invalid arguments");    
    }

    public long getdID() {
        return dID;
    }
    public String getLicenseNo() {
        return licenseNo;
    }
    public float getExperienceInYears() {
        return experienceInYears;
    }

    public String toString() {
        return "[ " + super.getName() + " , " + super.getSurname() + " , " + super.getPersonCode() + " ]:[" + this.dID + " , " + this.licenseNo + " , " + this.experienceInYears + "]";
    }
}
