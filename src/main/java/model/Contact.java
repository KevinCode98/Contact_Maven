package model;

import constants.Constants;
import utils.DateUtil;

import java.time.Instant;

public abstract class Contact implements Constants {
    protected String name;
    protected String number;
    final protected boolean isPerson;
    final protected Instant createdAt;
    protected Instant updatedAt;

    public Contact(String name, String number, boolean isPerson) {
        this.name = name;
        this.number = (number == null || number.trim().isEmpty())
                ? Constants.NO_NUMBER
                : number;
        this.isPerson = isPerson;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return number;
    }

    public String getNumber() {
        return number;
    }

    public String getCreatedAt() {
        return DateUtil.formatModelTimestamp(createdAt);
    }

    public String getUpdatedAt() {
        return DateUtil.formatModelTimestamp(updatedAt);
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isPerson() {
        return isPerson;
    }

    public String editName(String name) {
        this.name = name;
        return Constants.UPDATE_CONTACT;
    }

    public String editPhone(String number) {
        if (number.isEmpty()) {
            this.number = Constants.NO_NUMBER;
            return Constants.WRONG_PHONE;
        } else {
            this.number = number;
            return Constants.UPDATE_CONTACT;
        }
    }
}
