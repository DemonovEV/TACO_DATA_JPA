package tacos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
// Todo@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MY_OWN_SEQ")
    private Long id;

    private Date placedAt = new Date();

    @NotBlank(message = "Delivery name is required")
    private String deliveryName = "12";

    @NotBlank(message = "Street is required")
    private String deliveryStreet = "12";

    @NotBlank(message = "City is required")
    private String deliveryCity = "12";

    @NotBlank(message = "State is required")
    private String deliveryState = "12";

    @NotBlank(message = "Zip code is required")
    private String deliveryZip = "12";

    // @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber = "12";

    //@Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
    //    message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Column(name = "CC_CVV")
    // @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "REF_TO_TACO_ORDER", nullable = false)
    // Добавляет колонку для связи insert into taco (ref_to_taco_order1,created_at,name,id) values (?,?,?,?)
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }

}