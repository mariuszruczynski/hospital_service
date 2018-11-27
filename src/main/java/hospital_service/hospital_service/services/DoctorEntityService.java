package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.DoctorDTO;
import hospital_service.hospital_service.model.DoctorEntity;
import hospital_service.hospital_service.model.DoctorForm;
import hospital_service.hospital_service.model.EditDoctor;

import java.util.List;

public interface DoctorEntityService {
    List<DoctorEntity> findAll();

    void create(DoctorForm doctorForm);

    void deleteById(Long id);

    DoctorDTO findById(Long id);

    void editDoctor(EditDoctor editDoctor);
}
