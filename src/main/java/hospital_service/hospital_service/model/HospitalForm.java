package hospital_service.hospital_service.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class HospitalForm {

    private String name;
    private String country;
    private String town;
    private String street;
    private Long idUser;

}
