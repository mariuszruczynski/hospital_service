package hospital_service.hospital_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDoctorsForm {

    private Long hospitalId;
    private Long doctorId;
    private Date contractStartDate;
    private Date ContractEndDate;
    private String position;

}
