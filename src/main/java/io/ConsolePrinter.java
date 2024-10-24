package io;

import constants.Constants;

import java.lang.constant.Constable;

public class ConsolePrinter implements Constants {
    public static void printInfo(String message) {
        System.out.print(message);
    }

    public static void printInfoLn(String message) {
        System.out.println(message);
    }

    public static void printInfoAndWaitForReturn(String message) {
        System.out.print(message);
        ConsoleScanner.insertValues(EMPTY, EMPTY, EMPTY, EMPTY);
    }
}
