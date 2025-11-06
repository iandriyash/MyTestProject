package homework19.config;

import homework19.model.Customer;
import homework19.model.Order;
import homework19.repository.CustomerRepository;
import homework19.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) {
        log.info("=== Загрузка тестовых данных ===");

        // Создаем покупателей
        Customer customer1 = new Customer(null, "Иван", "Иванов");
        Customer customer2 = new Customer(null, "Петр", "Петров");
        Customer customer3 = new Customer(null, "Мария", "Сидорова");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        log.info("Создано покупателей: 3");

        // Создаем заказы
        Order order1 = new Order(null, customer1, LocalDate.now(), BigDecimal.valueOf(1500.00), BigDecimal.valueOf(5.00));
        Order order2 = new Order(null, customer2, LocalDate.now().minusDays(1), BigDecimal.valueOf(2300.00), BigDecimal.valueOf(10.00));
        Order order3 = new Order(null, customer3, LocalDate.now(), BigDecimal.valueOf(800.00), BigDecimal.valueOf(0.00));

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        log.info("Создано заказов: 3");

        // Тестирование методов
        log.info("\n=== Тестирование методов Repository ===");

        // 1. Получение всех данных
        log.info("Все покупатели: {}", customerRepository.findAll().size());
        log.info("Все заказы: {}", orderRepository.findAll().size());

        // 2. Получение по ID
        log.info("Покупатель с ID 1: {}", customerRepository.findById(1L));
        log.info("Заказ с ID 1: {}", orderRepository.findById(1L));

        // 3. Получение по дате
        log.info("Заказы на сегодня: {}", orderRepository.findByOrderDate(LocalDate.now()).size());

        log.info("=== Загрузка завершена ===\n");
    }
}