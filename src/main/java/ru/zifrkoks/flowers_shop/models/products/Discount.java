package ru.zifrkoks.flowers_shop.models.products;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "discounts")
@NoArgsConstructor
public class Discount {
    @Id
    private int id;
    private int procent;
    private LocalDate startDiscount;
    private LocalDate finishDiscount;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "discounts")
    private List<Flower> flowers = new ArrayList<>();

}
