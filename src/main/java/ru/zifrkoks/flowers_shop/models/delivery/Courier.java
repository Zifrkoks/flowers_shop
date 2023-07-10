package ru.zifrkoks.flowers_shop.models.delivery;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.flowers_shop.models.address.Address;
import ru.zifrkoks.flowers_shop.models.orders.Order;

@Data
@Entity
@NoArgsConstructor
@Table(name = "couriers")
public class Courier {
    @Id
    private int id;

    private boolean isActive = true; 
    @Column(
        nullable = false,
        length = 32
        )
    @NotNull
    private String name;

    @Column(
        nullable = false,
        length = 32
        )
    @NotNull
    private String surname;

    @Column(length = 35,nullable = true)
    private String patronymic;

    @Column(
        name = "username",
        unique = true,
        nullable = false
        )
    @NotNull
    @Size(min = 3,max = 32)
    private String username;

    @NotNull
    @Column(
        nullable = false
        )
    @Size(min = 8,max = 32)
    private String password;
    
    @Size(min = 11, max = 11)
    private String passportData;

    @OneToMany(
        mappedBy = "courier",
        cascade = {CascadeType.REFRESH,CascadeType.PERSIST}
        )
    private List<Order> orders = new ArrayList<>();

    @PositiveOrZero
    private int rating;

    @ManyToOne
    private Address lastAddress;

    @ManyToOne
    private Address homeAddress;

}
