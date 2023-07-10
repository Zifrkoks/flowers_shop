package ru.zifrkoks.flowers_shop.models.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@Table(name = "basket_flowers")
public class FlowersInBasket {
    @Id
    private long id;
    @ManyToOne
    @MapsId("basket_id")
    private int basket; 
    @ManyToOne
    @MapsId("flower_id")
    private int flower;
    private int count;

}
