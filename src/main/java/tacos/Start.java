package tacos;

import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Start {


    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);

        var session=
         new Configuration()
                 .addAnnotatedClass(Ingredient.class)
                 .buildSessionFactory().openSession();
        System.out.println(session);
        System.out.println(session.find(Ingredient.class,"TMTO"));
        var transaction = session.beginTransaction();
        session.save(new Ingredient("one","two"));
        transaction.commit();


        //s.save(new Ingredient("ONE","TWO", Ingredient.Type.VEGGIES));
    }

}
