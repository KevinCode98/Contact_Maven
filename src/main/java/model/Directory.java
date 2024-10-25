package model;

import static constants.Constants.*;
import io.ConsoleScanner;

import java.time.Instant;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Directory {
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

    public Contact getContact(int position) {
        return contacts.get(position);
    }

    public String editContact(int position, String attribute) {
        String result;
        Contact contact = getContact(position);
        if (contact.isPerson()) {
            String newAttribute = (!attribute.equals(BIRTH))
                    ? ConsoleScanner.insertString(INPUT_GENERAL.formatted(attribute))
                    : ConsoleScanner.insertString(INPUT_BIRTHDAY);

            Person person = (Person) contact;
            result = switch (attribute) {
                case NAME -> person.editName(newAttribute);
                case SURNAME -> person.editSurname(newAttribute);
                case BIRTH -> person.editBirthday(newAttribute);
                case GENDER -> person.editGender(newAttribute);
                case NUMBER -> person.editPhone(newAttribute);
                default -> throw new IllegalStateException("Unexpected value: " + attribute);
            };
        } else {
            String newAttribute = ConsoleScanner.insertString(INPUT_GENERAL.formatted(attribute));

            Organization organization = (Organization) contact;
            result = switch (attribute) {
                case NUMBER -> organization.editPhone(newAttribute);
                case ADDRESS -> organization.editAddress(newAttribute);
                default -> throw new IllegalStateException("Unexpected value: " + attribute);
            };
        }
        contact.setUpdatedAt(Instant.now());
        return result;
    }

    public String listContacts() {
        return contacts.isEmpty()
                ? EMPTY_LIST
                : contacts.stream().map(contact -> {
            if (contact.isPerson()) {
                Person person = (Person) contact;
                return SHOW_CONTACTS.formatted(
                        contacts.indexOf(contact) + 1,
                        person.getName(),
                        person.getSurname()
                );
            } else {
                Organization organization = (Organization) contact;
                return SHOW_CONTACTS.formatted(
                        contacts.indexOf(contact) + 1,
                        organization.getName(),
                        EMPTY
                );
            }

        }).collect(Collectors.joining(NEWLINE));
    }

    /**
     * @param position position of the contact in the directory
     * @return String with all the info of the contact
     */
    public String showInfo(int position) {
        Contact contact = getContact(position);

        if (contact.isPerson()) {
            Person person = (Person) contact;
            return FORMAT_PERSON.formatted(
                    person.getName(),
                    person.getSurname(),
                    person.getBirthday(),
                    person.getGender(),
                    person.getPhone(),
                    person.getCreatedAt(),
                    person.getUpdatedAt()
            );
        } else {
            Organization organization = (Organization) contact;
            return FORMAT_ORGANIZATION.formatted(
                    organization.name,
                    organization.getAddress(),
                    organization.getPhone(),
                    organization.getCreatedAt(),
                    organization.getUpdatedAt()
            );
        }
    }
}
