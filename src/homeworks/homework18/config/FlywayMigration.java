package homeworks.homework18.config;

import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FlywayMigration {

    public static void migrate() {
        Properties props = loadProperties();

        Flyway flyway = Flyway.configure()
                .dataSource(
                        props.getProperty("db.url"),
                        props.getProperty("db.username"),
                        props.getProperty("db.password")
                )
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load();

        System.out.println("=== Запуск миграций Flyway ===");
        flyway.migrate();
        System.out.println("=== Миграции успешно применены ===\n");
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream input = FlywayMigration.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find application.properties");
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties", e);
        }
        return props;
    }
}