package lt.techin.crud.api.dto.mapper;

import lt.techin.crud.api.dto.menu.MenuDto;
import lt.techin.crud.api.dto.menu.MenuEntityDto;
import lt.techin.crud.model.Menu;

public class MenuMapper {

    public static MenuEntityDto toMenuEntityDto(Menu menu) {
        var menuEntity = new MenuEntityDto();

        menuEntity.setId(menu.getId());
        menuEntity.setName(menu.getName());
        menuEntity.setDescription(menu.getDescription());
        menuEntity.setMeals(MealMapper.toMealSetDto(menu.getMeals()));

        return menuEntity;

    }

    public static Menu toMenu(MenuEntityDto menuEntityDto) {
        var menu = new Menu();

        menu.setName(menuEntityDto.getName());
        menu.setDescription(menuEntityDto.getDescription());
        menu.setMeals(MealMapper.toMealSet(menuEntityDto.getMeals()));

        return menu;
    }

    public static Menu toMenu(MenuDto menuDto) {
        var menu = new Menu();


        menu.setName(menuDto.getName());
        menu.setDescription(menuDto.getDescription());
        menu.setMeals(MealMapper.toMealSet(menuDto.getMeals()));

        return menu;
    }

}
