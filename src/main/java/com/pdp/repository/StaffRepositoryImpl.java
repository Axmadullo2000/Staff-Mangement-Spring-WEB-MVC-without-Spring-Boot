package com.pdp.repository;

import com.pdp.dto.StaffDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public class StaffRepositoryImpl implements StaffRepo {
    private final List<StaffDTO> staffList = new ArrayList<>();

    @Override
    public void save(String id, StaffDTO staff) {
        if (findById(id).isPresent()) {
            StaffDTO staffDTO = findById(id).get();

            staffDTO.setFirstName(staff.getFirstName());
            staffDTO.setLastName(staff.getLastName());
            staffDTO.setEmail(staff.getEmail());
        }else {
            StaffDTO staffDTO = new StaffDTO();

            staffDTO.setId(UUID.randomUUID().toString());
            staffDTO.setFirstName(staff.getFirstName());
            staffDTO.setLastName(staff.getLastName());
            staffDTO.setEmail(staff.getEmail());

            staffList.add(staffDTO);
        }
    }

    @Override
    public List<StaffDTO> findAll() {
        return staffList;
    }

    @Override
    public Optional<StaffDTO> findById(String id) {
        return staffList.stream()
                .filter(s -> s.getId().equals(id)).findFirst();
    }

    @Override
    public void deleteById(String id) {
        staffList.removeIf(s -> s.getId().equals(id));
    }

}
