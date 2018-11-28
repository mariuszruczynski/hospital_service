package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.HospitalDoctorsEntity;
import hospital_service.hospital_service.model.HospitalDoctorsForm;
import hospital_service.hospital_service.repositories.DoctorEntityRepository;
import hospital_service.hospital_service.repositories.HospitalEntityRepository;
import hospital_service.hospital_service.repositories.HospitalsDoctorsEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class HospitalDoctorsEntityServiceImpl implements HospitalDoctorsEntityService {

    private final HospitalsDoctorsEntityRepository hospitalsDoctorsEntityRepository;

    private final DoctorEntityRepository doctorEntityRepository;
    private final HospitalEntityRepository hospitalEntityRepository;

    public HospitalDoctorsEntityServiceImpl(HospitalsDoctorsEntityRepository hospitalsDoctorsEntityRepository, DoctorEntityRepository doctorEntityRepository, HospitalEntityRepository hospitalEntityRepository) {
        this.hospitalsDoctorsEntityRepository = hospitalsDoctorsEntityRepository;
        this.doctorEntityRepository = doctorEntityRepository;
        this.hospitalEntityRepository = hospitalEntityRepository;
    }

    @Override
    public void create(HospitalDoctorsForm hospitalDoctorsForm) {

        HospitalDoctorsEntity hospitalDoctorsEntity = new HospitalDoctorsEntity();

        hospitalDoctorsEntity.setContractStartDate(hospitalDoctorsForm.getContractStartDate());
        hospitalDoctorsEntity.setContractEndDate(hospitalDoctorsForm.getContractEndDate());
        hospitalDoctorsEntity.setPosition(hospitalDoctorsForm.getPosition());
        hospitalDoctorsEntity.setDoctorId(doctorEntityRepository.getOne(hospitalDoctorsForm.getDoctorId()));
        hospitalDoctorsEntity.setHospitalID(hospitalEntityRepository.getOne(hospitalDoctorsForm.getHospitalId()));

        hospitalsDoctorsEntityRepository.save(hospitalDoctorsEntity);
    }
}
