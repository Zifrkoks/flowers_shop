package ru.zifrkoks.flowers_shop.models.products;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.flowers_shop.models.user.Account;

@Entity
@Data
@NoArgsConstructor
@Table(name = "flower_reviews")
public class FlowerReview {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "flower_id", nullable = false)
    private Flower flower;
    private String text;
    private int rating;
    @JoinColumn(name = "author_id", nullable = false)
    private Account author;
}
