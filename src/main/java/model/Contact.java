package model;

import constants.Constants;

public class Contact implements Constants {
    private String name;
    private String surname;
    private String number;

    public Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = (number == null || number.trim().isEmpty()) ? "[no number]" : number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return number;
    }

    public String editName(String name) {
        this.name = name;
        return UPDATE_USER;
    }

    public String editSurname(String surname) {
        this.surname = surname;
        return UPDATE_USER;
    }

    public String editPhone(String number) {
        if (number.isEmpty()) {
            this.number = NO_NUMBER;
            return WRONG_PHONE;
        } else {
            this.number = number;
            return UPDATE_USER;
        }
    }
}
