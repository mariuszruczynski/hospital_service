package hospital_service.hospital_service.repositories;

import hospital_service.hospital_service.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorEntityRepository extends JpaRepository<DoctorEntity, Long> {

}
