package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.HospitalDoctorsEntity;
import hospital_service.hospital_service.model.HospitalDoctorsForm;
import hospital_service.hospital_service.repositories.DoctorEntityRepository;
import hospital_service.hospital_service.repositories.HospitalEntityRepository;
import hospital_service.hospital_service.repositories.HospitalsDoctorsEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalDoctorsEntityServiceImpl implements HospitalDoctorsEntityService {

    private final HospitalsDoctorsEntityRepository hospitalsDoctorsEntityRepository;

    public HospitalDoctorsEntityServiceImpl(HospitalsDoctorsEntityRepository hospitalsDoctorsEntityRepository, DoctorEntityRepository doctorEntityRepository, HospitalEntityRepository hospitalEntityRepository) {
        this.hospitalsDoctorsEntityRepository = hospitalsDoctorsEntityRepository;
    }

    @Override
    public void create(HospitalDoctorsForm hospitalDoctorsForm) {

        HospitalDoctorsEntity hospitalDoctorsEntity = new HospitalDoctorsEntity();

        hospitalDoctorsEntity.setContractStartDate(hospitalDoctorsForm.getContractStartDate());
        hospitalDoctorsEntity.setContractEndDate(hospitalDoctorsForm.getContractEndDate());
        hospitalDoctorsEntity.setPosition(hospitalDoctorsForm.getPosition());
        hospitalDoctorsEntity.setDoctorId(hospitalDoctorsForm.getDoctorId());
        hospitalDoctorsEntity.setHospitalID(hospitalDoctorsForm.getHospitalId());

        hospitalsDoctorsEntityRepository.save(hospitalDoctorsEntity);
    }

    @Override
    public List<HospitalDoctorsEntity> findDoctorIdByHospitalId(Long id) {
        return hospitalsDoctorsEntityRepository.findDoctorIdByHospitalId(id);
    }
}
