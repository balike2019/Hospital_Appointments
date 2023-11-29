package com.B.M.hospitalappointmentsystem.service;
import com.B.M.hospitalappointmentsystem.DAO.PatientDAO;
import com.B.M.hospitalappointmentsystem.bean.PatientBean;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {

    //private static final Logger logger = (Logger) LogManager.getLogger(PatientService.class);
    private final PatientDAO patientDAO;
    //private final PatientInterface patientInterface;



    @Autowired
    public PatientService(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    // Add methods for patient-related operations
    public List<PatientBean> getAllPatients() {
        return patientDAO.findAll();
    }

    public PatientBean getPatientById(Long id) {
        return patientDAO.findById(id).orElse(null);
    }

    public PatientBean createPatient(PatientBean patient) {
        return patientDAO.save(patient);
    }

    public PatientBean updatePatient(Long id, PatientBean updatedPatient) {
        if (patientDAO.existsById(id)) {
            updatedPatient.setId(id);
            return patientDAO.save(updatedPatient);
        }
        return null; // Handle not found scenario
    }

    public void deletePatient(Long id) {
        patientDAO.deleteById(id);
    }
}
