import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // write your code here
    System.out.println("Программа: пропущенные вызовы.\n");


    try (Scanner scanner = new Scanner(System.in)) {
      Controller controller = new Controller(scanner);
      controller.proceed();
    }

  }

}
