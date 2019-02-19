package hospital_service.hospital_service.model;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class DoctorDTO {

    private Long id;
    private String name;
    private String surname;
    private String licenceNumber;
    private String nationality;
    private Long idUser;

}
