import java.util.HashMap;
import java.util.Map;

/**
 * @author Stanislav Rakitov
 */
public class Contacts {
  private Map<String, Contact> contacts;

  public Contacts() {
    contacts = new HashMap<>();
  }

  // Добавление контакта (имя, фамилия, номер телефона, группа контакта: работа, друзья, семья).
  public void addContact(String name, String surname, String phone, Group group) {
    Contact contact = new Contact(name, surname, phone, group);
    if (contacts.put(phone, contact) != null) {
      System.out.println("Внимание, контакт с таким номером уже существовал ранее, и теперь он " +
                                 "перезаписан!");
    } else {
      System.out.printf("Номер %s добавлен\n", phone);
    }
  }

  // Удаление контакта по имени и фамилии.
  public void removeContact(String name, String surname) {

  }

  // Поиск контакта по номеру
  public Contact findContactByPhone(String phone) {
    return null;
  }


}
