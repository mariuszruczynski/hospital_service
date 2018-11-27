package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.DoctorEntity;
import hospital_service.hospital_service.model.DoctorForm;

import java.util.List;

public interface DoctorEntityService {
    List<DoctorEntity> findAll();

    void create(DoctorForm doctorForm);

    void deleteById(Long id);
}
