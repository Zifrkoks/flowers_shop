package ru.zifrkoks.flowers_shop.models.address;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cities")
@NoArgsConstructor
public class City {
    @Id
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "country_id",
        unique = false,
        nullable = false
        )
    private Country country;
    
    @Column(
        length = 24,
        nullable = false
        )
    @Size(
        min = 2,
        max = 24
        )
    @NotNull
    private String name;
    
    private boolean delivery;
    
    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "city",
        cascade = CascadeType.ALL
        )
    private List<Street> streets = new ArrayList<>();

    @OneToMany(
        mappedBy = "city",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL
        )
    private List<Address> addresses = new ArrayList<>();

}
