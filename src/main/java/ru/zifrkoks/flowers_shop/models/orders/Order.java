package ru.zifrkoks.flowers_shop.models.orders;

import java.time.LocalDateTime;
import java.util.Map;

import org.hibernate.tool.schema.TargetType;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.flowers_shop.models.address.Address;
import ru.zifrkoks.flowers_shop.models.delivery.Courier;
import ru.zifrkoks.flowers_shop.models.products.Flower;
import ru.zifrkoks.flowers_shop.models.user.Account;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    private int id;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @Pattern(
        regexp = "^\\+\\d{11,15}$"
        )
    @Column(
        length = 15,
        nullable = false
        )
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
        name = "order_id"
        )
    private List<OrderItem> OrderItem = new ArrayList<>();

    @NotBlank
    @ManyToOne
    @JoinColumn(
        name = "customer_id",
        referencedColumnName = "id",
        nullable = false
    )
    private Account customer;

    @ManyToOne
    @JoinColumn(
        name = "courier_id",
        referencedColumnName = "id",
        nullable = false
        )
    @NotBlank
    private Courier courier;

    @NotBlank
    @ManyToOne
    @JoinColumn(
        name = "address_id",
        referencedColumnName = "id",
        nullable = false
    )
    private Address address;

    private LocalDateTime createdAt;

    private LocalDateTime closedAt;

    @PositiveOrZero
    private int rating;
}
