package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.DoctorEntity;

import java.util.List;

public interface DoctorEntityService {
    List<DoctorEntity> findAll();
}
