package tacos;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("REF_TO_INGREDIENT")
public class IngredientRef {

    private final String ingredient;

}