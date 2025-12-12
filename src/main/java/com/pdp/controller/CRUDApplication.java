package com.pdp.controller;


import com.pdp.dto.StaffDTO;
import com.pdp.entity.Staff;
import com.pdp.repository.StaffRepositoryImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@Controller
@RequestMapping("/")
public class CRUDApplication {
    private final StaffRepositoryImpl staffRepositoryImpl;

    public CRUDApplication(StaffRepositoryImpl staffRepositoryImpl) {
        this.staffRepositoryImpl = staffRepositoryImpl;
    }

    @PostMapping("/staff/add")
    public String save(@ModelAttribute StaffDTO staffDTO) {
        Staff staff = new Staff();

        staff.setId(UUID.randomUUID().toString());
        staff.setFirstName(staffDTO.getFirstName());
        staff.setLastName(staffDTO.getLastName());
        staff.setEmail(staffDTO.getEmail());

        staffRepositoryImpl.save(staff);
        return "redirect:/";
    }

    @GetMapping
    public String getStaffInfo(Model model) {
        model.addAttribute("staff", staffRepositoryImpl.findAll());
        return "index";
    }

    @GetMapping("/staff/update/{id}")
    public String update(@PathVariable("id") String id, @ModelAttribute StaffDTO staffDTO, Model model) {
        Optional<Staff> currentStaff = staffRepositoryImpl.findById(id);
        Staff staff = new Staff();

        if (currentStaff.isPresent()) {
            staff = currentStaff.get();
        }

        model.addAttribute("staff", staff);
        return "update";
    }

    @PostMapping("/staff/update/{id}")
    public String update(@PathVariable("id") String id, @ModelAttribute StaffDTO staffDTO) {
        Optional<Staff> currentStaff = staffRepositoryImpl.findById(id);

        Staff staff = new Staff();
        if (currentStaff.isPresent()) {
            staff = currentStaff.get();
            staff.setFirstName(staffDTO.getFirstName());
            staff.setLastName(staffDTO.getLastName());
            staff.setEmail(staffDTO.getEmail());
        }

        staffRepositoryImpl.update(staff);
        return "redirect:/";
    }

    @PostMapping("/staff/delete/{id}")
    public String delete(@ModelAttribute StaffDTO staffDTO) {
        staffRepositoryImpl.deleteById(staffDTO.getId());
        return "redirect:/";
    }
}
