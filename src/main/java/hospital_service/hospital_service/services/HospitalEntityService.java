package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.*;
import org.springframework.stereotype.Service;

import java.util.List;



public interface HospitalEntityService {

    List<HospitalEntity> findAll();

    void create(HospitalForm hospitalForm);

    void deleteById(Long id);

    HospitalDTO findById(Long id);

    void editHospital(EditHospital editHospital);
}
