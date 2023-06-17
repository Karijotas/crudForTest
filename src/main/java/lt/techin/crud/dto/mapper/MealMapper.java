package lt.techin.crud.dto.mapper;

import lt.techin.crud.dao.MenuRepository;
import lt.techin.crud.dao.OrderRepository;
import lt.techin.crud.dto.meal.MealDto;
import lt.techin.crud.dto.meal.MealEntityDto;
import lt.techin.crud.model.Meal;

import java.util.HashSet;
import java.util.Set;

public class MealMapper {

    private static OrderRepository orderRepository;
    private static MenuRepository menuRepository;

    public static Set<MealDto> toMealSetDto(Set<Meal> mealSet) {
        Set<MealDto> mealSetDto = new HashSet<>();

        mealSet.stream().forEach(meal -> mealSetDto.add(toMealDto(meal)));

        return mealSetDto;
    }

    public static Set<Meal> toMealSet(Set<MealDto> mealSetDto) {
        Set<Meal> mealSet = new HashSet<>();

        mealSet.stream().forEach(meal -> mealSet.add(meal));

        return mealSet;
    }

    public static MealDto toMealDto(Meal meal) {
        var mealDto = new MealDto();

        mealDto.setName(meal.getName());
        mealDto.setDescription(meal.getDescription());
        mealDto.setPrice(meal.getPrice());
        mealDto.setOrder(meal.getOrder().getId());
        mealDto.setMenu(meal.getMenu().getName());

        return mealDto;
    }

    public static MealEntityDto toMealEntityDto(Meal meal) {
        var mealEntityDto = new MealEntityDto();

        mealEntityDto.setName(meal.getName());
        mealEntityDto.setDescription(meal.getDescription());
        mealEntityDto.setPrice(meal.getPrice());
        mealEntityDto.setOrder(meal.getOrder().getId());
        mealEntityDto.setMenu(meal.getMenu().getName());
        mealEntityDto.setMenuId(meal.getMenu().getId());

        return mealEntityDto;
    }

    public static Meal toMeal(MealEntityDto mealEntityDto) {
        var meal = new Meal();

        meal.setName(mealEntityDto.getName());
        meal.setDescription(mealEntityDto.getDescription());
        meal.setPrice(mealEntityDto.getPrice());
        meal.setOrder(orderRepository.findById(mealEntityDto.getOrder()).get());
        meal.setMenu(menuRepository.findById(mealEntityDto.getMenuId()).get());

        return meal;
    }

    public static Meal toMeal(MealDto mealDto) {
        var meal = new Meal();

        meal.setName(mealDto.getName());
        meal.setDescription(mealDto.getDescription());
        meal.setPrice(mealDto.getPrice());
        meal.setOrder(orderRepository.findById(mealDto.getOrder()).get());
        meal.setMenu(menuRepository.findById(mealDto.getMenuId()).get());

        return meal;
    }
}
