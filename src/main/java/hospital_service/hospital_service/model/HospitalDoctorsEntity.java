package hospital_service.hospital_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hospitals_doctors")
public class HospitalDoctorsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private HospitalEntity hospitalID;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctorId;
    @Column (name = "contract_start_date")
    private Date contractStartDate;
    @Column (name = "contract_end_date")
    private Date ContractEndDate;
    @Column (name = "position")
    private String position;
}
