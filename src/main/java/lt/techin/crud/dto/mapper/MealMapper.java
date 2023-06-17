package lt.techin.crud.dto.mapper;

import lt.techin.crud.dto.meal.MealDto;
import lt.techin.crud.model.Meal;

import java.util.HashSet;
import java.util.Set;

public class MealMapper {

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
}
