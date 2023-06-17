package lt.techin.crud.dto.mapper;

import lt.techin.crud.dto.menu.MenuDto;
import lt.techin.crud.dto.menu.MenuEntityDto;
import lt.techin.crud.model.Menu;

public class MenuMapper {

    public static MenuEntityDto toMenuEntityDto(Menu menu){
        var menuEntity = new MenuEntityDto();

        menuEntity.setName(menu.getName());
        menuEntity.setDescription(menu.getDescription());
        menuEntity.setMeals(menu.getMeals());

        return menuEntity;

    }

    public static Menu toMenu(MenuEntityDto menuEntityDto){
        var menu = new Menu();

        menu.setName(menuEntityDto.getName());
        menu.setDescription(menuEntityDto.getDescription());
    }
    public static Menu toMenu(MenuDto menuDto){

    }

}
