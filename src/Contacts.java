import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Stanislav Rakitov
 */
public class Contacts {
  private final Map<String, Contact> contacts;

  public Contacts() {
    contacts = new HashMap<>();
  }

  // Добавление контакта (имя, фамилия, номер телефона, группа контакта: работа, друзья, семья).
  public boolean addContact(String name, String surname, String phone, Group group) {
    Contact contact = new Contact(name, surname, phone, group);
    return contacts.put(phone, contact) == null;

  }

  // Удаление контакта по имени и фамилии.
  public boolean removeContact(String name, String surname) {
    // Check for empty database
    if (contacts.isEmpty()) {
      return false;
    }

    for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
      if (Objects.equals(entry.getValue().getFirstName(), name)
              && Objects.equals(entry.getValue().getLastName(), surname)) {
        return contacts.remove(entry.getKey()) != null;
      }
    }
    return false;
  }

  // Поиск контакта по номеру
  public Contact findContactByPhone(String phone) {
    return contacts.get(phone);
  }


}
