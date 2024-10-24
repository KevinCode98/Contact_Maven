package controller;

import io.ConsolePrinter;
import io.ConsoleScanner;
import model.Contact;
import model.Directory;
import constants.Constants;

import java.util.Map;

public class MainMenuController implements Runnable, Constants {
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
            choice = (Choice) getMenu(Choice.class.getName(), MENU, EMPTY);
            if (choice == null)
                ConsolePrinter.printInfoLn(INVALID);
            else
                getMenuAction(choice).run();
        } while (choice != Choice.EXIT);
    }

    private Enum getMenu(String type, String menu, String regex) {
        String choice = ConsoleScanner.insertString(menu);

        return switch (choice) {
            case ADD -> Choice.ADD;
            case REMOVE -> Choice.REMOVE;
            case EDIT -> Choice.EDIT;
            case COUNT -> Choice.COUNT;
            case LIST -> Choice.LIST;
            case EXIT -> Choice.EXIT;
            default -> null;
        };
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

    public void addContact() {
        String name = ConsoleScanner.insertString(INPUT_NAME);
        String surname = ConsoleScanner.insertString(INPUT_SURNAME);
        String phone = ConsoleScanner.insertString(INPUT_PHONE);

        if (!phone.matches(REGEX_NUMBER))
            phone = "";

        directory.addContact(new Contact(name, surname, phone));
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
        if (directory.countContacts() == 0)
            ConsolePrinter.printInfoLn(EMPTY_EDIT);
        else {
            ConsolePrinter.printInfoLn(directory.listContacts());
            int position = Integer.parseInt(ConsoleScanner.insertValues(SELECT_RECORD,
                    REGEX_POSITIVE_INTEGER, SELECT_RECORD, EMPTY));

            if (position >= 1 && position <= directory.countContacts()) {
                String attribute = ConsoleScanner.insertString(VALUES_TO_UPDATE);

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
        ConsolePrinter.printInfoLn(directory.listContacts());
    }

    public void exit() {
    }
}
