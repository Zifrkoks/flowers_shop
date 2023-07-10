package ru.zifrkoks.flowers_shop.models.products;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.flowers_shop.models.blog.Article;
import ru.zifrkoks.flowers_shop.models.blog.Tag;
import ru.zifrkoks.flowers_shop.models.user.Account;
import ru.zifrkoks.flowers_shop.models.user.FlowersInBasket;

@Data
@Entity
@NoArgsConstructor
@Table(name = "flowers")
public class Flower {
    @Id
    private String id;
    private int price;
    private int count;
    private String name;
    private String description;
    @OneToMany(mappedBy = "flower", cascade = CascadeType.ALL)
    private List<FlowerReview> flowerReviews = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "tegs_flowers")
    private List<Tag> tegs = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "flowers")
    private List<Article> articles = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "flowers_discounts")
    private List<Discount> discounts = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "flowers")
    private List<FlowersInBasket> baskets;
}
