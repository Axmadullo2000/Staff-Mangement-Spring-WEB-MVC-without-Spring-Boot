package com.pdp.repository;

import com.pdp.dto.StaffDTO;

import java.util.List;
import java.util.Optional;

public interface StaffRepo {
    void save(String id, StaffDTO staffDTO);

    List<StaffDTO> findAll();

    Optional<StaffDTO> findById(String id);

    void deleteById(String id);
}
