package lt.techin.crud.dto.orders;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntityDto extends OrderDto{
    private Long id;

}
