import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Stanislav Rakitov in 2021
 */
public class Controller {
  private final Scanner scanner;
  private final Contacts contacts;
  private final MissedCalls missedCalls;

  public Controller(Scanner scanner) {
    this.scanner = scanner;
    contacts = new Contacts();
    missedCalls = new MissedCalls();
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
    switch (line) {
      case "1":
        addContactHandler();
        break;
      case "2":
        addMissedCallHandler();
        break;
      case "3":
        printAllMissedCalls();
        break;
      case "4":
        missedCalls.clearAllCalls();
        break;
      // Secret case for debug
      case "debug":
        removeContact();
        break;
      default:
        System.out.println("Неверно выбран пункт меню");
    }
  }

  private void printAllMissedCalls() {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");
    String contactFullName;
    String formattedDateTime;

    for (Map.Entry<LocalDateTime, String> aCall : missedCalls.getEntries()) {

      formattedDateTime = aCall.getKey().format(formatter);

      Contact phone = contacts.findContactByPhone(aCall.getValue());

      if (phone != null) {
        contactFullName = String.format("%s %s", phone.getFirstName(), phone.getLastName());
      } else {
        contactFullName = aCall.getValue();
      }

      System.out.println(formattedDateTime + " " + contactFullName);
    }
  }

  private void addMissedCallHandler() {
    System.out.println("Добавьте номер пропущенного вызова");
    String line = scanner.nextLine();
    if (line.isBlank()) {
      System.out.println("Неверно введен номер");
      return;
    }
    System.out.println(missedCalls.addMissedCall(line) ? "Добавлен" : "Перезаписан");
  }

  private void addContactHandler() {
    System.out.println("Для добавления контакта введите:\n" +
                               "Имя, Фамилию, номер телефона, группу " +
                               "контакта (Работа/Друзья/Семья)");
    String line = scanner.nextLine();
    if (!line.isBlank()) {
      try {
        String[] split = line.split(",");
        String firstName = split[0].trim();
        String lastName = split[1].trim();
        String phone = split[2].trim();
        Group group;
        try {
          group = getGroup(split[3].trim());
          boolean result = contacts.addContact(firstName, lastName, phone, group);
          if (result) {
            System.out.printf("Номер %s добавлен\n", phone);
          } else {
            System.out.println("Внимание, контакт с таким номером уже существовал ранее, и теперь он перезаписан!");
          }
        } catch (IllegalGroupNameException e) {
          System.out.println(e.getMessage());
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Неправильный формат добавления контакта");
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

  private void removeContact() {
    System.out.println("Для удаления контакта введите его имя, фамилию");
    String line = scanner.nextLine();
    try {
      String[] split = line.split(",");
      String firstName = split[0].trim();
      String lastName = split[1].trim();
      boolean result = contacts.removeContact(firstName, lastName);
      System.out.println("Контакт " + (result ? "удален" : "не удален"));
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Неправильно введены данные");
    }

  }
}
