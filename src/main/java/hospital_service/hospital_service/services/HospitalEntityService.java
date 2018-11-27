package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.HospitalEntity;
import hospital_service.hospital_service.model.HospitalForm;
import org.springframework.stereotype.Service;

import java.util.List;



public interface HospitalEntityService {

    List<HospitalEntity> findAll();

    void create(HospitalForm hospitalForm);

    void deleteById(Long id);
}
