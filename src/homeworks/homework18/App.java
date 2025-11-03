package homeworks.homework18;

import homeworks.homework18.config.DatabaseConfig;
import homeworks.homework18.config.FlywayMigration;
import homeworks.homework18.dao.CustomerDAO;
import homeworks.homework18.dao.OrderDAO;
import homeworks.homework18.model.Customer;
import homeworks.homework18.model.Order;

import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Homework 18: PostgreSQL + Flyway ===\n");

        // 1. Запуск миграций
        FlywayMigration.migrate();

        // 2. Создаем DAO
        CustomerDAO customerDAO = new CustomerDAO();
        OrderDAO orderDAO = new OrderDAO();

        // 3. Получаем всех покупателей
        System.out.println("=== Все покупатели ===");
        List<Customer> customers = customerDAO.findAll();
        customers.forEach(System.out::println);

        // 4. Получаем все заказы
        System.out.println("\n=== Все заказы ===");
        List<Order> orders = orderDAO.findAll();
        orders.forEach(System.out::println);

        // 5. Добавляем нового покупателя
        System.out.println("\n=== Добавление нового покупателя ===");
        Customer newCustomer = new Customer("Петр", "Петров");
        customerDAO.save(newCustomer);
        System.out.println("Добавлен покупатель: " + newCustomer);

        // 6. Добавляем новый заказ
        System.out.println("\n=== Добавление нового заказа ===");
        Order newOrder = new Order(newCustomer.getId(), 2, new BigDecimal("7.50"));
        orderDAO.save(newOrder);
        System.out.println("Добавлен заказ: " + newOrder);

        // 7. Получаем заказы конкретного покупателя
        System.out.println("\n=== Заказы покупателя ID=1 ===");
        List<Order> customerOrders = orderDAO.findByCustomerId(1);
        customerOrders.forEach(System.out::println);

        // 8. Получаем покупателя по ID
        System.out.println("\n=== Поиск покупателя по ID=2 ===");
        Customer customer = customerDAO.findById(2);
        System.out.println(customer);

        // 9. Показываем финальную статистику
        System.out.println("\n=== Финальная статистика ===");
        System.out.println("Всего покупателей: " + customerDAO.findAll().size());
        System.out.println("Всего заказов: " + orderDAO.findAll().size());

        // 10. Закрываем connection pool
        DatabaseConfig.close();

        System.out.println("\n=== Работа с БД завершена ===");
    }
}