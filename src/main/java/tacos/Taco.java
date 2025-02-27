package tacos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(exclude = "createdAt")
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
// TODO  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MY_OWN_SEQ")
    private Long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany
    @JoinTable(name = "INGREDIENT_COLLECTION",
            joinColumns =
            @JoinColumn(name = "ref_to_taco", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "ref_to_ingredient", referencedColumnName = "ID")
    )
    private List<Ingredient> ingredients = new ArrayList<>();
    //private List<Ingredient> ingredients;
/*
    public void addIngredient(Ingredient taco) {
        this.ingredients.add(new IngredientRef(taco.getId()));
    }
*/
}
