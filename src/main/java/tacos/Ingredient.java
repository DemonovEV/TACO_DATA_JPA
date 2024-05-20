package tacos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Ingredient {

    @Id
    private String id;

    private String name;
    private Type type;

    @Getter
    public enum Type {
        WRAP("Designate your wrap:"),
        PROTEIN("Pick your protein:"),
        VEGGIES("Determine your veggies:"),
        CHEESE("Choose your cheese:"),
        SAUCE("Select your sauce:"),
        TEST("Choose TEST :"),
        HORSE("Choose your HORSE :");

        String title;

        Type(String title) {
            this.title = title;
        }
    }
}