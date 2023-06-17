package lt.techin.crud.dto.meal;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
public class MealDto {

    private String name;
    private String description;
    private BigDecimal price;
    private String menu;
    private Long order;

}
