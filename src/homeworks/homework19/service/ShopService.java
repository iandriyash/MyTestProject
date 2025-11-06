package homework19.service;

import homework19.model.Customer;
import homework19.model.Order;
import homework19.repository.CustomerRepository;
import homework19.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    // Получение всех покупателей
    public List<Customer> getAllCustomers() {
        log.info("Получение всех покупателей");
        return customerRepository.findAll();
    }

    // Получение покупателя по ID
    public Optional<Customer> getCustomerById(Long id) {
        log.info("Получение покупателя по ID: {}", id);
        return customerRepository.findById(id);
    }

    // Удаление всех покупателей
    public void deleteAllCustomers() {
        log.info("Удаление всех покупателей");
        customerRepository.deleteAll();
    }

    // Получение всех заказов
    public List<Order> getAllOrders() {
        log.info("Получение всех заказов");
        return orderRepository.findAll();
    }

    // Получение заказа по ID
    public Optional<Order> getOrderById(Long id) {
        log.info("Получение заказа по ID: {}", id);
        return orderRepository.findById(id);
    }

    // Получение заказов по дате
    public List<Order> getOrdersByDate(LocalDate date) {
        log.info("Получение заказов по дате: {}", date);
        return orderRepository.findByOrderDate(date);
    }

    // Удаление всех заказов
    public void deleteAllOrders() {
        log.info("Удаление всех заказов");
        orderRepository.deleteAll();
    }
}