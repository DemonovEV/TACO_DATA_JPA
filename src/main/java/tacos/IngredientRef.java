package tacos;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("INGREDIENT_COLLECTION") // Указание таблицы хранения. Без  будет INGREDIENT_REF
public class IngredientRef {
    @Column("REF_TO_INGREDIENT") // Без указания колонка буден называться как поле - >INGREDIENT
    private final String ingredient;
}