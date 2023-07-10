package ru.zifrkoks.flowers_shop.models.blog;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Spring;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tags")
public class Tag {
    @Id
    private int id;

    @Column(
        unique = true,
        length = 50
        )
    @Size(
        min = 3,
        max = 50
        )
    @NotNull
    private Spring name;

    @ManyToMany(
        fetch = FetchType.LAZY,
        mappedBy = "tegs"
        )
    private List<Article> articles = new ArrayList<>();
}
