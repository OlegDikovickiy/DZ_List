import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    List<String> basket = new ArrayList<>();

    while (true) {
      System.out.println("Введите номер операции");
      System.out.println("1. Добавить");
      System.out.println("2. Удалить");
      System.out.println("3. Показать список продуктов");
      System.out.println("4. Найти");
      System.out.println("5. Завершить");

      String input = scanner.nextLine();

      switch (input) {
        case ("1"): {
          System.out.println("Какой продукт добавить?");
          String product = scanner.nextLine();
          basket.add(product);
          System.out.println(product + " - добавлен в корзину");
          break;
        }
        case ("2"): {
          if (basket.isEmpty()) {
            System.out.println("В корзине нет продуктов");
          } else {
            System.out.println("Список покупок:");
            for (int i = 0; i < basket.size(); i++) {
              System.out.println((i + 1) + ". " + basket.get(i));
            }

            System.out.println("Какую хотите удалить? Введите номер или название: ");
            String numberOrName = scanner.nextLine();
            try {
              int number = Integer.parseInt(numberOrName) - 1;
              basket.remove(number);
              System.out.println("Удалено");

            } catch (NumberFormatException e) {
              if (basket.contains(numberOrName)) {
                int index = basket.indexOf(numberOrName);
                basket.remove(index);
              } else {
                System.out.println("Значение: " + numberOrName + " не найдено в вашем списке");
              }
            } catch (IndexOutOfBoundsException e) {
              System.out.println("Вы можете ввести значение от 1 до " + basket.size());
            }
          }
          break;
        }
        case ("3"): {
          if (basket.isEmpty()) {
            System.out.println("В корзине нет продуктов");
          } else {
            System.out.println("Список покупок:");
            for (int i = 0; i < basket.size(); i++) {
              System.out.println((i + 1) + ". " + basket.get(i));
            }
          }
          break;
        }
        case ("4"): {

          if (basket.isEmpty()) {
            System.out.println("В корзине нет продуктов");
          } else {
            String request = scanner.nextLine();
            String queryLower = request.toLowerCase();
            for (int i = 0; i < basket.size(); i++) {
              String itemLower = basket.get(i);
              if (itemLower.toLowerCase().contains(queryLower)) {
                System.out.println((i + 1) + ". " + itemLower);
              } else {
                continue;
              }
            }
          }
          break;
        }
        case ("5"): {
          System.exit(0);
        }
      }
    }
  }
}