package homeworks.homework12;

import homeworks.homework12.exceptions.*;
import homeworks.homework12.model.Person;
import homeworks.homework12.service.FileService;
import java.io.IOException;
import java.util.Scanner;

/**
 * Основной класс приложения для обработки данных о людях
 */
public class PersonDataProcessor {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Приложение для обработки данных о людях ===");
        System.out.println("Введите данные в произвольном порядке, разделенные пробелами:");
        System.out.println("Фамилия Имя Отчество дата_рождения(dd.mm.yyyy) номер_телефона пол(f/m) возраст");
        System.out.println("Пример: Иванов Иван Иванович 15.05.1990 79123456789 m 33");
        System.out.println("Для выхода введите 'exit'");
        System.out.println();

        while (true) {
            try {
                System.out.print("Введите данные: ");
                String input = scanner.nextLine().trim();

                if ("exit".equalsIgnoreCase(input)) {
                    System.out.println("Программа завершена.");
                    break;
                }

                if (input.isEmpty()) {
                    System.out.println("Пустая строка. Попробуйте снова.");
                    continue;
                }

                processPersonData(input);

            } catch (InvalidFieldCountException e) {
                System.err.println("Ошибка количества полей:");
                if (e.hasMoreFields()) {
                    System.err.println("В файле больше данных, чем требуется.");
                } else if (e.hasLessFields()) {
                    System.err.println("В файле меньше данных, чем требуется.");
                }
                System.err.println(e.getMessage());

            } catch (InvalidDateFormatException e) {
                System.err.println("Ошибка формата даты:");
                System.err.println(e.getMessage());

            } catch (InvalidPhoneNumberException e) {
                System.err.println("Ошибка номера телефона:");
                System.err.println(e.getMessage());

            } catch (InvalidGenderException e) {
                System.err.println("Ошибка формата пола:");
                System.err.println(e.getMessage());

            } catch (InvalidAgeException e) {
                System.err.println("Ошибка формата возраста:");
                System.err.println(e.getMessage());

            } catch (InvalidDataException e) {
                System.err.println("Ошибка данных:");
                System.err.println(e.getMessage());

            } catch (IOException e) {
                System.err.println("Ошибка записи в файл:");
                e.printStackTrace();

            } catch (Exception e) {
                System.err.println("Неожиданная ошибка:");
                e.printStackTrace();
            }

            System.out.println(); // Пустая строка для разделения
        }

        scanner.close();
    }

    /**
     * Обрабатывает введенные данные о человеке
     */
    private static void processPersonData(String input) throws InvalidDataException, IOException {
        // Разбиваем строку на поля
        String[] fields = input.split("\\s+");

        // Создаем объект Person
        Person person = Person.fromStringArray(fields);

        // Записываем в файл
        FileService.writePersonToFile(person);

        System.out.println("Данные успешно обработаны:");
        System.out.println(person);
    }
}
