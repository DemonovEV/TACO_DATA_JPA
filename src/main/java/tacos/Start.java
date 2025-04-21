package tacos;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Properties;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Start {


    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
        System.out.println(
                Student.class.isAssignableFrom(Student.class)
        );

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5436/gele_main?currentSchema=taco_step4");
        properties.put(Environment.USER, "gele_usr");
        properties.put(Environment.PASS, "gele_usr");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "create");


        var session=
         new Configuration()
               // .addProperties(properties)
                 .addAnnotatedClass(Student.class)
                 .configure()
                 .buildSessionFactory().openSession();
        System.out.println(session);
        var fff=session.find(Student.class,2);
        System.out.println(fff);
       var transaction = session.beginTransaction();
        var obj=new Student().setFirstName("as");
        fff.setFirstName("HORRR");
        session.save(fff);
       transaction.commit();
    }

}
