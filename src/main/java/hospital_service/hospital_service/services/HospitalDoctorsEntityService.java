package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.DoctorDTO;
import hospital_service.hospital_service.model.HospitalDoctorsEntity;
import hospital_service.hospital_service.model.HospitalDoctorsForm;

import java.util.List;

public interface HospitalDoctorsEntityService {

    void create(HospitalDoctorsForm hospitalDoctorsForm);

    List<HospitalDoctorDTO> findDoctorIdByHospitalId(Long id);
}
