package com.B.M.hospitalappointmentsystem.service;

import com.B.M.hospitalappointmentsystem.DAO.DoctorDAO;
import com.B.M.hospitalappointmentsystem.DAO.PatientDAO;
import com.B.M.hospitalappointmentsystem.bean.DoctorBean;
import com.B.M.hospitalappointmentsystem.bean.PatientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService {
    private final DoctorDAO doctorDAO;

@Autowired
    public DoctorService(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }



    // Add methods for doctor-related operations
    public List<DoctorBean> getAllDoctors() {
        return doctorDAO.findAll();
    }

    public DoctorBean getDoctorById(Long id) {
        return doctorDAO.findById(id).orElse(null);
    }

    public DoctorBean createDoctor(DoctorBean patient) {
        return doctorDAO.save(patient);
    }

    public DoctorBean updatedDoctor(Long id, DoctorBean updatedDoctor) {
        if (doctorDAO.existsById(id)) {
            updatedDoctor.setId(id);
            return doctorDAO.save(updatedDoctor);
        }
        return null; // Handle not found scenario
    }

    public void deleteDoctor(Long id) {
        doctorDAO.deleteById(id);
    }
}


