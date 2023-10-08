package com.B.M.hospitalappointmentsystem.DAO;

import com.B.M.hospitalappointmentsystem.bean.DoctorBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDAO extends JpaRepository<DoctorBean, Long> {

}

