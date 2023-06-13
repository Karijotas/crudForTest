package lt.techin.crud.controller;

import lt.techin.crud.dto.menu.MenuDto;
import lt.techin.crud.dto.menu.MenuEntityDto;
import lt.techin.crud.model.Menu;
import lt.techin.crud.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static lt.techin.crud.dto.mapper.MenuMapper.toMenu;
import static lt.techin.crud.dto.mapper.MenuMapper.toMenuEntityDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/menu")
@Validated
public class MenuController {

    private final Logger logger = LoggerFactory.getLogger(MenuController.class);
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    @ResponseBody
    public List<Menu> getAllMenus() {
        return menuService.getAll();
    }

    @GetMapping(value = "/{menuId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MenuEntityDto> getMenu(@PathVariable Long menuId) {
        var menuOptional = menuService.getById(menuId);

        return menuOptional
                .map(menu -> ok(toMenuEntityDto(menu)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Menu> createMenu(@Valid @RequestBody MenuEntityDto menuEntityDto) {
        return ok(menuService.create(toMenu(menuEntityDto)));
    }

    @PatchMapping("/{menuId}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long menuId, @Valid @RequestBody MenuDto menuDto) {
        logger.info("Trying to update menu by id: {}", menuId);
        return ok(menuService.update(menuId, toMenu(menuDto)));
    }

    @DeleteMapping("/delete/{menuId}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long menuId) {
        logger.info("Trying to delete menu by id: {}", menuId);

        if (menuService.deleteById(menuId)) {
          return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
