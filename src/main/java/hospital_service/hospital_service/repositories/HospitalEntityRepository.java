package hospital_service.hospital_service.repositories;

import hospital_service.hospital_service.model.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalEntityRepository  extends JpaRepository<HospitalEntity, Long> {

    @Query(value = "SELECT * FROM hospitals WHERE id_user=:idUser", nativeQuery = true)
    List<HospitalEntity> findAll(@Param("idUser") Long userId);

}
