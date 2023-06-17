package lt.techin.crud.model.dto.meal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealEntityDto extends MealDto{
    private Long id;

}
