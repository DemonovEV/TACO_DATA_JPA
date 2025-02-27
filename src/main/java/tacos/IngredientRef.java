package tacos;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("ingredient_collection") // Указание таблицы хранения. Без  будет INGREDIENT_REF
public class IngredientRef {
    @Column("ref_to_ingredient") // Без указания колонка буден называться как поле - >INGREDIENT
    private final String ingredient;
}