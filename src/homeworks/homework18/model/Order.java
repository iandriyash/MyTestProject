package homeworks.homework18.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;
    private Integer customerId;
    private LocalDateTime orderDate;
    private Integer totalOrders;
    private BigDecimal discount;

    public Order(Integer customerId, Integer totalOrders, BigDecimal discount) {
        this.customerId = customerId;
        this.totalOrders = totalOrders;
        this.discount = discount;
    }
}