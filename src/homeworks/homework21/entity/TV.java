package homeworks.homework21.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tvs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(name = "screen_size", nullable = false)
    private Integer screenSize;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "is_smart", nullable = false)
    private Boolean isSmart;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}