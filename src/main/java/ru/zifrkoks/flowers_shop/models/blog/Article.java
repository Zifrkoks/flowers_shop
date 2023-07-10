package ru.zifrkoks.flowers_shop.models.blog;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.flowers_shop.models.products.Flower;
import ru.zifrkoks.flowers_shop.models.user.Account;

@Data
@Entity
@Table(name = "articles")
@NoArgsConstructor
public class Article {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(
        name = "author_username",
        nullable = false,
        unique = false,
        referencedColumnName = "username"
        )
    private Account author;

    @Column(
        name = "title",
        unique = true,
        nullable = false,
        length = 100
        )
    @Size(
        min = 5,
        max = 100
        )
    @NotNull
    private String title;

    @Column(
        name = "text",
        unique =  true,
        nullable = false,
        length = 10000
        )
    @NotNull
    @Size(
        min = 100,
        max = 10000
        )
    private String text;

    @PositiveOrZero
    private int views = 0;

    @PositiveOrZero
    private int rating = 0;

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "article",
        cascade = CascadeType.ALL
        )
    private List<ArticleReview> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "flowers_articles"
        )
    private List<Flower> flowers = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "tegs_articles"
        )
    private List<Tag> tags = new ArrayList<>();


}
