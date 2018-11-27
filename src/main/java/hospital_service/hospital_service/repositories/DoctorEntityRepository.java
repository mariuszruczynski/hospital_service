package hospital_service.hospital_service.repositories;

import hospital_service.hospital_service.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorEntityRepository extends JpaRepository<DoctorEntity, Long> {
}
