package homeworks.homework21.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TvDto {
    private Long id;
    private String brand;
    private String model;
    private Integer screenSize;
    private BigDecimal price;
    private Boolean isSmart;
    private LocalDateTime createdAt;
}