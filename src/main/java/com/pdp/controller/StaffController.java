package com.pdp.controller;


import com.pdp.dto.StaffDTO;
import com.pdp.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/staff/add")
    public String create(@ModelAttribute StaffDTO staffDTO) {
        staffService.save(staffDTO.getId(), staffDTO);
        return "redirect:/";
    }

    @GetMapping
    public String getStaff(Model model) {
        model.addAttribute("staff", staffService.findAll());
        return "index";
    }

    @GetMapping("/staff/update/{id}")
    public String getToUpdate(@PathVariable("id") String id, @ModelAttribute StaffDTO staffDTO, Model model) {
        StaffDTO staff = staffService.findById(id);
        model.addAttribute("staff", staff);
        return "update";
    }

    @PostMapping("/staff/update/{id}")
    public String update(@PathVariable("id") String id, @ModelAttribute StaffDTO staffDTO) {
        staffService.save(id, staffDTO);
        return "redirect:/";
    }

    @PostMapping("/staff/delete/{id}")
    public String delete(@ModelAttribute StaffDTO staffDTO) {
        staffService.deleteById(staffDTO.getId());
        return "redirect:/";
    }
}
