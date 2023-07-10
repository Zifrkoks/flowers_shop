package ru.zifrkoks.flowers_shop.models.orders;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.flowers_shop.models.products.Flower;

@Data
@Entity
@NoArgsConstructor
public class OrderItem {
    @Id
    private int id;
    
    @ManyToOne
    @JoinColumn(
        referencedColumnName = "id",
        name = "flower_id",
        nullable = false
    )
    @NotBlank
    private Flower flower;
    
    @PositiveOrZero
    private int count;

    @ManyToOne
    @JoinColumn(
        referencedColumnName = "id",
        name = "order_id",
        nullable = false
    )
    @NotBlank
    private Order order;

}
