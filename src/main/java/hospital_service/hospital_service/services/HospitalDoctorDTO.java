package hospital_service.hospital_service.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class HospitalDoctorDTO {

    private String name;
    private String surname;
    private String licenceNumber;
    private String position;
    private Date contractStartDate;
    private Date ContractEndDate;

}
