package constants;

public interface Constants {
    String MENU = "Enter action (add, remove, edit, count, list, exit): ";

    String SHOW_CONTACTS = "%d. %s %s, %s";

    String INPUT_NAME = "Enter the name of the person: ";

    String INPUT_SURNAME = "Enter the surname of the person: ";

    String INPUT_PHONE = "Enter the number: ";

    String SELECT_RECORD = "Select a record: ";

    String COUNT_DIRECTORY = "The Phone Book has %s records.";

    String EMPTY_LIST = "No records to list";

    String EMPTY_EDIT = "No records to edit";

    String EMPTY_REMOVE = "No records to remove";

    String WRONG_PHONE = "Wrong number format!";

    String UPDATE_USER = "The record updated!";

    String INVALID = "Invalid";

    String NAME = "name";

    String SURNAME = "surname";

    String NUMBER = "number";

    String ADD = "add";

    String REMOVE = "remove";

    String EDIT = "edit";

    String COUNT = "count";

    String LIST = "list";

    String EXIT = "exit";

    String EMPTY = "";

    String SCAPE = "\n";

    String REGEX_NUMBER = "^\\+?([\\da-zA-Z]{1,}[\\s-]?)?(\\([\\da-zA-Z]{2,}(\\)[\\s-]|\\)$))?([\\da-zA-Z]{2,}[\\s-]?)*([\\da-zA-Z]{2,})?$";

    String REGEX_POSITIVE_INTEGER = "^[1-9][0-9]*$";

    String UPDATE_NEW_VALUE = "Enter %s: ";

    String NO_NUMBER = "[no number]";

    String VALUES_TO_UPDATE = "Select a field (name, surname, number): ";
}
