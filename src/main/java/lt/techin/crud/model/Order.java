package lt.techin.crud.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @OneToMany(mappedBy = "order")
    private Set<Meal> meals;
}
