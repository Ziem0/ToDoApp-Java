package model;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 * Class representing a todo list.
 * TodoList object should aggregate TodoItem objects.
 */
public class TodoList {
    private LinkedList<TodoItem> list;

    public TodoList() {
        this.list = new LinkedList<>();
    }

    public LinkedList<TodoItem> getList() {
        return list;
    }

    public void addTask(String name, LocalDate deadline, boolean isImportant) {
        list.add(new TodoItem(name, deadline, isImportant));
    }

    public void removeTask(int index) {
        list.remove(index);
    }

    public String toString() {
        int number = 1;
        StringBuilder out = new StringBuilder("\n\t\t");

        for (TodoItem i : list) {
            out.append(number).append(". ").append(i.toString()).append("\n");
            number++;
        }
        return out.toString();
    }

    public void getChangeMarked(int idx) {
        list.get(idx).changeMarked();
    }


    private static class TodoItem {
        private String name;
        private LocalDate deadline;
        private boolean isImportant;
        private boolean mark;

        private TodoItem(String name, LocalDate deadline, boolean isImportant) {
            this.name = name;
            this.deadline = deadline;
            this.isImportant = isImportant;
            this.mark = false;
        }

        private void changeMarked() {
            this.mark = !this.mark;
        }

        public String toString() {
            String isBird = " ";
            if (mark) {
                isBird = "x";
            }
            return "[" + isBird + "] " + name + " ---> deadline: " + deadline.toString();
        }
    }
}

