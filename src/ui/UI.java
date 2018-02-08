package ui;

import controller.CheckInput;
import model.TodoList;

import javax.swing.*;
import java.time.LocalDate;

public class UI {
    public static final String[] MENU = {"\n\nMAIN MENU", "1.Show all tasks", "2.Add new task", "3.Get quarter", "4.Quit"};
    public static final String[] QUARTER_MENU = {"\n\n1.Show tasks\n", "2.Remove task\n", "3.Mark/Unmark task\n", "4.Back\n"};
    public static final String[] QUARTERS = {"\n\nChoose quarter:\n1.IU\n", "2.IN\n", "3.NU\n", "4.NN"};


    public static String getQuarter(String idx) {
        switch (idx) {
            case "1":
                return "IU";
            case "2":
                return "IN";
            case "3":
                return "NU";
            default:
                return "NN";
        }
    }

    public static String getTaskName() {
        return JOptionPane.showInputDialog("Enter task name: ");
    }

    public static boolean getIsImportant() {
        String isImportant = JOptionPane.showInputDialog("'Y' --> important \n'N' --> not important").toUpperCase();
        if (CheckInput.isImportantValid(isImportant)) {
            switch (isImportant) {
                case "Y":
                    return true;
                case "N":
                    return false;
            }

        }
        System.out.println("Invalid type! Only 'Y' --> important \n'N' --> not important");
        return getIsImportant();
    }

    public static void showMenu(String[] menu) {
        for (String i : menu) {
            System.out.println(i);
        }
    }

    public static String userOption(String[] menu) {
        String userChoice = JOptionPane.showInputDialog("Enter option: ");
        if (Integer.valueOf(userChoice) < 1 || Integer.valueOf(userChoice) > menu.length) {
            System.out.println("Invalid option!");
            return userOption(menu);
        }
        return userChoice;
    }

    public static LocalDate getDate() {
        String dateString = JOptionPane.showInputDialog("Enter date(format: yyyy.mm.dd): ");
        if (CheckInput.isDateValidFormat(dateString)) {
            String[] dateList = dateString.split("-");
            int year = Integer.valueOf(dateList[0]);
            int month = Integer.valueOf(dateList[1]);
            int day = Integer.valueOf(dateList[2]);
            return LocalDate.of(year, month, day);
        }
        System.out.println("Invalid date format!");
        return getDate();
    }

    public static int getTaskNumber(TodoList list) {
        String idx = JOptionPane.showInputDialog("Enter task number to remove: ");

        if (Integer.valueOf(idx) < 0 || Integer.valueOf(idx) > list.getList().size()) {
            System.out.println("Invalid number!");
            return getTaskNumber(list);
        } else {
            return Integer.valueOf(idx)-1;
        }
    }

}
