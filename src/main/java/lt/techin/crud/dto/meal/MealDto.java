package lt.techin.crud.dto.meal;

import lt.techin.crud.dto.menu.MenuDto;
import lt.techin.crud.dto.orders.OrderDto;

import java.math.BigDecimal;

public class MealDto {

    private String name;
    private String description;
    private BigDecimal price;
    private MenuDto menu;
    private OrderDto order;

}
