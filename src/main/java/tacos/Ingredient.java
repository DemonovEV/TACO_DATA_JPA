package tacos;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ingredient {
    @Id
    private String id;
    private String name;
    @Enumerated(EnumType.STRING) //В отсутствие аннотации @Enumerated Hibernate будет сохранять порядковый
            //(ORDINAL) номер значения
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