import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserDataApp {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите Фамилию Имя Отчество:");
            String fullName = scanner.nextLine();

            System.out.println("Введите дату рождения (dd.mm.yyyy):");
            String birthDate = scanner.nextLine();

            System.out.println("Введите номер телефона (только цифры без дефисов и +):");
            String phoneNumber = scanner.nextLine();

            System.out.println("Введите пол (f - женский, m - мужской):");
            String gender = scanner.nextLine();

            String[] nameParts = fullName.split(" ");
            if (nameParts.length != 3) {
                handleInvalidData("Неверное количество частей ФИО");
                return;
            }

            String surname = nameParts[0];
            String name = nameParts[1];
            String patronymic = nameParts[2];

            // Валидация и обработка данных

            // Создание файла
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(surname + ".txt"))) {
                String userData = surname + " " + name + " " + patronymic + ", " + birthDate + ", " + phoneNumber + ", " + gender;
                writer.write(userData);
                System.out.println("Данные успешно записаны в файл.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (InputMismatchException e) {
            handleInvalidData("Ошибка формата введенных данных");
        }
    }

    private static void handleInvalidData(String errorMessage) {
        System.out.println("Ошибка: " + errorMessage);
    }
}