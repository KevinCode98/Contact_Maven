package controller;

import io.ConsolePrinter;
import io.ConsoleScanner;
import model.Contact;
import model.Directory;
import model.Organization;
import model.Person;

import static constants.Constants.*;

import java.util.Map;

public class MainMenuController implements Runnable {
    private final Directory directory;

    public MainMenuController() {
        directory = new Directory();
    }

    @Override
    public void run() {
        mainMenuLoop();
    }

    private void mainMenuLoop() {
        Choice choice;

        do {
            choice = (Choice) getMenu(Choice.class.getName(), MENU);
            if (choice == null)
                ConsolePrinter.printInfoLn(INVALID);
            else {
                getMenuAction(choice).run();
                ConsolePrinter.printInfoLn("");
            }
        } while (choice != Choice.EXIT);
    }

    private Enum getMenu(String type, String menu) {
        String choice = ConsoleScanner.insertString(menu);
        if (type.equals(Choice.class.getName()))
            return CHOICE_MAP.getOrDefault(choice, null);
        else if (type.equals(ContactTypeEnum.class.getName()))
            return TYPE_MAP.getOrDefault(choice, null);
        return null;
    }

    // Methods from the menu
    private Runnable getMenuAction(Choice choice) {
        return Map.<Choice, Runnable>of(
                Choice.ADD, this::addContact,
                Choice.REMOVE, this::removeContact,
                Choice.EDIT, this::editContact,
                Choice.COUNT, this::countContact,
                Choice.LIST, this::listContacts,
                Choice.EXIT, this::exit
        ).get(choice);
    }

    private Runnable getMenuContact(ContactTypeEnum contactTypeEnum) {
        return Map.<ContactTypeEnum, Runnable>of(
                ContactTypeEnum.PERSON, this::addPerson,
                ContactTypeEnum.ORGANIZATION, this::addOrganization
        ).get(contactTypeEnum);
    }

    private void addPerson() {
        String name = ConsoleScanner.insertString(INPUT_NAME);
        String surname = ConsoleScanner.insertString(INPUT_SURNAME);
        String gender = ConsoleScanner.insertString(INPUT_GENDER);
        String birthday = ConsoleScanner.insertString(INPUT_BIRTHDAY);
        String phone = ConsoleScanner.insertString(INPUT_PHONE);

        if (!phone.matches(REGEX_NUMBER))
            phone = "";

        directory.addContact(new Person(name, surname, phone, gender, birthday));
        ConsolePrinter.printInfoLn("The record added.");
    }

    private void addOrganization() {
        String name = ConsoleScanner.insertString(INPUT_NAME_ORGANIZATION);
        String address = ConsoleScanner.insertString(INPUT_ADDRESS);
        String phone = ConsoleScanner.insertString(INPUT_PHONE);

        if (!phone.matches(REGEX_NUMBER))
            phone = "";

        directory.addContact(new Organization(name, phone, address));
        ConsolePrinter.printInfoLn("The record added.");
    }

    public void addContact() {
        ContactTypeEnum contactTypeEnum = (ContactTypeEnum) getMenu(ContactTypeEnum.class.getName(), MENU_CONTACT_TYPE);
        if (contactTypeEnum == null) {
            ConsolePrinter.printInfoLn(INVALID);
        } else {
            getMenuContact(contactTypeEnum).run();
        }
    }
    public void removeContact() {
        if (directory.countContacts() == 0)
            ConsolePrinter.printInfoLn(EMPTY_REMOVE);
        else {
            ConsolePrinter.printInfoLn(directory.listContacts());
            int position = Integer.parseInt(ConsoleScanner.insertValues(SELECT_RECORD,
                    REGEX_POSITIVE_INTEGER, SELECT_RECORD, EMPTY));

            if (position >= 1 && position <= directory.countContacts())
                directory.deleteContact(position - 1);
            else
                ConsolePrinter.printInfoLn(INVALID);
        }
    }

    public void editContact() {
        if (directory.countContacts() == 0) {
            ConsolePrinter.printInfoLn(EMPTY_EDIT);
        } else {
            ConsolePrinter.printInfoLn(directory.listContacts());
            int position = Integer.parseInt(ConsoleScanner.insertValues(SELECT_RECORD,
                    REGEX_POSITIVE_INTEGER, SELECT_RECORD, EMPTY));

            if (position >= 1 && position <= directory.countContacts()) {
                Contact contact = directory.getContact(position - 1);

                String attribute = (contact.isPerson())
                        ? ConsoleScanner.insertString(VALUES_TO_UPDATE_PEOPLE)
                        : ConsoleScanner.insertString(VALUES_TO_UPDATE_ORGANIZATION);
                ConsolePrinter.printInfoLn(directory.editContact(position - 1, attribute));
            } else {
                ConsolePrinter.printInfoLn(INVALID);
            }
        }
    }

    public void countContact() {
        ConsolePrinter.printInfoLn(COUNT_DIRECTORY.formatted(directory.countContacts()));
    }

    public void listContacts() {
        if (directory.countContacts() == 0) {
            ConsolePrinter.printInfoLn(EMPTY_REMOVE);
        } else {
            ConsolePrinter.printInfoLn(directory.listContacts());
            int position = Integer.parseInt(ConsoleScanner.insertValues(SELECT_RECORD,
                    REGEX_POSITIVE_INTEGER, SELECT_RECORD, EMPTY));

            if (position >= 1 && position <= directory.countContacts())
                ConsolePrinter.printInfoLn(directory.showInfo(position - 1));
            else
                ConsolePrinter.printInfoLn(INVALID);
        }
    }

    public void exit() {
    }

    private final Map<String, Choice> CHOICE_MAP = Map.of(
            ADD, Choice.ADD,
            REMOVE, Choice.REMOVE,
            EDIT, Choice.EDIT,
            COUNT, Choice.COUNT,
            INFO, Choice.LIST,
            EXIT, Choice.EXIT
    );

    private final Map<String, ContactTypeEnum> TYPE_MAP = Map.of(
            PERSON, ContactTypeEnum.PERSON,
            ORGANIZATION, ContactTypeEnum.ORGANIZATION
    );
}
