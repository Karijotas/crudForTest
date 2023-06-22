package lt.techin.crud.api;

import lombok.extern.slf4j.Slf4j;
import lt.techin.crud.api.dto.menu.MenuDto;
import lt.techin.crud.api.dto.menu.MenuEntityDto;
import lt.techin.crud.model.Menu;
import lt.techin.crud.service.MenuService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static lt.techin.crud.api.dto.mapper.MenuMapper.toMenu;
import static lt.techin.crud.api.dto.mapper.MenuMapper.toMenuEntityDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/menu")
@Validated
@Slf4j
public class MenuController {

    private final MenuService service;

    public MenuController(MenuService menuService) {
        this.service = menuService;
    }

    @GetMapping
    @ResponseBody
    public List<Menu> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{menuId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MenuEntityDto> getIndividual(@PathVariable Long menuId) {
        var menuOptional = service.getById(menuId);

        return menuOptional
                .map(menu -> ok(toMenuEntityDto(menu)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Menu> create(@Valid @RequestBody MenuEntityDto menuEntityDto) {
        return ok(service.create(toMenu(menuEntityDto)));
    }

    @PatchMapping("/{menuId}")
    public ResponseEntity<Menu> update(@PathVariable Long menuId, @Valid @RequestBody MenuDto menuDto) {
        log.info("Trying to update menu by id: {}", menuId);
        return ok(service.update(menuId, toMenu(menuDto)));
    }

    @DeleteMapping("/delete/{menuId}")
    public ResponseEntity<Void> delete(@PathVariable Long menuId) {
        log.info("Trying to delete menu by id: {}", menuId);

        if (service.deleteById(menuId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PatchMapping("/{menuId}/add/{mealId]")
    public ResponseEntity<Menu> addMealToMenu(@PathVariable Long mealId, @PathVariable Long menuId) {
        log.info("Trying to add a meal {} to menu {}", mealId, menuId);
        return ok(service.addMealToMenu(mealId, menuId));
    }
}
