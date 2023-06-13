package lt.techin.crud.dto.menu;

import com.fasterxml.jackson.annotation.JsonFormat;
import lt.techin.crud.dto.meal.MealDto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class MenuDto {

    public String name;
    public Set<MealDto> meals;

    public String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;
    private String createdBy;
    private String modifiedBy;

    public MenuDto() {

    }

    public MenuDto(String name, Set<MealDto> meals, String description, LocalDateTime createdDate, LocalDateTime modifiedDate, String createdBy, String modifiedBy) {
        this.name = name;
        this.meals = meals;
        this.description = description;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MealDto> getMeals() {
        return meals;
    }

    public void setMeals(Set<MealDto> meals) {
        this.meals = meals;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuDto menuDto = (MenuDto) o;
        return Objects.equals(name, menuDto.name) && Objects.equals(meals, menuDto.meals) && Objects.equals(description, menuDto.description) && Objects.equals(createdDate, menuDto.createdDate) && Objects.equals(modifiedDate, menuDto.modifiedDate) && Objects.equals(createdBy, menuDto.createdBy) && Objects.equals(modifiedBy, menuDto.modifiedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, meals, description, createdDate, modifiedDate, createdBy, modifiedBy);
    }

    @Override
    public String

    toString() {
        return "MenuDto{" +
                "name='" + name + '\'' +
                ", meals=" + meals +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                '}';
    }
}
