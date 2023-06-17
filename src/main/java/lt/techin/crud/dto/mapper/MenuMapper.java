package lt.techin.crud.dto.mapper;

import lt.techin.crud.dto.menu.MenuDto;
import lt.techin.crud.dto.menu.MenuEntityDto;
import lt.techin.crud.model.Menu;

import static lt.techin.crud.dto.mapper.MealMapper.toMealSet;
import static lt.techin.crud.dto.mapper.MealMapper.toMealSetDto;

public class MenuMapper {

    public static MenuEntityDto toMenuEntityDto(Menu menu) {
        var menuEntity = new MenuEntityDto();

        menuEntity.setName(menu.getName());
        menuEntity.setDescription(menu.getDescription());
        menuEntity.setMeals(toMealSetDto(menu.getMeals()));

        return menuEntity;

    }

    public static Menu toMenu(MenuEntityDto menuEntityDto) {
        var menu = new Menu();

        menu.setName(menuEntityDto.getName());
        menu.setDescription(menuEntityDto.getDescription());
        menu.setMeals(toMealSet(menuEntityDto.getMeals()));

        return menu;
    }

    public static Menu toMenu(MenuDto menuDto) {
        var menu = new Menu();


        menu.setName(menuDto.getName());
        menu.setDescription(menuDto.getDescription());
        menu.setMeals(toMealSet(menuDto.getMeals()));

        return menu;
    }

}
