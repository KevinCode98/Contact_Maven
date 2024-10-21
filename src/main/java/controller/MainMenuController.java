package controller;

import io.ConsolePrinter;
import io.ConsoleScanner;
import model.Contact;

public class MainMenuController implements Runnable {

    @Override
    public void run() {
        addContact();
    }

    public void addContact() {
        String firstName = ConsoleScanner.insertValues("Enter the name of the person:\n", "", "", "");
        String surname = ConsoleScanner.insertValues("Enter the surname of the person:\n", "", "", "");
        String phone = ConsoleScanner.insertValues("Enter the number:\n", "", "", "");

        Contact contact = new Contact(firstName, surname, phone);

        ConsolePrinter.printInfoLn("");
        ConsolePrinter.printInfoLn("A record created!");
        ConsolePrinter.printInfoLn("A Phone Book with a single record created!");
    }
}
