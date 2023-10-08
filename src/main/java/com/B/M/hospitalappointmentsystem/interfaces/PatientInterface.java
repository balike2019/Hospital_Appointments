package com.B.M.hospitalappointmentsystem.interfaces;

import com.B.M.hospitalappointmentsystem.DAO.PatientDAO;
import com.B.M.hospitalappointmentsystem.bean.PatientBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PatientInterface {
    //private final PatientDAO patientDAO;

    //@Autowired
   // public PatientService(PatientDAO patientDAO) ;

    // Add methods for patient-related operations
    public List<PatientBean> getAllPatients() ;

    public PatientBean getPatientById(Long id) ;


    public PatientBean createPatient(PatientBean patient) ;
       // return patientDAO.save(patient);


    public PatientBean updatePatient(Long id, PatientBean updatedPatient) ;


    public void deletePatient(Long id) ;


}
