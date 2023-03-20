package com.ehms.ehmsdemo.controller;

import com.ehms.ehmsdemo.model.Doctor;
import com.ehms.ehmsdemo.repository.DoctorRepository;
import com.ehms.ehmsdemo.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorRepository repo;

    @Autowired
    SearchRepository srepo;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(value = "/doctors")
    public List<Doctor> getAllDoctor() {
        return repo.findAll();
    }

    @GetMapping(value = "/doctors/{text}")
    public List<Doctor> searchDoctor(@PathVariable String text) {
        return srepo.searchByTest(text);
    }

    @PostMapping("/doctor")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return repo.save(doctor);
    }

}
