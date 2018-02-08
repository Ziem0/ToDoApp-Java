import controller.Controller;
import model.TodoList;
import ui.UI;

/**
 * Class representing the TodoApp application.
 * It is the main entry point for this program.
 */
public class App {

  public static void main(String[] args){
    Controller c = new Controller();
    boolean quit = false;

    while (!quit) {
      UI.showMenu(UI.MENU);
      String userChoice = UI.userOption(UI.MENU);

      switch (userChoice) {
        case "1":
          showAllTask(c);
          break;
        case "2":
          c.addTask(UI.getTaskName(),UI.getDate(),UI.getIsImportant());
          break;
        case "3":
          boolean back = false;
          UI.showMenu(UI.QUARTERS);
          String userChoice2 = UI.userOption(UI.QUARTERS);
          String option = UI.getQuarter(userChoice2);

          while (!back) {
            UI.showMenu(UI.QUARTER_MENU);
            TodoList quarter = c.getMatrix().get(option);
            String quarterOptions = UI.userOption(UI.QUARTER_MENU);

            switch (quarterOptions) {
              case "1":
                System.out.println(quarter);
                break;
              case "2":
                System.out.println(quarter);
                int idx = UI.getTaskNumber(quarter);
                c.removeTask(idx,quarter);
                break;
              case "3":
                System.out.println(quarter);
                int idx1 = UI.getTaskNumber(quarter);
                quarter.getChangeMarked(idx1);
                break;
              case "4":
                back = true;
            }

          }
          break;
        case "4":
          quit = true;
      }
    }
  }

  private static void showAllTask(Controller c) {
    for (TodoList i : c.getMatrix().values()) {
      System.out.println(i.toString());
    }
  }
}
