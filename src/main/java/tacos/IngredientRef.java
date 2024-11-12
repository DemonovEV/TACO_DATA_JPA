package tacos;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("INGREDIENT_COLLECTION")
public class IngredientRef {
    @Column("REF_TO_INGREDIENT")
    private final String ingredient;

}