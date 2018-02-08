package controller;

import model.TodoList;

import java.time.LocalDate;
import java.util.TreeMap;

public class Controller {
    private TreeMap<String, TodoList> matrix;

    public Controller() {
        this.matrix = new TreeMap<>();
        matrix.put("IU", new TodoList());
        matrix.put("IN", new TodoList());
        matrix.put("NU", new TodoList());
        matrix.put("NN", new TodoList());
    }

    public TreeMap<String, TodoList> getMatrix() {
        return matrix;
    }

    public void addTask(String name, LocalDate deadline, boolean isImportant) {
        LocalDate today = LocalDate.now();
        int difference = deadline.getDayOfYear() - today.getDayOfYear();

        if (isImportant && difference < 3) {
            matrix.get("IU").addTask(name, deadline,isImportant);
        } else if (isImportant) {
            matrix.get("IN").addTask(name, deadline,isImportant);
        } else if (difference < 3) {
            matrix.get("NU").addTask(name, deadline, isImportant);
        } else {
            matrix.get("NN").addTask(name, deadline, isImportant);
        }
        System.out.println("New task is added!");
    }

    public void removeTask(int idx, TodoList list) {
        list.removeTask(idx);
        System.out.println("Task was removed!");
    }
}
