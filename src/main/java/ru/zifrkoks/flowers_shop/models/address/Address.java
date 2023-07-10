package ru.zifrkoks.flowers_shop.models.address;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.flowers_shop.models.user.Account;

@Data
@Entity
@Table(name = "addresses")
@NoArgsConstructor
public class Address 
{
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(
        name ="country_name",
        referencedColumnName = "name"
        )
    private Country country;

    @ManyToOne
    @JoinColumn(
        name ="city_name",
        referencedColumnName = "name"
        )
    private City city;
    
    @ManyToOne
    @JoinColumn(
        name ="street_name",
        referencedColumnName = "name"
        )
    private Street street;
    
    @Column(
        length = 10,
        nullable = false
        )
    private String house;
    
    @Column(length = 5)
    private String apartements;
    
    @ManyToMany
    @JoinTable(name = "castomers_addresses")
    private List<Account> castomers = new ArrayList<>();
}
