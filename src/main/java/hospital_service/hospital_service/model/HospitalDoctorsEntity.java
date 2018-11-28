package hospital_service.hospital_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private HospitalEntity hospitalEntity;
    @ManyToOne
    @JoinColumn(name = "dostor_id")
    private DoctorEntity dostorId;
    @Column (name = "contract_start_date")
    private LocalDate contractStartDate;
    @Column (name = "contract_end_date")
    private LocalDate ContractEndDate;
    @Column (name = "position")
    private String position;
}
