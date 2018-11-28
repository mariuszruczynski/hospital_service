package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.DoctorDTO;
import hospital_service.hospital_service.model.DoctorEntity;
import hospital_service.hospital_service.model.DoctorForm;
import hospital_service.hospital_service.model.EditDoctor;
import hospital_service.hospital_service.repositories.DoctorEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorEntityServiceImpl implements DoctorEntityService {

    private final DoctorEntityRepository doctorEntityRepository;

    public DoctorEntityServiceImpl(DoctorEntityRepository doctorEntityRepository) {
        this.doctorEntityRepository = doctorEntityRepository;
    }

    @Override
    public List<DoctorEntity> findAll() {
        return doctorEntityRepository.findAll();
    }

    @Override
    public void create(DoctorForm doctorForm) {

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setName(doctorForm.getName());
        doctorEntity.setSurname(doctorForm.getSurname());
        doctorEntity.setLicenceNumber(doctorForm.getLicenceNumber());
        doctorEntity.setNationality(doctorForm.getNationality());

        doctorEntityRepository.save(doctorEntity);
    }

    @Override
    public void deleteById(Long id) {
        doctorEntityRepository.deleteById(id);

    }

    @Override
    public DoctorDTO findById(Long id) {
        return convertToDoctorDTO(doctorEntityRepository.findById(id).orElse(null));
    }

    private DoctorDTO convertToDoctorDTO(DoctorEntity doctorEntity) {
        return DoctorDTO.builder()
                .id(doctorEntity.getId())
                .name(doctorEntity.getName())
                .surname(doctorEntity.getSurname())
                .licenceNumber(doctorEntity.getLicenceNumber())
                .nationality(doctorEntity.getNationality())
                .build();
    }

    public void editDoctor(EditDoctor editDoctor) {

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(editDoctor.getId());
        doctorEntity.setName(editDoctor.getName());
        doctorEntity.setSurname(editDoctor.getSurname());
        doctorEntity.setLicenceNumber(editDoctor.getLicenceNumber());
        doctorEntity.setNationality(editDoctor.getNationality());

        doctorEntityRepository.save(doctorEntity);

    }
}
