package ru.zifrkoks.flowers_shop.models.user;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.flowers_shop.models.address.Address;
import ru.zifrkoks.flowers_shop.models.blog.Article;
import ru.zifrkoks.flowers_shop.models.blog.ArticleReview;
import ru.zifrkoks.flowers_shop.models.orders.Order;
import ru.zifrkoks.flowers_shop.models.products.Flower;
import ru.zifrkoks.flowers_shop.models.products.FlowerReview;


@Data
@Entity
@NoArgsConstructor
@Table(name="users")
public class Account 
{
    @Id
    private int id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    private String fullName;

    @Column(unique = true,nullable = false)
    private String number;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "castomers")
    private List<Address> address = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "favorite-flowers_users")
    private List<Flower> favoriteFlowers = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "author")
    private List<FlowerReview> flowerReview = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "author")
    private List<ArticleReview> articleReview = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "author")
    private List<Article> articles = new ArrayList<>();
    
}
