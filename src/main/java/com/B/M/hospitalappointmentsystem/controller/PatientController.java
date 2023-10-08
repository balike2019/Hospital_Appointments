package com.B.M.hospitalappointmentsystem.controller;

import com.B.M.hospitalappointmentsystem.bean.PatientBean;
import com.B.M.hospitalappointmentsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientBean>> getAllPatients() {
        List<PatientBean> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientBean> getPatientById(@PathVariable Long id) {
        PatientBean patient = patientService.getPatientById(id);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/save")
    public ResponseEntity<PatientBean> createPatient(@RequestBody PatientBean patient) {
        PatientBean createdPatient = patientService.createPatient(patient);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientBean> updatePatient(@PathVariable Long id, @RequestBody PatientBean updatedPatient) {
        PatientBean patient = patientService.updatePatient(id, updatedPatient);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
