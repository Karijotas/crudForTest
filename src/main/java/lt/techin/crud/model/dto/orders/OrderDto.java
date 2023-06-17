package lt.techin.crud.model.dto.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.techin.crud.model.dto.meal.MealDto;

import java.math.BigDecimal;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Set<MealDto> meals;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    private BigDecimal totalAmount;
    private String address;
    private String status;
    private String trackingNumber;

}
