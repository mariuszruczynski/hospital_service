package hospital_service.hospital_service.services;

import hospital_service.hospital_service.model.HospitalEntity;
import org.springframework.stereotype.Service;

import java.util.List;



public interface HospitalEntityService {

    public List<HospitalEntity> findAll();

}
