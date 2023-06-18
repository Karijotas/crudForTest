package lt.techin.crud.service;

import lombok.extern.slf4j.Slf4j;
import lt.techin.crud.config.exception.CustomValidationException;
import lt.techin.crud.dao.MealRepository;
import lt.techin.crud.dao.MenuRepository;
import lt.techin.crud.dao.OrderRepository;
import lt.techin.crud.model.Meal;
import lt.techin.crud.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class MenuService {

    private final MenuRepository menuRepository;
    private final MealRepository mealRepository;
    private final OrderRepository orderRepository;

    private final Validator validator;

    @Autowired
    public MenuService(MenuRepository menuRepository, MealRepository mealRepository, OrderRepository orderRepository, Validator validator) {
        this.menuRepository = menuRepository;
        this.mealRepository = mealRepository;
        this.orderRepository = orderRepository;
        this.validator = validator;
    }

    void validateInputWithInjectedValidator(Menu menu) {
        Set<ConstraintViolation<Menu>> violations = validator.validate(menu);
        if (!violations.isEmpty()) {
            throw new CustomValidationException(violations.toString(), "Menu", "Error in menu entity", menu.toString());
        }
    }

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getById(Long id) {
        return menuRepository.findById(id);
    }

    public Menu create(Menu menu) {
        var newMenu = new Menu();

        newMenu.setId(menu.getId());
        newMenu.setName(menu.getName());
        newMenu.setMeals(menu.getMeals());
        newMenu.setCreatedDate(menu.getCreatedDate());
        newMenu.setModifiedDate(menu.getModifiedDate());
        newMenu.setCreatedBy(menu.getCreatedBy());
        newMenu.setModifiedBy(menu.getModifiedBy());

        return menuRepository.save(newMenu);
    }

    public Menu update(Long id, Menu menu) {
        validateInputWithInjectedValidator(menu);

        Menu existingMenu = menuRepository.findById(id)
                .orElseThrow(() -> new CustomValidationException("Menu doesn't exist", "id", "Menu not found", id.toString()));

        existingMenu.setName(menu.getName());
        existingMenu.setMeals(menu.getMeals());
        existingMenu.setModifiedDate(menu.getModifiedDate());
        existingMenu.setModifiedBy(menu.getModifiedBy());

        return menuRepository.save(existingMenu);
    }

    public Boolean deleteById(Long id) {
        try {
            menuRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    public Menu addMealToMenu(Long mealId, Long menuId) {
        var meal = mealRepository.findById(mealId)
                .orElseThrow(() -> new CustomValidationException("Meal doesn't exist", "id", "Meal not found", mealId.toString()));
        var menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new CustomValidationException("Menu doesn't exist", "id", "Menu not found", menuId.toString()));

        var meals = menu.getMeals();

        meals.add(meal);
        menu.setMeals(meals);

        return menu;
    }

    public Menu removeMealFromMenu(Long mealId, Long menuId) {
        var meal = mealRepository.findById(mealId)
                .orElseThrow(() -> new CustomValidationException("Meal doesn't exist", "id", "Meal not found", mealId.toString()));
        var menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new CustomValidationException("Menu doesn't exist", "id", "Menu not found", menuId.toString()));
        var meals = menu.getMeals();

        meals.remove(meal);
        menu.setMeals(meals);

        return menu;
    }

    public Menu updateMealInMenu(Long mealId, Meal meal, Long menuId) {
        var existingMeal = mealRepository.findById(mealId)
                .orElseThrow(() -> new CustomValidationException("Meal doesn't exist", "id", "Meal not found", mealId.toString()));
        var menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new CustomValidationException("Menu doesn't exist", "id", "Menu not found", menuId.toString()));
        var meals = menu.getMeals();

        meals.removeIf(meal1 -> meal1.equals(existingMeal));
        meals.add(meal);
        menu.setMeals(meals);

        return menu;
    }
}
