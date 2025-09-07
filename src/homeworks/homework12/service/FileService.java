package homeworks.homework12.service;

import homeworks.homework12.model.Person;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Сервис для работы с файлами
 */
public class FileService {
    private static final String OUTPUT_DIR = "output";

    /**
     * Записывает данные о человеке в файл
     */
    public static void writePersonToFile(Person person) throws IOException {
        // Создаем директорию, если её нет
        Path outputDir = Paths.get(OUTPUT_DIR);
        if (!Files.exists(outputDir)) {
            Files.createDirectories(outputDir);
        }

        // Имя файла = фамилия + .txt
        String fileName = person.getLastName() + ".txt";
        Path filePath = outputDir.resolve(fileName);

        // Записываем в файл (добавляем, если файл уже существует)
        try (BufferedWriter writer = Files.newBufferedWriter(filePath,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(person.toFileString());
            writer.newLine();
        }

        System.out.println("Данные успешно записаны в файл: " + filePath);
    }
}