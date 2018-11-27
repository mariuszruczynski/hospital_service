package hospital_service.hospital_service.services;


import hospital_service.hospital_service.model.DoctorEntity;
import hospital_service.hospital_service.model.DoctorForm;
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

}
