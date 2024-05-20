package tacos.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import tacos.IngredientRef;
import tacos.data.IngredientRepository;

//@Component //тут просто для демонстрации возможности
@RequiredArgsConstructor
public class IngredientByIdConverter implements Converter<String, IngredientRef> {

    private final IngredientRepository ingredientRepo;



    @Override
    public IngredientRef convert(String id) {
        return new IngredientRef(
                ingredientRepo.findById(id).orElse(null).getId()
                //,null

        );
        //  throw new IllegalArgumentException("Asdasda");
        // return ingredientRepo.findById(id).orElse(null);
    }

}
