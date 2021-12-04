import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // write your code here
    System.out.println("Программа: пропущенные вызовы.\n");

    try (Scanner scanner = new Scanner(System.in)) {
      while (true) {
        printMenu();
      }
    }

  }

  private static void printMenu() {
    System.out.println("Меню:\n" +
                               "1. Добавить контакт\n" +
                               "2. Добавить пропущенный вызов\n" +
                               "3. Вывести все пропущенные вызовы\n" +
                               "4. Очистить пропущенные вызовы\n" +
                               "5. Выход\n" +
                               "Выберите пункт из меню (1-4):");
  }
}
