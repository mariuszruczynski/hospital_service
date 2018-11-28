package hospital_service.hospital_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDoctorsForm {

    private Long hospitalId;
    private Long doctorId;
    private LocalDate contractStartDate;
    private LocalDate ContractEndDate;
    private String position;

}
