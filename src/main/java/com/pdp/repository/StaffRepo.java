package com.pdp.repository;

import com.pdp.entity.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffRepo {
    void save(Staff staff);

    void update(Staff staff);

    List<Staff> findAll();

    Optional<Staff> findById(String id);

    void deleteById(String id);
}
