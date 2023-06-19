package lt.techin.crud.service;

import lt.techin.crud.config.exception.CustomValidationException;
import lt.techin.crud.dao.MealRepository;
import lt.techin.crud.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static lt.techin.crud.service.FinderClass.findMeal;

@Service
public class MealService {
    private final MealRepository repository;

    private final Validator validator;

    @Autowired
    public MealService(MealRepository mealRepository, Validator validator) {
        this.repository = mealRepository;
        this.validator = validator;
    }

    void validateInputWithInjectedValidator(Meal meal) {
        Set<ConstraintViolation<Meal>> violations = validator.validate(meal);
        if (!violations.isEmpty()) {
            throw new CustomValidationException(violations.toString(), "Meal", "Error in meal entity", meal.toString());
        }
    }

    public List<Meal> getAll() {
        return repository.findAll();
    }

    public Optional<Meal> getById(Long id) {
        return repository.findById(id);
    }

    public Meal create(Meal meal) {
        var newMeal = new Meal();

        newMeal.setId(meal.getId());
        newMeal.setName(meal.getName());
        newMeal.setDescription(meal.getDescription());
        newMeal.setPrice(meal.getPrice());
        newMeal.setMenu(meal.getMenu());
        newMeal.setOrder(meal.getOrder());
        newMeal.setAmount(meal.getAmount());
        newMeal.setImageURL(meal.getImageURL());

        return repository.save(newMeal);
    }

    public Meal update(Long id, Meal meal) {
        validateInputWithInjectedValidator(meal);
        Meal existing = findMeal(id);

        existing.setName(meal.getName());
        existing.setDescription(meal.getDescription());
        existing.setPrice(meal.getPrice());
        existing.setMenu(meal.getMenu());
        existing.setOrder(meal.getOrder());
        existing.setAmount(meal.getAmount());
        existing.setImageURL(meal.getImageURL());

        return repository.save(existing);
    }

    public Boolean deleteById(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}