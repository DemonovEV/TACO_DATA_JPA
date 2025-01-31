package tacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Start {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }

  /*  @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo,
                                        OrderRepository orders
                                        ) {

        return args -> {
            //   orders.deleteAll();
            //  repo.deleteAll();

            if (repo.count() == 0) {

               repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
                repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
            repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
            repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
            repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

            repo.save(new Ingredient("TST1", "TEST1", Type.TEST));
            repo.save(new Ingredient("TST2", "TEST2", Type.TEST));
            repo.save(new Ingredient("TST3", "TEST3", Type.TEST));
            }


        };
    }*/

}
