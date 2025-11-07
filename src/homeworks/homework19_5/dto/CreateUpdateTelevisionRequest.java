package homeworks.homework19_5.dto;

import java.math.BigDecimal;

public record CreateUpdateTelevisionRequest(
        String brand,
        String model,
        Integer sizeInches,
        String resolution,
        String panelType,
        Boolean smart,
        BigDecimal price,
        Integer year
) {}
