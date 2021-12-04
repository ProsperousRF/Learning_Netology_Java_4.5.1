/**
 * @author Stanislav Rakitov
 */
public class Contact {

  private final String name;
  private final String surname;
  private final String phone;
  private final Group group;

  public Contact(String name, String surname, String phone, Group group) {
    this.name = name;
    this.surname = surname;
    this.phone = phone;
    this.group = group;
  }

  @Override
  public String toString() {
    return "Contact{" +
            "name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", phone='" + phone + '\'' +
            ", group=" + group +
            '}';
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getPhone() {
    return phone;
  }

  public Group getGroup() {
    return group;
  }
}
