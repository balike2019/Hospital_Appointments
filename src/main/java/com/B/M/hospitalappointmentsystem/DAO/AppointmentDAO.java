package com.B.M.hospitalappointmentsystem.DAO;

import com.B.M.hospitalappointmentsystem.bean.AppointmentBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AppointmentDAO extends JpaRepository<AppointmentBean, Long> {
    boolean existsByAppointmentDateTime(LocalDateTime appointmentDateTime);

}

