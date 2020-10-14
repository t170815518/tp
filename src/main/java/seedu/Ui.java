package seedu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *Represents the Class for functions related to the CLI User interface
 * and used to print out exception messages for troubleshooting purpose.
 */
public class Ui {
    private Scanner scanner;
    private static String SEPARATOR="===================";

    /**
     * Constructor of Ui.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     *print out the on startup message.
     */
    public void welcomeMessage() {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        logo +
        String welcomeMessage =
                "_____________________________________________\n"
                +"Whats up people! Duke is here to save the day\n"
                +"So, what can I do for you?\n";
        System.out.print(welcomeMessage);
        showDivider();
    }

    /**
     * print out the exit message.
     */
    public void byeMessage() {
        String byeMessage =
                "Aye captain. This is Duke Signing out!\n";
        System.out.print(byeMessage);
        Ui.showDivider();
    }

    /**
     *print out a divider line for better readability of CLI.
     */
    public static void showDivider(){
        System.out.println("_____________________________________________\n");
    }

    /**
     * Scan and Read in user input on the CLI.
     * @return String command.
     */
    public String readCommand() {
        System.out.println(SEPARATOR);
        System.out.println("Please type the command!");
        System.out.println(SEPARATOR);

        String commandString = scanner.nextLine();
        return commandString;
    }

    /**
     * Prints the Exception information based on the parameters.
     * @param e DukeExceptionType
     */
    public void showError(DueQuestExceptionType e) {
        switch (e) {
        case MISSING_DEADLINE:
            System.out.println("Missing Deadline!");
            showDivider();
            break;
        case MISSING_EVENT_INFO:
            System.out.println("Missing Event Information!");
            showDivider();
            break;
        case WRONG_INPUT_FORMAT:
            System.out.println("Wrong Input format");
            showDivider();
            break;
        case MISSING_DESCRIPTION:
            System.out.println("Missing Description!");
            showDivider();
            break;
        case WRONG_DATE_FORMAT:
            System.out.println("Missing Or Wrong Date Format! Enter in DD-MM-YYYY:");
            showDivider();
            break;
        case INVALID_COMMAND:
            System.out.println("No proper Commands Detected, retype again!");
            showDivider();
            break;
        default:
        }
    }

    public static void print(String text){
        System.out.println(text);
    }

    public static <T> void printListGenericType(ArrayList<T> lists) {
        if (lists != null) {
            for (T i: lists) {
                print(i.toString());
            }
        }
        if (lists.size() == 0) {
            System.out.println("You don't have any tasks!");
        }
        print("");
    }

    /**
     * convert LocalDate object into String line that is easily readable
     * @param date
     * @return
     */
    public static String convertDateToString(LocalDate date){
        String stringDate = date.format(DateTimeFormatter.ofPattern("d MMM"));
        return stringDate;
    }
}
