package hospital_service.hospital_service.repositories;

import hospital_service.hospital_service.model.HospitalDoctorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalsDoctorsEntityRepository extends JpaRepository<HospitalDoctorsEntity, Long> {


}
