package hospital_service.hospital_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditHospital {

    private Long id;
    private String name;
    private String country;
    private String town;
    private String street;

}
