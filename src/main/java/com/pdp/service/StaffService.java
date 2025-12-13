package com.pdp.service;

import com.pdp.dto.StaffDTO;
import com.pdp.repository.StaffRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StaffService {
    private final StaffRepositoryImpl staffRepositoryImpl;

    public StaffService(StaffRepositoryImpl staffRepositoryImpl) {
        this.staffRepositoryImpl = staffRepositoryImpl;
    }

    public void save(String id, StaffDTO newStaffDTO) {
        staffRepositoryImpl.save(id, newStaffDTO);
    }

    public List<StaffDTO> findAll() {
        return staffRepositoryImpl.findAll();
    }

    public StaffDTO findById(String id) {
        return staffRepositoryImpl.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        staffRepositoryImpl.deleteById(id);
    }

}
