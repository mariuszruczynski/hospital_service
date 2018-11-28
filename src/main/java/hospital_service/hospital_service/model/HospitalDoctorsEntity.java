package hospital_service.hospital_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hospitals_doctors")
public class HospitalDoctorsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "hospital_id")
    private Long hospitalID;
    @Column(name = "doctor_id")
    private Long doctorId;
    @Column(name = "contract_start_date")
    private Date contractStartDate;
    @Column(name = "contract_end_date")
    private Date ContractEndDate;
    @Column(name = "position")
    private String position;
}
