package lt.techin.crud.service;

import lt.techin.crud.config.exception.CustomValidationException;
import lt.techin.crud.dao.MealRepository;
import lt.techin.crud.dao.MenuRepository;
import lt.techin.crud.dao.OrderRepository;
import lt.techin.crud.model.Meal;
import lt.techin.crud.model.Menu;
import lt.techin.crud.model.Order;

public class FinderClass {

    public static MenuRepository menuRepository;
    public static MealRepository mealRepository;

    public static OrderRepository orderRepository;

    public static Menu findMenu(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new CustomValidationException("Menu doesn't exist", "id", "Menu not found", id.toString()));
    }

    public static Meal findMeal(Long id) {
        return mealRepository.findById(id)
                .orElseThrow(() -> new CustomValidationException("Meal doesn't exist", "id", "Meal not found", id.toString()));
    }

    public static Order findOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new CustomValidationException("Order doesn't exist", "id", "Order not found", id.toString()));
    }
}
