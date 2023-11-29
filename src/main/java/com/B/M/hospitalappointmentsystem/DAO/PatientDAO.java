package com.B.M.hospitalappointmentsystem.DAO;

import com.B.M.hospitalappointmentsystem.bean.PatientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientDAO extends JpaRepository<PatientBean,Long> {
   

}

