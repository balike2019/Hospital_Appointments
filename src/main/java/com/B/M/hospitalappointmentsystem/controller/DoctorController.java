package com.B.M.hospitalappointmentsystem.controller;

import com.B.M.hospitalappointmentsystem.bean.DoctorBean;
import com.B.M.hospitalappointmentsystem.bean.PatientBean;
import com.B.M.hospitalappointmentsystem.service.DoctorService;
import com.B.M.hospitalappointmentsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;


    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DoctorBean>> getAllDoctors() {
        List<DoctorBean> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorBean> getDoctorById(@PathVariable Long id) {
        DoctorBean doctor = doctorService.getDoctorById(id);
        if (doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/save")
    public ResponseEntity<DoctorBean> createDoctor(@RequestBody DoctorBean doctor) {
        DoctorBean createdDoctor = doctorService.createDoctor(doctor);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorBean> updateDoctor(@PathVariable Long id, @RequestBody DoctorBean updatedDoctor) {
        DoctorBean doctor = doctorService.updatedDoctor(id, updatedDoctor);
        if (doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



