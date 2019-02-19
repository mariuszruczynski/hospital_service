package hospital_service.hospital_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorForm {

    private Long id;
    private String name;
    private String surname;
    private String licenceNumber;
    private String nationality;
    private Long idUser;

}
