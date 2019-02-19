package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.HospitalDoctorsEntity;
import hospital_service.hospital_service.model.HospitalDoctorsForm;
import hospital_service.hospital_service.repositories.HospitalsDoctorsEntityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalDoctorsEntityServiceImpl implements HospitalDoctorsEntityService {

    private final HospitalsDoctorsEntityRepository hospitalsDoctorsEntityRepository;
    private final DoctorEntityService doctorEntityService;
    private final UserUtils userUtils;

    public HospitalDoctorsEntityServiceImpl(HospitalsDoctorsEntityRepository hospitalsDoctorsEntityRepository, DoctorEntityService doctorEntityService, UserUtils userUtils) {
        this.hospitalsDoctorsEntityRepository = hospitalsDoctorsEntityRepository;
        this.doctorEntityService = doctorEntityService;
        this.userUtils = userUtils;
    }

    @Override
    public void create(HospitalDoctorsForm hospitalDoctorsForm) {

        HospitalDoctorsEntity hospitalDoctorsEntity = getHospitalDoctorsEntity(hospitalDoctorsForm);
        hospitalsDoctorsEntityRepository.save(hospitalDoctorsEntity);
    }



    @Override
    public List<HospitalDoctorDTO> findDoctorIdByHospitalId(Long id) {
        List<HospitalDoctorDTO> hospitalDoctorDTOS = new ArrayList<>();
        for (HospitalDoctorsEntity e : hospitalsDoctorsEntityRepository.findDoctorIdByHospitalId(id)) {
            HospitalDoctorDTO hospitalDoctorDTO = getHospitalDoctorDTO(e);
            hospitalDoctorDTOS.add(hospitalDoctorDTO);
        }
        return hospitalDoctorDTOS;
    }

    private HospitalDoctorsEntity getHospitalDoctorsEntity(HospitalDoctorsForm hospitalDoctorsForm) {

        HospitalDoctorsEntity hospitalDoctorsEntity = new HospitalDoctorsEntity();
        hospitalDoctorsEntity.setContractStartDate(hospitalDoctorsForm.getContractStartDate());
        hospitalDoctorsEntity.setContractEndDate(hospitalDoctorsForm.getContractEndDate());
        hospitalDoctorsEntity.setPosition(hospitalDoctorsForm.getPosition());
        hospitalDoctorsEntity.setDoctorId(hospitalDoctorsForm.getDoctorId());
        hospitalDoctorsEntity.setHospitalID(hospitalDoctorsForm.getHospitalId());
        hospitalDoctorsEntity.setIdUser(userUtils.getLoggedUserId());
        return hospitalDoctorsEntity;
    }

    private HospitalDoctorDTO getHospitalDoctorDTO(HospitalDoctorsEntity e) {

        return new HospitalDoctorDTO(
                doctorEntityService.findById(e.getDoctorId()).getName(),
                doctorEntityService.findById(e.getDoctorId()).getSurname(),
                doctorEntityService.findById(e.getDoctorId()).getLicenceNumber(),
                e.getPosition(),
                e.getContractStartDate(),
                e.getContractEndDate());
    }
}
