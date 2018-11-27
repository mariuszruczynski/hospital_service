package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.HospitalEntity;
import hospital_service.hospital_service.model.HospitalForm;
import hospital_service.hospital_service.repositories.HospitalEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitaEntityServiceImpl implements HospitalEntityService {

   private final HospitalEntityRepository hospitalEntityRepository;

    public HospitaEntityServiceImpl(HospitalEntityRepository hospitalEntityRepository) {
        this.hospitalEntityRepository = hospitalEntityRepository;
    }

    @Override
    public List<HospitalEntity> findAll() {
        return hospitalEntityRepository.findAll();
    }

    @Override
    public void create(HospitalForm hospitalForm) {

    }
}
