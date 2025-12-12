package com.pdp.repository;

import com.pdp.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class StaffRepositoryImpl implements StaffRepo {
    private final List<Staff> staffList = new ArrayList<>();

    @Override
    public void save(Staff staff) {
        staffList.add(staff);
    }

    @Override
    public List<Staff> findAll() {
        return staffList;
    }

    @Override
    public Optional<Staff> findById(String id) {
        return staffList.stream()
                .filter(s -> s.getId().equals(id)).findFirst();
    }

    @Override
    public void deleteById(String id) {
        staffList.removeIf(s -> s.getId().equals(id));
    }

    @Override
    public void update(Staff staff) {
        deleteById(staff.getId());
        staffList.add(staff);
    }
}
