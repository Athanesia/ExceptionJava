import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputExample {

    public static float getUserFloatInput() {
        float userInput = 0.0f;
        boolean validInput = false;

        try (Scanner scanner = new Scanner(System.in)) {
            while (!validInput) {
                try {
                    System.out.print("Введите дробное число: ");
                    userInput = scanner.nextFloat();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Некорректный ввод. Пожалуйста, введите дробное число.");
                    scanner.nextLine(); // Очистка буфера ввода
                }
            }
        }

        return userInput;
    }

    public static void main(String[] args) {
        float userFloat = getUserFloatInput();
        System.out.println("Вы ввели: " + userFloat);
    }
}