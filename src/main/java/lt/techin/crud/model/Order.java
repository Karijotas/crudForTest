package lt.techin.crud.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @OneToMany(mappedBy = "order")
    private Set<Meal> meals;
    @NotBlank
    private String customerName;
    @Email
    private String customerEmail;
    @NotBlank
    private String customerPhoneNumber;
    @NotBlank
    private BigDecimal totalAmount;
    @NotBlank
    private String address;
    @NotBlank
    private String status;
    @NotBlank
    private String trackingNumber;
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
        modifiedDate = LocalDateTime.now();
        createdBy = "FoodCourt app";
        modifiedBy = "FoodCourt app";
    }

    @PreUpdate
    public void preUpdate() {
        modifiedDate = LocalDateTime.now();
        modifiedBy = "FoodCourt app";
    }
}
