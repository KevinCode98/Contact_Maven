package model;

import static constants.Constants.*;

public class Person extends Contact {
    private String surname;
    private String gender;
    private String birthday;

    public Person (String name, String surname, String number, String gender, String birthday) {
        super(name, number, true);
        this.surname = surname;
        this.gender = (gender == null || gender.trim().isEmpty())
                ? NO_DATA
                : gender;
        this.birthday = (birthday == null || birthday.trim().isEmpty())
                ? NO_DATA
                : birthday;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String editSurname(String surname) {
        this.surname = surname;
        return UPDATE_CONTACT;
    }

    public String editBirthday(String birthday) {
        this.birthday = birthday;
        return UPDATE_CONTACT;
    }

    public String editGender(String gender) {
        this.gender = gender;
        return UPDATE_CONTACT;
    }

}
