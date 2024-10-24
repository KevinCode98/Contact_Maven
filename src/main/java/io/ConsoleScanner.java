package io;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleScanner {
    public static Scanner sc = new Scanner(System.in);

    public static String insertValues(String message, String regex, String error, String menu) {
        ConsolePrinter.printInfo(message);
        return (scanValidate(regex, () -> {
            if(!menu.isEmpty())
                ConsolePrinter.printInfoLn(menu);

            ConsolePrinter.printInfoAndWaitForReturn(error);
        }));
    }

    public static String insertString(String message) {
        ConsolePrinter.printInfo(message);
        return sc.nextLine();
    }

    private static String scanValidate(String regex, Runnable invalidAction) {
        String input = sc.nextLine();
        while (!input.matches(regex)) {
            invalidAction.run();
            input = sc.nextLine();
        }

        return input;
    }

    private static void clean() {
        try {
            var clearCommand = System.getProperty("os.name").contains("Windows")
                    ? new ProcessBuilder("cmd", "/c", "cls")
                    : new ProcessBuilder("clear");
            clearCommand.inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
        }
    }
}
