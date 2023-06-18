package lt.techin.crud.model.dto.mapper;

import lt.techin.crud.model.Order;
import lt.techin.crud.model.dto.orders.OrderDto;
import lt.techin.crud.model.dto.orders.OrderEntityDto;

import static lt.techin.crud.model.dto.mapper.MealMapper.toMealSet;
import static lt.techin.crud.model.dto.mapper.MealMapper.toMealSetDto;

public class OrderMapper {

    public static OrderEntityDto toOrderEntityDto(Order order) {
        var orderEntityDto = new OrderEntityDto();

        orderEntityDto.setId(order.getId());
        orderEntityDto.setMeals(toMealSetDto(order.getMeals()));
        orderEntityDto.setCustomerName(order.getCustomerName());
        orderEntityDto.setCustomerEmail(order.getCustomerEmail());
        orderEntityDto.setCustomerPhoneNumber(order.getCustomerPhoneNumber());
        orderEntityDto.setTotalAmount(order.getTotalAmount());
        orderEntityDto.setAddress(order.getAddress());
        orderEntityDto.setStatus(order.getStatus());
        orderEntityDto.setTrackingNumber(order.getTrackingNumber());

        return orderEntityDto;
    }

    public static Order toOrder(OrderEntityDto orderEntityDto) {
        var order = new Order();

        order.setMeals(toMealSet(orderEntityDto.getMeals()));
        order.setCustomerName(orderEntityDto.getCustomerName());
        order.setCustomerEmail(orderEntityDto.getCustomerEmail());
        order.setCustomerPhoneNumber(orderEntityDto.getCustomerPhoneNumber());
        order.setTotalAmount(orderEntityDto.getTotalAmount());
        order.setAddress(orderEntityDto.getAddress());
        order.setStatus(orderEntityDto.getStatus());
        order.setTrackingNumber(orderEntityDto.getTrackingNumber());

        return order;
    }

    public static Order toOrder(OrderDto orderDto) {
        var order = new Order();

        order.setMeals(toMealSet(orderDto.getMeals()));
        order.setCustomerName(orderDto.getCustomerName());
        order.setCustomerEmail(orderDto.getCustomerEmail());
        order.setCustomerPhoneNumber(orderDto.getCustomerPhoneNumber());
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setAddress(orderDto.getAddress());
        order.setStatus(orderDto.getStatus());
        order.setTrackingNumber(orderDto.getTrackingNumber());

        return order;
    }

}
