package controller;

public class CheckInput {

    public static boolean isDateValidFormat(String date) {
        return date.matches("[0-9]{4}-[0-1]{1}[0-9]{1}-[0-3]{1}[0-9]{1}");
    }

    public static boolean isImportantValid(String txt) {
        return txt.matches("[YN]{1}");
    }
}
