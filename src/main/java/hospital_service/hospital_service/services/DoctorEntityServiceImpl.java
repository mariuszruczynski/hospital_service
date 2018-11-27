package hospital_service.hospital_service.services;


import hospital_service.hospital_service.model.DoctorEntity;
import hospital_service.hospital_service.repositories.DoctorEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorEntityServiceImpl  implements  DoctorEntityService{

    private final DoctorEntityRepository doctorEntityRepository;

    public DoctorEntityServiceImpl(DoctorEntityRepository doctorEntityRepository) {
        this.doctorEntityRepository = doctorEntityRepository;
    }

    @Override
    public List<DoctorEntity> findAll() {
        return doctorEntityRepository.findAll();
    }
}
