package constants;

public interface Constants {
    String MENU = "Enter action (add, remove, edit, count, list, exit): ";

    String MENU_CONTACT_TYPE = "Enter the type (person, organization): ";

    String SHOW_CONTACTS = "%d. %s %s";

    String INPUT_NAME = "Enter the name: ";

    String INPUT_NAME_ORGANIZATION = "Enter the organization name: ";

    String INPUT_SURNAME = "Enter the surname of the person: ";

    String INPUT_PHONE = "Enter the number: ";

    String INPUT_GENDER = "Enter the gender (M, F): ";

    String INPUT_BIRTHDAY = "Enter the birth date: ";

    String INPUT_ADDRESS = "Enter the address: ";

    String INPUT_GENERAL = "Enter the %s: ";

    String SELECT_RECORD = "Select a record: ";

    String COUNT_DIRECTORY = "The Phone Book has %s records.";

    String EMPTY_LIST = "No records to list";

    String EMPTY_EDIT = "No records to edit";

    String EMPTY_REMOVE = "No records to remove";

    String WRONG_PHONE = "Wrong number format!";

    String UPDATE_CONTACT = "The record updated!";

    String INVALID = "Invalid";

    String NAME = "name";

    String ADDRESS = "address";

    String SURNAME = "surname";

    String NUMBER = "number";

    String BIRTH = "birth";

    String GENDER = "gender";

    String ADD = "add";

    String REMOVE = "remove";

    String EDIT = "edit";

    String COUNT = "count";

    String INFO = "info";

    String EXIT = "exit";

    String PERSON = "person";

    String ORGANIZATION = "organization";

    String EMPTY = "";

    String NEWLINE = "\n";

    String REGEX_NUMBER = "^\\+?([\\da-zA-Z]{1,}[\\s-]?)?(\\([\\da-zA-Z]{2,}(\\)[\\s-]|\\)$))?([\\da-zA-Z]{2,}[\\s-]?)*([\\da-zA-Z]{2,})?$";

    String REGEX_POSITIVE_INTEGER = "^[1-9][0-9]*$";

    String UPDATE_NEW_VALUE = "Enter %s: ";

    String NO_NUMBER = "[no number]";

    String NO_DATA = "[no data]";

    String VALUES_TO_UPDATE_PEOPLE = "Select a field (name, surname, birth, gender, number): ";

    String VALUES_TO_UPDATE_ORGANIZATION = "Select a field (address, number): ";

    String FORMAT_PERSON = """
            Name: %s
            Surname: %s
            Birth date: %s
            Gender: %s
            Number: %s
            Time created: %s
            Time last edit: %s""";

    String FORMAT_ORGANIZATION = """
            Organization name: %s
            Address: %s
            Number: %s
            Time created: %s
            Time last edit: %s""";
}
