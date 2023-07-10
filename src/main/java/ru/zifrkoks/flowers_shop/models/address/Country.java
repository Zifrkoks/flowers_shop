package ru.zifrkoks.flowers_shop.models.address;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "countries")
public class Country {
    @Id
    private int id;

    @NotNull
    @Size(
        min = 3,
        max = 64
        )
    @Column(
        name = "name",
        unique = true,
        nullable = false,
        length = 64
        )
    private String name;
    
    private boolean delivery;
    
    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "country",
        cascade = CascadeType.ALL
        )
    private List<City> cities = new ArrayList<>();

    @OneToMany(
        mappedBy = "city",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL
        )
    private List<Address> addresses = new ArrayList<>();
}
