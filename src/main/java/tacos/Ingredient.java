package tacos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.Accessors;

@Entity

@Data
@NoArgsConstructor
@Accessors(chain = true)

public class Ingredient {
    @Id
    @Setter(AccessLevel.NONE)
    public Integer id;
    private String name;

}