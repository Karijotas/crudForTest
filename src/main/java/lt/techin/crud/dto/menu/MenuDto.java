package lt.techin.crud.dto.menu;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.techin.crud.dto.meal.MealDto;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
public class MenuDto {

    public String name;
    public Set<MealDto> meals;

    public String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;
    private String createdBy;
    private String modifiedBy;
}