package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.*;
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

        HospitalEntity hospitalEntity = new HospitalEntity();

        hospitalEntity.setName(hospitalForm.getName());
        hospitalEntity.setCountry(hospitalForm.getCountry());
        hospitalEntity.setTown(hospitalForm.getTown());
        hospitalEntity.setStreet(hospitalForm.getStreet());

        hospitalEntityRepository.save(hospitalEntity);
    }

    @Override
    public void deleteById(Long id) {
        hospitalEntityRepository.deleteById(id);
    }

    @Override
    public HospitalDTO findById(Long id) {
        return convertToHospitalDTO(hospitalEntityRepository.findById(id).orElse(null));
    }

    @Override
    public void editHospital(EditHospital editHospital) {

        HospitalEntity hospitalEntity = new HospitalEntity();
        hospitalEntity.setId(editHospital.getId());
        hospitalEntity.setName(editHospital.getName());
        hospitalEntity.setCountry(editHospital.getCountry());
        hospitalEntity.setTown(editHospital.getTown());
        hospitalEntity.setStreet(editHospital.getStreet());

        hospitalEntityRepository.save(hospitalEntity);
    }

    private HospitalDTO convertToHospitalDTO(HospitalEntity hospitalEntity) {
        return HospitalDTO.builder()
                .id(hospitalEntity.getId())
                .name(hospitalEntity.getName())
                .country(hospitalEntity.getCountry())
                .town(hospitalEntity.getTown())
                .street(hospitalEntity.getStreet())
                .build();

    }
}



