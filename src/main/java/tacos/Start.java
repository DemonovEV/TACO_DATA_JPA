package tacos;

import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Start {


    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);

        var session =
                new Configuration()
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory().openSession();
        System.out.println(session);
        System.out.println(session.find(Student.class, 2));
        var ss = session.find(Student.class, 2);


        //s.save(new Ingredient("ONE","TWO", Ingredient.Type.VEGGIES));
    }

}
