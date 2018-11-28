package hospital_service.hospital_service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "name")
    private String name;
    @Column (name = "surname")
    private String surname;
    @Column(name = "licence_number", unique = true, nullable = false)
    private String licenceNumber;
    @Column (name = "nationality")
    private String nationality;

}
