package lt.techin.crud.dto.meal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealDto {

    private String name;
    private String description;
    private BigDecimal price;
    private String menu;
    private Long menuId;
    private Long order;

}
