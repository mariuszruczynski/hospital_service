package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.*;
import hospital_service.hospital_service.repositories.HospitalEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalEntityServiceImpl implements HospitalEntityService {

    private final HospitalEntityRepository hospitalEntityRepository;
    private final UserUtils userUtils;

    public HospitalEntityServiceImpl(HospitalEntityRepository hospitalEntityRepository, UserUtils userUtils) {
        this.hospitalEntityRepository = hospitalEntityRepository;
        this.userUtils = userUtils;
    }

    @Override
    public List<HospitalEntity> findAll() {
        return hospitalEntityRepository.findAll(userUtils.getLoggedUserId());
    }

    @Override
    public void create(HospitalForm hospitalForm) {

        HospitalEntity hospitalEntity = new HospitalEntity();

        hospitalEntity.setName(hospitalForm.getName());
        hospitalEntity.setCountry(hospitalForm.getCountry());
        hospitalEntity.setTown(hospitalForm.getTown());
        hospitalEntity.setStreet(hospitalForm.getStreet());
        hospitalEntity.setIdUser(userUtils.getLoggedUserId());

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
        hospitalEntity.setIdUser(userUtils.getLoggedUserId());

        hospitalEntityRepository.save(hospitalEntity);
    }

    private HospitalDTO convertToHospitalDTO(HospitalEntity hospitalEntity) {
        return HospitalDTO.builder()
                .id(hospitalEntity.getId())
                .name(hospitalEntity.getName())
                .country(hospitalEntity.getCountry())
                .town(hospitalEntity.getTown())
                .street(hospitalEntity.getStreet())
                .idUser(hospitalEntity.getIdUser())
                .build();

    }
}



