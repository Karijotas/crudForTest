package lt.techin.crud.api;

import lombok.extern.slf4j.Slf4j;
import lt.techin.crud.api.dto.meal.MealDto;
import lt.techin.crud.api.dto.meal.MealEntityDto;
import lt.techin.crud.model.Meal;
import lt.techin.crud.service.MealService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static lt.techin.crud.api.dto.mapper.MealMapper.toMeal;
import static lt.techin.crud.api.dto.mapper.MealMapper.toMealEntityDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/meals" )
@Validated
@Slf4j
public class MealController {

    private final MealService service;

    public MealController(MealService mealService) {
        this.service = mealService;
    }

    @GetMapping
    @ResponseBody
    public List<Meal> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{mealId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MealEntityDto> getIndividual(@PathVariable Long mealId) {
        var optional = service.getById(mealId);

        return optional
                .map(meal -> ok(toMealEntityDto(meal)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Meal> create(@Valid @RequestBody MealEntityDto mealEntityDto) {
        return ok(service.create(toMeal(mealEntityDto)));
    }

    @PatchMapping("/{mealId}")
    public ResponseEntity<Meal> update(@PathVariable Long mealId, @Valid @RequestBody MealDto mealDto) {
        log.info("Trying to update meal by id: {}", mealId);
        return ok(service.update(mealId, toMeal(mealDto)));
    }

    @DeleteMapping("/delete/{mealId}")
    public ResponseEntity<Void> delete(@PathVariable Long mealId) {
        log.info("Trying to delete meal by id: {}", mealId);

        if (service.deleteById(mealId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
