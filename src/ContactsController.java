import java.util.Scanner;

/**
 * @author Stanislav Rakitov in 2021
 */
public class ContactsController {
  private final Scanner scanner;
  private final Contacts contacts;

  public ContactsController(Scanner scanner) {
    this.scanner = scanner;
    contacts = new Contacts();
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
        addContact();
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

  private void addContact() {
    System.out.println("Для добавления контакта введите:\n" +
                               "Имя, Фамилию, номер телефона, группу " +
                               "контакта (Работа/Друзья/Семья)");
    String line = scanner.nextLine();
    if (!line.isBlank()) {
      String[] split = line.split(",");
      String firstName = split[0].trim();
      String lastName = split[1].trim();
      String phone = split[2].trim();
      Group group;
      try {
        group = getGroup(split[3].trim());
        contacts.addContact(firstName, lastName, phone, group);
      } catch (IllegalGroupNameException e) {
        System.out.println(e.getMessage());
      }

    }
  }

  private Group getGroup(String line) throws IllegalGroupNameException {

    if (line.isBlank()) {
      throw new IllegalGroupNameException("Группа не может быть пустой");
    }
    if ("Работа".equalsIgnoreCase(line)) {
      return Group.WORK;
    } else if ("Друзья".equalsIgnoreCase(line)) {
      return Group.FRIENDS;
    } else if ("Семья".equalsIgnoreCase(line)) {
      return Group.FAMILY;
    } else {
      throw new IllegalGroupNameException("Название группы не распознано");
    }
  }
}
