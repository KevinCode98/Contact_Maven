package model;

import constants.Constants;
import io.ConsoleScanner;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Directory implements Constants {
    private final ArrayList<Contact> contacts;

    public Directory() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void deleteContact(int position) {
        contacts.remove(position);
    }

    public int countContacts() {
        return contacts.size();
    }

    public String editContact(int position, String attribute) {
        if (contacts.isEmpty())
            return EMPTY_EDIT;

        Contact contactToEdit = contacts.get(position);
        String newValue = ConsoleScanner.insertString(UPDATE_NEW_VALUE.formatted(attribute));

        if(attribute.equals(NUMBER) && !newValue.matches(REGEX_NUMBER)){
            newValue = "";
        }

        return switch (attribute) {
            case NAME -> contactToEdit.editName(newValue);
            case SURNAME -> contactToEdit.editSurname(newValue);
            case NUMBER -> contactToEdit.editPhone(newValue);
            default -> INVALID;
        };
    }

    public String listContacts() {
        return contacts.isEmpty() ? EMPTY_LIST :
                contacts.stream().map(contact -> SHOW_CONTACTS.formatted(
                                contacts.indexOf(contact) + 1,
                                contact.getName(), contact.getSurname(), contact.getPhone()))
                        .collect(Collectors.joining(SCAPE));
    }
}
