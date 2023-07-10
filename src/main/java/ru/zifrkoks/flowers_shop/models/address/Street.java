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
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "streets")
@NoArgsConstructor
public class Street {
    @Id
    private int id;

    @Column(
        nullable = false,
        length = 150
        )
    @Size(
        min = 3,
        max = 150
        )
    private String name;
    
    @ManyToOne(
        fetch = FetchType.LAZY
        )
    @JoinColumn(
        name = "city_id",
        unique = false,
        nullable = false
        )
    private City city;
    @OneToMany(
        mappedBy = "city",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL
        )
    private List<Address> addresses = new ArrayList<>();
}
