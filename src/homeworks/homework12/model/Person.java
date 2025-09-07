package homeworks.homework12.model;

import homeworks.homework12.exceptions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private long phoneNumber;
    private char gender;
    private int age;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Person() {}

    public Person(String lastName, String firstName, String middleName,
                  LocalDate birthDate, long phoneNumber, char gender, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    public static Person fromStringArray(String[] data) throws InvalidDataException {
        if (data.length != 7) {
            throw new InvalidFieldCountException(7, data.length);
        }

        Person person = new Person();
        String[] fields = new String[7]; // Массив для отслеживания порядка

        // Заполняем поля по порядку
        for (int i = 0; i < data.length; i++) {
            fields[i] = data[i].trim();
        }

        // Присваиваем поля явно
        try {
            person.setLastName(fields[0]);    // Фамилия
            person.setFirstName(fields[1]);   // Имя
            person.setMiddleName(fields[2]);  // Отчество
            person.setBirthDate(parseDate(fields[3]));  // Дата
            person.setPhoneNumber(parsePhoneNumber(fields[4]));  // Телефон
            person.setGender(parseGender(fields[5]));  // Пол
            person.setAge(parseAge(fields[6]));       // Возраст
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidDataException("Недостаточно данных для обработки");
        }

        // Проверяем, что все поля заполнены
        if (person.lastName == null || person.firstName == null || person.middleName == null ||
                person.birthDate == null || person.phoneNumber == 0 || person.gender == 0 || person.age == 0) {
            throw new InvalidDataException("Не удалось определить все необходимые поля");
        }

        return person;
    }

    private static boolean isDate(String value) {
        return value.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
    }

    private static boolean isPhoneNumber(String value) {
        return value.matches("\\d{10,15}");
    }

    private static boolean isGender(String value) {
        return value.matches("[fmFM]");
    }

    private static boolean isAge(String value) {
        return value.matches("\\d{1,3}") && !isPhoneNumber(value);
    }

    private static LocalDate parseDate(String dateStr) throws InvalidDateFormatException {
        try {
            return LocalDate.parse(dateStr, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatException(dateStr);
        }
    }

    private static long parsePhoneNumber(String phoneStr) throws InvalidPhoneNumberException {
        try {
            return Long.parseLong(phoneStr);
        } catch (NumberFormatException e) {
            throw new InvalidPhoneNumberException(phoneStr);
        }
    }

    private static char parseGender(String genderStr) throws InvalidGenderException {
        char gender = genderStr.toLowerCase().charAt(0);
        if (gender == 'f' || gender == 'm') {
            return gender;
        }
        throw new InvalidGenderException(genderStr);
    }

    private static int parseAge(String ageStr) throws InvalidAgeException {
        try {
            int age = Integer.parseInt(ageStr);
            if (age < 0 || age > 150) {
                throw new InvalidAgeException(ageStr);
            }
            return age;
        } catch (NumberFormatException e) {
            throw new InvalidAgeException(ageStr);
        }
    }

    // Геттеры и сеттеры
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public long getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(long phoneNumber) { this.phoneNumber = phoneNumber; }

    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d %c %d",
                lastName, firstName, middleName,
                birthDate.format(DATE_FORMATTER),
                phoneNumber, gender, age);
    }

    public String toFileString() {
        return String.format("%s %s %s %s %d %c %d",
                lastName, firstName, middleName,
                birthDate.format(DATE_FORMATTER),
                phoneNumber, gender, age);
    }
}