package tacos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "student")
@Table(name = "STUDENT")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    Long studentId;

    @Column(name = "FNAMEE")
    String firstName;
    @Column(name = "LNAMEE")
    String lastName;
    @Column(name = "CONTACT_NO")
    String contactNo;

}