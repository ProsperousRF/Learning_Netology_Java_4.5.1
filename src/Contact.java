/**
 * @author Stanislav Rakitov
 */
public class Contact {

  private final String firstName;
  private final String lastName;
  private final String phone;
  private final Group group;

  public Contact(String firstName, String lastName, String phone, Group group) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.group = group;
  }

  @Override
  public String toString() {
    return "Contact{" +
            "name='" + firstName + '\'' +
            ", surname='" + lastName + '\'' +
            ", phone='" + phone + '\'' +
            ", group=" + group +
            '}';
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhone() {
    return phone;
  }

  public Group getGroup() {
    return group;
  }
}
