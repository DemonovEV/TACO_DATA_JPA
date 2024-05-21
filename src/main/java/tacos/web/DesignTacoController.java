package tacos.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import tacos.Ingredient;
import tacos.Taco;
import tacos.TacoOrder;
import tacos.data.IngredientRepository;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        var ingredients = ingredientRepo.findAll();
        model.addAttribute("Ingredient_types",
                StreamSupport.stream(ingredients.spliterator(), false)
                        .collect(
                                Collectors.groupingBy(Ingredient::getType)
                        )
        );
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(
            @RequestBody String body,
            @RequestParam Map<String, String> param_map,
            @PathVariable Map<String, String> path_map,
            @RequestHeader Map<String, String> header_map,

            @Valid Taco taco, Errors errors,
            @Valid @ModelAttribute TacoOrder tacoOrder, Errors errors2

    ) {

        if (errors.hasErrors()) {
            return "design";
        }

        tacoOrder.addTaco(taco);

        return "redirect:/orders/current";
    }

}