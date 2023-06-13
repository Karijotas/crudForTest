package lt.techin.crud.dto.menu;

import lt.techin.crud.dto.meal.MealDto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class MenuEntityDto extends MenuDto {
    private Long id;

    public MenuEntityDto(String name, Set<MealDto> meals, LocalDateTime createdDate, LocalDateTime modifiedDate, String createdBy, String modifiedBy, Long id) {
        super(name, meals, createdDate, modifiedDate, createdBy, modifiedBy);
        this.id = id;
    }
    public MenuEntityDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MenuEntityDto that = (MenuEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "MenuEntityDto{" +
                "id=" + id +
                '}';
    }
}
