package homeworks.homework19_5.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "televisions")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Television {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private Integer sizeInches;
    private String resolution;
    private String panelType;
    private Boolean smart;
    private BigDecimal price;

    @Column(name = "production_year")
    private Integer year;
}
