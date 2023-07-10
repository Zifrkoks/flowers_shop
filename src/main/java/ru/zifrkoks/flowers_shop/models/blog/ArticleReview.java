package ru.zifrkoks.flowers_shop.models.blog;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.flowers_shop.models.user.Account;

@Data
@Entity
@NoArgsConstructor
@Table(name = "article_views")
public class ArticleReview {
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

    @ManyToOne
    @JoinColumn(
        name = "article_id",
        nullable = false
        )
    private Article article;

    @Column(
        nullable = true
        )
    @Size(max = 255)
    private String text;

    @PositiveOrZero
    private int rating;
}
