package ru.zifrkoks.flowers_shop.models.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.flowers_shop.models.address.Address;
import ru.zifrkoks.flowers_shop.models.products.Flower;

@Data
@Entity
@Table(name = "baskets")
@NoArgsConstructor
public class Basket {
    @Id
    private int id;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "basket")
    private Account account;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "basket")
    private List<FlowersInBasket> flowers = new ArrayList<>();
    private Address address;
}
