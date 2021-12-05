import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // write your code here
    System.out.println("Программа: пропущенные вызовы.\n");


    try (Scanner scanner = new Scanner(System.in)) {
      ContactsController contactsController = new ContactsController(scanner);
      contactsController.proceed();
    }

  }

}
