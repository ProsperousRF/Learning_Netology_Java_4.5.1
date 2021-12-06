import java.util.Scanner;

/**
 * @author Stanislav Rakitov in 2021
 */
public class ContactsController {
  private Scanner scanner;

  public ContactsController(Scanner scanner) {
    this.scanner = scanner;
  }

  private void printMenu() {
    System.out.println("Меню:\n" +
                               "1. Добавить контакт\n" +
                               "2. Добавить пропущенный вызов\n" +
                               "3. Вывести все пропущенные вызовы\n" +
                               "4. Очистить пропущенные вызовы\n" +
                               "5. Выход\n" +
                               "Выберите пункт из меню (1-4):");
  }

  public void proceed() {
    while (true) {
      printMenu();
      String line = scanner.nextLine();
      if ("5".equals(line) || "".equals(line)) {
        break;
      } else {
        menuHandler(line);
      }
    }

  }

  private void menuHandler(String line) {
    // TODO: 12/5/2021 add menu handler except for exit
    switch (line) {
      case "1":
        // TODO: 12/6/2021 Add contact
        break;
      case "2":
        // TODO: 12/6/2021 Add missed call
        break;
      case "3":
        // TODO: 12/6/2021 Printout all missed calls
        break;
      case "4":
        // TODO: 12/6/2021 Clear all missed calls
        break;
      default:
        System.out.println("Неверно выбран пункт меню");
    }
  }
}
