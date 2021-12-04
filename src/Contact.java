/**
 * @author Stanislav Rakitov
 */
public class Contact {

  private String name;
  private String surname;
  private String phone;
  private Group group;

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
}
