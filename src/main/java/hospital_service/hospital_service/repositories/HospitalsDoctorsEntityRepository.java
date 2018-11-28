package hospital_service.hospital_service.repositories;

import hospital_service.hospital_service.model.HospitalDoctorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HospitalsDoctorsEntityRepository extends JpaRepository<HospitalDoctorsEntity, Long> {

    @Query("SELECT doct FROM HospitalDoctorsEntity doct WHERE doct.hospitalID=:hospitalId")
    List<HospitalDoctorsEntity> findDoctorIdByHospitalId(@Param("hospitalId") Long id);

}
