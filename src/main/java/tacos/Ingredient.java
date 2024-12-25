package tacos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Ingredient //implements Persistable<String> 
{

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

        private final String title;

        Type(String title) {
            this.title = title;
        }
    }
}